package com.ynet.fullview.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderInfo {
    private String id;

    private String shop;

    private String wantName;

    private String serviceQQ;

    private String customerQQ;

    private String projectName;

    private String technology;

    private String orderDate;

    private BigDecimal totalAmt;

    private BigDecimal bookAmt;

    private String projectProcess;

    private BigDecimal programAmt;

    private String paperTitle;

    private BigDecimal paperAmt;

    private String qq;

    private String programName;

    private String paperName;

    private String tel;

    private String orderBillStatue;

    private String docPath;

    private String docName;

    private String imagePath;

    private String remarks;

    private String flowNo;

    private String price;

}
