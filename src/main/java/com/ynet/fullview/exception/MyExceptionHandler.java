package com.ynet.fullview.exception;

import com.ynet.fullview.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class MyExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public JsonResult handleRunTimeException(Exception e){
        log.error(e.toString());
        return new JsonResult("系统繁忙，请稍后再试！");
    }

    @ResponseBody
    @ExceptionHandler(value = ActionException.class)
    public JsonResult handleActionException(ActionException e){
        log.info("业务异常:{}",e);
        return new JsonResult(e.getErrorMsg());
    }

    @ResponseBody
    @ExceptionHandler(value = AuthorizationException.class)
    public JsonResult ErrorHandler(ActionException e){
        log.info("权限不足异常:{}",e);
        return new JsonResult("没有通过权限验证!");
    }
}
