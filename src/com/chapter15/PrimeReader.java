package com.chapter15;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 本类PrimeReader读取Primes.dat中的整数，并将它们显示出来。
 * 
 * @author Iron Core
 * @date 2019年7月19日
 * @note 
 * 
 */
public class PrimeReader {
	public static void main(String[] args) {
		try (FileInputStream file = new FileInputStream(".\\src\\com\\chapter15\\Primes.dat");
				BufferedInputStream buff = new BufferedInputStream(file);
				DataInputStream data = new DataInputStream(buff)) {
			try {
				int in;
				do {
					in = data.readInt();
					//System.out.print(buff.read()+" ");
					System.out.print(in+" ");
				} while (true);
			} catch (EOFException eofe) {
				data.close();
				buff.close();
				System.out.println("\n读取完毕");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
