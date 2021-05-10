package com.zst.el.utils;

/**
 * @author robert
 * @date 2021/5/10 14:06
 */
public class MysqlUtil {

    public static final String EM_LOGIN_LOG = "EM_LOGIN_LOG_";

    public static final String EM_OPT_LOG = "EM_OPT_LOG_";


    //分表算法
    //登录分表

    /**
     * 根据账号的最后一位进行分表
     * @param number
     * @return
     */
    public static String getEmLoginLog(String number){
        int arr = number.charAt(number.length()-1);
        return EM_LOGIN_LOG+arr%5;
    }

    //操作分表
    /**
     * 根据登录用户的id进行分表
     */
    public static String getEmOptLog(long id){
        return EM_OPT_LOG+id%10;
    }

    public static void main(String[] args) {
        System.out.println(getEmLoginLog("robertr"));
    }


}
