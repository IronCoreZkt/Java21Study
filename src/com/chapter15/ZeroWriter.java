package com.chapter15;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 读取一个文件以判断其中的字节数，然后使用0覆盖该文件所有的字节。
 * 
 * @author Iron Core
 * @date 2019年7月24日
 * @note 判断字节数，所以使用字节流，InputStream/OutputStream系的类（FileInputStream/BufferedInputStream）。
 * 
 */
public class ZeroWriter {

	public static void main(String[] args) {
		int bytes = ZeroWriter.readByteNumber();
		System.out.println("\n读取完毕，字节数为："+bytes);
		ZeroWriter.writeZero(bytes);
		System.out.println("写入完毕！");
	}

	public static int readByteNumber() {
		try (FileInputStream fileIn = new FileInputStream(".\\src\\com\\chapter15\\ZeroWriterDataFile.dat");
				BufferedInputStream buffIn = new BufferedInputStream(fileIn)) {
			System.out.println("开始读取字节并计数");
			int count = 0, a;
			do {
				a = buffIn.read();
				if (a != -1) {
					count++;
					System.out.print(" "+ a);
				}
			} while (a != -1);
			buffIn.close();
			return count;
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static boolean writeZero(int number) {
		try (FileOutputStream fileOut = new FileOutputStream(".\\src\\com\\chapter15\\ZeroWriterDataFile.dat");
				BufferedOutputStream buffOut = new BufferedOutputStream(fileOut)) {
			System.out.println("开始写0");
			for (int i = 0; i < number; i++)
				buffOut.write(0);
			buffOut.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
