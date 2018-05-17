package priv.cx.carl.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2017年10月29日 下午8:17:25
 */
public class ExecutorThread {

	public static void main(String[] args) {
		// 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务,按照指定顺序(FIFO, LIFO, 优先级)执行
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 20; i++) {
			Runnable syncRunnable = new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());
				}
			};
			executorService.execute(syncRunnable);
		}
		
		// 创建一个可重用固定线程数的线程池，以共享的无界队列方式来运行这些线程
		/*ExecutorService executorService = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 20; i++) {
			Runnable syncRunnable = new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());
				}
			};
			executorService.execute(syncRunnable);
		}*/

		// 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程
		/*ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 20; i++) {
			Runnable syncRunnable = new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());
				}
			};
			executorService.execute(syncRunnable);
		}*/
		
		// 创建一个定长线程池，支持定时及周期性任务执行
		/*ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
		for (int i = 0; i < 20; i++) {
			Runnable syncRunnable = new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());
				}
			};
			executorService.scheduleAtFixedRate(syncRunnable, 5000, 3000, TimeUnit.MILLISECONDS);
		}*/

	}
}
