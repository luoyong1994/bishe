package com.ynet.fullview.controller.orderController.manageOrder;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.ynet.fullview.model.OrderInfo;
import com.ynet.fullview.service.orderservice.manageservice.ManageService;
import com.ynet.fullview.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.plaf.synth.SynthSpinnerUI;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/queryOrder/")
public class ManageOrderController {

    @Autowired
    ManageService manageService;

    @RequestMapping("queryOrderInfo.do")
    public JsonResult queryOrderInfo() {
        return new JsonResult(manageService.queryOrderList());
    }

    @PostMapping("queryAcceptFlow.do")
    public JsonResult queryAcceptFlow() {
        return new JsonResult(manageService.queryAcceptFlow());
    }

    @PostMapping("deleteAcceptFlow.do")
    public JsonResult deleteAcceptFlow(OrderInfo orderInfo) {
        manageService.deleteAcceptFlow(orderInfo);
        return new JsonResult();
    }


    @PostMapping("authedAcceptFlow.do")
    public JsonResult authedAcceptFlow(OrderInfo orderInfo) {
        manageService.authedAcceptFlow(orderInfo);
        return new JsonResult();
    }

    @PostMapping("updateInOrder.do")
    public JsonResult updateInOrder(@RequestParam("id") String id, String totalAmt, String bookAmt, String paperAmt,
                                    String programAmt, String outPaperAmt, String outProgramAmt, String projectProcess) {
        Map map = new HashMap<String,String>();
        map.put("id",id);
        map.put("totalAmt",totalAmt);
        map.put("bookAmt",bookAmt);
        map.put("paperAmt",paperAmt);
        map.put("programAmt",programAmt);
        map.put("outPaperAmt",outPaperAmt);
        map.put("outProgramAmt",outProgramAmt);
        map.put("projectProcess",projectProcess);
        System.out.println(map);
        manageService.updateInOrder(map);
        return new JsonResult();
    }
}
