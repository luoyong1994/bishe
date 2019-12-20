package com.ynet.fullview.dao;

import com.ynet.fullview.model.OrderInfo;
import com.ynet.fullview.model.OutOrder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutOrderMapper {
    public void addOutOrder(OrderInfo orderInfo);
    public void updateOutOrder(OrderInfo orderInfo);
    public void deleteOutOrder(OrderInfo orderInfo);
    public List<OutOrder> queryOutOrder(OrderInfo orderInfo);
    public OutOrder queryOutOrderById(OrderInfo orderInfo);
}