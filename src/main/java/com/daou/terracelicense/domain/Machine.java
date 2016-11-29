package com.daou.terracelicense.domain;

import java.io.Serializable;

/**
 * Created by user on 2016-11-26.
 */
public class Machine implements Serializable{
    private String serialKey;
    private String testStr;

    public Machine(String serialKey, String testStr) {
        this.serialKey = serialKey;
        this.testStr = testStr;
    }

    public String getSerialKey() {
        return serialKey;
    }

    public void setSerialKey(String serialKey) {
        this.serialKey = serialKey;
    }

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }
}
