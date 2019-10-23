package com.chapter17;

import java.nio.Buffer;
import java.nio.IntBuffer;

/**
 * 本类测试nio中缓冲区的put和get位置以加深对缓冲区当前位置position和限制limit的印象。
 * 
 * @author Iron Core
 * @date 2019年9月9日
 * @note nio包中Buffer的put(int[] src)会覆盖当前位置(position)到该数组src的长度（长度超过缓冲区大小会报错），
 *       然后将当前位置标记到src长度+1的位置。
 *       实际上Buffer类还有标记mark和容量capacity，mark<=position<=limit<=capacity，但在这里我们不关注它们。
 *
 */
public class ReadTemps {

	public ReadTemps() {
		int[] temps = { 25, 26, 27, 28, 29, 30 };
		IntBuffer buff = IntBuffer.wrap(temps);
		int[] autumn = { 20, 21, 22 };
		showCurrentLimitAndPosition(buff);
		buff.put(autumn);
		showCurrentLimitAndPosition(buff);
		buff.flip();//flip刷新了缓冲区，并将限制limit设置为当前位置，28，29，30会被丢弃。
		showCurrentLimitAndPosition(buff);
		//buff.position(0);
		for (int i =0;buff.hasRemaining();i++)
			System.out.println("The "+i+" position's content is " + buff.get() + ".");
		showCurrentLimitAndPosition(buff);
	}

	public static void main(String[] args) {
		new ReadTemps();
	}
	
	public static final void showCurrentLimitAndPosition(Buffer buff){
		System.out.println("此时限制\t\tlimit="+buff.limit());
		System.out.println("此时当前位置\tposition="+buff.position());
	}

}
