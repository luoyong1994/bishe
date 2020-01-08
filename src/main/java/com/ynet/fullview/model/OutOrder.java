package com.ynet.fullview.model;

import java.math.BigDecimal;

public class OutOrder {
    private String orderId;

    private BigDecimal totalAmt;

    private BigDecimal programAmt;

    private BigDecimal paperAmt;

    private String programName;

    private String paperName;

    private String tel;

    private String projectProcess;

    private String orderDate;

    private String qq;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(BigDecimal totalAmt) {
        this.totalAmt = totalAmt;
    }

    public BigDecimal getProgramAmt() {
        return programAmt;
    }

    public void setProgramAmt(BigDecimal programAmt) {
        this.programAmt = programAmt;
    }

    public BigDecimal getPaperAmt() {
        return paperAmt;
    }

    public void setPaperAmt(BigDecimal paperAmt) {
        this.paperAmt = paperAmt;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getProjectProcess() {
        return projectProcess;
    }

    public void setProjectProcess(String projectProcess) {
        this.projectProcess = projectProcess;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }
}