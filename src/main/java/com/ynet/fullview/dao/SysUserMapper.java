package com.ynet.fullview.dao;

import com.ynet.fullview.model.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserMapper {
    SysUser selectByPrimaryKey(String id);
    void addUser(SysUser sysUser);
    List<SysUser> queryUsers(SysUser sysUser);
    SysUser queryUserByUserName(SysUser sysUser);
}