package com.owl.magicUtil.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * class 类选择工具
 * @author engwen
 * email xiachanzou@outlook.com
 * 2018/11/21.
 */
public abstract class ClassTypeUtil {

    private static Class[] classTypeBase = new Class[]{char.class, int.class, long.class, short.class, float.class, double.class, boolean.class};
    private static Class[] classTypePack = new Class[]{String.class, Integer.class, Long.class, Short.class, Float.class, Double.class, Boolean.class};

    private static boolean isContain(Class[] classType, Object obj) {
        for (Class className : classType) {
            if (className.equals(obj.getClass())) {
                return true;
            }
        }
        return false;
    }

    private static boolean isContain(Class[] classType, Class obj) {
        for (Class className : classType) {
            if (className.equals(obj)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBaseClass(Object obj) {
        return isContain(classTypeBase, obj);
    }

    public static boolean isPackClass(Object obj) {
        return isContain(classTypePack, obj);
    }

    public static boolean isBaseClass(Class obj) {
        return isContain(classTypeBase, obj);
    }

    public static boolean isPackClass(Class obj) {
        return isContain(classTypePack, obj);
    }

    /*
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
                System.out.println("请确保两个对象中的属性名称以及类型完全一样。name:" + field.getName());
                e.printStackTrace();
            }
        }
        return newObj;
    }
}
