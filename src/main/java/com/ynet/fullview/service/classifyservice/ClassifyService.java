package com.ynet.fullview.service.classifyservice;

import com.ynet.fullview.model.Annex;
import com.ynet.fullview.model.Classify;

import java.util.List;

public interface ClassifyService {
    public Classify addClassify(Classify classify);
    public void updateClassify(Classify classify);
    public void deleteClassify(Classify classify);
    public List<Classify> queryClassify(Classify classify);
}
