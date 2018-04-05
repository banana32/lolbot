package com.java.helloworld.controller;

public class ResponseMessageVO {
    private MessageVO message;

    public ResponseMessageVO() {
    }

    public ResponseMessageVO(MessageVO message) {
        this.message = message;
    }

    public MessageVO getMessage() {
        return message;
    }

    public void setMessage(MessageVO message) {
        this.message = message;
    }
}
