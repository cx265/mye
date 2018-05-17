package priv.cx.carl.jdk8;

@FunctionalInterface
public interface MyPredicate<T> {

	public boolean test(T t);
	
}
