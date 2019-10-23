package com.chapter5;

import java.awt.Point;

/**
 * 
 * @author Iron Core 重载构造函数
 */
public class Box {
	int x1 = 0;
	int x2 = 0;
	int y1 = 0;
	int y2 = 0;

	public Box(int x1, int x2, int y1, int y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}

	public Box(Point topLeft, Point bottomRight) {
		this(topLeft.x, bottomRight.x, topLeft.y, bottomRight.y);
	}

	public Box(Point topLeft, int w, int h) {
		this(topLeft.x, topLeft.x + w, topLeft.y, topLeft.y + h);
	}

	public void showBox() {
		System.out.println("x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2);
	}

	public static void main(String[] args) {
		Box rect = new Box(1, 2, 3, 4);
		System.out.println("paras is 1 2 3 4");
		rect.showBox();
		System.out.println("\nparas is (5,6) and (7,8)");
		rect = new Box(new Point(5, 6), new Point(7, 8));
		rect.showBox();
		System.out.println("\nparas is (9,10) and 11 , 12");
		rect = new Box(new Point(9, 10), 11, 12);
		rect.showBox();
	}

}
