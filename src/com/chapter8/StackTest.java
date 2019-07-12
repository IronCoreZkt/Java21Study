package com.chapter8;

import java.util.Iterator;
import java.util.Stack;

/**
 * 测试Stack从Vector继承的迭代器
 * 
 * @author Iron Core
 * @date 2019年7月12日
 * @note 个人感觉栈后进先出就像手枪弹夹，而{@link Stack}是通过vector数组加上自己的一些方法实现栈这一数据结构的，
 *       并且它和{@link Vector}都是线程安全的（synchronized）。
 * 
 */
public class StackTest {
	public static void main(String[] args) {
		Stack<String> s = new Stack<String>();
		s.push("FirstItem");
		s.push("SecondItem");
		s.push("ThirdItem");
		s.push("FourthItem");
		System.out.println("现在弹出:" + s.pop());
		System.out.println("现在瞄一眼顶部元素:" + s.peek());
		for (Iterator<String> iterator = s.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);

		}
		/*
		 * for (String str : s) { System.out.println(str); }
		 */

	}
}
