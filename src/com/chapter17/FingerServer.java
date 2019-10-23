package com.chapter17;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 本程序为非阻断套接字的客户和服务器,使用方法类似TimeServer。
 * 
 * @author Iron Core
 * @date 2019年9月3日
 * @note 前面TimeServer（socket服务端）和Finger（socket客户端）都使用流（socket.getInputStream等等）来进行输入输出，
 *       但这是阻断式的，即程序中的语句必须执行完毕后，才执行其他操作，要使用非阻断输入输出，则必须使用通道而非流。
 *       ServerSocket和Socket是一对，ServerSocketChannel和SocketChannel是一对（支持异步通信），
 *       服务器必须先建立ServerSocket或者ServerSocketChannel 来等待客户端的连接，
 *       客户端必须建立相对应的Socket或者SocketChannel来与服务器建立连接，
 *       服务器接受到客户端的连接后，再生成一个Socket或者SocketChannel与此客户端通信。
 *       不过Socket和SocketChannel可以通过 Socket.channel() SocketChannel.socket()
 *       方法相互转换 同理ServerSocket 和ServerSocketChannel 也可以相互转换。
 *
 */
public class FingerServer {
	public FingerServer() {
		
			// 创建server socket channel和socket
		try (ServerSocketChannel sock = ServerSocketChannel.open();
			ServerSocket socket = sock.socket()){
			
			// 配置该套接字通道为非阻断式
			sock.configureBlocking(false);

			// 监视器设置监视对象的主机名host和端口port并绑定到socket
			InetSocketAddress server = new InetSocketAddress("localhost", 79);// 表示连接到的Internet地址。
			socket.bind(server);

			// 创建选择器Selector并注册到通道
			Selector selector = Selector.open();
			sock.register(selector, SelectionKey.OP_ACCEPT);

			// 无限循环，寻找客户端的连接
			while (true) {
				// 等待连接
				selector.select();

				// 获取等待事件的选择键selection key列表
				Set<SelectionKey> keys = selector.selectedKeys();
				Iterator<SelectionKey> it = keys.iterator();

				// 遍历和处理每个键
				while (it.hasNext()) {
					// 获取键并移除
					SelectionKey sKey = it.next();
					it.remove();
					if (sKey.isAcceptable()) {
						// 创建与客户端的Socket连接,返回键值关联的通道
						ServerSocketChannel selChannel = (ServerSocketChannel) sKey.channel();
						ServerSocket sSock = selChannel.socket();
						Socket connection = sSock.accept();

						// 处理Finger请求
						handleRequest(connection);
						connection.close();
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void handleRequest(Socket connection) throws IOException {
		// 创建输入输出
		InputStreamReader isr = new InputStreamReader(connection.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		PrintWriter pw = new PrintWriter(new BufferedOutputStream(connection.getOutputStream()), false);
		// 输出服务端的响应
		pw.println("[Nio Finger Server]Pls input your target username:");
		pw.flush();
		// 处理用户输入
		String outLine = null;
		String inLine = br.readLine();

		if (inLine.length() > 0) {
			outLine = inLine;
		}

		readPlan(outLine, pw);

		// 清理连接
		pw.flush();
		pw.close();
		br.close();
		isr.close();
	}

	private void readPlan(String userName, PrintWriter pw) {
		try (FileReader file = new FileReader(".\\src\\com\\chapter17\\"+userName + ".plan"); 
			BufferedReader buff = new BufferedReader(file)) {
			boolean eof = false;
			pw.println("\nUser name: " + userName + "\n");
			while (!eof) {
				String line = buff.readLine();
				if (line != null)
					pw.println(line);
				else
					eof = true;
			}
		} catch (IOException e) {
			pw.println("User " + userName + " not found");
		}

	}

	public static void main(String[] args) {
		new FingerServer();
	}

}
