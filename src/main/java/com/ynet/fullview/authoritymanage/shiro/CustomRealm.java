package com.ynet.fullview.authoritymanage.shiro;

import com.ynet.fullview.authoritymanage.service.LoginService;
import com.ynet.fullview.dao.AuthManagerMapper;
import com.ynet.fullview.dao.SysUserMapper;
import com.ynet.fullview.exception.ActionException;
import com.ynet.fullview.model.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2020/1/7
 * Time: 23:25
 * Description: No Description
 */
@Slf4j
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private LoginService loginService;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private AuthManagerMapper authManagerMapper;




    /**
     * 创建数据库信息认证器
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //获取登录用户名
        String userName = (String) principals.getPrimaryPrincipal();
        //根据用户名去数据库查询用户信息
        SysUser sysUser = new SysUser();
        sysUser.setUsername(userName);
        List<Map<String, String>> authorizInfo = authManagerMapper.queryAuthorityInfo(sysUser);
        Map<String, List<String>> componentAuthorizDataMap = componentAuthorizData(authorizInfo);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for (Map.Entry<String, List<String>> entry : componentAuthorizDataMap.entrySet()) {
            //添加角色
            simpleAuthorizationInfo.addRole(entry.getKey());
            List<String> authorList = entry.getValue();
            for (int i = 0; i < authorList.size(); i++) {
                //添加权限
                simpleAuthorizationInfo.addStringPermission(authorList.get(i));
            }
        }
        return simpleAuthorizationInfo;
    }


    /**
     * 组装权限数据
     *
     * @return
     */
    private Map<String, List<String>> componentAuthorizData(List<Map<String, String>> authorizerList) {
        Map<String, List<String>> map = new HashMap<>();
        int len = authorizerList.size();
        for (int i = 0; i < len; i++) {
            Map<String, String> info = authorizerList.get(i);
            String roleName = info.get("roleName");
            if (map.get(roleName) != null) {
                List<String> infoList = map.get(roleName);
                infoList.add(info.get("resourceRouter"));
            } else {
                List<String> list = new ArrayList<>();
                list.add(info.get("resourceRouter"));
                map.put(roleName, list);
            }
        }
        return map;
    }


    /**
     * 创建登录信息认证器
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if (token.getPrincipal() == null) {
            return null;
        }
        //获取用户信息
        String userName = token.getPrincipal().toString();
        SysUser sysUser = new SysUser();
        sysUser.setUsername(userName);
        SysUser sysUser1 = sysUserMapper.queryUserByUserName(sysUser);
        if (sysUser1 == null) {
            throw new ActionException("用户名密码错误");
        } else {
            //创建认证器，供shiro认证使用
            //盐
            String rand = sysUser1.getRandom();
            ByteSource bytes = ByteSource.Util.bytes(rand);
            String realmName = this.getName();
            log.info("服务器保存密码为：{}",sysUser1.getPassword());
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userName, sysUser1.getPassword(), bytes,getName());
            return simpleAuthenticationInfo;
        }
    }
}
