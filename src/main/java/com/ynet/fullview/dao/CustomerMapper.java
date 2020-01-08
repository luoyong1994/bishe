package com.ynet.fullview.dao;

import com.ynet.fullview.model.OrderInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerMapper {
    public List<OrderInfo> queryOrderInfo(@Param("content") String content);
    public OrderInfo queryOrderDeatil(OrderInfo orderInfo);
    public void addAcceptOrderFlow(OrderInfo orderInfo);
    public void deleteAcceptFlow(OrderInfo orderInfo);
    public OrderInfo queryAcceptFlow(OrderInfo orderInfo);
}
