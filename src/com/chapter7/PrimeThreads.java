package com.chapter7;

public class PrimeThreads {
	public static void main(String[] args) {
		/*
		 * PrimeFinder pf = new PrimeFinder(300); pf.run();
		 * System.out.println(pf.target+":"+pf.prime);
		 */
		PrimeThreads pt = new PrimeThreads(args);
		System.out.println(pt.getClass());
	}

	public PrimeThreads(String[] args) {
		PrimeFinder[] finder = new PrimeFinder[args.length];
		for (int i = 0; i < args.length; i++) {
			try {
				long count = Long.parseLong(args[i]);
				System.out.println("Looking for the " + count + " prime...");
				finder[i] = new PrimeFinder(count);
			} catch (NumberFormatException nfe) {
				System.out.println("Please input correct integer!");
				System.out.println("errMsg:" + nfe.getMessage());
				nfe.printStackTrace();
			} catch (NegativeNumberException e) {
				e.printStackTrace();
			}
		}
		boolean isCompleted = false;
		//检查所有的PrimerFinder线程是否都已经结束
		while (!isCompleted) {
			isCompleted = true;
			for (int j = 0; j < finder.length; j++) {
				if (finder[j] == null)
					continue;
				if (!finder[j].finished) {
					isCompleted = false;
				} else {
					displayResult(finder[j]);
					//将线程设置为null，以释放该对象占用的资源（并防止其结果被显示多次）
					finder[j] = null;
				}
			}
			//将线程设置为null，以释放该对象占用的资源（并防止其结果被显示多次）
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				//do nothing
			}
		}
	}

	private void displayResult(PrimeFinder pf) {
		System.out.println("The " + pf.target + " prime:" + pf.prime);

	}

}
