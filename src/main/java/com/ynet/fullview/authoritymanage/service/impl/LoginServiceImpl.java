package com.ynet.fullview.authoritymanage.service.impl;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.ynet.fullview.authoritymanage.bean.Permissions;
import com.ynet.fullview.authoritymanage.bean.Role;
import com.ynet.fullview.authoritymanage.bean.User;
import com.ynet.fullview.authoritymanage.service.LoginService;
import com.ynet.fullview.dao.SysUserMapper;
import com.ynet.fullview.exception.ActionException;
import com.ynet.fullview.model.SysUser;
import com.ynet.fullview.util.IDUtil;
import com.ynet.fullview.util.JsonResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2020/1/7
 * Time: 23:24
 * Description: No Description
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public User getUserName() {
        User user = getMapByUser();
        return user;
    }

    /**
     * 实现用户的注册功能
     *
     * @return
     */
    @Override
    public JsonResult registerUser(SysUser sysUser) {
        SysUser sysUser1 = sysUserMapper.queryUserByUserName(sysUser);
        if (sysUser1 != null) {
            throw new ActionException("用户名已存在！");
        }
        sysUser.setId(IDUtil.generaryId());
        String defaultPassword = "123qwe";
        //产生盐
        String random = new SecureRandomNumberGenerator().nextBytes().toHex();
        //将用户的密码md5三次并加盐计算出
        String password = new Md5Hash(defaultPassword, random, 3).toString();
        sysUser.setPassword(password);
        sysUserMapper.addUser(sysUser);
        Map<String, String> map = new HashMap<>();
        map.put("state", "success");
        map.put("message", "注册成功");
        map.put("password", defaultPassword);
        return new JsonResult(map);
    }


    @Override
    public JsonResult userLogin(SysUser sysUser) {
        if (sysUser != null) {
            SysUser sysUser1 = sysUserMapper.queryUserByUserName(sysUser);
            if (sysUser1 != null) {
                try {
                    String password = new Md5Hash(sysUser.getPassword(), sysUser1.getRandom(), 3).toString();
                    Subject subject = SecurityUtils.getSubject();
                    UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(sysUser.getUsername(), password);
                    subject.login(usernamePasswordToken);
                } catch (AuthenticationException e) {
                    throw new ActionException("用户名密码错误！");
                }
            } else {
                throw new ActionException("用户名密码错误！");
            }
        } else {
            throw new ActionException("用户名密码错误！");
        }
        return new JsonResult();
    }

    /**
     * 模拟数据库
     *
     * @return
     */
    User getMapByUser() {
        //权限处理
        Permissions permissions = new Permissions();
        permissions.setId("1");
        permissions.setPermissionName("query");
        Permissions permissions1 = new Permissions();
        permissions1.setId("2");
        permissions1.setPermissionName("add");
        HashSet<Permissions> permissionsHashSet = new HashSet<>();
        permissionsHashSet.add(permissions);
        permissionsHashSet.add(permissions1);
        Role role = new Role();
        role.setId("1");
        role.setRoleName("admin");
        role.setPermissions(permissionsHashSet);
        User user = new User();
        user.setId("1");
        user.setPassWord("123456");
        HashSet<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        return user;
    }


    public static void main(String[] args) {
        String random = new SecureRandomNumberGenerator().nextBytes().toHex();
        //将用户的密码md5三次并加盐计算出
        String password = new Md5Hash("123qwe", random, 3).toString();
        System.out.println(random.length());
        System.out.println(password.length());
    }
}
