package com.java.helloworld.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
public class BotController {
    @PostMapping(value = "message", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessageVO message(@RequestBody RequestMessageVO req_vo) {
        System.out.println(req_vo);

        ResponseMessageVO res_vo = new ResponseMessageVO();
        MessageVO mes_vo = new MessageVO();

        mes_vo.setText("hello idiot " + req_vo.getContent());
        res_vo.setMessage(mes_vo);
        return res_vo;
    }   

    @GetMapping(value="keyboard")
    public KeyboardVO keyboard(){
        KeyboardVO keyboard = new KeyboardVO(new String[]{"�뼱�젣 �쟾�쟻", "理쒓렐 �쟾�쟻", "�븞�뀞 �븞�뀞"});

        return keyboard;
    }
}