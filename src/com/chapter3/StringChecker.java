package com.chapter3;

public class StringChecker {
	public static void main(String[] args){
		String str = "A Lannister always pays his debts.";
		
		System.out.println("The String is " + str);
		System.out.println("Length of the String is "+ str.length());
		System.out.println("The charactor at position 6 is "+str.charAt(6));
		System.out.println("The substring form 12 to 18 is "+str.substring(12,18));
		System.out.println("The index of the 't' is "+str.indexOf('t'));
		System.out.println("The index of the beginning of the "+"substring \"debts\" is "+str.indexOf("debts"));
		System.out.println("The string in uppercase is "+ str.toUpperCase());
		
		double pi = Math.PI;
		//四舍五入3.14159
		System.out.format("%.4f%n",pi);
		//格式化输出金额
		int accountBalance = 5003;
		System.out.format("$%,d%n", accountBalance);
		
		/*String s,s2;
		s = "portrzebie";
		s2 = s.valueOf(550);
		System.out.println(s2);
		s2 = String.valueOf(550);
		System.out.println(s2);
		System.out.println(s);*/
	}
}
