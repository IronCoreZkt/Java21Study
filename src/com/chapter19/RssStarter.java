package com.chapter19;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import nu.xom.Attribute;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Text;

/**
 * 本类使用XOM库来创建和处理XML文档，XOM是基于树的XML文档模型。
 * 
 * @author Iron Core
 * @date 2019年11月25日
 * @note 
 *
 */
public class RssStarter {
	public static void main(String[] args){
		// 创建一个rss元素，作为文档的根节点
		Element rss = new Element("rss");
		
		// 向元素添加version属性
		Attribute version = new Attribute("version","2.0");
		rss.addAttribute(version);
		
		// 创建rss的子节点channel
		Element channel = new Element("channel");
		rss.appendChild(channel);
		
		// 创建channel的子节点title并添加文字元素
		Element title = new Element("title");
		Text titleText = new Text("workbench");
		title.appendChild(titleText);
		channel.appendChild(title);
		
		// 创建channel的子节点link并添加文字元素
		Element link = new Element("link");
		Text linkText = new Text("http://workbench.cadenhead.org/");
		link.appendChild(linkText);
		channel.appendChild(link);
		
		// 创建文档并将rss作为根节点
		Document doc = new Document(rss);
		
		// 存储XML文件
		try (
			FileWriter fw = new FileWriter(".\\src\\com\\chapter19\\feed.rss");
			BufferedWriter out = new BufferedWriter(fw);
		){
			out.write(doc.toXML());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(doc.toXML());
		
	}

}
