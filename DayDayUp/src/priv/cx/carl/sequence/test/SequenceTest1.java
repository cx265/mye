package priv.cx.carl.sequence.test;

import org.junit.Test;

import priv.cx.carl.sequence.Sequence;

public class SequenceTest1 {

	@Test
	public void name() {
		try {
			int times, maxTimes = 1000, loop = 100;
			Sequence sequence = new Sequence(0, 0);
			for (int i = 0; i < loop; i++) {
				times = 0;
				for (int j = 0; j < maxTimes; j++) {
					long id = sequence.nextId();
					if (id % 2 == 0) {
						times++;
					}
					Thread.sleep(1);
				}
				System.out.println("偶数:" + times + ",奇数:" + (maxTimes - times));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
