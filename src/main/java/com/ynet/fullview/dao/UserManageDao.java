package com.ynet.fullview.dao;

import com.ynet.fullview.model.Sysuser;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/3/3
 * Time: 20:45
 * Description: No Description
 */
@Repository
public interface UserManageDao {
    public void addUser(Sysuser sysuser);
    public void deletUser(Sysuser sysuser);
}
