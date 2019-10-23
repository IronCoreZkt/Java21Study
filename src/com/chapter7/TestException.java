package com.chapter7;

/**
 * @author Iron Core
 * @description JAVA异常功能测试
 */
public class TestException {

	static int quotient(int x, int y) throws MyException {
		if (y < 0) {
			//try {
				throw new MyException("除数不能为负数！aaa");
			/*//测试return和throw
			} catch (MyException mye) {
				System.out.println("catch块");
				throw new MyException("除数不能为负数！bbb");
			} finally {
				System.out.println("finally块");
				return 1111111;
			}*/
		}
		return x / y;
	}

	// 主方法入口
	public static void main(String[] args) {
		try {
			int result = quotient(9, -1);
			System.out.println(result);
		} catch (MyException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
			// System.out.println("除数不能为零");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("END TRY//CATCH");
		}

	}
}

/**
 * @description 自定义异常
 */
class MyException extends Exception {
	private static final long serialVersionUID = 1L;
	private String msg;

	/**
	 * @param errorMsg
	 * @function 构造函数
	 */
	public MyException(String errorMsg) {
		// super(errorMsg);
		System.out.println("建立异常对象！");
		this.msg = errorMsg;
	}

	@Override
	public String getMessage() {
		return this.msg;
	}
}