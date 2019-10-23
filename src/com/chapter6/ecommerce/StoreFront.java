package com.chapter6.ecommerce;

import java.util.Collections;
import java.util.LinkedList;
/**
 * 表示出售这些商品的网上商店
 * @author Iron Core
 *
 */
public class StoreFront {
	private LinkedList<Item> catalog = new LinkedList<Item>();

	/**
	 * 添加商品
	 * @param id
	 * @param name
	 * @param price
	 * @param quantity
	 * @param noDiscount
	 */
	public void addItem(String id, String name, String price, String quantity, String noDiscount) {
		Item item = new Item(id, name, price, quantity, noDiscount);
		catalog.add(item);
	}

	public Item getItem(int i) {
		return catalog.get(i);
	}

	public int getSize() {
		return catalog.size();
	}

	/**
	 * 调用Item中的compareTo方法按照价格price排序
	 */
	public void sort() {
		/*体现了在类 Item 中实现 Comparable 接口的好处。
		*类方法Collections.sort()将对链表和其他数据结构中的对象进行排序，期间将调用对象的
		*compareTo()方法确定排列顺序。
		*/
		Collections.sort(catalog);
	}
}
