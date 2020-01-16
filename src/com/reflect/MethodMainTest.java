package com.reflect;

import java.lang.reflect.Method;

/**
 * 反射main方法并调用
 * @author Iron Core
 * @date 2020年1月16日
 * @note 
 */
public class MethodMainTest {
	public static void main(String[] args) {
		try {
			// 1、获取Student的字节码对象
			Class clazz = Class.forName("com.reflect.Student");

			// 2、获取main方法
			Method methodMain = clazz.getMethod("main", String[].class);
			// 3、调用main方法
			/* 第一个参数因为方法是static静态的，所以可以为null，第二个参数是String数组
			 * 这里拆的时候将new String[]{"a","b","c"}拆成三个对象（Object... args），
			 * 所以需要强转。
			 */
			methodMain.invoke(null, (Object)new String[]{"1","2","3"});
			// methodMain.invoke(null, new Object[] { new String[] { "a", "b", "c" } });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
