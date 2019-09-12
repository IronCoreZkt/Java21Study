package com.chapter17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class WebSaver {

	protected String getData(String address) throws MalformedURLException, IOException {
		URL page = new URL(address);
		HttpURLConnection conn = (HttpURLConnection) page.openConnection();
		conn.connect();
		
		InputStreamReader in = new InputStreamReader((InputStream) conn.getContent());
		BufferedReader buff = new BufferedReader(in);
		
		StringBuilder text = new StringBuilder();
		
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
		buff.close();
		in.close();
		return text.toString();
	}

	protected void saveData(String text, String targetFile) {
		FileSystem fs = FileSystems.getDefault();
		Path target = fs.getPath(".\\src\\com\\chapter17\\" + targetFile + ".txt");
		try (FileWriter saver = new FileWriter(target.toFile());
			 BufferedWriter buff = new BufferedWriter(saver)) {
			buff.write(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		WebSaver ws= new WebSaver();
		try {
			ws.saveData(ws.getData("http://worldtimeapi.org/api/ip"), "WebSaverTest");
			System.out.println("Finished!");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
