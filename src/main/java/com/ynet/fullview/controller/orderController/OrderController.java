package com.ynet.fullview.controller.orderController;

import com.ynet.fullview.model.OrderInfo;
import com.ynet.fullview.service.orderservice.OrderService;
import com.ynet.fullview.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order/")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("add.do")
    public JsonResult addOrder(OrderInfo orderInfo){
        System.out.println(orderInfo);
        orderService.addOrder(orderInfo);
        return new JsonResult();
    }

    @PostMapping("updateInOrder.do")
    public JsonResult updateInOrder(OrderInfo orderInfo){
        orderService.updaetInOrder(orderInfo);
        return new JsonResult();
    }

    @PostMapping("deleteInOrder.do")
    public JsonResult deleteInOrder(OrderInfo orderInfo){
        orderService.deleteInOrder(orderInfo);
        return new JsonResult();
    }

    @PostMapping("queryInOrder.do")
    public JsonResult queryInOrder(OrderInfo orderInfo){
        return new JsonResult(orderService.queryInOrder(orderInfo));
    }

    @PostMapping("updateOutOrder.do")
    public JsonResult updateOutOrder(OrderInfo orderInfo){
        orderService.updateOutOrder(orderInfo);
        return new JsonResult();
    }

    @PostMapping("deleteOutOrder.do")
    public JsonResult deleteOuterOrder(OrderInfo orderInfo){
        orderService.deleteOutOrder(orderInfo);
        return new JsonResult();
    }

    @PostMapping("queryOutOrder.do")
    public JsonResult queryOutOrder(OrderInfo orderInfo){
        return new JsonResult(orderService.queryOutOrder(orderInfo));
    }


}
