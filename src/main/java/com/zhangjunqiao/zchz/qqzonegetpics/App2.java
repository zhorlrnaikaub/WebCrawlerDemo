package com.zhangjunqiao.zchz.qqzonegetpics;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.util.EntityUtils;

/**
 * 
 * @author 张jq
 * @aim 为了学习用HttpResponse和HttpRequest获取页面内容
 * 
 */

public class App2 {

	public static void main(String[] args) throws ClientProtocolException,
			IOException {
		Response resp;
		resp = Request
				.Get("http://www.cnblogs.com/loveyakamoz/archive/2011/07/21/2112804.html")
				.execute();

		HttpResponse returnResponse = resp.returnResponse();
		StatusLine statusLine = returnResponse.getStatusLine();
		System.out.println(statusLine.getStatusCode());// 状态码
		System.out.println(returnResponse.getLocale());// 地区吧……
		System.out.println(returnResponse.getProtocolVersion());// HTTP协议版本

		String responseStr = EntityUtils.toString(returnResponse.getEntity(),
				"utf-8");
		System.out.println("responseStr now is " + responseStr);// 网页实体内容
	}

}
