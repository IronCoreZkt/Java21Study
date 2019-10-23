package com.chapter6;

/**
 * @author Iron Core
 * 在子类中，方法的可见性不能低于它覆盖的方法的可见性;
 * 作为通用的规则，覆盖方法时，新方法的访问控制不能比原来的方法更严格;
 */
public class ExtendsOverrideVisuality {
	int i = 10;
	private void show(){
		System.out.println(i);
	}
}

class EOVSon extends ExtendsOverrideVisuality{
	void show(){
		System.out.println("i="+i);
	}
}