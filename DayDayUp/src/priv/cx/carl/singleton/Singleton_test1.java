package priv.cx.carl.singleton;
/**
* @author 作者:chenxuan E-mail:chenx265@163.com
* @version 创建时间：2017年3月2日 下午3:16:30
*/
public class Singleton_test1 {
	
	private Singleton_test1() {
	}

	private static volatile Singleton_test1 singleton;

	public static Singleton_test1 getInstance() {
		if (singleton == null){
			synchronized (Singleton_test1.class) {
				if (singleton == null){
					singleton = new Singleton_test1();
				}
			}
		}
		return singleton;
	}
}
