package com.chapter3;

public class BirthdayShow {
	public static void main(String[] args){
		String s = "10/02/1996";
		String month = s.substring(0, 2);
		String day = s.substring(3, 5);
		String year = s.substring(6);
		
		System.out.println("year:"+year);
		System.out.println("month:"+month);
		System.out.println("day:"+day);
	}

}
