package com.chapter8;

/**
 * 枚举测试
 * 
 * @author Iron Core
 * @date 2019年7月17日
 * @note 所有的枚举都继承自java.lang.Enum类，枚举个人看来就是类的数组（参考枚举values方法），
 *       values方法会返回一个枚举内元素的数组，每个单独的枚举元素都属于这个枚举的类型，都可以有其属性和方法，{@see TestArrays}
 *       并且枚举的访问权限限定符只能是public，默认也是public，其构造函数为private。
 * 
 */
public enum NewOldDegree {
	PRISTINEMINT("pristine mint", 5.00F),
	MINT("mint", 3.00F),
	NEARMINT("near mint", 2.00F),
	VERYFINE("very fine", 1.50F),
	FINE("fine", 1.00F), 
	GOOD("good", 0.50F),
	POOR("poor", 0.25F), 
	COVERLESS("coverless", 0.10F);
	
	private String desc;
	private float factor;
	
	private NewOldDegree(String inDesc,float inFactor){
		this.desc= inDesc;
		this.factor= inFactor;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public float getFactor() {
		return factor;
	}
	public static float getFactorByDesc(String inDesc) {
		for (NewOldDegree nod : NewOldDegree.values()) {
			if(nod.getDesc()==inDesc){
				return nod.factor;
			}
		}
		return -1F;
	}
	public void setFactor(float factor) {
		this.factor = factor;
	}
}
