package com.chapter5;

/*
 * 1、子类对象拥有父类的私有变量但没有访问权，也就是有拥有权而不能直接使用(可见调试)。
 * 2、子类构造函数会默认继承父类的无参构造函数，若父类无无参构造函数且定义了
 * 	    有参构造函数，则子类构造函数需要用super调用该函数，且需要为第一条语句。
 */
public class ConstructorExtends {
	public static void main(String[] args) {
		Pupil p = new Pupil();
		p.show();
	}

}

class Student { // 父类Student
	private String name;
	private int height;

	public Student() {
		this.name = "a";
		this.height = 180;
		System.out.println("父类构造函数调用，当前实例为：" + this);
	}
	
	//若父类只有带参构造函数，子类构造函数需要用super调用
	/*public Student(String a, int b) {
		this.name = a;
		this.height = b;
		System.out.println("父类构造函数调用，当前实例为：" + this);
	}*/

	public String getName() {
		return name;
	}

	public int getHeight() {
		return height;
	}
}

class Pupil extends Student { // 子类Pupil
	private int score;

	/*
	 * 无参构造函数Pupil()直接继承了父类中的无参构造函数Student()，
	 * 但是父类中的name、height是private的。
	 */
	public Pupil() {
		// super("b",185);//调用超类的带参构造函数super语句必须为第一条语句
		score = 10;
		System.out.println("子类构造函数调用，当前实例为：" + this);
	}

	public void show() {
		System.out.print("姓名：" + getName() + "\n身高：" + getHeight() 
		+ "\n分数：" + score); // 输出时，直接用get方法名。
	}
}