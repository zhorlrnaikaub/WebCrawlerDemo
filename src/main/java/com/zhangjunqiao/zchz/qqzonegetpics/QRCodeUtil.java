package com.zhangjunqiao.zchz.qqzonegetpics;

import java.awt.image.BufferedImage;
import java.util.Hashtable;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * @date 20150905
 * @author zjq
 * @aim 生成二维码工具
 */
public class QRCodeUtil {

	private static final String CHARSET = "utf-8";
	// 二维码尺寸
	private static final int QRCODE_SIZE = 300;
	// LOGO宽度
	private static final int WIDTH = 60;
	// LOGO高度
	private static final int HEIGHT = 60;

	/**
	 * 创建标准二维码图片
	 * 
	 * @param content
	 * @return
	 * @throws WriterException
	 */
	public static BufferedImage standEncodeQr(String content)
			throws WriterException {
		Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
		hints.put(EncodeHintType.MARGIN, 1);

		BitMatrix bitMatrix = new MultiFormatWriter().encode(content,
				BarcodeFormat.QR_CODE, QRCODE_SIZE, QRCODE_SIZE, hints);
		int width = bitMatrix.getWidth();
		int height = bitMatrix.getHeight();
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);

		MatrixToImageConfig config = new MatrixToImageConfig(0xFF000001,
				0xFFFFFFFF);
		image = MatrixToImageWriter.toBufferedImage(bitMatrix, config);
		return image;
	}

	/*
	*//**
	 * 创建 image 完整二维码图片
	 * 
	 * @param content
	 * @param imgPath
	 * @param response
	 * @throws Exception
	 */
	/*
	 * public static BufferedImage encode(String text, NamecardVo namecardVo)
	 * throws Exception {
	 * 
	 * BufferedImage image1 = createImage(text, namecardVo.getNamecardInfo()
	 * .get(NamecardInfoKeyCons.PHOTOURL)); int width = image1.getWidth(); int
	 * height = image1.getHeight();
	 * 
	 * BufferedImage image2 = new BufferedImage(300, 182,
	 * BufferedImage.TYPE_INT_RGB); int width2 = image2.getWidth(); int height2
	 * = image2.getHeight();
	 * 
	 * // 画图 selfDefinedPhoto(namecardVo, image2);
	 * 
	 * // 从图片中读取RGB int[] imageArrayOne = new int[width * height]; imageArrayOne
	 * = image1.getRGB(0, 0, width, height, imageArrayOne, 0, width); int[]
	 * imageArrayTwo = new int[width2 * height2]; imageArrayTwo =
	 * image2.getRGB(0, 0, width2, height2, imageArrayTwo, 0, width2);
	 * 
	 * // 生成新图片 BufferedImage imageNew = new BufferedImage(300, 482,
	 * BufferedImage.TYPE_INT_RGB); imageNew.setRGB(0, 0, width, height,
	 * imageArrayOne, 0, width);// 设置左半部分的RGB imageNew.setRGB(0, height, width,
	 * height2, imageArrayTwo, 0, width);// 设置下半部分的RGB
	 * 
	 * return imageNew; }
	 *//**
	 * 自定义图片以便拼接到二维码上
	 * 
	 * @param namecardVo
	 * @param image2
	 * @param width2
	 * @param height2
	 * @throws FileNotFoundException
	 * @throws FontFormatException
	 * @throws IOException
	 */
	/*
	 * private static void selfDefinedPhoto(NamecardVo namecardVo, BufferedImage
	 * image) throws FileNotFoundException, FontFormatException, IOException {
	 * Graphics2D graph = image.createGraphics(); graph.setColor(Color.WHITE);
	 * graph.fillRect(0, 0, image.getWidth(), image.getHeight()); File file =
	 * new File("src/main/resources/李旭科漫画体v1.0.ttf"); FileInputStream fis = new
	 * FileInputStream(file); BufferedInputStream bis = new
	 * BufferedInputStream(fis);
	 * 
	 * Font dynamicFont = Font.createFont(Font.TRUETYPE_FONT, bis).deriveFont(
	 * Font.BOLD, 24f);
	 * 
	 * graph.setColor(Color.RED); graph.setFont(dynamicFont); graph.drawString(
	 * namecardVo.getNamecardInfo().get(NamecardInfoKeyCons.NICKNAME), 120, 50);
	 * 
	 * graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	 * RenderingHints.VALUE_ANTIALIAS_ON); fis.close(); bis.close();
	 * 
	 * graph.setColor(Color.GREEN); graph.drawString(
	 * namecardVo.getNamecardInfo().get(NamecardInfoKeyCons.COUNTRY), 120, 100);
	 * 
	 * graph.dispose(); }
	 *//**
	 * 拼接二维码图片
	 * 
	 * @param content
	 * @param imgContent
	 * @return
	 * @throws Exception
	 */
	/*
	 * private static BufferedImage createImage(String text, String imgUrl)
	 * throws Exception {
	 * 
	 * //创建一个标准二维码图片 BufferedImage image = standEncodeQr(text);
	 * 
	 * // 插入中间小图标 insertImage(image, imgUrl); return image; }
	 *//**
	 * 插入二维码中间头像小图片
	 * 
	 * @param source
	 * @param imgPath
	 * @throws Exception
	 */
	/*
	 * private static void insertImage(BufferedImage source, String imgUrl)
	 * throws Exception { logger.info("photo url {}", imgUrl);
	 * 
	 * URL url = new URL(imgUrl); HttpURLConnection httpURLConnection =
	 * (HttpURLConnection) url .openConnection(); httpURLConnection.connect();
	 * InputStream in = httpURLConnection.getInputStream();
	 * 
	 * Image src = ImageIO.read(in); in.close();
	 * 
	 * int width = src.getWidth(null); int height = src.getHeight(null);
	 * 
	 * if (true) { // 压缩LOGO if (width > WIDTH) { width = WIDTH; } if (height >
	 * HEIGHT) { height = HEIGHT; } Image image = src.getScaledInstance(width,
	 * height, Image.SCALE_SMOOTH); BufferedImage tag = new BufferedImage(width,
	 * height, BufferedImage.TYPE_INT_RGB); Graphics g = tag.getGraphics();
	 * g.drawImage(image, 0, 0, null); // 绘制缩小后的图 g.dispose(); src = image; }
	 * Graphics2D graph = source.createGraphics();
	 * 
	 * int x = (QRCODE_SIZE - width) / 2; int y = (QRCODE_SIZE - height) / 2;
	 * graph.drawImage(src, x, y, width, height, null); Shape shape = new
	 * RoundRectangle2D.Float(x, y, width, width, 6, 6); graph.setStroke(new
	 * BasicStroke(3f)); graph.draw(shape); graph.dispose();
	 * 
	 * }
	 */

}
