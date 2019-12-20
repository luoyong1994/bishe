package com.ynet.fullview.service.userserviceImpl;

import com.ynet.fullview.dao.SysUserMapper;
import com.ynet.fullview.exception.ActionException;
import com.ynet.fullview.model.SysUser;
import com.ynet.fullview.service.userservice.UserService;
import com.ynet.fullview.util.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser signIn(SysUser sysUser) {
        if(sysUser!=null){
            SysUser sysUser1 = sysUserMapper.queryUserByUserName(sysUser);
            if(sysUser1!=null){
                if(sysUser.getPassword().equals(sysUser1.getPassword())){
                    return sysUser1;
                }else{
                    throw new ActionException("用户名密码错误！");
                }
            }else {
                throw new ActionException("用户名密码错误！");
            }
        }else {
            throw new ActionException("用户名密码错误！");
        }
    }

    @Override
    public void addUser(SysUser sysUser) {
        if(sysUser!=null){
            SysUser sysUser1 = sysUserMapper.queryUserByUserName(sysUser);
            if(sysUser1!=null){
                throw new ActionException("用户名已存在！");
            }
            sysUser.setId(IDUtil.generaryId());
            sysUserMapper.addUser(sysUser);
        }else {
            throw new ActionException("用户信息不能为空");
        }
    }

    @Override
    public List<SysUser> queryUsers(SysUser sysUser) {
        return sysUserMapper.queryUsers(sysUser);
    }


}
