package com.zhangjunqiao.zchz.qqzonegetpics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.google.zxing.WriterException;

/**
 * 
 * @author zjq
 * @aim 20150906学习处理二维码
 * 
 */
public class App3 {

	public static void main(String[] args) throws WriterException {
		/*
		 * String imgPath = "D:\\Users\\Zhangjunqiao\\3_Files"; try {
		 * BufferedImage image = ImageIO.read(new FileInputStream(imgPath)); }
		 * catch (FileNotFoundException e) { e.printStackTrace(); } catch
		 * (IOException e) { e.printStackTrace(); }
		 */
		String content = "http://www.sinaimg.cn/dy/slidenews/8_img/2015_36/65486_439634_724233.jpg";

		BufferedImage image2 = QRCodeUtil.standEncodeQr(content);
		try {
			ImageIO.write(image2, "jpg", new File(
					"D:\\Users\\Zhangjunqiao\\3_Files\\2.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
