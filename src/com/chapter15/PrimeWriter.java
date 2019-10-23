package com.chapter15;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 本类使用数据流（过滤流）DataOutputStream将前指定个数素数作为整数写入文件Primes.dat。
 * 
 * @author Iron Core
 * @date 2019年7月19日
 * @note 
 * 
 */
public class PrimeWriter {

	public static void main(String[] args) {
		int[] primes = new int[10];
		int numPrime = 0;
		// candidate候选人: the number that might be prime
		int candidate = 2;
		while (numPrime < primes.length) {
			if (isPrime(candidate)) {
				primes[numPrime] = candidate;
				numPrime++;
			}
			candidate++;
		}
		try (FileOutputStream file = new FileOutputStream(".\\src\\com\\chapter15\\Primes.dat");
				BufferedOutputStream buff = new BufferedOutputStream(file);
				DataOutputStream data = new DataOutputStream(buff)) {
			for (int i = 0; i < primes.length; i++) {
				data.writeInt(primes[i]);
			}
			data.close();
			System.out.println("Wirte file successfully, close the stream.");
		} catch (IOException e) {
			System.out.println("Error -- " + e.getMessage());
		}

	}

	private static boolean isPrime(int checknumber) {
		double root = Math.sqrt(checknumber);
		for (int i = 2; i <= root; i++) {
			if (checknumber % i == 0)
				return false;
		}
		return true;
	}

}
