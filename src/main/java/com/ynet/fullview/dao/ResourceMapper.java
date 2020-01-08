package com.ynet.fullview.dao;

import com.ynet.fullview.model.Resource;

public interface ResourceMapper {
    Resource selectByPrimaryKey(Integer id);
}