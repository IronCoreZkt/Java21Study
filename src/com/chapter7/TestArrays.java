package com.chapter7;

import com.chapter8.NewOldDegree;

public class TestArrays {
	public static void main(String[] args) {
		int[] inta = new int[3];
		/*inta[0] = 6;
		inta[1] = 5;
		inta[2] = 7;
		inta[3] = 8;*/
		System.out.println(inta.length+" "+inta[1]);
		NewOldDegree nod = NewOldDegree.COVERLESS;
		System.out.println(NewOldDegree.GOOD);
		System.out.println(nod.getDesc());
	}

}
