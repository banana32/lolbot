package com.java.helloworld.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MessageController {
    @PostMapping(value = "/message", consumes = "application/json", headers = "content-type=application/json")
    public String homeKeyBoardApi(@RequestBody RequestMessageVO vo) {
        System.out.print(vo);

        return "{\"text\": \"hello lolbot\"}";
    }
}