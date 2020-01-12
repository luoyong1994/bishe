package com.ynet.fullview.model;

import lombok.Data;

@Data
public class Resource {
    private String id;

    private String name;

    private String router;

    private String type;

    private Integer parentid;

    private Integer sort;
}