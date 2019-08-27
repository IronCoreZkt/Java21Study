package com.chapter17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

/**
 * 本类用于练习套接字，是一个基本的Finger客户端。
 * 
 * @author Iron Core
 * @date 2019年8月14日
 * @note Finger是向系统查询其用户的协议。通过建立Finger服务器，系统管理员让连接到Internet
 *       的机器能够回答有关用户信息的查询。用户可以通过创建.plan文件来提供有关自己的信息，
 *       这些信息将被发送给使用Finger来询问的用户。
 *
 */
public class Finger {
	public static void main(String[] args) {
		String user;
		String host;
		// 发出Finger请求，指定用户名并加上@和主机名，其格式和电子邮件地址相同。
		if ((args.length == 1) && (args[0].indexOf("@") > -1)) {
			// StringTokenizer将输入的参数（格式为user@host）转换为两个String对象。
			StringTokenizer split = new StringTokenizer(args[0], "@");
			user = split.nextToken();
			host = split.nextToken();
		} else {
			System.out.println("请输入项目启动参数，Usage：java Finger user@host");
			return;
		}
		try (Socket digit = new Socket(host, 79); // 79一般为保留给Finger服务的端口
				BufferedReader in = new BufferedReader(new InputStreamReader(digit.getInputStream()))) {
			digit.setSoTimeout(20000);// 超过20s为超时
			// Finger服务要求通过套接字发送要查询的用户名，并在后面加上回车和换行。
			PrintStream out = new PrintStream(digit.getOutputStream());
			out.print(user + "\015\012");// "\ddd"为八进制，即13CR和10LF
			boolean eof = false;
			while (!eof) {
				String line = in.readLine();
				if (line != null)
					System.out.println(line);
				else
					eof = true;
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
