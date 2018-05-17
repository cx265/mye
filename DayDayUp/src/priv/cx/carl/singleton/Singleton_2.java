package priv.cx.carl.singleton;
/**
* @author 作者:chenxuan E-mail:chenx265@163.com
* @version 创建时间：2017年3月2日 下午3:16:42
*/
public class Singleton_2 {

	public static Singleton_2 getInstance() {
		return NestedClass.singleton;
	}

	private static class NestedClass {
		private static Singleton_2 singleton = new Singleton_2();
	}
}
