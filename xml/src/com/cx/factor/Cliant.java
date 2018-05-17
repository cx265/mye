package com.cx.factor;

public class Cliant {
	public static void main(String[] args) {
		Product productA = CreateProduct.createProduct("A");
		System.out.println(productA.getClass().getName());
		Product productB = CreateProduct.createProduct("B");
		System.out.println(productA.getClass().getName());
	}
}
