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

        switch(req_vo.getContent()) {
            case "어제 전적":
                mes_vo.setText("이것은 어제 전적입니다.");
                break;
            case "최근 전적":
                mes_vo.setText("이것은 최근 전적입니다.");
                break;
            default:
                mes_vo.setText("아직 미구현 기능 입니다.");
                break;
        }
        res_vo.setMessage(mes_vo);
        return res_vo;
    }

    @GetMapping(value="keyboard")
    public KeyboardVO keyboard(){
        KeyboardVO keyboard = new KeyboardVO(new String[]{"어제 전적", "최근 전적"});

        return keyboard;
    }
}