package com.ynet.fullview.model;

import lombok.Data;

import java.util.Set;

@Data
public class SysUser {
    private String id;

    private String username;

    private String name;

    private String password;

    private String qq;

    private String tel;

    private String random;

    private Set<UserRole> roles;
}