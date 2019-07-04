package com.chapter3;

public class AyeAye {
	int i = 40;

	public AyeAye() {
		setValue(i++);
	}

	void setValue(int inputValue) {
		System.out.println("inputValue = " + inputValue);
		System.out.println("i="+i);
		System.out.println("end init");
		
	}
	
	void showValue(){
		System.out.println("i="+i);
	}
	
	public static void main(String[] args){
		AyeAye aa = new AyeAye();
		aa.showValue();
	}
}