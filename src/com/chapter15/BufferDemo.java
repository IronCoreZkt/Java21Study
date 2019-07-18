package com.chapter15;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 测试缓存流（过滤流）BufferedInputStream和BufferedOutputStream
 * 
 * @author Iron Core
 * @date 2019年7月18日
 * @note {@link BufferedInputStream}继承文件流{@link FileInputStream}，FileInputStream继承InputStream抽象类。
 * 
 */
public class BufferDemo {
	public static void main(String[] args) {
		int start = 0;
		int finish = 255;
		if (args.length > 1) {
			start = Integer.parseInt(args[0]);
			finish = Integer.parseInt(args[1]);
		} else if (args.length > 0) {
			start = Integer.parseInt(args[0]);
		}
		ArgStream as = new ArgStream(start, finish);
		System.out.println("Writing:");
		boolean writesuccess = as.writeStream();
		System.out.println("\nwrite data " + (writesuccess ? "successful" : "failed") + "\nReading:");
		boolean readsuccess = as.readStream();
		System.out.println("read data " + (readsuccess ? "successful" : "failed"));

	}
}

class ArgStream {
	int start;
	int finish;

	public ArgStream(int inStart, int inFinish) {
		this.start = inStart;
		this.finish = inFinish;
	}

	public boolean writeStream() {
		try (FileOutputStream file = new FileOutputStream(".\\src\\com\\chapter15\\numbers.dat");
				BufferedOutputStream buff = new BufferedOutputStream(file);) {
			for (int out = start; out <= finish; out++) {
				buff.write(out);
				System.out.print(" " + out);
			}
			buff.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean readStream() {
		try (FileInputStream file = new FileInputStream(".\\src\\com\\chapter15\\numbers.dat");
				BufferedInputStream buff = new BufferedInputStream(file);) {
			int in;
			do {
				in = buff.read();
				if (in != -1)
					System.out.print(" " + in);
			} while (in != -1);
			System.out.println();
			buff.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception:" + e.getMessage());
			return false;
		}
	}

}