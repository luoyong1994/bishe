package com.ynet.fullview.service.orderserviceImpl.manageserviceImpl;


import com.ynet.fullview.dao.InOrderMapper;
import com.ynet.fullview.dao.ManageOrderMapper;
import com.ynet.fullview.dao.OutOrderMapper;
import com.ynet.fullview.exception.ActionException;
import com.ynet.fullview.model.InOrder;
import com.ynet.fullview.model.OrderInfo;
import com.ynet.fullview.model.OutOrder;
import com.ynet.fullview.service.orderservice.manageservice.ManageService;
import com.ynet.fullview.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    private ManageOrderMapper manageOrderMapper;

    @Autowired
    private OutOrderMapper outOrderMapper;

    @Autowired
    private InOrderMapper inOrderMapper;

    @Override
    public List<OrderInfo> queryOrderList() {
        return manageOrderMapper.queryInOrder();
    }

    @Override
    public List<OrderInfo> queryAcceptFlow() {
        return manageOrderMapper.queryAcceptFlow();
    }

    @Override
    public void deleteAcceptFlow(OrderInfo orderInfo) {
        manageOrderMapper.deleteAcceptFlow(orderInfo);
    }

    @Override
    public void authedAcceptFlow(OrderInfo orderInfo) {

        OrderInfo acceptFlow = manageOrderMapper.queryAcceptFlowByFlowId(orderInfo);
        OrderInfo outOrder = new OrderInfo();
        outOrder.setFlowNo(acceptFlow.getFlowNo());
        outOrder.setProgramName(acceptFlow.getProgramName());
        outOrder.setPrice(acceptFlow.getPrice());
        outOrder.setTel(acceptFlow.getTel());
        outOrder.setQq(acceptFlow.getQq());
        outOrder.setOrderDate(DateUtil.getNowTime());
        outOrder.setId(acceptFlow.getId());
        OrderInfo orderInfoExist = manageOrderMapper.queryOutOrderById(outOrder);
        if(orderInfoExist!=null){
            throw new ActionException("该定单已分配技术，请拒绝该订单，已实现数据同步");
        }
        outOrderMapper.addOutOrder(outOrder);
        manageOrderMapper.deleteAcceptFlow(orderInfo);
    }

    @Override
    public void updateInOrder(Map<String, String> map) {
        OrderInfo outOrder = new OrderInfo();
        outOrder.setId(map.get("id"));
        boolean updateOutFlag = false;
        if(map.get("outProgramAmt")!=null && map.get("outProgramAmt").length()>0){
            outOrder.setProgramAmt(new BigDecimal(map.get("outProgramAmt")));
            updateOutFlag =true;
        }
        if(map.get("outPaperAmt")!=null && map.get("outPaperAmt").length()>0){
            outOrder.setPaperAmt(new BigDecimal(map.get("outPaperAmt")));
            updateOutFlag =true;
        }
        OutOrder orderInfo = outOrderMapper.queryOutOrderById(outOrder);
        if(orderInfo!=null && orderInfo.getOrderId()!=null){
            if(updateOutFlag){
                outOrderMapper.updateOutOrder(outOrder);
            }
        }else {
            throw new ActionException("订单未分配技术，请走订单分配流程");
        }
        OrderInfo inOrder = new OrderInfo();
        boolean updateInorderFlage = false;
        inOrder.setId(map.get("id"));
        if(map.get("totalAmt")!=null && map.get("totalAmt").length()>0){
            inOrder.setTotalAmt(new BigDecimal(map.get("totalAmt")));
            updateInorderFlage=true;
        }
        if(map.get("programAmt")!=null && map.get("programAmt").length()>0){
            inOrder.setPaperAmt(new BigDecimal(map.get("paperAmt")));
            updateInorderFlage=true;
        }
        if(map.get("programAmt")!=null && map.get("programAmt").length()>0){
            inOrder.setProgramAmt(new BigDecimal(map.get("programAmt")));
            updateInorderFlage=true;
        }
        if(map.get("projectProcess") !=null && map.get("projectProcess").length()>0){
            inOrder.setProjectProcess(map.get("projectProcess"));
            updateInorderFlage=true;
        }
        if(updateInorderFlage){
            inOrderMapper.updaetInOrder(inOrder);
        }
    }
}
