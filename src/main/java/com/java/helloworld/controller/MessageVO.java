package com.java.helloworld.controller;

public class MessageVO {
    private String text;

    public MessageVO() {

    }

    public MessageVO(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
