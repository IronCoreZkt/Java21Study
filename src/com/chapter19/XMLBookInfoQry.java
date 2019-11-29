package com.chapter19;

import java.io.File;
import java.io.IOException;

import nu.xom.*;

/**
 * 读取Book.xml中作者为George R. R. Martin的书名。
 * 
 * @author Iron Core
 * @date 2019年11月29日
 *
 */
public class XMLBookInfoQry {
	public static void main(String[] args) {
		Builder builder = new Builder();
		File xml = new File(".\\src\\com\\chapter19\\Book.xml");
		try {
			Document doc = builder.build(xml);
			Element book = doc.getRootElement();
			Elements items = book.getChildElements("item");
			for (int i = 0; i < items.size(); i++) {
				Element item = items.get(i);
				Element author = item.getFirstChildElement("author");
				if ("George R. R. Martin".equals(author.getValue())) {
					String bookname = item.getFirstChildElement("title").getValue();
					System.out.println("书名为" + bookname + "。");
				}
			}
		} catch (ParsingException | IOException e) {
			e.printStackTrace();
		}
	}
}
