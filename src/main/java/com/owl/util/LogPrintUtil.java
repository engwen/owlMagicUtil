package com.owl.util;


import java.util.Date;


/**
 * @author engwen
 * email xiachanzou@outlook.com
 * 2019/6/25.
 */
public abstract class LogPrintUtil {

    public static void info(String msg) {
        log(msg, "INFO");
    }

    public static void error(String msg) {
        log(msg, "ERROR");
    }

    private static void log(String msg, String level) {
        System.out.println("[" + level + "][" + DateCountUtil.getDateFormSdf(new Date(), DateCountUtil.YMDHMS4BAR) +
                "][" + Thread.currentThread().getStackTrace()[3].getClassName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "] " + msg);
    }
}
