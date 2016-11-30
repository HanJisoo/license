package com.daou.terracelicense.domain;

import java.io.Serializable;

/**
 * Created by user on 2016-11-30.
 */
public class CodeControl implements Serializable{
    private String value;
    private String code;
    private String category;
    private String publicState;
    private boolean view;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPublicState() {
        return publicState;
    }

    public void setPublicState(String publicState) {
        this.publicState = publicState;
    }

    public boolean isView() {
        return view;
    }

    public void setView(boolean view) {
        this.view = view;
    }
}
