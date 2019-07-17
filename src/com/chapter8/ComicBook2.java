package com.chapter8;

import java.util.HashMap;

/**
 * 改用enum枚举表示连环画的新旧程度
 * 
 * @author Iron Core
 * @date 2019年7月17日
 */
public class ComicBook2 {
	public ComicBook2() {
	}

	public static void main(String[] args) {
		Comic[] comix = new Comic[3];
		comix[0] = new Comic("Amazing Spider-Man", "1A", "very fine", 12_000.00F);
		comix[1] = new Comic("Incredible Hulk", "181", "near mint", 680.00F);
		comix[2] = new Comic("Cerebus", "1A", "good", 190.00F);
		for (int i = 0; i < comix.length; i++) {
			comix[i].setPrice(NewOldDegree.getFactorByDesc(comix[i].condition));
			System.out.println("TITLE:" + comix[i].title);
			System.out.println("ISSUENUMBER:" + comix[i].issueNumber);
			System.out.println("CONDITION:" + comix[i].condition);
			System.out.println("PRICE:" + comix[i].price + "\n");
		}

	}

	// 内部类，表示商品漫画信息
	static class Comic {
		String title;
		String issueNumber;
		String condition;
		float basePrice;
		float price;

		Comic(String inTitle, String inIssueBumber, String inCondition, float inBasePrice) {
			title = inTitle;
			issueNumber = inIssueBumber;
			condition = inCondition;
			basePrice = inBasePrice;
		}

		void setPrice(float factor) {
			price = basePrice * factor;
		}
	}
}
