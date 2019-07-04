package com.chapter5;

public class OverflowTest {
	public static void main(String[] args) {
		int i = 128;
		byte j = (byte) i; // byte范围是-128到127
		System.out.println(j);// 溢出，所以j=-128
		System.out.println((float)5/2);
	}

}
