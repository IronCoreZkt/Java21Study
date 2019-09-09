package com.chapter17;

import java.nio.IntBuffer;

/**
 * 本类测试nio中缓冲区的put和get位置以加深对缓冲区当前位置position和限制limit的印象。
 * 
 * @author Iron Core
 * @date 2019年9月9日
 * @note nio包中buff的put(int[] src)会覆盖当前位置(position)到该数组src的长度（长度超过缓冲区大小会报错），
 *       然后将当前位置标记到src长度+1的位置。
 *
 */
public class ReadTemps {

	public ReadTemps() {
		int[] temps = { 25, 26, 27, 28, 29, 30 };
		IntBuffer buff = IntBuffer.wrap(temps);
		int[] autumn = { 20, 21, 22 };
		buff.put(autumn);
		//buff.flip();//flip刷新了缓冲区，并将限制limit设置为当前位置，28，29，30会被丢弃。
		buff.position(0);
		while (buff.hasRemaining())
			System.out.println("First position's content is " + buff.get() + ".");
	}

	public static void main(String[] args) {
		new ReadTemps();
	}

}
