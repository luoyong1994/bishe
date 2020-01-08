package com.ynet.fullview.exception;

public class ActionException extends RuntimeException{
    private String errorMsg;

    public ActionException(String errorMsg){
        this.errorMsg=errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "ActionException{" +
                "errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
