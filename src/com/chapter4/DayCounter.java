package com.chapter4;

public class DayCounter {
	public static int countDays(int month, int year) {
		int count = -1;
		switch (month) {
		case 1:
			;
		case 3:
			;
		case 5:
			;
		case 7:
			;
		case 8:
			;
		case 10:
			;
		case 12:
			count = 31;
			System.out.println("该月份天数为三十一天");
			break;
		case 4:
			;
		case 6:
			;
		case 9:
			;
		case 11:
			count = 30;
			System.out.println("该月份天数为三十天");
			break;
		case 2:
			if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
				count = 29;
				System.out.println("闰年二月为二十九天");
			} else {
				count = 28;
				System.out.println("非闰年二月为二十八天");
			}
			break;
		default:
			System.out.println("请输入12以内的正整数！");
		}
		return count;
	}

	public static void main(String[] args) {
		int yearIni = 1900;
		int monthIni = 2;
		//运行配置中对args这个字符串数组（命令行参数）有预定义
		if (args.length >= 1)
			monthIni = Integer.parseInt(args[0]);
		if (args.length >= 2)
			yearIni = Integer.parseInt(args[1]);
		System.out.println(monthIni + "/" + yearIni + " has " + countDays(monthIni, yearIni) + " days.");
	}

}
