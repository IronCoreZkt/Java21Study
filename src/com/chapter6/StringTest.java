package com.chapter6;

import java.awt.Point;

public class StringTest {
	public static void main(String[] args) {
		/*String str1 = "abc";
		String str2 = "a";
		String str3 = str1 + "bc";
		// String str3 = "a" + "bc";
		System.out.println(str1 == str3);*/
		String str1 = new String("abc");
		String str2 = str1;
		str1 = "cba";
		System.out.println(str1+":"+str2);
		System.out.println(ZipCode.isInteger(str1));
		/*Point p1 =new Point(6,4);
		Point p2 =new Point(7,7);
		p2 =p1;
		p1.x=5;
		p1.y=10;
		System.out.println("p2.x="+p2.x+",p2.y="+p2.y);*/
	}
}
