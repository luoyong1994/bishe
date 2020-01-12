package com.ynet.fullview.authoritymanage.bean;

import lombok.Data;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2020/1/7
 * Time: 23:22
 * Description: No Description
 */
@Data
public class Role {

    private String id;
    private String roleName;
    private Set<Permissions> permissions;
}
