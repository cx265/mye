package com.cx.factor;

public class CreateProduct {
	public static Product createProduct(String str){
		if ("A".equals(str)) {
			return new ConProductA();
		} else if ("B".equals(str)) {
			return new ConProductB();
		}
		return null;
	}

}
