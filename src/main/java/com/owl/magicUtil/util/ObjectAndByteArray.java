package com.owl.magicUtil.util;

import java.io.*;

/**
 * object对象必须继承Serializable
 * @author engwen
 * email xiachanzou@outlook.com
 * 2017/4/14.
 */
public class ObjectAndByteArray {

    /**
     * 将Object对象转为byte数组
     * @param obj
     * @return
     */
    public static byte[] toByteArray(Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream byteIn = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOut = new ObjectOutputStream(byteIn);
            objectOut.writeObject(obj);
            objectOut.flush();
            bytes = byteIn.toByteArray();
            objectOut.close();
            byteIn.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return bytes;
    }

    /**
     * 将byte数组转成Object对象
     * @param bytes
     * @return
     */
    public static Object toObject(byte[] bytes) {
        Object object = null;
        ByteArrayInputStream byteIn = new ByteArrayInputStream(bytes);
        try {
            ObjectInputStream objIn = new ObjectInputStream(byteIn);
            object = objIn.readObject();
            objIn.close();
            byteIn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }
}
