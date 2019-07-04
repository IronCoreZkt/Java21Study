package com.chapter7;

/**
 * @author Iron Core
 * @description finally和catch块中一般情况不应带return语句，
 * 目前测试结果为这些块中带return的话调用者会接收不到其抛出的exception对象。
 * @date 2019年6月26日 
 * 
 */
public class TestException2 {
	public TestException2() {
	}
 
	boolean testEx() throws Exception {
		boolean ret = true;
		try {
			ret = testEx1();
		} catch (Exception e) {
			System.out.println("testEx, catch exception");
			ret = false;
			throw e;
		} finally {
			System.out.println("testEx, finally; return value=" + ret);
			return ret;
		}
	}
 
	boolean testEx1() throws Exception {
		boolean ret = true;
		try {
			ret = testEx2();
			if (!ret) {
				return false;
			}
			System.out.println("testEx1, at the end of try");
			return ret;
		} catch (Exception e) {
			System.out.println("testEx1, catch exception");
			ret = false;
			throw e;
		} finally {
			System.out.println("testEx1, finally; return value=" + ret);
			return ret;
		}
	}
 
	boolean testEx2() throws Exception {
		boolean ret = true;
		try {
			int b = 12;
			int c;
			for (int i = 2; i >= -2; i--) {
				c = b / i;
				System.out.println("i=" + i);
			}
			return true;
		} catch (Exception e) {
			System.out.println("testEx2, catch exception");
			ret = false;
			throw e;
		} finally {
			System.out.println("testEx2, finally; return value=" + ret);
			//return ret;
		}
	}
 
	public static void main(String[] args) {
		TestException2 testException2 = new TestException2();
		try {
			testException2.testEx();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}