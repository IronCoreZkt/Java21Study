package com.chapter3;

import java.awt.Point;

public class RefTester {
	public static void main(String[] args){
		Point pt1,pt2;
		pt1 = new Point(100,100);
		pt2 = pt1;
		pt1.x = 123;
		pt2.y = 321;
		System.out.println("Point pt1's X="+pt1.x+" and Y="+pt1.y);
		System.out.println("Point pt2's X="+pt2.x+" and Y="+pt2.y);
		System.out.println("Same obeject? " +(pt1 == pt2));
		
		String pennsylvania = "65000";
		int penn = Integer.parseInt(pennsylvania);
		System.out.println(penn);
		
		Float f1 = 12.5F;
		Float f2 = 16F;
		System.out.println(Math.max(f1, f2));
	}

}
