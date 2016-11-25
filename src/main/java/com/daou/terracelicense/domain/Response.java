package com.daou.terracelicense.domain;

import java.io.Serializable;

/**
 * Created by user on 2016-11-24.
 */
public class Response implements Serializable {
    private static final long serialVersionUID = 1L;

    private String status;
    private String value;

    public Response(String status, String value) {
        this.status = status;
        this.value = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
