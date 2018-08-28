package com.owl.magicUtil.util;

import com.owl.magicUtil.model.ModelPrototype;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.regex.Pattern;

/**
 * @author engwen
 * email xiachanzou@outlook.com
 * 2017/3/16.
 */
public abstract class RegexUtil {

    private static final String is_empty = "(\\s)";

    private static final String is_mobile = "^1[3456789]\\d{9}$";

    private static final String is_email = "^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";

    private static final String is_date = "^\\d{4}[-/]\\d{1,2}[-/]\\d{1,2}$";

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
     * 檢測所有的參數是否爲空
     * @param inputs 未定義長度數組
     * @return 結果
     */
    public static boolean isParamsAllEmpty(Object... inputs) {
        boolean result = true;
        for (Object input : inputs) {
            if (null == input || (input instanceof String && isEmpty((String) input))
                    || (input instanceof Collection && ((Collection) input).size() <= 0)) {
                continue;
            }
            result = false;
            break;
        }
        return result;
    }

    /**
     * 數組對象中是否含有爲空
     * @param inputs
     * @return
     */
    public static boolean isParamsHaveEmpty(Object... inputs) {
        boolean result = false;
        for (Object input : inputs) {
            if (null == input || (input instanceof String && isEmpty((String) input))
                    || (input instanceof Collection && ((Collection) input).size() <= 0)) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * 檢測是否具有爲空選項,注意先後順序
     * @param params 確保對象不能爲空
     * @param inputs 確保對象下的屬性不能爲空
     * @return boolean
     */
    public static boolean isParamsHaveEmpty(ModelPrototype params, Object... inputs) {
        return null == params || isParamsHaveEmpty(inputs);
    }

    /**
     * 判断一个对象是否有属性为空--有一个为空即为true，全部非空才为false
     * @param object MsgResult的子类对象
     * @return
     */
    public static boolean isObjectHaveEmpty(ModelPrototype object) {
        boolean result = false;
        if (object == null) {
            result = true;
        } else {
            try {
                BeanInfo beanInfo = Introspector.getBeanInfo(object.getClass(), ModelPrototype.class);
                PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
                if (descriptors != null && descriptors.length > 0) {
                    for (PropertyDescriptor descriptor : descriptors) {
                        Method method = descriptor.getReadMethod();
                        Object obj = method.invoke(object);
                        //如果类型是String类型,需满足正则校验
                        if (obj == null || (obj instanceof String && isEmpty((String) obj))) {
                            result = true;
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                result = true;
            }
        }
        return result;
    }

    /**
     * 校验单列集合是否有数据
     * @param collection
     * @return true 有
     */
    public static boolean isCollectionHaveData(Collection collection) {
        return collection != null && collection.size() > 0;
    }
}
