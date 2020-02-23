package com.ynet.fullview.service.userserviceImpl;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.ynet.fullview.dao.SysUserMapper;
import com.ynet.fullview.exception.ActionException;
import com.ynet.fullview.model.SysUser;
import com.ynet.fullview.service.userservice.UserService;
import com.ynet.fullview.util.IDUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.ranges.Range;

import javax.swing.plaf.synth.SynthSpinnerUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private HashedCredentialsMatcher hashedCredentialsMatcher;


    @Override
    public SysUser signIn(SysUser sysUser) {
        if (sysUser != null) {
            Subject currentUser = SecurityUtils.getSubject();
            SysUser sysUser1 = sysUserMapper.queryUserByUserName(sysUser);
            if (sysUser1 == null) {
                throw new ActionException("用户名密码错误！");
            }
            if (!currentUser.isAuthenticated()) {
                SimpleHash simpleHash = new SimpleHash(hashedCredentialsMatcher.getHashAlgorithmName(), sysUser.getPassword(), sysUser.getPassword(), hashedCredentialsMatcher.getHashIterations());
                log.info("用户加密后的密码为：{}", simpleHash.toString());
                UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(sysUser.getUsername(), simpleHash.toString());
                usernamePasswordToken.setRememberMe(true);
                try {
                    currentUser.login(usernamePasswordToken);
                    return sysUser1;
                } catch (IncorrectCredentialsException e) {
                    throw new ActionException("用户名密码错误！");
                } catch (ExcessiveAttemptsException e) {
                    throw new ActionException("登录次数过多！");
                } catch (UnauthorizedException e) {
                    throw new ActionException("您没有得到相应的授权！");
                }

            } else {
                return sysUser1;
            }
        } else {
            throw new ActionException("用户名密码错误！");
        }

    }

    @Override
    public void addUser(SysUser sysUser) {
        if (sysUser != null) {
            SysUser sysUser1 = sysUserMapper.queryUserByUserName(sysUser);
            if (sysUser1 != null) {
                throw new ActionException("用户名已存在！");
            }
            sysUser.setId(IDUtil.generaryId());
            //----加盐-----
            //产生盐
            int rand = (int) (Math.random() * 10000);
            while (rand < 1000) {
                rand *= 10;
            }
            String randString = rand + "L";
            ByteSource credentialSalt = ByteSource.Util.bytes(randString);
            SimpleHash simpleHash = new SimpleHash("MD5", sysUser.getPassword(), credentialSalt, 4);
            sysUser.setPassword(simpleHash.toString());
            sysUser.setRandom(randString);
            sysUserMapper.addUser(sysUser);
        } else {
            throw new ActionException("用户信息不能为空");
        }
    }

    @Override
    public List<SysUser> queryUsers(SysUser sysUser) {
        return sysUserMapper.queryUsers(sysUser);
    }


    @Override
    public void deleteUserById(SysUser sysUser) {
        sysUserMapper.deleteUserById(sysUser);
    }

    @Override
    public void updateUserById(SysUser sysUser) {
        sysUserMapper.updateUserById(sysUser);
    }
}
