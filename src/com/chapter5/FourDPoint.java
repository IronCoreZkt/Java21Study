package com.chapter5;

import java.awt.Point;

public class FourDPoint extends Point {
	private static final long serialVersionUID = 1L;
	int z, t;

	FourDPoint(int x, int y, int z, int t) {
		super(x, y);
		this.z = z;
		this.t = t;
	}

	public static void main(String[] args) {
		FourDPoint fdp = new FourDPoint(1, 2, 3, 4);
		System.out.println("x=" + fdp.x);
		System.out.println("y=" + fdp.y);
		System.out.println("z=" + fdp.z);
		System.out.println("t=" + fdp.t);
	}

}
