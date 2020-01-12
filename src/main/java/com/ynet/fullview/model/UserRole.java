package com.ynet.fullview.model;

import lombok.Data;

import java.util.Set;

@Data
public class UserRole {

    private String id;

    private Integer userid;

    private String roleId;

    private String roleName;

    private String roleDesc;

    private Set<Resource> resources;
}