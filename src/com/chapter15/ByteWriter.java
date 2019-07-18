package com.chapter15;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 测试文件输出流FileOutputStream
 * 
 * @author Iron Core
 * @date 2019年7月18日
 * @note 从JDK7开始的try-with-resource使关闭资源变得方便。
 * 
 */
public class ByteWriter {
	public static void main(String[] args) {
		int[] data = { 71, 73, 70, 56, 57, 97, 13, 0, 12, 0, 145, 0, 0, 255, 255, 255, 255, 255, 0, 0, 0, 0, 0, 0, 0,
				44, 0, 0, 0, 0, 13, 0, 12, 0, 0, 2, 38, 132, 45, 121, 11, 25, 175, 150, 120, 20, 162, 132, 51, 110, 106,
				239, 22, 8, 160, 56, 137, 96, 72, 77, 33, 130, 86, 37, 219, 182, 230, 137, 89, 82, 181, 50, 220, 103,
				20, 0, 59 };
		// try-with-resource, since jdk7
		try (FileOutputStream file = new FileOutputStream(".\\src\\com\\chapter15\\pic.gif")) {
			for (int i = 0; i < data.length; i++) {
				file.write(data[i]);
			}
			System.out.println("输出完成");
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error -- " + e.toString());
		}
		try {

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
