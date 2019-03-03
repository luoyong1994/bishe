package com.ynet.fullview.service;

import com.ynet.fullview.dao.UserManageDao;
import com.ynet.fullview.model.Sysuser;
import com.ynet.fullview.util.ID;
import com.ynet.fullview.util.JsonResult;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/3/3
 * Time: 20:43
 * Description: No Description
 */
@Service
public class UserManageService {

    @Resource
    private UserManageDao userManageDao;

    public void addUser(Sysuser sysuser){
        sysuser.setUserId(ID.getID());
    }

    public void deletUser(Sysuser sysuser){
        userManageDao.deletUser(sysuser);
    }

}
