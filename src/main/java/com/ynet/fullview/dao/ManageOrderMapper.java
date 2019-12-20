package com.ynet.fullview.dao;

import com.ynet.fullview.model.OrderInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManageOrderMapper {
   public List<OrderInfo> queryInOrder();
   public List<OrderInfo> queryAcceptFlow();
   public void deleteAcceptFlow(OrderInfo orderInfo);
   public OrderInfo queryAcceptFlowByFlowId(OrderInfo orderInfo);
   public OrderInfo queryOutOrderById(OrderInfo orderInfo);
}
