package com.ynet.fullview.service.customerservice;

import com.ynet.fullview.model.OrderInfo;

import java.util.List;

public interface CustomerService {

    public List<OrderInfo> queryOrderInfo(String content);
    public OrderInfo queryOrderDeatil(OrderInfo orderInfo);
    public void addAcceptOrderFlow(OrderInfo orderInfo);
}
