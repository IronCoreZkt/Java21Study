package com.chapter6.ecommerce;

/**
 * GiftShop 演示了类 Storefront 和 Item 使之可用的公有接口的每一部分。
 * 创建网上商店；
 * 添加商品；
 * 按销售价格将商品排序；
 * 遍历链表，显示每种商品的信息。
 * @author Iron Core
 *
 */
public class GiftShop {
	public static void main(String[] args) {
		StoreFront sf = new StoreFront();
		sf.addItem("C01", "MUG", "9.99", "150", "false");
		sf.addItem("C02", "LG MUG", "12.99", "82", "true");
		sf.addItem("C03", "MOUSEPAD", "10.49", "800", "false");
		sf.addItem("D01", "TSHIRT", "16.99", "90", "true");
		sf.sort();

		int sfSize = sf.getSize();
		for (int i = 0; i < sfSize; i++) {
			Item show =sf.getItem(i);
			System.out.println("\nItem ID："+show.getId()+
					"\nName:"+show.getName()+
					"\nRetail Price:"+show.getRetail()+
					"\nPrice:"+show.getPrice()+
					"\nQuantity:"+show.getQuantity());
		}
	}
}
