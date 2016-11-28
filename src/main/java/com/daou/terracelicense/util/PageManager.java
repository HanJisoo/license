package com.daou.terracelicense.util;

/**
 * Created by user on 2016-11-26.
 */
public class PageManager {
    public static final int MACHINE_PAGE_LIMIT = 30;

    public static int getOffsetByPage(String page, int limit){
        int offset = ( Integer.parseInt(page) - 1 ) * limit;
        return offset;
    }

}
