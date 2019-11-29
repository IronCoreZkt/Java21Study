package com.chapter19;

import java.io.IOException;

import nu.xom.*;

/**
 * 本类在SportsFilter的RSS feed中查找NFL并输出。
 * 
 * @author Iron Core
 * @date 2019年11月29日
 * @note 需要在程序自变量中添加两个参数，一个是目标feed，另一个是要在标题中搜索的单词。
 *
 */
public class RssFilter {
	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("参数有误,第一个参数是要检查的 feed，第二个参数是要在标题中搜索的单词。");
			System.exit(-1);
		}
		String rssFile = args[0];
		String term = args[1];

		Builder builder = new Builder();
		try {
			Document doc = builder.build(rssFile);
			Element rss = doc.getRootElement();
			//System.out.println(doc.toXML());
			Attribute rssVersion = rss.getAttribute("version");
			String version = rssVersion.getValue();
			if (("0.91".equals(version)) & (doc.getDocType() == null)) {
				DocType rssDtd = new DocType("rss", "http://my.netscape.com/publish/formats/rss-0.91.dtd");
				doc.insertChild(rssDtd, 0);
			}

			Element channel = rss.getFirstChildElement("channel");
			Element title = channel.getFirstChildElement("title");
			Text titleText = (Text) title.getChild(0);
			titleText.setValue(titleText.getValue() + ":Search for " + term + " articles");
			
			//搜索channel标签下的所有item元素。
			Elements items = channel.getChildElements("item");
			for (int i = 0; i < items.size(); i++) {
				Element item = items.get(i);
				Element iTitle = item.getFirstChildElement("title");
				if (iTitle != null) {
					Text iTitleText = (Text) iTitle.getChild(0);
					if (iTitleText.toString().indexOf(term) == -1) {
						channel.removeChild(item);//如果不是运行参数中指定的搜索内容则删除
					}
				}
			}
			Serializer output = new Serializer(System.out);
			output.setIndent(2);
			output.write(doc);
		} catch (ParsingException | IOException e) {
			e.printStackTrace();
		}

	}

}
