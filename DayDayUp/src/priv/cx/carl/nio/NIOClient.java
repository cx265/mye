package priv.cx.carl.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2018年5月9日 下午4:10:57
 */
public class NIOClient {

	private int flag = 1;
	private static int blockSize = 4096;
	private static ByteBuffer sendBuffer = ByteBuffer.allocate(blockSize);
	private static ByteBuffer receiveBuffer = ByteBuffer.allocate(blockSize);
	private final static InetSocketAddress SOCKET_ADDRESS = new InetSocketAddress("127.0.0.1", 7070);

	public static void main(String[] args) {
		try {
			SocketChannel socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(false);
			// 打开选择器
			Selector selector = Selector.open();
			socketChannel.register(selector, SelectionKey.OP_CONNECT);
			socketChannel.connect(SOCKET_ADDRESS);
			Set<SelectionKey> selectionKeys;
			Iterator<SelectionKey> iterator;
			SelectionKey selectionKey;
			SocketChannel client;
			String sendText;
			String receiveText;
			int count = 0;
			while (true) {
				selectionKeys = selector.selectedKeys();
				iterator = selectionKeys.iterator();
				while (iterator.hasNext()) {
					selectionKey = iterator.next();
					if (selectionKey.isConnectable()) {
						System.out.println("客户端正在连接");
						client = (SocketChannel) selectionKey.channel();
						if (client.isConnectionPending()) {
							client.finishConnect();
							System.out.println("连接完成");
							sendBuffer.clear();
							sendBuffer.put("Hello ".getBytes());
							sendBuffer.flip();
							client.write(sendBuffer);
						}
						client.register(selector, SelectionKey.OP_READ);
					} else if (selectionKey.isReadable()) {
						client = (SocketChannel) selectionKey.channel();
						receiveBuffer.clear();
						try {
							count = client.read(receiveBuffer);
							if (count > 0) {
								receiveText = new String(receiveBuffer.array(), 0, count);
								System.out.println("clinet读到的消息：" + receiveText);
								client.register(selector, SelectionKey.OP_WRITE);
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else if (selectionKey.isWritable()) {
						sendBuffer.clear();
						client = (SocketChannel) selectionKey.channel();
						sendText = "client msg";
						sendBuffer.put(sendText.getBytes());
						sendBuffer.flip();
						try {
							client.write(sendBuffer);
							System.out.println("client发送了消息：" + sendText);
							client.register(selector, SelectionKey.OP_READ);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				selectionKeys.clear();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
