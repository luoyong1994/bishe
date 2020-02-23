package com.ynet.fullview.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
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

    private String papertel;

    private String paperqq;
}