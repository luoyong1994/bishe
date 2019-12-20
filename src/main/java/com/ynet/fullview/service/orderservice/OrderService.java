package com.ynet.fullview.service.orderservice;

import com.ynet.fullview.model.InOrder;
import com.ynet.fullview.model.OrderInfo;
import com.ynet.fullview.model.OutOrder;

import java.util.List;

public interface OrderService {

    public void addOrder(OrderInfo orderInfo);

    public void updaetInOrder(OrderInfo orderInfo);
    public void deleteInOrder(OrderInfo orderInfo);
    public List<InOrder> queryInOrder(OrderInfo orderInfo);

    public void updateOutOrder(OrderInfo orderInfo);
    public void deleteOutOrder(OrderInfo orderInfo);
    public List<OutOrder> queryOutOrder(OrderInfo orderInfo);

}
