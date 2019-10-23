package com.chapter16;

//@FunctionalInterface
/**
 * 配合测试lambda的实现类型和限制还有Comparator#equals方法不用实现的原因
 * 
 * @author Iron Core
 * @date 2019年7月30日
 * @note {@see Comparator}中的equals方法不需要实现，因为所有类默认继承Object的equals方法，相当于已经重写。
 * 		 lambda表达式实现的类型必须是函数式接口functional interface，也就是只有一个方法的接口。
 *       （lambda表达式实现的类型不能是抽象类，但内部类可以）。
 */
public interface TestComparator {
	void show();
	// void bark();

	boolean equals(Object obj);

}
