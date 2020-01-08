package com.ynet.fullview.authoritymanage.service.impl;

import com.ynet.fullview.authoritymanage.bean.Permissions;
import com.ynet.fullview.authoritymanage.bean.Role;
import com.ynet.fullview.authoritymanage.bean.User;
import com.ynet.fullview.authoritymanage.service.LoginService;
import org.springframework.stereotype.Service;

import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2020/1/7
 * Time: 23:24
 * Description: No Description
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public User getUserName() {
        User user = getMapByUser();
        return user;
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
        user.setPassWorld("123456");
        HashSet<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        return user;
    }
}
