package com.owl.magicUtil.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 对象工具类
 * @author engwen
 * email xiachanzou@outlook.com
 * 2019/2/28.
 */
public class ObjectUtil {
    /*
     * 將一个对象的所有属性赋值给另一个对象的对应属性，以旧的属性为主体
     * @param oldObj 主要對象
     * @param newObj 將要塞入的對象
     * @return 返回原對象
     */
    public static <T, K> K setThisObjToAnotherObj(T oldObj, K newObj) {
        Field[] oldFields = oldObj.getClass().getDeclaredFields();
        Field[] newFields = newObj.getClass().getDeclaredFields();
        for (Field oldField : oldFields) {
            for (Field newField : newFields) {
                if (oldField.getName().equals(newField.getName())) {
                    try {
                        String methodStr = oldField.getName().substring(0, 1).toUpperCase() + oldField.getName().substring(1);
                        String setMethodStr = "set" + methodStr;
                        String getMethodStr = "get" + methodStr;
                        Method getMethod = oldObj.getClass().getDeclaredMethod(getMethodStr);
                        Object value = getMethod.invoke(oldObj);
                        Method setMethod = newObj.getClass().getDeclaredMethod(setMethodStr, value.getClass());
                        setMethod.invoke(newObj, value);
                    } catch (Exception e) {
                        System.out.println("新的对象中不存在这个属性，直接跳过。name:" + (oldField == null ? "空指针" : oldField.getName()));
                    }
                }
            }
        }
        return newObj;
    }


    /*
     * 将对象的所有属性赋值给另一个对象的对应属性，如果没有就跳过，以新的对象为主体
     * @param oldObj 主要對象
     * @param newObj 將要塞入的對象
     * @return 返回原對象
     */
    public static <T, K> K getThisObjFromAnotherObj(T oldObj, K newObj) {
        Field[] oldFields = oldObj.getClass().getDeclaredFields();
        Field[] newFields = newObj.getClass().getDeclaredFields();
        for (Field newField : newFields) {
            for (Field oldField : oldFields) {
                if (newField.getName().equals(oldField.getName())) {
                    try {
                        String methodStr = newField.getName().substring(0, 1).toUpperCase() + newField.getName().substring(1);
                        String setMethodStr = "set" + methodStr;
                        String getMethodStr = "get" + methodStr;
                        Method getMethod = oldObj.getClass().getDeclaredMethod(getMethodStr);
                        Object value = getMethod.invoke(oldObj);
                        Method setMethod = newObj.getClass().getDeclaredMethod(setMethodStr, value.getClass());
                        setMethod.invoke(newObj, value);
                    } catch (Exception e) {
                        System.out.println("旧的对象中不存在这个属性，直接跳过：name:" + (newField == null ? "空指针" : newField.getName()));
                    }
                }
            }
        }

        return newObj;
    }

    /*
     * 将指定的一级对象转化为json字符串
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> String toJSON(T obj) {
        StringBuilder stringBuilder = new StringBuilder("{");
        if (obj instanceof Map) {
            ((Map) obj).keySet().forEach(key -> {
                stringBuilder.append("\"");
                stringBuilder.append(key);
                stringBuilder.append("\"");
                stringBuilder.append(":");
                stringBuilder.append("\"");
                stringBuilder.append(((Map) obj).get(key));
                stringBuilder.append("\"");
                stringBuilder.append(",");
            });
        } else {
            Field[] fields = obj.getClass().getDeclaredFields();
            Field errorFiled = null;
            try {
                for (Field field : fields) {
                    errorFiled = field;
                    String getMethodStr = "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                    Method getMethod = obj.getClass().getDeclaredMethod(getMethodStr);
                    Object value = getMethod.invoke(obj);
                    stringBuilder.append("\"");
                    stringBuilder.append(field.getName());
                    stringBuilder.append("\"");
                    stringBuilder.append(":");
                    stringBuilder.append("\"");
                    stringBuilder.append(value);
                    stringBuilder.append("\"");
                    stringBuilder.append(",");
                }
            } catch (Exception e) {
                System.out.println("转化出错。name:" + errorFiled.getName());
                e.printStackTrace();
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
