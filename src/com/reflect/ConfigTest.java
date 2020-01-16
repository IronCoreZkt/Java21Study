package com.reflect;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 利用反射和配置文件，可以使应用程序更新时不需要动类似于本类这样主体的代码，
 * 只需要更新配置文件和新配置文件中指定的新类。
 * @author Iron Core
 * @date 2020年1月16日
 */
public class ConfigTest {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, IOException {
		// 反射获取Class对象
		Class stuClass = Class.forName(getValue("className"));
		// 获取show()方法
		Method m = stuClass.getMethod(getValue("methodName"));
		// 调用show()方法
		m.invoke(stuClass.getConstructor().newInstance());
	}
	
	// 此方法接收一个key，在配置文件中获取相应的value
	public static String getValue(String key) throws IOException{
		Properties pro  = new Properties();
		FileReader in = new FileReader(".\\src\\com\\reflect\\pro.txt");
		pro.load(in);
		in.close();
		return pro.getProperty(key);
	}
}
