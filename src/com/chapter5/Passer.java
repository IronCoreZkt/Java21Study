package com.chapter5;

/**
 * @author Iron Core
 * 调用接受对象参数的方法时，对象是按引用传递的。我们在方法内对该对象所做的任何操作都将影
 * 响原来的对象。请记住，这样的对象包括数组以及数组的对象。将数组传递给方法，
 * 并在方法中修改其内容时，将影响原来的数组。
 * 另一方面，基本数据类型和字符串是按值传递的，因此在方法中无法修改原来的值。
 */
public class Passer {
	public void toUpperCase(String[] test, int x) {
		int arrayLength = test.length;
		for (int i = 0; i < arrayLength; i++) {
			test[i] = test[i].toUpperCase();
		}
		x = 7;
		System.out.println("x=" + x);
	}

	public static void main(String[] args) {
		Passer p = new Passer();
		int mainx = 6;
		p.toUpperCase(args, mainx);
		System.out.println("mainx=" + mainx);
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
	}

}
