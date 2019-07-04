package com.chapter3;

public class Pool {
	int height;
	int weight;
	int depth;
	public static void main(String[] args){
		Pool p = new Pool();
		p.height = 6;
		p.weight = 4;
		p.depth = 3;
		System.out.println("水池高"+p.height+"米,宽"+p.weight+"米,深"+p.depth+"米。");
	}

}
