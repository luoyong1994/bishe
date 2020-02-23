package com.ynet.fullview.service.userservice;


import com.ynet.fullview.model.SysUser;

import java.util.List;

public interface UserService {
    public SysUser signIn(SysUser sysUser);
    public void addUser(SysUser sysUser);
    public List<SysUser> queryUsers(SysUser sysUser);
    public void deleteUserById(SysUser sysUser);
    public void updateUserById(SysUser sysUser);
}
