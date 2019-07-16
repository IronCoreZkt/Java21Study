package com.chapter8;

import java.util.HashMap;

/**
 * 本类主要用于测试HashMap的映射功能。
 * 
 * @author Iron Core
 * @date 2019年7月16日
 * @note 本类中主要用了HashMap的put和get方法，key值唯一，如果多次put同一个key会导致后面的value覆盖掉前面的value值，也就是说get
 *       到该key的value是后面put进去的。本类还使用了比较少见的static类，static一般修饰类变量和类方法，修饰类时只能修饰内部类，
 *       使内部类不用新建一个外部类的实例后再实例化。
 * 
 */
public class ComicBook {
	public ComicBook() {
	}

	public static void main(String[] args) {
		// setup a hashmap
		HashMap<String, Float> quality = new HashMap<String, Float>();
		quality.put("mint", 3.00F);
		quality.put("near mint", 2.00F);
		quality.put("very fine", 1.50F);
		quality.put("fine", 1.00F);
		quality.put("good", 0.50F);
		quality.put("poor", 0.25F);
		// System.out.println(quality.get("mint"));
		Comic[] comix = new Comic[3];
		comix[0] = new Comic("Amazing Spider-Man", "1A", "very fine", 12_000.00F);
		comix[0].setPrice(quality.get(comix[0].condition));
		comix[1] = new Comic("Incredible Hulk", "181", "near mint", 680.00F);
		comix[1].setPrice(quality.get(comix[1].condition));
		comix[2] = new Comic("Cerebus", "1A", "good", 190.00F);
		comix[2].setPrice(quality.get(comix[2].condition));
		for (int i = 0; i < comix.length; i++) {
			System.out.println("TITLE:" + comix[i].title);
			System.out.println("ISSUENUMBER:" + comix[i].issueNumber);
			System.out.println("CONDITION:" + comix[i].condition);
			System.out.println("PRICE:" + comix[i].price + "\n");
		}

	}

	//内部类，表示商品漫画信息
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
