package com.java.helloworld.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MessageController {
    @PostMapping(value = "message", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessageVO keyBoardApi(@RequestBody RequestMessageVO req_vo) {
        System.out.println(req_vo);

        ResponseMessageVO res_vo = new ResponseMessageVO();
        MessageVO mes_vo = new MessageVO();

        mes_vo.setText("hello " + req_vo.getContent());
        res_vo.setMessage(mes_vo);
        return res_vo;
    }
}