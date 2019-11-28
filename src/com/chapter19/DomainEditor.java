package com.chapter19;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;
import nu.xom.ParsingException;
import nu.xom.Text;
import nu.xom.ValidityException;

/**
 * 本类将修改XML并输出到控制台和保存到文件feed2.rss。
 * 
 * @author Iron Core
 * @date 2019年11月25日
 * @note Builder类表示SAX分析程序，将XML转换为Document对象。
 *
 */
public class DomainEditor {
	public static void main(String[] args) {
		Builder builder = new Builder();
		File xmlFile = new File(".\\src\\com\\chapter19\\feed.rss");
		try {
			//建立SAX分析扫描得到的文档对象
			Document doc = builder.build(xmlFile);

			Element root = doc.getRootElement();
			Element channel = root.getFirstChildElement("channel");
			
			//修改节点内容
			Elements children = channel.getChildElements();
			for (int i = 0; i < children.size(); i++) {
				Element link = children.get(i);
				Text linkText = (Text) link.getChild(0);
				if (linkText.getValue().equals("http://workbench.cadenhead.org/")) {
					link.removeChild(0);
					link.appendChild("http://www.cadenhead.org/");
				}
				System.out.println(children.size());
			}
			
			//添加新的子节点
			Element item = new Element("item");
			Element itemTitle = new Element("title");
			itemTitle.appendChild("Free the Bound Periodicals");
			item.appendChild(itemTitle);
			channel.appendChild(item);
			
			// 存储XML程序修改后的结果
			try (FileWriter fw = new FileWriter(".\\src\\com\\chapter19\\feed2.rss");
					BufferedWriter buff = new BufferedWriter(fw);
				) {
					buff.write(doc.toXML());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.println(doc.toXML());
		} catch (ValidityException e) {
			e.printStackTrace();
		} catch (ParsingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
