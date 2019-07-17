package com.chapter8;

import java.util.BitSet;

/**
 * Bitset类的使用，一组开/关（布尔）值
 * 
 * @author Iron Core
 * @date 2019年7月10日
 * 
 */
public class HolidaySked {
	BitSet sked;

	public HolidaySked() {
		sked = new BitSet(365);
		int[] holiday = { 1, 15, 50, 148, 185, 246, 281, 316, 326, 359 };
		for (int i = 0; i < holiday.length; i++) {
			addHoliday(holiday[i]);
		}
	}

	private void addHoliday(int holidayIn) {
		sked.set(holidayIn);
	}

	public boolean isHoliday(int dayToCheck) {
		return sked.get(dayToCheck);
	}

	public static void main(String[] args) {
		HolidaySked hs = new HolidaySked();
		boolean rslt = hs.isHoliday(50);
		System.out.println("第50天" + (rslt ? "是" : "不是") + "节假日。");
	}

}
