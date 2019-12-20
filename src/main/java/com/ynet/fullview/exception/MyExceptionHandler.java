package com.ynet.fullview.exception;

import com.ynet.fullview.util.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public JsonResult handleRunTimeException(Exception e){
        System.out.println("有异常---------------");
        e.printStackTrace();
        return new JsonResult("系统繁忙，请稍后再试！");
    }

    @ResponseBody
    @ExceptionHandler(value = ActionException.class)
    public JsonResult handleActionException(ActionException e){
        System.out.println("自己的异常-----------------");
        e.printStackTrace();
        return new JsonResult(e.getErrorMsg());
    }
}
