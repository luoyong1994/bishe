package com.ynet.fullview.service;

import com.ynet.fullview.dao.FullViewDao;
import com.ynet.fullview.model.Region;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/3/3
 * Time: 21:23
 * Description: No Description
 */
@Service
public class FullViewService {

    @Resource
    private FullViewDao fullViewDao;

    public void addFullView(Region region){
        fullViewDao.addFullView(region);
    }

    public void updateFullView(Region region){
        fullViewDao.updateFullView(region);
    }

    public List<Region> queryFullview(Region region){
        return fullViewDao.queryFullview(region);
    }
}
