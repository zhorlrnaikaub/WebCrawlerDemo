package com.zhangjunqiao.zchz.qqzonegetpics;

import java.io.File;
import java.util.Random;

import org.junit.Test;
 
/**
 * QQ 工具类
 * 
 * @author 张俊俏
 * @since 2015-8-31
 **/
public class QQUtil {
    /**
     * QQ用户头像地址
     */
    public static String QQ_LOGO_URL = "http://qlogo4.store.qq.com/qzone/QQNumber/QQNumber/100";

    /**
     * QQ 信息URl
     */
    public static String QQ_INFO_URL = "http://r.cnc.qzone.qq.com/cgi-bin/user/cgi_personal_card?uin=954443045&fupdate=1&g_tk=2082931194&rd=1401115199";

    /**
     * 头像保存的路径
     */
    public static String FILE_PATH = "E:/qqlogo/";

    /**
     * 文件的后缀
     */
    public static String FILE_SUFFIX = ".jpg";

    /**
     * 生成QQ号码的随机器
     */
    public static Random qqNumRandom = new Random();

    /**
     * QQ号码 起始基数
     */
    public static int QQ_NUM_CARDINAL = 100000;

    /**
     * QQ号码 max 基数
     */
    public static int QQ_MAX_NUM = 999900000;

    /**
     * 生成QQ号码
     * 
     * @return qq
     */
    public static String generateQQNum() {
        return String.valueOf((QQ_NUM_CARDINAL + QQUtil.qqNumRandom.nextInt(QQ_MAX_NUM)));
    }

    /**
     * 生成头像URL
     * 
     * @param qq
     * @return url
     */
    public static String generateLogoUrl(String qq) {
        return QQ_LOGO_URL.replaceAll("QQNumber", qq);
    }

    /**
     * 生成保存在本地的路径
     * 
     * @param qq
     * @return path
     */
    public static String generatePath(String qq) {
        return new StringBuffer(FILE_PATH).append(qq).append(FILE_SUFFIX).toString();
    }

    /**
     * 创建文件夹
     */
    @Test
    public void mkdir() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            file.mkdirs();
        }
        System.out.println("创建文件夹:" + FILE_PATH + "成功.");
    }

    /**
     * 删除文件夹
     */
    @Test
    public void rmdir() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            File files[] = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                files[i].delete();
            }
            file.delete();
        }
        System.out.println("删除文件夹:" + FILE_PATH + "成功.");
    }

}
