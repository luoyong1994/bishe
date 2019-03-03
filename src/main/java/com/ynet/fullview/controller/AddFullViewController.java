package com.ynet.fullview.controller;

import com.ynet.fullview.model.Region;
import com.ynet.fullview.service.FullViewService;
import com.ynet.fullview.util.ID;
import com.ynet.fullview.util.JsonResult;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/3/3
 * Time: 18:35
 * Description: No Description
 */
@RestController
@RequestMapping("/view")
public class AddFullViewController {

    @Resource
    private FullViewService fullViewService;

    @RequestMapping("/addView.do")
    public JsonResult addFullView(Region region){
        region.setId(ID.getID());
        fullViewService.addFullView(region);
        return new JsonResult();
    }


    @RequestMapping("/updateView.do")
    public JsonResult updateFullView(Region region){
        fullViewService.updateFullView(region);
        return new JsonResult();
    }

    @RequestMapping("/queryView.do")
    public JsonResult queryFullview(Region region){
        return new JsonResult(fullViewService.queryFullview(region));
    }

}
