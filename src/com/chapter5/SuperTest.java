package com.chapter5;

public class SuperTest {
	public static void main(String[] args) {
		Son s = new Son();
		s.show();
	}
}

class GrandFather {
	String name = "grandfather";

	void show() {
		System.out.println(this.name);
	}
}

class Father extends GrandFather {
	String name = "father";
}

class Son extends Father {
	void showSon() {
		System.out.println(this.name);
	}

	void show() {
		super.show();
	}
}