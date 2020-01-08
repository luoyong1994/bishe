package com.ynet.fullview.dao;

import com.ynet.fullview.model.InOrder;
import com.ynet.fullview.model.OrderInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InOrderMapper {
    public void addInOrder(OrderInfo orderInfo);
    public void updaetInOrder(OrderInfo orderInfo);
    public void deleteInOrder(OrderInfo orderInfo);
    public List<InOrder> queryInOrder(OrderInfo orderInfo);
}