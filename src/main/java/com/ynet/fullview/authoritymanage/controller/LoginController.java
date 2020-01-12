package com.ynet.fullview.authoritymanage.controller;

import com.ynet.fullview.authoritymanage.bean.User;
import com.ynet.fullview.authoritymanage.service.LoginService;
import com.ynet.fullview.model.SysUser;
import com.ynet.fullview.util.JsonResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2020/1/7
 * Time: 23:23
 * Description: No Description
 */
@Controller
@ResponseBody
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/register.do")
    public JsonResult registerUser(SysUser sysUser) {
        JsonResult jsonResult = loginService.registerUser(sysUser);
        return jsonResult;
    }



    //            subject.checkRole("admin"); 代码检测角色
    //            subject.checkPermissions("query", "add"); 代码检测权限
    //            @RequiresRoles("admin")  注解检测角色
    //            @RequiresPermissions("add") 注解配置权限要求
    @RequestMapping("/login.do")
    public JsonResult login(SysUser sysUser) {
       return loginService.userLogin(sysUser);
    }
}
