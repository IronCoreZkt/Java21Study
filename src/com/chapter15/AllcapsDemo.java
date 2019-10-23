package com.chapter15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 本类将文件（/Java21/src/com/chapter15/AllcapsDemoSourceFile.txt，在运行参数中配置）中的所有文本转换为大写字符。
 * 
 * @author Iron Core
 * @date 2019年7月23日
 * @note 本类使用缓冲输入流来读取文件，每次读取一个字符。将字符转换为大写后，使用缓冲输出流将其发送到临时文件中。这里使用File
 *       对象（而不是字符串）来指出涉及的文件，因此可以在需要时删除文件和对其进行重命名。
 * 
 */
public class AllcapsDemo {
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("You must specify a filename");
			System.exit(-1);
		}
		AllCaps cap = new AllCaps(args[0]);
		cap.convert();
	}
}

/**
 * 助手类，完成小写到大写的转换。
 * 
 * @author Iron Core
 * @date 2019年7月23日
 * @note
 * 
 */
class AllCaps {
	String sourceName;

	public AllCaps(String sourceArg) {
		sourceName = sourceArg;
	}

	public void convert() {
		try {
			// create file objects
			FileSystem fs = FileSystems.getDefault();
			Path source = fs.getPath(sourceName);
			Path temp = fs.getPath(sourceName + "_tmp");
			// create input stream
			FileReader fr = new FileReader(source.toFile());
			BufferedReader in = new BufferedReader(fr);
			// create output stream
			FileWriter fw = new FileWriter(temp.toFile());
			BufferedWriter out = new BufferedWriter(fw);

			boolean eof = false;
			int inChar;
			System.out.println("INFO -- 开始转换！");
			do {
				inChar = in.read();
				if (inChar != -1) {
					System.out.print((char) inChar);
					char outChar = Character.toUpperCase((char) inChar);
					out.write(outChar);
				} else
					eof = true;
			} while (!eof);
			in.close();
			out.close();
			// 类方法 delete(Path)删除路径参数指定的文件。
			Files.delete(source);
			// 类方法 move(Path, Path)将前一个路径参数指定的文件重命名为第二个路径参数指定的文件。
			Files.move(temp, source);
			System.out.println("INFO -- 转换完成！");
		} catch (IOException | SecurityException e) {
			// e.printStackTrace();
			System.out.println("Error -- " + e.getMessage());
		}

	}
}
