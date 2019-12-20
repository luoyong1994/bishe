package com.ynet.fullview.controller.annexController;

import com.ynet.fullview.model.OrderInfo;
import com.ynet.fullview.service.annexservice.AnnexService;
import com.ynet.fullview.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/annex/")
public class AnnexController {


    @Autowired
    private AnnexService annexService;

    @PostMapping("deleteAnnex.do")
    public JsonResult deleteAnnex(OrderInfo orderInfo){
        annexService.deleteAnnex(orderInfo);
        return new JsonResult();
    }

    @PostMapping("updateAnnex.do")
    public JsonResult updateAnnex(OrderInfo orderInfo){
        annexService.updateAnnex(orderInfo);
        return new JsonResult();
    }


    @PostMapping("queryAnnex.do")
    public JsonResult queryAnnex(OrderInfo orderInfo){
        return new JsonResult(annexService.queryAnnex(orderInfo));
    }
}
