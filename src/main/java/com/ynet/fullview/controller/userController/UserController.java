package com.ynet.fullview.controller.userController;

import com.ynet.fullview.model.SysUser;
import com.ynet.fullview.service.userservice.UserService;
import com.ynet.fullview.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user/")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("signIn.do")
    public JsonResult userSignIn(SysUser sysUser, HttpServletRequest request) {
        log.info("登录用户信息：{}", sysUser.toString());
        SysUser sysUser1 = userService.signIn(sysUser);
        HttpSession session = request.getSession();
        session.setAttribute("user", sysUser1);
        return new JsonResult(sysUser1);
    }

    @PostMapping("addUser.do")
    public JsonResult addUser(SysUser sysUser) {
        userService.addUser(sysUser);
        return new JsonResult();
    }

    @PostMapping("queryUsers.do")
    public JsonResult queryUser(SysUser sysUser) {
        return new JsonResult(userService.queryUsers(sysUser));
    }


    @PostMapping("deleteUser.do")
    public JsonResult deleteUserById(SysUser sysUser) {
        userService.deleteUserById(sysUser);
        return new JsonResult();
    }

    @PostMapping("updateUser.do")
    public JsonResult updateUserById(SysUser sysUser) {
        userService.updateUserById(sysUser);
        return new JsonResult();
    }


}
