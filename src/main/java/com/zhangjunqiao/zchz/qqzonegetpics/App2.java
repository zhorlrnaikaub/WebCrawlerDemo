package com.zhangjunqiao.zchz.qqzonegetpics;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.ContentType;
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
		GetUrlContent();
		//PostUrlContent("");
	}

	public static void GetUrlContent() throws ClientProtocolException,
			IOException {
		Response resp;
		resp = Request
				.Get("http://www.cnblogs.com/loveyakamoz/archive/2011/07/21/2112804.html")
				.execute();

		HttpResponse resultResponse = resp.returnResponse();
		StatusLine statusLine = resultResponse.getStatusLine();
		System.out.println(statusLine.getStatusCode());// 状态码
		System.out.println(resultResponse.getLocale());// 地区吧……
		System.out.println(resultResponse.getProtocolVersion());// HTTP协议版本

		String responseStr = EntityUtils.toString(resultResponse.getEntity(),
				"utf-8");
		System.out.println("responseStr now is " + responseStr);// 网页实体内容
	}

	public static void PostUrlContent(String requestObj) throws ClientProtocolException,
			IOException {
		// String body = new ObjectMapper().writeValueAsString(requestObj);
		Response response = Request
				.Post("http://www.cnblogs.com/loveyakamoz/archive/2011/07/21/2112804.html")
				.bodyString(requestObj, ContentType.APPLICATION_JSON).execute();


		HttpResponse resultResponse = response.returnResponse();
		System.out.println(resultResponse.toString());
		StatusLine statusLine = resultResponse.getStatusLine();

		String responseStr = EntityUtils.toString(resultResponse.getEntity());

		if (statusLine.getStatusCode() >= 300) {
			System.out.println("ERROR");
			throw new HttpResponseException(statusLine.getStatusCode(),
					statusLine.getReasonPhrase());
		}
		System.out.println("PostresponseStr now is " + responseStr);// 网页实体内容

	}

}
