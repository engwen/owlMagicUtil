package com.owl.magicUtil.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 日期工具類
 * @author engwen
 * email xiachanzou@outlook.com
 * 2017/5/10.
 */
public abstract class DateCountUtil {
    public static final SimpleDateFormat YMDHMS = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    public static final SimpleDateFormat YMDHM = new SimpleDateFormat("yyyy/MM/dd HH:mm");
    public static final SimpleDateFormat YMDH = new SimpleDateFormat("yyyy/MM/dd HH");
    public static final SimpleDateFormat YMD = new SimpleDateFormat("yyyy/MM/dd");

    public static final SimpleDateFormat HHMMSS = new SimpleDateFormat("HH:mm:ss");
    public static final SimpleDateFormat HHMM = new SimpleDateFormat("HH:mm");


    /**
     * 获取指定的日期格式
     * @param date 日期
     * @param sdf 格式
     * @return 日期字符串
     */
    public static String getDateFormSdf(Date date, SimpleDateFormat sdf) {
        return sdf.format(date);
    }

    /**
     * 返回指定格式的日期
     * @param date 日期
     * @param sdfStr 格式
     * @return 日期
     */
    public static String getDateFormSdfStr(Date date, String sdfStr) {
        return getDateFormSdf(date, new SimpleDateFormat(sdfStr));
    }

    /**
     * 根据指定格式的字符串，返回指定格式的日期
     * @param dateString dates
     * @param sdf 格式
     * @return 日期字符串
     */
    public static Date getDateFormSdf(String dateString, SimpleDateFormat sdf) {
        Date date = null;
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    /**
     * 根据指定格式的字符串，返回指定格式的日期
     * @param dateString dates
     * @param sdfStr 格式
     * @return 日期
     */
    public static Date getDateFormSdfStr(String dateString, String sdfStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(sdfStr);
        return getDateFormSdf(dateString, sdf);
    }

    /**
     * 获取距离现在多少年
     * @param date 日期
     * @return int
     */
    public static int getDateToNowHowYears(Date date) {
        int backYears = getDateToDateHowYears(date, new Date());
        return backYears > 0 ? backYears : 0;
    }

    /**
     * 计算两个日期之间的年份
     * @param oldDate 旧的日期
     * @param newDate 新的日期
     * @return int
     */
    public static int getDateToDateHowYears(Date oldDate, Date newDate) {
        Calendar calendarOld = Calendar.getInstance();
        calendarOld.clear();
        calendarOld.setTime(oldDate);
        Calendar calendarNew = Calendar.getInstance();
        calendarNew.clear();
        calendarNew.setTime(newDate);
        int backYears = calendarNew.get(Calendar.YEAR) - calendarOld.get(Calendar.YEAR);
        return backYears > 0 ? backYears : 0;
    }

    /**
     * 计算两个日期之间的月份，日期不足一月按一月算
     * @param oldDate 旧的日期
     * @param newDate 新的日期
     * @return int
     */
    public static int getDateToDateHowMonth(Date oldDate, Date newDate) {
        Calendar calendarOld = Calendar.getInstance();
        calendarOld.clear();
        calendarOld.setTime(oldDate);
        Calendar calendarNew = Calendar.getInstance();
        calendarNew.clear();
        calendarNew.setTime(newDate);
        int backYears = calendarNew.get(Calendar.YEAR) - calendarOld.get(Calendar.YEAR);
        int backMonth = calendarNew.get(Calendar.MONTH) - calendarOld.get(Calendar.MONTH);

        return backYears >= 0 ? ((backYears * 12) + (backMonth + 1)) : 0;
    }

    /**
     * 獲取指定日期指定天數後的00:00开始日期
     * @param date 旧的日期
     * @param day 指定天數後
     * @return Date
     */
    public static Date addDay(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, day);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 獲取指定日期指定天數後的yyyy-MM-dd 23:59:59日期
     * @param date 旧的日期
     * @param day 指定天數後
     * @return Date
     */
    public static Date addDayWithLastTime(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, day);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    /**
     * 獲取指定日期指定天數後的日期
     * @param date 旧的日期
     * @param day 指定天數後
     * @return Date
     */
    public static Date addFullDay(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, day);
        return calendar.getTime();
    }

    /**
     * 在制定的时间上加或减去几小时-支持浮点数
     * @param date 旧的日期
     * @param hour 小時
     * @return Date
     */
    public static Date addHour(Date date, float hour) {
        Calendar Cal = Calendar.getInstance();
        Cal.setTime(date);
        Cal.add(Calendar.MINUTE, (int) (hour * 60));
        return Cal.getTime();
    }

    /**
     * 獲取指定日期指定天數後的日期
     * @param date 旧的日期
     * @param month 月
     * @return Date
     */
    public static Date add30DayByOneMonth(Date date, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 30 * month);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 獲取指定日期指定月后的日期
     * @param date 旧的日期
     * @param month 月
     * @return Date
     */
    public static Date addMoth(Date date, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, month);
        return calendar.getTime();
    }

    /**
     * 计算距离当前日期指定天数的日期，并取该日期的最小值(0时0分0秒)
     * @param day 距离当前日期的天数，正数表示当前日期之后几天的日期，负数表示当前日期之前几天的日期
     * @return date
     */
    public static Date addDay(int day) {
        return addDay(new Date(), day);
    }

    /**
     * 返回两个日期相差的天数，不足一天按一天算
     * 备注:该方法是:5月7日和5月7日相差一天，和5月8日相差两天
     * @param startdate 開始日期
     * @param enddate 結束日期
     * @return int
     */
    public static int getsubDay(Date startdate, Date enddate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String start = format.format(startdate);
        String end = format.format(enddate);
        try {
            startdate = format.parse(start);
            enddate = format.parse(end);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long startTime = startdate.getTime();
        long endTime = enddate.getTime();
        long sub = endTime - startTime;
        return (int) Math.ceil(sub * 1.0 / (24 * 60 * 60 * 1000)) + 1;
    }

    /**
     * 将yyyy-MM-dd HH:mm格式的字符串转化为日期
     * @param strdate 開始日期
     * @return date
     */
    public static Date getHHmmDate(String strdate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = null;
        try {
            date = format.parse(strdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 将传入日期的小时和分钟和秒提取出来
     * @param date 日期
     * @return str
     */
    public static String getHHmmss(Date date) {
        return HHMMSS.format(date);
    }

    /**
     * 将传入日期的小时和分钟提取出来
     * @param date 日期
     * @return str
     */
    public static String getHHmm(Date date) {
        return HHMM.format(date);
    }


    /**
     * 本周的第一天和最後一天
     * @return map
     */
    public static Map getWeekDay() {
        Map<String, String> map = new HashMap<String, String>();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); // 获取本周一的日期
        map.put("mon", df.format(cal.getTime()));
        // 这种输出的是上个星期周日的日期，因为国外把周日当成第一天
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        // 增加一个星期，才是我们中国人理解的本周日的日期
        cal.add(Calendar.WEEK_OF_YEAR, 1);
        map.put("sun", df.format(cal.getTime()));
        return map;
    }

    /**
     * 本月的第一天和最後一天
     * @return map
     */
    public static Map getMonthDate() {
        Map<String, String> map = new HashMap<String, String>();
        // 获取Calendar
        Calendar calendar = Calendar.getInstance();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        // 设置时间,当前时间不用设置
        // calendar.setTime(new Date());
        calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DATE));
        map.put("monthF", format.format(calendar.getTime()));
        // 设置日期为本月最大日期
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
        map.put("monthL", format.format(calendar.getTime()));
        return map;
    }

}
