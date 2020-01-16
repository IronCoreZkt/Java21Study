package com.reflect;

public class Student {
	/* 构造函数 */
	Student(String str) {
		System.out.println("调用构造方法，str=" + str);
	}

	public Student() {
		System.out.println("调用公有无参构造方法");
	}

	public Student(char sex) {
		System.out.println("调用公有单参构造方法，sex=" + sex);
	}

	public Student(String name, int age) {
		System.out.println("调用公有双参构造方法，name=" + name + ",age=" + age);
	}

	protected Student(boolean n) {
		System.out.println("调用受保护的构造方法，n=" + n);
	}

	private Student(int age) {
		System.out.println("调用私有构造方法，age=" + age);
	}

	/* 成员变量，字段 */
	public String name;
	protected int age;
	char sex;
	private String phoneNum;

	@Override
	public String toString() {
		return "Student [name=" + name + ",age=" + age + ",sex=" + sex + ",phoneNum=" + phoneNum + "]";
	}

	/* 成员变量，字段 */
	public void show(){
		System.out.println("调用了：公有的，无参的show()");
	}
	public void show1(String s) {
		System.out.println("调用了：公有的，String参数的show1(String s)，s=" + s);
	}

	protected void show2() {
		System.out.println("调用了：受保护的，无参的show2()");
	}

	void show3() {
		System.out.println("调用了：默认限定的，无参的show3()");
	}

	private String show4(int age) {
		System.out.println("调用了：私有的，并有返回值的，int参数的show4(int age)，age=" + age);
		return "abcd";
	}

	public static void main(String[] args){
		System.out.println("excute the method \"main\"");
	}
}
