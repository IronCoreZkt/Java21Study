package com.chapter17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 本类中 2/3的代码用于运行应用程序、创建用户界面和一个有效的URL对象。
 * 
 * @author Iron Core
 * @date 2019年8月9日
 * @note
 *
 */
public class WebReader extends JFrame {

	private static final long serialVersionUID = -1256125929387744666L;

	JTextArea box = new JTextArea("Getting data...");

	public WebReader() {
		super("Get File Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 300);
		JScrollPane pane = new JScrollPane(box);
		add(pane);
		setVisible(true);
	}

	/**
	 * getData()方法加载 Web文档中的数据并将其显示在一个文本区域中。
	 * 
	 * @param address
	 * @throws MalformedURLException
	 */
	void getData(String address) throws MalformedURLException {
		setTitle(address);
		// 加载Web上的文本文档并逐行读取其中的内容：1．创建一个表示资源的网络地址的URL对象。
		URL page = new URL(address);
		StringBuilder text = new StringBuilder();
		try {
			// 2．创建一个HttpURLConnection对象，它能够加载URL并连接到相应的站点。
			HttpURLConnection conn = (HttpURLConnection) page.openConnection();
			conn.connect();

			// 同时显示报头和文档中的文本
			String key, header;
			int i = 0;
			do {
				key = conn.getHeaderFieldKey(i);
				header = conn.getHeaderField(i);
				if (key == null)
					key = "";
				else
					key = key + ": ";
				if (header != null) {
					text.append(key);
					text.append(header);
					text.append("\n");
				}
				i++;
			} while (header != null);

			// 3．使用HttpURLConnection对象的getContent()方法来创建一个InputStreamReader，用于读取来自URL的数据流。
			InputStreamReader in = new InputStreamReader((InputStream) conn.getContent());
			// 4．使用输入流阅读器来创建一个BufferedReader对象，后者能够高效地从输入流中读取字符。
			BufferedReader buff = new BufferedReader(in);
			box.setText("Getting data ...");
			String line;
			boolean eof = false;
			while (!eof) {
				line = buff.readLine();
				if (line != null) {
					text.append(line);
					text.append("\n");
				} else
					eof = true;
			}
			box.setText(text.toString());
		} catch (IOException e) {
			System.out.println("IOException: " + e.getMessage() + "\n");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		WebReader wr = new WebReader();
		// 使用构造函数URL(String)时，必须处理MalformedURLException异常，该异常在指定字符串不是有效URL时引发。
		try {
			wr.getData("http://worldtimeapi.org/api/ip");
		} catch (MalformedURLException e) {
			System.out.println("Bad Url:" + e.getMessage());
			e.printStackTrace();
		}

	}

}
