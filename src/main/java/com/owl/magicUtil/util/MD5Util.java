package com.owl.magicUtil.util;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @author engwen
 * email xiachanzou@outlook.com
 * 2017/4/14.
 */
public class MD5Util {

    public static MessageDigest messageDigest;

    //16进制
    private final static char[] HEX = "0123456789abcdef".toCharArray();

    /**
     * 获取md5
     * @param inputStr
     * @return
     */
    public static String getMD5(String inputStr) {
        String backStr = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            backStr = bytes2Hex(messageDigest.digest(inputStr.getBytes("UTF-8")));
        } catch (Exception e) {
            return null;
        }
        return backStr;
    }

    /**
     * 獲取文件的MD5
     * @param inputFile 文件路径
     * @return 已经通过MD5算法加密的32位字符串
     */
    public final static String getMD5(File inputFile) {
        String md5 = null;
        FileInputStream fileInputStream = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            fileInputStream = new FileInputStream(inputFile);
            byte[] buffer = new byte[1024];
            int length = -1;
            while ((length = fileInputStream.read(buffer, 0, 1024)) != -1) {
                messageDigest.update(buffer, 0, length);
            }
            BigInteger bigInt = new BigInteger(1, messageDigest.digest());
            System.out.println("文件md5值：" + bigInt.toString(16));
            md5 = bigInt.toString(16);
        } catch (Exception e) {

        } finally {
            try {
                if (null != fileInputStream) {
                    fileInputStream.close();
                }
            } catch (Exception e2) {

            }
        }
        return md5;
    }

    /**
     * 将字节数组转成 16 进制的字符串来表示，每个字节采用两个字符表表示
     *
     * @param bys 需要转换成 16 进制的字节数组
     * @return
     */
    public static String bytes2Hex(byte[] bys) {
        char[] chs = new char[bys.length * 2];
        for (int i = 0, offset = 0; i < bys.length; i++) {
            chs[offset++] = HEX[bys[i] >> 4 & 0xf];
            chs[offset++] = HEX[bys[i] & 0xf];
        }
        return new String(chs);
    }
}
