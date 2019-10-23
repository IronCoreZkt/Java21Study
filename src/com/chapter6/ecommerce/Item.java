package com.chapter6.ecommerce;

/**
 * Item 是一个支持类，它表示网上商店出售的产品。
 * 其中有一些私有实例变量，用于存储产品的 ID、名称、库存（数量）、零售价格和是否参与打折。
 * @author Iron Core
 *
 */

public class Item implements Comparable {
	private String id;
	private String name;
	private double retail;
	private double price;
	private int quantity;
	private boolean noDiscount;

	Item(String idIn, String nameIn, String retailIn, String qIn, String discountIn) {
		id = idIn;
		name = nameIn;
		retail = Double.parseDouble(retailIn);
		quantity = Integer.parseInt(qIn);
		noDiscount = discountIn.equals("true");
		if(noDiscount == true)
			price = retail;
		else if (quantity > 400)
			price = retail * .5D;
		else if (quantity > 200)
			price = retail * .6D;
		else
			price = retail * .7D;
		// floor函数求小于等于参数的最大整数，这句话的作用就是四舍五入，并保留两位或更少的小数
		price = Math.floor(price * 100 + 0.5) / 100;
	}
	
	public int compareTo(Object o) {
		Item temp = (Item) o;
		if (price > temp.price)
			return 1;
		else if (price < temp.price)
			return -1;
		return 0;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getRetail() {
		return retail;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

}
