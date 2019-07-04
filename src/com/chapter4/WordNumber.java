package com.chapter4;

public class WordNumber {
	public static void main(String[] args) {
		long num = 0L;
		if (args.length > 0) {
			switch (args[0]) {
			case "one":
				num = 1L;
				break;
			case "two":
				num = 2L;
				break;
			case "three":
				num = 3L;
				break;
			case "four":
				num = 4L;
				break;
			case "five":
				num = 5L;
				break;
			case "six":
				num = 6L;
				break;
			case "seven":
				num = 7L;
				break;
			case "eight":
				num = 8L;
				break;
			case "nine":
				num = 9L;
				break;
			case "ten":
				num = 10L;
				break;
			default:
				System.out.println("不是十内的英文字串（包括十且需要全小写）");
				;
			}
		}
		System.out.println("num=" + num);
	}

}
