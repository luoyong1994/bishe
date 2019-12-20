package com.ynet.fullview.service.orderservice.manageservice;

import com.ynet.fullview.model.OrderInfo;


import java.util.List;
import java.util.Map;


/**
 * 查询订单:
 * 1、未分配完成订单
 * 2、开发中的订单
 * 3、已结账订单
 * 4、已预约订单
 */
public interface ManageService {
    public List<OrderInfo> queryOrderList();
    public List<OrderInfo> queryAcceptFlow();
    public void deleteAcceptFlow(OrderInfo orderInfo);
    public void authedAcceptFlow(OrderInfo orderInfo);
    public void updateInOrder(Map<String,String> map);
}
