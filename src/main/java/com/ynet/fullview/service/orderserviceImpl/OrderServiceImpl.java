package com.ynet.fullview.service.orderserviceImpl;

import com.ynet.fullview.dao.AnnexMapper;
import com.ynet.fullview.dao.InOrderMapper;
import com.ynet.fullview.dao.OutOrderMapper;
import com.ynet.fullview.model.InOrder;
import com.ynet.fullview.model.OrderInfo;
import com.ynet.fullview.model.OutOrder;
import com.ynet.fullview.service.orderservice.OrderService;
import com.ynet.fullview.util.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private InOrderMapper inOrderMapper;

    @Autowired
    private OutOrderMapper outOrderMapper;

    @Autowired
    private AnnexMapper annexMapper;


    @Override
    public void addOrder(OrderInfo orderInfo) {
        String id = IDUtil.generaryId();
        orderInfo.setId(id);
        inOrderMapper.addInOrder(orderInfo);
        annexMapper.addAnnex(orderInfo);
    }


    @Override
    public void updaetInOrder(OrderInfo orderInfo) {
        inOrderMapper.updaetInOrder(orderInfo);
    }

    @Override
    public void deleteInOrder(OrderInfo orderInfo) {
        inOrderMapper.deleteInOrder(orderInfo);
    }

    @Override
    public List<InOrder> queryInOrder(OrderInfo orderInfo) {
        return inOrderMapper.queryInOrder(orderInfo);
    }



    @Override
    public void updateOutOrder(OrderInfo orderInfo) {
        outOrderMapper.updateOutOrder(orderInfo);
    }

    @Override
    public void deleteOutOrder(OrderInfo orderInfo) {
        outOrderMapper.deleteOutOrder(orderInfo);
    }

    @Override
    public List<OutOrder> queryOutOrder(OrderInfo orderInfo) {
        return outOrderMapper.queryOutOrder(orderInfo);
    }
}
