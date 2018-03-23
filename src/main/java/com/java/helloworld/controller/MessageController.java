package com.java.helloworld.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MessageController {
    @PostMapping(value = "message", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String homeKeyBoardApi(@RequestBody RequestMessageVO vo) {
        System.out.println(vo);

        return "{\"text\": \"hello lolbot\"}";
    }
}