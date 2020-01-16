package com.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * 反射成员变量并调用（设置）
 * @author Iron Core
 * @date 2020年1月9日
 * @note 1、批量获取
 *	 		1).Field[] getFields():获取所有的"公有字段"；
 * 		 	2).Field[] getDeclaredFields():获取所有字段，包括：私有、受保护、默认、公有；
 * 		 2、单个获取
 * 			1).public Field getField(String fieldName):获取某个"公有的"字段；
 * 			2).public Field getDeclaredField(String fieldName):获取某个字段(可以是私有的)；
 *			设置字段的值：
 * 			Field --> public void set(Object obj,Object value):
 * 						参数说明：
 * 						1.obj:要设置的字段所在的对象；
 * 						2.value:要为字段设置的值。
 */
public class Fileds {
	public static void main(String[] args)
			throws ClassNotFoundException, NoSuchFieldException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
		Class stuClass = Class.forName("com.reflect.Student");

		System.out.println("**获取所有公有字段**");
		Field[] fieldArray = stuClass.getFields();
		for (Field field : fieldArray) {
			System.out.println(field);
		}

		System.out.println("**获取所有字段，包括私有，受保护，默认的**");
		fieldArray = stuClass.getDeclaredFields();
		for (Field field : fieldArray) {
			System.out.println(field);
		}

		System.out.println("**获取公有字段**并调用**");
		Field f = stuClass.getField("name");
		System.out.println(f);
		// 获取一个Student对象
		Object obj = stuClass.getConstructor().newInstance();
		// 为字段设置值，第一个参数：要传入设置的对象，第二个参数：要传入的实参
		f.set(obj, "Ace");
		// 验证
		Student stu = (Student) obj;
		System.out.println("验证名字：stu.name=" + stu.name);

		System.out.println("**获取私有字段**并调用**");
		f = stuClass.getDeclaredField("phoneNum");
		System.out.println(f);
		f.setAccessible(true);//暴力访问，解除私有限定
		f.set(obj, "18888889999");
		System.out.println("验证电话：stu" + stu);
	}
}
