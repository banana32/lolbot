package com.java.helloworld.controller;

import java.io.Serializable;

public class RequestMessageVO implements Serializable{

    private static final long serialVersionUID = -1L;

    private String user_key;
    private String type;
    private String content;

    public RequestMessageVO(){

    }

    public RequestMessageVO(String user_key, String type, String content) {
        this.user_key = user_key;
        this.type = type;
        this.content = content;
    }

    public String getUser_key() {
        return user_key;
    }

    public void setUser_key(String user_key) {
        this.user_key = user_key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "RequestMessageVO{" +
                "user_key='" + user_key + '\'' +
                ", type='" + type + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
