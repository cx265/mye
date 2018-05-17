package priv.cx.carl.singleton;
/**
* @author 作者:chenxuan E-mail:chenx265@163.com
* @version 创建时间：2017年3月2日 下午3:16:40
*/
public class Singleton_1 {

	public Singleton_1() {
	}

	private static Singleton_1 singleton;

	public static Singleton_1 getInstance() {
		if (singleton == null) {
			synchronized (Singleton_1.class) {
				if (singleton == null) {
					Singleton_1 temp = new Singleton_1();
					singleton = temp;
				}
			}
		}
		return singleton;
	}
}
