package priv.cx.carl.aio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2018年5月10日 下午3:38:37
 */
public class AIOServer {

	public AIOServer(int port) {
		try {
			final AsynchronousServerSocketChannel listener = AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(port));
			listener.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {

				@Override
				public void completed(AsynchronousSocketChannel ash, Void vi) {
					// 接受下一个连接
					listener.accept(null, this);
					handler(ash);
				}

				@Override
				public void failed(Throwable exc, Void vi) {
					System.out.println("aio失败");
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void handler(AsynchronousSocketChannel ash) {
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		try {
			ash.read(byteBuffer).get();
			byteBuffer.flip();
			System.out.println("服务端接收消息：" + byteBuffer.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		int port = 7070;
		AIOServer server = new AIOServer(port);
		System.out.println("server start ->" + port);
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
