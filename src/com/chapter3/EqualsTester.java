package com.chapter3;

class EqualsTester {
	public static void main(String[] args){
		String str1, str2;
		str1 = "Boy, Let's not talk too much.";
		str2 = str1;
		
		System.out.println("String1 = "+str1);
		System.out.println("String2 = "+str2);
		System.out.println("Same obeject? " +(str1 == str2));
		
		str2 = new String(str1);
		System.out.println("String1 = "+str1);
		System.out.println("String2 = "+str2);
		System.out.println("Same obeject? " +(str1 == str2));
		System.out.println("Same value? " +str1.equals(str2));
		/*StringBuilder sb1  = new StringBuilder("abcd");
		StringBuilder sb2;
		sb2 = sb1;
		
		sb2.append("123");

		System.out.println("String1 = "+sb1);
		System.out.println("String2 = "+sb2);
		System.out.println("Same obeject? " +(sb1 == sb2));*/
		String str3 = str1.getClass().getName();
		System.out.println("str3的类为:"+str3);
		boolean check1 = str3 instanceof String;
		System.out.println(check1);
		
	}
}
