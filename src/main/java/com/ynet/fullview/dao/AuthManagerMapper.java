package com.ynet.fullview.dao;

import com.ynet.fullview.model.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2020/1/12
 * Time: 10:44
 * Description: 认证管理器
 */
@Repository
public interface AuthManagerMapper {

    public List<Map<String, String>> queryAuthorityInfo(SysUser sysUser);
}
