package com.chapter16;

/**
 * 测试lambda的实现类型和限制还有Comparator#equals方法不用实现的原因
 * 
 * @author Iron Core
 * @date 2019年7月30日
 * @note {@see Comparator}中的equals方法不需要实现，因为所有类默认继承Object的equals方法，相当于已经重写。
 * 		 lambda表达式实现的类型必须是函数式接口functional interface，也就是只有一个方法的接口。
 *       （lambda表达式实现的类型不能是抽象类，但内部类可以）。
 * 
 */
public class TestComparator2 implements TestComparator{
	@Override
	public void show() {
		/*TestComparator tc = new TestComparator(){
			public void show() {
				System.out.println("内部类中的实现");
			}

			@Override
			public void bark() {
				// TODO 自动生成的方法存根
				
			}
		};*/
		TestComparator tc = ()->{
				System.out.println("内部类中的实现");
			};
		tc.show();
	}

	/*@Override
	public void bark() {
		// TODO 自动生成的方法存根
		
	}*/
	public static void main(String[] args){
		new TestComparator2().show();
	}
}
