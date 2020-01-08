package com.ynet.fullview.dao;

import com.ynet.fullview.model.Classify;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassifyMapper {
    public void addClassify(Classify classify);
    public void updateClassify(Classify classify);
    public void deleteClassify(Classify classify);
    public List<Classify> queryClassify(Classify classify);
}