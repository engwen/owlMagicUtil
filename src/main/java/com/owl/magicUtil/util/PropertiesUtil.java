package com.owl.magicUtil.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 讀取配置文件工具類（根目錄下）
 * author engwen
 * email xiachanzou@outlook.com
 * 2017/4/7.
 */
public abstract class PropertiesUtil {
    private static final String CONFIG = "config";

    /**
     * 讀取指定配置文件信息
     * @param propertiesName
     * @param key
     * @return
     */
    public static String readProperties(String propertiesName, String key) {
        return ResourceBundle.getBundle(propertiesName, Locale.getDefault()).getString(key);
    }

    /**
     * 讀取默認配置文件信息
     * @param key
     * @return
     */
    public static String readConfigProperties(String key) {
        return readProperties(CONFIG, key);
    }
}
