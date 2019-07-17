package com.chapter8;

public class Hashtest {
	public static void main(String[] args) {
		String str1 = "hello";
		String str2 = new String("hello");
		System.out.println(str1==str2);
		System.out.println(str1.hashCode()==str2.hashCode());
		//String str3= null;
		//System.out.println(str3);
	}

}
