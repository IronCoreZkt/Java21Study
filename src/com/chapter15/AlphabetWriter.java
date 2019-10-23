package com.chapter15;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 本类通过BufferedWriter装载FileWriter关联的文件输出源Alphabet.txt输出ASCII65到90的大写英文字母。
 * 
 * @author Iron Core
 * @date 2019年7月22日
 * @note {@link BufferedWriter#newLine()}发送运行程序的平台使用的行尾字符
 * 
 */
public class AlphabetWriter {

	public static void main(String[] args) {
		try (FileWriter file = new FileWriter(".\\src\\com\\chapter15\\Alphabet.txt");
				BufferedWriter buff = new BufferedWriter(file)) {
			System.out.println("INFO:开始写入!");
			for (int i = 65; i < 91; i++) {
				//ASCII码一个字节八位，Unicode两字节十六位
				buff.write((char) i);
				if (i == 74 || i == 84)
					buff.newLine();
			}
			buff.close();
			System.out.println("INFO:写入完成!");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
