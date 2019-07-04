package com.chapter4;

public class YearEachDayDisplayer {
	public static void main(String[] args) {
		int year = 2019;
		if (args.length > 0)
			year = Integer.parseInt(args[0]);
		for (int month = 1; month < 13; month++) {
			int days = DayCounter.countDays(month, year);
			for (int day = 1; day <= days; day++) {
				System.out.println(year + "年" + month + "月" + day + "日");
			}
		}
	}
}
