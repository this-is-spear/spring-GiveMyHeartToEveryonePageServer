package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Imaspear on 2021-11-30
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */

@Controller
public class helloController {

    @GetMapping("")
    public String home(){
        return "test";
    }

    @GetMapping("/image-card")
    public String imageCardView(){
        return "image-card";
    }
}
