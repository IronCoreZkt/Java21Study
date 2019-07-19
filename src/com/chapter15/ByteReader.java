package com.chapter15;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 测试文件输入流FileInputStream
 * 
 * @author Iron Core
 * @date 2019年7月18日
 * @note 只写文件名则默认地址为项目文件夹下，本项目则为Java21文件夹。{@link FileInputStream}继承 {@link java.io.InputStream}
 * 
 */
public class ByteReader {
	public static void main(String[] args) {
		try (FileInputStream file =
				// new FileInputStream("doge_thumb.gif");
				new FileInputStream(".\\src\\com\\chapter15\\doge_thumb.gif")) {
			boolean eof = false;
			int count = 0;
			while (!eof) {
				int input = file.read();
				System.out.print(input + " ");
				if (input == -1)
					eof = true;
				else
					count++;
			}
			file.close();
			System.out.println("\nBytes read:" + count);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error -- " + e.toString());
		}

	}

}
