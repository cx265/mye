package priv.cx.carl.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.sun.security.ntlm.Client;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2018年5月10日 下午3:52:38
 */
public class AIOClient {

	AsynchronousSocketChannel client = null;
	
	public AIOClient(String host, int port) {
		try {
			client = AsynchronousSocketChannel.open();
			Future<?> future = client.connect(new InetSocketAddress(host, port));
			System.out.println(future.get());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	public void write(byte b) {
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		byteBuffer.put(b);
		byteBuffer.flip();
		client.write(byteBuffer);
	}
	
	public static void main(String[] args) {
		AIOClient client = new AIOClient("localhost", 7070);
		client.write( (byte) 34);
	}

}
