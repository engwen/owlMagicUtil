package com.owl.magicUtil.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author engwen
 * email xiachanzou@outlook.com
 * 2019/1/5.
 */
public class ObjClassUtil {
    /**
     * 將一个对象的所有属性赋值给另一个对象的对应属性
     * @param oldObj 主要對象
     * @param newObj 將要塞入的對象
     * @return 返回原對象
     */
    public static <T, K> K setThisObjToAnotherObj(T oldObj, K newObj) {
        Field[] fields = oldObj.getClass().getDeclaredFields();

        for (Field field : fields) {
            try {
                String methodStr = field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                String setMethodStr = "set" + methodStr;
                String getMethodStr = "get" + methodStr;
                Method getMethod = oldObj.getClass().getDeclaredMethod(getMethodStr);
                Object value = getMethod.invoke(oldObj);

                Method setMethod = newObj.getClass().getDeclaredMethod(setMethodStr, value.getClass());
                setMethod.invoke(newObj, value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return newObj;
    }
}
