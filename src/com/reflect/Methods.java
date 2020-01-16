package com.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射成员方法并调用
 * @author Iron Core
 * @date 2020年1月9日
 * @note 1、批量获取
 *	 		public Method[] getMethods():获取所有"公有方法"，（包含了父类的方法也包含Object类）；
 * 		 	public Method[] getDeclaredMethods():获取所有的成员方法，包括私有的(不包括继承的)；
 * 		 2、单个获取
 * 			public Method getMethod(String name,Class<?>... parameterTypes):
 * 						参数说明：name为方法名，Class...为形参的Class类型对象；
 * 			public Method getDeclaredMethod(String name,Class<?>... parameterTypes)；
 *			调用方法：
 * 			Method --> public Object invoke(Object obj,Object... args):
 * 						参数说明：
 * 						1.obj:要调用方法的对象；
 * 						2.value:调用方法时所传入的实参。
 */
public class Methods {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class stuClass = Class.forName("com.reflect.Student");

		System.out.println("**获取所有公有方法**");
		Method[] methodArray = stuClass.getMethods();
		for (Method m : methodArray) {
			System.out.println(m);
		}

		System.out.println("**获取所有方法，包括私有、默认、受保护**");
		methodArray = stuClass.getDeclaredMethods();
		for (Method m : methodArray) {
			System.out.println(m);
		}

		System.out.println("**获取公有的show1()方法**");
		Method m = stuClass.getMethod("show1", String.class);
		System.out.println(m);
		// 实例化一个Student对象
		Object obj = stuClass.getConstructor().newInstance();
		m.invoke(obj, "吴彦祖");

		System.out.println("**获取私有的show4()方法**");
		m = stuClass.getDeclaredMethod("show4", int.class);
		System.out.println(m);
		m.setAccessible(true);
		Object result = m.invoke(obj, 18);
		System.out.println("返回值：" + result);

	}

}
