package com.ynet.fullview.authoritymanage.service;

import com.ynet.fullview.authoritymanage.bean.User;
import com.ynet.fullview.model.SysRole;
import com.ynet.fullview.model.SysUser;
import com.ynet.fullview.util.JsonResult;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2020/1/7
 * Time: 23:23
 * Description: No Description
 */
public interface LoginService {
    User getUserName();

    JsonResult registerUser(SysUser sysUser);

    JsonResult userLogin(SysUser sysUser);
}
