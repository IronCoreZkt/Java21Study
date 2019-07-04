package com.chapter4;

public class SwitchTest {
	//验证字符串数组中赋值后是否为同一个对象还是说只是值相同
	public static void main(String[] args) {
		String[] strs=new String[3];
		strs[0]="abc0";
		strs[1]="abc1";
		strs[2]="abc2";
		strs[1]=strs[0];
		System.out.println("is same obeject?"+((strs[1]==strs[0])?"yes":"no"));
	}
}
