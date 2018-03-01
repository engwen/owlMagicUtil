package com.owl.magicUtil.util;

import com.owl.magicUtil.model.MsgResult;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * @author engwen
 * email xiachanzou@outlook.com
 * 2017/3/16.
 */
public class RegexUtil {

    private static final String is_empty = "(\\s)";

    private static final String is_mobile = "^1[3456789]\\d{9}$";

    private static final String is_email = "^[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}$ ";

    private static final String is_date = "^\\d{4}(-|/)\\d{1,2}(-|/)\\d{1,2}$";

    public static boolean isEmpty(String input) {
        return null == input || "".equals(input) || Pattern.matches(is_empty, input) || "null".equals(input);
    }

    public static boolean isMobile(String input) {
        return !isEmpty(input) && Pattern.matches(is_mobile, input);
    }

    public static boolean isEmail(String input) {
        return !isEmpty(input) && Pattern.matches(is_email, input);
    }

    public static boolean isDate(String input) {
        return !isEmpty(input) && Pattern.matches(is_date, input);
    }

    /**
     * @param input 校验传入的参数是否有空
     * @return
     */
    public static boolean haveEmpty(Object... input) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] == null || (input[i] instanceof String && isEmpty((String) input[i]))) {
                return true;
            }
        }
        return false;
    }


    /**
     * 判断一个对象是否有属性为空--有一个为空即为true，全部非空才为false
     * @param object MsgResult的子类对象
     * @return
     */
    public static boolean isAtrHaveEmpty(MsgResult object) {
        if (object == null) {
            return true;
        }
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(object.getClass(), MsgResult.class);
            PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
            if (descriptors != null && descriptors.length > 0) {
                for (PropertyDescriptor descriptor : descriptors) {
                    Method method = descriptor.getReadMethod();
                    Object obj = method.invoke(object);
                    //如果类型是String类型,需满足正则校验
                    if (obj == null || (obj instanceof String && isEmpty((String) obj))) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
