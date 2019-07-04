package com.chapter5;

public class RangeLister {
	public int[] makeRange(int upper, int lower) {
		int[] range = new int[upper - lower + 1];
		for (int i = lower; i <= upper; i++) {
			range[i - lower] = i;
		}
		return range;
	}

	public static void main(String[] args) {
		RangeLister rl = new RangeLister();
		int[] a = rl.makeRange(4, 2);
		for (int i = 0; i < a.length; i++) {
			System.out.println("a" + i + "=" + a[i]);
		}
	}

}
