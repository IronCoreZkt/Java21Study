package com.chapter16;

/**
 * 测试内部类对外部作用域的引用。
 * 
 * @author Iron Core
 * @date 2019年8月5日
 * 
 */
public class ClosureRefTest {
	public static void main(String[] args) {
		ClosureRefTest a= new ClosureRefTest();
		AClass b=a.create("222222");
		b.show();
	}
	public AClass create(String text){
		int para2=111111;
		System.out.println(para2+text);
		return new AClass(){
			void show() {
				System.out.println(para2);
				System.out.println(text);
				System.out.println("匿名内部类");
			}
		};
	}
}

abstract class AClass {
	int para = 666666;

	abstract void show();
}