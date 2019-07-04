package com.chapter7;

/**
 * @author Iron Core
 * @description 读取十六进制字串
 * @date 2019年6月25日
 * 
 */
public class HexReader {
	String[] input = { "000A110D1D260219", "78700F1318141E0C", "6A197D45B0FFFFFF" };

	public static void main(String[] args) {
		HexReader hr = new HexReader();
		for (int i = 0; i < hr.input.length; i++) {
			hr.readLine(hr.input[i]);
		}
		String testStr = "abcde";
		//返回bc而不是bcd
		System.out.println(testStr.substring(1,3));
	}

	public void readLine(String str) {
		try {
			for (int j = 0; j + 1 < str.length(); j += 2) {
				String sub = str.substring(j, j + 2);
				int num = Integer.parseInt(sub, 16);
				if (num == 255) {
					break;
				}
				System.out.print(num + " ");
			}
		} finally {
			System.out.println("finally块**");
		}
	}

}
