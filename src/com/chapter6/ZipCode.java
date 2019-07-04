package com.chapter6;

import java.util.regex.Pattern;

/**
 * 使用访问控制来确保其实例变量zipCode总是一个5位或9位数
 * @author Iron Core
 *
 */
public class ZipCode {
	private String zipCode;
	
	public ZipCode(String zipCodeInit) {
		//判断字符串是否全部为数字
		if (isInteger(zipCodeInit)) {
			setzipCode(zipCodeInit);
		}else{
			System.out.println("请输入数字!");
		}
	}

	public void setzipCode(String zipCodeIn) {
		int length = zipCodeIn.length();
		//判断位数是否为5或者9
		if (length == 5 || length == 9) {
			this.zipCode = zipCodeIn;
		} else {
			System.out.println("您输入的邮政编码不是五位数或者九位数");
		}
	}

	public String getzipCode() {
		return this.zipCode;
	}

	/**
	 * 静态/类不变（sf）方法，用于判断字符串是否全部为数字
	 * @param str
	 * @return true表示为数字字符串，false则相反
	 */
	public static final boolean isInteger(String str) {
		if (null == str || "".equals(str)) {
			return false;
		}
		String regex = "^[-\\+]?[\\d]*$";
		Pattern pattern = Pattern.compile(regex);
		return pattern.matcher(str).matches();
	}
	
	public static void main(String[] args){
		ZipCode zp1 =new ZipCode("12345");
		System.out.println("zp1.zipCode="+zp1.zipCode);
		ZipCode zp2 =new ZipCode("abcd12345");
		System.out.println("zp2.zipCode="+zp2.zipCode);
		
	}
	/*
	 * private int zipCode;
	 * 
	 * public int getzipCode() { return zipCode; }
	 * 
	 * public void setzipCode(int zipCode) { if ((zipCode > 9999 && zipCode <=
	 * 19999) || (zipCode > 99999999 && zipCode <= 199999999)) this.zipCode =
	 * zipCode; else System.out.println("您输入的邮政编码不是五位数或者九位数"); }
	 */

}
