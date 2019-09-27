package com.owl.util;

import java.util.Arrays;

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
        return Arrays.asList(classType).contains(obj.getClass());
    }

    private static boolean isContain(Class[] classType, Class obj) {
        return Arrays.asList(classType).contains(obj);
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

    public static boolean isArrayClass(Object obj) {
        return obj instanceof Object[] || obj instanceof int[] || obj instanceof float[] || obj instanceof double[];
    }
}
