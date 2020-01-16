package com.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 通过反射越过泛型检查
 * @author Iron Core
 * @date 2020年1月16日
 */
public class GenericityPass {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ArrayList<String> strList = new ArrayList<>();
		strList.add("aaa");
		strList.add("bbb");
		// strList.add(111);
		
		// 获取ArrayList的Class对象，反向调用add()方法，添加数据
		Class listClass = strList.getClass();
		Method m = listClass.getMethod("add", Object.class);
		m.invoke(strList, 100);
		
		for (Object obj : strList) {
			System.out.println(obj);
		}
	}

}
