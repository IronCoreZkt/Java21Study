package com.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 构造函数反射并调用
 * @author Iron Core
 * @date 2020年1月8日
 * @note 1、批量获取
 *	 		public Constructor[] getConstructors()：所有"公有的"构造方法；
 * 		 	public Constructor[] getDeclaredConstructors()：获取所有的构造方法(包括私有、受保护、默认、公有)；
 * 		 2、单个获取
 * 			public Constructor getConstructor(Class... parameterTypes):获取单个的"公有的"构造方法；
 * 			public Constructor getDeclaredConstructor(Class... parameterTypes):获取"某个构造方法"可以是私有的，或受保护、默认、公有；
 *			调用方法：
 * 			Constructor-->newInstance(Object... initargs)。
 */
public class Constructors {
	public static void main(String[] args) {
		try {
			Class clazz = Class.forName("com.reflect.Student");

			System.out.println("*所有公共构造函数*");
			Constructor[] conArray = clazz.getConstructors();
			for (Constructor c : conArray) {
				System.out.println(c);
			}

			System.out.println("*所有构造函数(包括：私有，默认，受保护，公有)*");
			conArray = clazz.getDeclaredConstructors();
			for (Constructor c : conArray) {
				System.out.println(c);
			}

			System.out.println("*获取公有、无参的构造方法*");
			Constructor con = clazz.getConstructor(null);
			// 1>、因为是无参的构造方法所以类型是一个null,不写也可以：这里需要的是一个参数的类型，切记是类型
			// 2>、返回的是描述这个无参构造函数的类对象。
			System.out.println("con=" + con);
			Object obj = con.newInstance();// 调用构造方法

			System.out.println("*获取私有构造方法，并调用*");
			con = clazz.getDeclaredConstructor(int.class);
			System.out.println("con=" + con);
			con.setAccessible(true);// 暴力访问(忽略掉访问修饰符)
			obj = con.newInstance(18);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}

}
