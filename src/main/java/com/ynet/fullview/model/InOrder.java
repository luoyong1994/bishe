package com.ynet.fullview.model;

import java.math.BigDecimal;

public class InOrder {
    private String id;

    private String shop;

    private String wantName;

    private String qq;

    private String projectName;

    private String technology;

    private String orderDate;

    private BigDecimal totalAmt;

    private BigDecimal bookAmt;

    private String projectProcess;

    private BigDecimal programAmt;

    private String paperTitle;

    private BigDecimal paperAmt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getWantName() {
        return wantName;
    }

    public void setWantName(String wantName) {
        this.wantName = wantName;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(BigDecimal totalAmt) {
        this.totalAmt = totalAmt;
    }

    public BigDecimal getBookAmt() {
        return bookAmt;
    }

    public void setBookAmt(BigDecimal bookAmt) {
        this.bookAmt = bookAmt;
    }

    public String getProjectProcess() {
        return projectProcess;
    }

    public void setProjectProcess(String projectProcess) {
        this.projectProcess = projectProcess;
    }

    public BigDecimal getProgramAmt() {
        return programAmt;
    }

    public void setProgramAmt(BigDecimal programAmt) {
        this.programAmt = programAmt;
    }

    public String getPaperTitle() {
        return paperTitle;
    }

    public void setPaperTitle(String paperTitle) {
        this.paperTitle = paperTitle;
    }

    public BigDecimal getPaperAmt() {
        return paperAmt;
    }

    public void setPaperAmt(BigDecimal paperAmt) {
        this.paperAmt = paperAmt;
    }

    @Override
    public String toString() {
        return "InOrder{" +
                "id='" + id + '\'' +
                ", shop='" + shop + '\'' +
                ", wantName='" + wantName + '\'' +
                ", qq='" + qq + '\'' +
                ", projectName='" + projectName + '\'' +
                ", technology='" + technology + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", totalAmt=" + totalAmt +
                ", bookAmt=" + bookAmt +
                ", projectProcess='" + projectProcess + '\'' +
                ", programAmt=" + programAmt +
                ", paperTitle='" + paperTitle + '\'' +
                ", paperAmt=" + paperAmt +
                '}';
    }
}