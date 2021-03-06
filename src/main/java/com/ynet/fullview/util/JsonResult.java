package com.ynet.fullview.util;


import com.ynet.fullview.exception.ActionException;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/3/3
 * Time: 16:54
 * Description: No Description
 */
public class JsonResult {
    public static final int SUCCESS = 0;
    public static final int ERROR = 1;

    private int state;
    /** 错误消息  */
    private String message;
    /** 返回正确时候的数据 */
    private Object data;

    public JsonResult() {
    }


    public JsonResult(String error){
        state = ERROR;
        this.message = error;
    }

    public JsonResult(Object data){
        state = SUCCESS;
        this.data = data;
    }

    public JsonResult(Throwable e) {
        state = ERROR;
        message = e.getMessage();
    }

    public JsonResult(int state, Throwable e) {
        this.state = state;
        if(e instanceof ActionException){
            ActionException actionException = (ActionException)e;
            this.message=actionException.getErrorMsg();
        }else{
            this.message = e.getMessage();
        }
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsonResult [state=" + state + ", message=" + message + ", data=" + data + "]";
    }
}
