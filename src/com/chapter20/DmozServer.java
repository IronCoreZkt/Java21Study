package com.chapter20;

import java.io.IOException;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.webserver.WebServer;

/**
 * 实现XMLRPC服务器。
 * 
 * @author Iron Core
 * @date 2019年12月9日
 * @note 
 *
 */
public class DmozServer {
	public static void main(String[] args){
		try {
			startServer();
		} catch (XmlRpcException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void startServer() throws XmlRpcException, IOException{
		System.out.println("Strating Dmoz server...");
		//在端口4413上创建web服务，然后基于这个web服务创建XmlRpc服务
		WebServer server = new WebServer(4413);
		XmlRpcServer xmlRpcServer = server.getXmlRpcServer();
		PropertyHandlerMapping phm = new PropertyHandlerMapping();
		
		//注册处理程序（handler），添加属性映射
		phm.addHandler("dmoz", DmozHandlerImpl.class);
		xmlRpcServer.setHandlerMapping(phm);
		
		//启动服务，监听请求
		server.start();
		System.out.println("Started Dmoz server successfully!");
	}

}
