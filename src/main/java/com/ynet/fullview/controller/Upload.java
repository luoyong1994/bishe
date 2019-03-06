package com.ynet.fullview.controller;

import com.ynet.fullview.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/upload")
public class Upload {

    @RequestMapping("/uploadImg.do")
    public JsonResult uploadImg(MultipartFile muliPartFile, HttpServletRequest request){
        String path = request.getContextPath();
        System.out.println(path);
        return new JsonResult();
    }


    public JsonResult uploadFile(){
        return new JsonResult();
    }
}
