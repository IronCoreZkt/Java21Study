package com.chapter15;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 通过缓冲字符流读取自己的源代码（读取文本文件）
 * 
 * @author Iron Core
 * @date 2019年7月22日
 * @note Reader(abstract)>InputStreamReader>FileReader
 *       Reader(abstract)>BufferedReader
 *       {@link BufferedReader#readLine} 返回一个
 *       String对象，其中包含流中的下一行文本，但不包括表示行尾的字符。 如果到达流尾，则返回 null。
 *       个人总结，字符流就是以特定字节数（2字节byte/18位bit）去解析字节流然后返回特定字节数表示的字符。
 * 
 */
public class SourceReader {
	public static void main(String[] args) {
		try (FileReader file = new FileReader(".\\src\\com\\chapter15\\SourceReader.java"); // 关联输入源与文件
				BufferedReader buff = new BufferedReader(file)// 关联缓冲过滤器与输入源
		) {
			System.out.println("INFO:读取开始!");
			boolean eof = false;
			while (!eof) {
				String line = buff.readLine();
				if (line == null)
					eof = true;
				else
					System.out.println(line);
			}
			System.out.println("INFO:读取完毕!");
			buff.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

}
