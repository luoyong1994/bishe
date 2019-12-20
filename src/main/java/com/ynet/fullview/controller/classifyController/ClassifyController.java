package com.ynet.fullview.controller.classifyController;

import com.ynet.fullview.model.Classify;
import com.ynet.fullview.service.classifyservice.ClassifyService;
import com.ynet.fullview.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/classify/")
public class ClassifyController {

    @Autowired
    private ClassifyService classifyService;

    @PostMapping("add.do")
    public JsonResult addClassify(Classify classify){
        return new JsonResult(classifyService.addClassify(classify));
    }

    @PostMapping("update.do")
    public JsonResult updateClassify(Classify classify){
        classifyService.updateClassify(classify);
        return new JsonResult();
    }

    @PostMapping("delete.do")
    public JsonResult deleteClassify(Classify classify){
        classifyService.deleteClassify(classify);
        return new JsonResult();
    }

    @PostMapping("query.do")
    public JsonResult queryClassify(Classify classify){
        return new JsonResult(classifyService.queryClassify(classify));
    }
}
