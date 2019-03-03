package com.ynet.fullview.controller;

import com.ynet.fullview.model.Sysuser;
import com.ynet.fullview.service.UserManageService;
import com.ynet.fullview.util.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/3/3
 * Time: 18:36
 * Description: No Description
 */
@RestController
@RequestMapping("/user")
public class UserManageController {

    @Resource
    private UserManageService userManageService;

    @RequestMapping("/addUser")
    public JsonResult addUser(Sysuser sysuser){
        userManageService.addUser(sysuser);
        return new JsonResult();
    }

    public JsonResult deletUser(Sysuser sysuser){
        return new JsonResult();
    }
}
