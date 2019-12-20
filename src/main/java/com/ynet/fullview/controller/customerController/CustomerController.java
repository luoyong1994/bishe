package com.ynet.fullview.controller.customerController;

import com.ynet.fullview.model.OrderInfo;
import com.ynet.fullview.service.customerservice.CustomerService;
import com.ynet.fullview.service.orderservice.OrderService;
import com.ynet.fullview.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("queryOrderInfo.do")
    public JsonResult queryOrderInfo(String content){
        return new JsonResult(customerService.queryOrderInfo(content));
    }


    @PostMapping("queryOrderDetail.do")
    public JsonResult queryOrderDetailById(OrderInfo orderInfo){
        return new JsonResult(customerService.queryOrderDeatil(orderInfo));
    }

    @PostMapping("addAcceptOrderFlow.do")
    public JsonResult addAcceptOrderFlow(OrderInfo orderInfo){
        customerService.addAcceptOrderFlow(orderInfo);
        return new JsonResult();
    }


}
