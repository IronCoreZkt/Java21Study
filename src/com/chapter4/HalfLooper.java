package com.chapter4;

public class HalfLooper {
	public static void main(String[] args) {
		int[] denver = { 1_700_000, 4_600_000, 2_100_000 };
		int[] philadelphia = { 1_800_000, 5_000_000, 2_500_000 };
		int[] total = new int[denver.length];
		int sum = 0;
		for (int i = 0; i < denver.length; i++) {
			total[i] = denver[i] + philadelphia[i];
			sum = sum + total[i];
			System.out.format((i + 2012) + " year's production is %,d%n", total[i]);
		}
		int average = sum / philadelphia.length;
		System.out.format("Average annual total production:%,d%n", average);
	}
}
