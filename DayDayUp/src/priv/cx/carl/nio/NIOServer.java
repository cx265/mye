package priv.cx.carl.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2018年5月9日 下午1:34:25
 */
public class NIOServer {

	private int blockSize = 4096;
	private ByteBuffer sendBuffer = ByteBuffer.allocate(blockSize);
	private ByteBuffer receiveBuffer = ByteBuffer.allocate(blockSize);
	private Selector selector;

	public NIOServer(int port) {
		try {
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
			// 设置是否阻塞
			serverSocketChannel.configureBlocking(false);
			ServerSocket serverSocket = serverSocketChannel.socket();
			serverSocket.bind(new InetSocketAddress(port));
			// 打开选择器
			selector = Selector.open();
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("Server start -> " + port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void listen() {
		while (true) {
			try {
				selector.select();
				Set<SelectionKey> selectionKeys = selector.selectedKeys();
				Iterator<SelectionKey> iterator = selectionKeys.iterator();
				while (iterator.hasNext()) {
					SelectionKey selectionKey = iterator.next();
					iterator.remove();
					// 业务逻辑
					handleKey(selectionKey);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void handleKey(SelectionKey selectionKey) {
		ServerSocketChannel server = null;
		SocketChannel client = null;
		String sendText;
		String receiveText;
		int count = 0;
		if (selectionKey.isAcceptable()) {
			System.out.println("selectionKey.isAcceptable()");
			server = (ServerSocketChannel) selectionKey.channel();
			try {
				client = server.accept();
				client.configureBlocking(false);
				client.register(selector, selectionKey.OP_READ);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (selectionKey.isReadable()) {
			System.out.println("selectionKey.isReadable()");
			client = (SocketChannel) selectionKey.channel();
			try {
				count = client.read(receiveBuffer);
				if (count > 0) {
					receiveText = new String(receiveBuffer.array(), 0, count);
					System.out.println("server读到的消息：" + receiveText);
					client.register(selector, selectionKey.OP_WRITE);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (selectionKey.isWritable()) {
			System.out.println("selectionKey.isWritable()");
			sendBuffer.clear();
			client = (SocketChannel) selectionKey.channel();
			sendText = "msg";
			sendBuffer.put(sendText.getBytes());
			sendBuffer.flip();
			try {
				client.write(sendBuffer);
				System.out.println("server发送了消息：" + sendText);
				client.register(selector, selectionKey.OP_READ);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		int port = 7070;
		NIOServer nioServer = new NIOServer(port);
		nioServer.listen();
	}

}
