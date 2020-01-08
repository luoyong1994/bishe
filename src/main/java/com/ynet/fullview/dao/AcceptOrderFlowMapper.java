package com.ynet.fullview.dao;

import com.ynet.fullview.model.AcceptOrderFlow;

public interface AcceptOrderFlowMapper {
    AcceptOrderFlow selectByPrimaryKey(String flowno);
}