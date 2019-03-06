package com.ynet.fullview.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/test")
public class WXTestController {
    @RequestMapping("/token")
    public  String getTest(HttpServletRequest request,
                           @RequestParam(required = false) String echostr,
                           @RequestParam(required = false) String signature,
                           @RequestParam(required = false) String timestamp,
                           @RequestParam(required =false) String nonce){
        System.out.println("-------------"+signature);
        System.out.println("-------------"+timestamp);
        System.out.println("-------------"+echostr);
        System.out.println("-------------"+nonce);
        return echostr;

    }
}
