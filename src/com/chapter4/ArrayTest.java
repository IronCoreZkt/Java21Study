package com.chapter4;

public class ArrayTest {
	public static void main(String[] args) {
		{
			int[] i = new int[3];
			for (int j : i) {
				System.out.println(j);
			}
		}
		{
			int i = 0010;// 当使用字面量的时候，前缀 0 表示 8 进制，而前缀 0x 代表 16 进制
			System.out.println("i=" + i);
		}
		{
			int[][][] dimensionsTest = new int[100][20][33];
			System.out.println("一维元素个数为" + dimensionsTest.length);
			System.out.println("二维元素个数为" + dimensionsTest[1].length);
			System.out.println("三维元素个数为" + dimensionsTest[1][1].length);
		}
		blockTest();
	}

	/*
	 * 块语句可用于类定义和方法定义中，还可用于逻辑和循环结构中。
	 * 像此示例这样使用内部块的方式并不常见。
	 */
	public static void blockTest() {
		int x = 10;
		{// start of block
			int y = 11;
			y += x;
			System.out.println("测试块语句，y变量值为" + y);
		} // end of block
	}
}
