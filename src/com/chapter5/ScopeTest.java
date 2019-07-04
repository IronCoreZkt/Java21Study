package com.chapter5;

public class ScopeTest {
	int test = 10;

	void printTest() {
		int test = 20;
		System.out.println("test in the block is " + test);
		System.out.println("test in the object is " + this.test);
	}

	public static void main(String[] args) {
		ScopeTest st = new ScopeTest();
		st.printTest();
	}

}
