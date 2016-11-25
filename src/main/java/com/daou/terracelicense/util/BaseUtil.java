package com.daou.terracelicense.util;

/**
 * Created by user on 2016-11-24.
 */
public class BaseUtil {
    public static boolean stringNullOrEmpty(String s){
        boolean result;
        if(s == null || "".equals(s)){
            result = true;
        }else{
            result = false;
        }

        return result;
    }
}
