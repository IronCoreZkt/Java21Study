package com.chapter15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.chapter7.HexReader;

/**
 * 利用第7章的程序HexRead，使其从文本文件中读取两位的十六进制序列，并显示相应的十进制值
 * 
 * @author Iron Core
 * @date 2019年7月24日
 * @note 文本文件也就是字符流，所以使用Reader/Writer系的类（FileReader/BufferedReader）
 * 
 */
public class HexTxtReader {

	public static void main(String[] args) {
		try (FileReader file = new FileReader(".\\src\\com\\chapter15\\HexData.txt");
				BufferedReader buff = new BufferedReader(file)) {
			HexReader hr = new HexReader();
			boolean eof = false;
			System.out.println("INFO:读取开始!");
			while (!eof) {
				String hextxt = buff.readLine();
				if (hextxt != null)
					hr.readLine(hextxt);
				else
					eof = true;
			}
			buff.close();
			System.out.println("INFO:读取完毕!");
		} catch (IOException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}
}
