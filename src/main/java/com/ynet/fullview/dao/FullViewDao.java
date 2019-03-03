package com.ynet.fullview.dao;

import com.ynet.fullview.model.Region;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 2019/3/3
 * Time: 21:25
 * Description: No Description
 */
@Repository
public interface FullViewDao {
    public void addFullView(Region region);
    public void updateFullView(Region region);
    public List<Region> queryFullview(Region region);
}
