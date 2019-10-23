package com.chapter8;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ArrayList测试，主要关于contain,add操作。
 * 
 * @author Iron Core
 * @date 2019年7月15日
 * @note ArrayList超过指定容量的时候，数组列表会自动增长，增加的长度为旧（增加前）容量的一半，{@link ArrayList#grow}。
 * 
 */
public class CodeKeeper {
	ArrayList<String> list;
	String[] codes = { "alpha", "lambda", "gamma", "delta", "zeta" };

	public CodeKeeper(String[] userCodes) {
		list = new ArrayList<String>();
		// load built-in codes
		for (int i = 0; i < codes.length; i++) {
			addCode(codes[i]);
		}
		// load user codes
		for (int i = 0; i < userCodes.length; i++) {
			addCode(userCodes[i]);
		}
		// display all codes
		/*for (Iterator<String> ite = list.iterator(); ite.hasNext();) {
			System.out.println(ite.next());
		}*/
		for (String string : list) {
			System.out.println(string);
		}
	}

	private void addCode(String code) {
		if (!list.contains(code)) {
			list.add(code);
		}
	}
	
	public static void main(String[] args){
		CodeKeeper ck =new CodeKeeper(args);
	}

}
