package com.chapter19;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import nu.xom.Builder;
import nu.xom.Comment;
import nu.xom.Document;
import nu.xom.ParsingException;
import nu.xom.Serializer;
import nu.xom.ValidityException;

/**
 * 本类向XML添加注释和输出格式化后的XML内容到文件。
 * 
 * @author Iron Core
 * @date 2019年11月28日
 * @note 这里使用XOM中的Comment来添加注释， 使用XOM中的Serializer来格式化XOM默认输出的内容。
 *		  表示XML文档时，XOM默认不会保留没有意义的空白，顺带一提，XOM的设计目标为不考虑XML文
 *		  档中任何没有语法意义的内容，不管文本是使用字符实体、CDATA部分还是常规字符创建的，
 *		  处理的方式都一样。
 */
public class DomainWriter {
	public static void main(String[] args) {
		Builder builder = new Builder();
		File xmlFile = new File(".\\src\\com\\chapter19\\feed2.rss");
		try {
			//建立Document文档，内容是SAX分析指定File得到的树模型
			Document doc = builder.build(xmlFile);
			//新建注释
			Comment timestamp = new Comment("File created " + new java.util.Date());
			//将注释插入到指定位置（XML声明后面）
			doc.insertChild(timestamp, 0);
			
			//格式化输出doc中的内容
			FileOutputStream f = new FileOutputStream(".\\src\\com\\chapter19\\feed3.rss");
			Serializer output = new Serializer(f, "ISO-8859-1");
			output.setIndent(2);
			output.write(doc);
			
			System.out.println("格式化完成！");
		} catch (ValidityException e) {
			e.printStackTrace();
		} catch (ParsingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
