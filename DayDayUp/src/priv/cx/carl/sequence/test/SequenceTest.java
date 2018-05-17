package priv.cx.carl.sequence.test;

import java.util.HashSet;
import java.util.Set;

import priv.cx.carl.sequence.Sequence;

public class SequenceTest {

	public static void main(String[] args) {
		Set<Long> set = new HashSet<Long>();
		final Sequence idWorker1 = new Sequence(0, 0);
		final Sequence idWorker2 = new Sequence(1, 0);
		Thread t1 = new Thread(new IdWorkThread(set, idWorker1));
		Thread t2 = new Thread(new IdWorkThread(set, idWorker2));
		t1.setDaemon(true);// 守护线程
		t2.setDaemon(true);
		t1.start();
		t2.start();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("执行结束");
	}

	static class IdWorkThread implements Runnable {
		private Set<Long> set;
		private Sequence idWorker;

		public IdWorkThread(Set<Long> set, Sequence idWorker) {
			this.set = set;
			this.idWorker = idWorker;
		}

		@Override
		public void run() {
			while (true) {
				long id = idWorker.nextId();
				if (!set.add(id)) {
					System.out.println("重复id:" + id);
				}
			}
		}
	}

}
