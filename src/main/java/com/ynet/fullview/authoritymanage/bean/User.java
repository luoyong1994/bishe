package com.ynet.fullview.authoritymanage.bean;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2020/1/7
 * Time: 23:22
 * Description: No Description
 */

public class User {
    private String id;
    private String userName;
    private String passWorld;
    private Set<Role> roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWorld() {
        return passWorld;
    }

    public void setPassWorld(String passWorld) {
        this.passWorld = passWorld;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", passWorld='" + passWorld + '\'' +
                ", roles=" + roles +
                '}';
    }
}
