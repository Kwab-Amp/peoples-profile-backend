package com.ttlabs.project.models;

import java.io.Serializable;

public class Response implements Serializable {
    private boolean status;
    private String message;
    private Object data;

    public Response(boolean status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Response(boolean status, Object data) {
        this.status = status;
        this.data = data;
    }

    public Response(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
