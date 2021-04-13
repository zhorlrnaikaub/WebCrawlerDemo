package com.zhangjunqiao.zchz.qqzonegetpics;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * 
 * @author 张俊俏
 * @since 2015年8月31日 下午3:58:58
 **/

public class FindPicThread implements Runnable {
	public static CloseableHttpClient httpClient = HttpClients.createDefault();


	public void run() {
		while (true) {
			// 生成QQ号码,头像URL,本地保存路径
			 
			final String qq = QQUtil.generateQQNum();
			final String qqLogoUrl = QQUtil.generateLogoUrl(qq);
			final String path = QQUtil.generatePath(qq);

			HttpGet httpGet = new HttpGet(qqLogoUrl);
			// 模拟谷歌 爬虫
			httpGet.setHeader("User-Agent",
					"Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)");
			try {
				// 执行请求
				HttpResponse response = httpClient.execute(httpGet);
				HttpEntity entity = response.getEntity();
				// entity不为空,且不是默认的图片,则保存
				if (entity != null && entity.getContentLength() != 2055) {
					File storeFile = new File(path);
					FileOutputStream output = new FileOutputStream(storeFile);
					InputStream instream = entity.getContent();
					byte b[] = new byte[8192];
					int j = 0;
					while ((j = instream.read(b)) != -1) {
						output.write(b, 0, j);
					}
					instream.close();
					output.flush();
					output.close();
					EntityUtils.consume(entity);
					System.out.println("qq号码为" + qq + "的头像下载完成...");
				}
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	 

}
