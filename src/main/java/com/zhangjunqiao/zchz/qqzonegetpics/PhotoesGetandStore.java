package com.zhangjunqiao.zchz.qqzonegetpics;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.util.Base64Utils;

/**
 * 
 * @author zjq
 * @aim 学习Base64转换图片
 * @result 可以在这个网址检验http://www.vgot.net/test/image2base64.php?
 *
 */
public class PhotoesGetandStore {

	public static void main(String[] args) {
		getandstoreURLphotoes();
	}

	public static void getandstoreURLphotoes() {
		try {
			URL url = new URL(
					"http://www.qqbody.com/uploads/allimg/201409/10-160540_880.jpg");
			HttpURLConnection httpURLConnection = (HttpURLConnection) url
					.openConnection();
			httpURLConnection.connect();
			InputStream in = httpURLConnection.getInputStream();

			BufferedInputStream bufin = new BufferedInputStream(in);
			int buffSize = in.available();
			ByteArrayOutputStream out = new ByteArrayOutputStream(buffSize);
			byte[] temp = new byte[buffSize];
			int size = 0;

			while ((size = bufin.read(temp)) != -1) {
				out.write(temp, 0, size);
			}

			byte[] content = out.toByteArray();
			String photoContent = Base64Utils.encodeToString(content);
			System.out.println("photo is " + photoContent);
			bufin.close();
			in.close();
			out.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
