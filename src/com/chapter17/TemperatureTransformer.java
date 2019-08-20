package com.chapter17;

import java.nio.IntBuffer;

/**
 * 本类将华氏温度转换为摄氏温度，并将结果存储到一个缓冲区。
 * 
 * @author Iron Core
 * @date 2019年8月19日
 * @note Buffer类的flip方法可以刷新缓冲区的大小和目前位置，也可以使用position手动调目前位置。
 *
 */
public class TemperatureTransformer {

	public static void main(String[] args) {
		int[] temps = { 90, 85, 80, 75, 70, 65, 60, 70, 80, 90, 100 };
		IntBuffer tempsBuff = IntBuffer.wrap(temps);
		// IntBuffer tempsBuff = IntBuffer.allocate(temps.length);
		for (int i = 0; tempsBuff.remaining() > 0; i++) {
			if (i == 0)
				System.out.println("转换前：");
			System.out.print(tempsBuff.get() + " ");
		}
		tempsBuff.flip();
		// tempsBuff.position(0);
		for (int i = 0; i < temps.length; i++) {
			int celsius = (temps[i] - 32) / 9 * 5;
			tempsBuff.put(celsius);
		}
		// 把当前位置设置为缓冲区的开头
		tempsBuff.position(0);
		// 显示缓冲区的内容
		for (int i = 0; tempsBuff.remaining() > 0; i++) {
			if (i == 0)
				System.out.println("\n转换后：");
			System.out.print(tempsBuff.get() + " ");
		}
	}

}
