package com.ynet.fullview.authoritymanage.bean;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2020/1/7
 * Time: 23:22
 * Description: No Description
 */
public class Role {

    private String id;
    private String roleName;
    private Set<Permissions> permissions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<Permissions> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permissions> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", roleName='" + roleName + '\'' +
                ", permissions=" + permissions +
                '}';
    }
}
