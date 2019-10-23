package com.chapter7;

/**
 * @author Iron Core
 * @description PrimeFinder类查找特定的素数，如第100个素数、第1000个素数或第30000个素数
 * @date 2019年6月27日
 * 
 */
public class PrimeFinder implements Runnable {// PrimeFinder 类实现了 Runnable接口，因此可将其作为线程运行
	public long target;// 指出要查找的第几个素数
	public long prime;// 用于存储找到的最后一个素数
	public boolean finished = false;
	private Thread runner;

	public PrimeFinder(long inTarget) throws NegativeNumberException{
		if (inTarget < 0) {
			throw new NegativeNumberException("请不要用负数作为指定数");
		}
		target = inTarget;
		if (runner == null) {
			runner = new Thread(this);
			runner.start();
		}
	}

	/**
	 * 重写Runnable接口的run方法
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		long numOfPrime = 0;
		long candidate = 2;
		while (numOfPrime < target) {
			if (isPrime(candidate)) {
				numOfPrime++;
				prime = candidate;
				// System.out.println("第"+numOfPrime+"个素数为："+candidate);
			}
			candidate++;
		}
		finished = true;
	}

	/**
	 * 判断传入的参数是否为素数
	 * 
	 * @param checkNumber
	 * @return
	 */
	private boolean isPrime(long checkNumber) {
		double root = Math.sqrt(checkNumber);// Math.sqrt()方法用于返回参数的算术平方根。
		for (int i = 2; i <= root; i++) {
			// 如果一个数能被2或更大的数整除（余数为 0），则说明它不是素数
			if (checkNumber % i == 0) {
				return false;
			}
		}
		return true;
	}

}

class NegativeNumberException extends Exception {
	private static final long serialVersionUID = 1L;
	String errorMsg = null;
	public NegativeNumberException(String msg) {
		this.errorMsg=msg;
	}
	@Override
	public String getMessage() {
		return errorMsg;
	}
}
