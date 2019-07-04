package com.chapter6;

public class Grand {
	private int a = 10;
	int b = 20;
	public void showG(){
		System.out.println("GGGGGGrand");
	}
	public static void testStaticFunc(){
		System.out.println("123");
	}
	
	public static void main(String[] args) {
		Grand g = new Son();
		g.showG();
		System.out.println(g.a);
		Son s =new Son();
		System.out.println(s.b);
		Son.testStaticFunc();
	}

}
class Son extends Grand{
	int c =30;
	public void showS(){
		System.out.println("SSSSSon");
	}
	public static void testStaticFunc(){
		System.out.println("321");
	}
}

class GrandSon extends Son{
	
}