package com.chapter17;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 本程序与连接到4415端口的客户端程序建立连接，显示当前时间并关闭连接。
 * 
 * @author Iron Core
 * @date 2019年8月15日
 * @note windows要在控制面板-程序-启用或关闭windows功能中打开Telnet客户端选项，然后在cmd中输入telnet localhost
 *       4415来查看运行情况。
 *
 */
public class TimeServer extends Thread {
	private ServerSocket sock;

	public TimeServer() {
		super();
		try {
			sock = new ServerSocket(4415);
			System.out.println("TimeServer is running...");
		} catch (IOException e) {
			System.out.println("Error: couldn't create socket.");
			System.exit(1);
		}
	}

	public void run() {
		Socket client = null;
		while (true) {
			if (sock == null)
				return;
			try {
				// ServerSocket.accept()监听指定的端口并接收来自客户端的连接。
				client = sock.accept();
				BufferedOutputStream bb = new BufferedOutputStream(client.getOutputStream());
				PrintStream os = new PrintStream(bb);
				os.println(new Date());
				os.flush();
				os.close();
				client.close();
			} catch (IOException e) {
				System.out.println("Error: couldn't connect.");
				e.printStackTrace();
				System.exit(1);
			}

		}
	}

	public static void main(String[] args) {
		TimeServer server = new TimeServer();
		server.run();
	}

}
