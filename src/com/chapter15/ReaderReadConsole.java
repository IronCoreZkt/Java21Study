package com.chapter15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReaderReadConsole {

	public static void main(String[] args) {
		String command;
		System.out.println("请输入：");
		//InputStreamReader可以读取InputStream类型的输入，System.in是InputStream类型。
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			command = br.readLine();
			System.out.println(command);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
