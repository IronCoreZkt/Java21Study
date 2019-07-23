package com.chapter15;

/**
 * 读取当前目录路径。
 * 
 * @author Iron Core
 * @date 2019年7月23日
 * @note 相对路径是根据当前的用户文件夹确定的，后者存储在系统属性user.dir中。可以使用java.lang包中的System
 *       类来获悉到该文件夹的完整路径，这个包不需要导入。
 * 
 */
public class UserFolder {
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
	}
}
