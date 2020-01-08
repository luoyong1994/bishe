package com.ynet.fullview.service.customerserviceImpl;

import com.ynet.fullview.dao.CustomerMapper;
import com.ynet.fullview.model.OrderInfo;
import com.ynet.fullview.service.customerservice.CustomerService;
import com.ynet.fullview.util.DateUtil;
import com.ynet.fullview.util.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<OrderInfo> queryOrderInfo(String content) {

        return customerMapper.queryOrderInfo(content);
    }


    @Override
    public OrderInfo queryOrderDeatil(OrderInfo orderInfo) {
        return customerMapper.queryOrderDeatil(orderInfo);
    }


    @Override
    public void addAcceptOrderFlow(OrderInfo orderInfo) {
        orderInfo.setOrderDate(DateUtil.getNowTime());
        orderInfo.setFlowNo(IDUtil.generaryId());
        customerMapper.addAcceptOrderFlow(orderInfo);
    }
}
