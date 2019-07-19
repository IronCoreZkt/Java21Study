package com.chapter15;

import java.io.BufferedInputStream;
import java.io.IOException;

/**
 * 本类主要用于测试控制台输入流{@link System#in}
 * 
 * @author Iron Core
 * @date 2019年7月19日
 * @note System类位于java.lang包中，in为InputStream类常量。
 * 
 */
public class ConsoleInput {
	public static String readLine() {
		StringBuilder res = new StringBuilder();
		try (BufferedInputStream buff = new BufferedInputStream(System.in)) {
			int in;
			char inChar;
			do {
				in = buff.read();
				inChar = (char) in;
				if ((in != -1) && (in != '\n') && (in != '\r'))
					res.append(inChar);
			} while ((in != -1) && (in != '\n') && (in != '\r'));
			buff.close();
			return res.toString();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error:" + e.getMessage());
			return null;
		}
	}

	public static void main(String[] args) {
		System.out.println("What's your name?");
		System.out.println("\nHello, " + ConsoleInput.readLine());
	}

}
