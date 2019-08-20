package com.chapter17;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * 本应用程序BufferConvertor将一个小型文件的内容读入到字节缓冲区中，显示缓冲区的内容，
 * 将该缓冲区转换为字符缓冲区，然后显示字符缓冲区的内容。
 * 
 * @author Iron Core
 * @date 2019年8月20日
 * @note 本类使用了java.nio中的缓冲区、java.nio.charset中的字符集和java.nio.channels中的通道，
 *       首先创建一个文件输入字节流，使用该流的getChannel方法创建文件通道，
 *       其次是使用该通道的size方法返回的长度创建字节缓冲区，使用通道的read方法将数据从通道读到缓冲区，
 *       如此，就有了包含原始字节数据的缓冲区，
 *       最后就是使用字符集解码字节缓冲区到字符缓冲区。
 *
 */
public class BufferConvertor {

	public static void main(String[] args) {

		String data = ".\\src\\com\\chapter17\\friends.dat";
		try (FileInputStream inData = new FileInputStream(data)) {
			// read byte data into a byte buffer
			FileChannel inChannel = inData.getChannel();
			long size = inChannel.size();
			ByteBuffer source = ByteBuffer.allocate((int) size);
			inChannel.read(source, 0);
			source.position(0);
			System.out.println("Original byte data: ");
			while (source.remaining() > 0) {
				System.out.print(source.get() + " ");
			}
			// convert byte data into character data
			source.position(0);
			Charset ascii = Charset.forName("US-ASCII");
			CharsetDecoder toAscii = ascii.newDecoder();
			CharBuffer aimData = toAscii.decode(source);
			aimData.position(0);
			System.out.println("\n\nNew character data: ");
			while (aimData.remaining() > 0) {
				System.out.print(aimData.get());
			}
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
			System.out.println("ERROR：未发现指定目标文件!\n" + fnfe.getMessage());
		} catch (CharacterCodingException cce) {
			cce.printStackTrace();
			System.out.println("ERROR：字符编码错误!\n" + cce.getMessage());
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.out.println("ERROR：输入输出错误!\n" + ioe.getMessage());
		}

	}

}
