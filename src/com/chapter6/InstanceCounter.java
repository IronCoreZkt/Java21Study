package com.chapter6;

public class InstanceCounter {
	private static int nums = 0;

	protected static int getNums() {
		return nums;
	}

	private static void addInstance() {
		nums++;
	}

	InstanceCounter() {
		addInstance();
	}

	public static void main(String[] args) {
		System.out.println("Starting with " + InstanceCounter.getNums() + " objects.");
		for (int i = 0; i < 100; i++) {
			new InstanceCounter();
		}
		System.out.println("End with " + InstanceCounter.getNums() + " objects created.");
	}
}
