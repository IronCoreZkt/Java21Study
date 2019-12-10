package com.chapter20;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

public class SiteClient {
	public static void main(String[] args) {
		SiteClient client = new SiteClient();
		try {
			HashMap resp = client.getRandomSite();
			if (resp.size() > 0) {
				System.out.println("URL:" + resp.get("url") + "\nTitle:" + 
				resp.get("title") + "\nDescription：" + resp.get("description"));
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (XmlRpcException e) {
			e.printStackTrace();
		}
	}

	public HashMap getRandomSite() throws MalformedURLException, XmlRpcException {
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		URL server = new URL("http://localhost:4413/");
		config.setServerURL(server);
		XmlRpcClient client = new XmlRpcClient();
		client.setConfig(config);

		ArrayList params = new ArrayList();
		HashMap result = (HashMap) client.execute("dmoz.getRandomSite", params);
		return result;
	}

}
