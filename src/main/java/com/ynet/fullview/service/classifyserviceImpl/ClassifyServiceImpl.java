package com.ynet.fullview.service.classifyserviceImpl;

import com.ynet.fullview.dao.ClassifyMapper;
import com.ynet.fullview.exception.ActionException;
import com.ynet.fullview.model.Classify;
import com.ynet.fullview.service.classifyservice.ClassifyService;
import com.ynet.fullview.util.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassifyServiceImpl implements ClassifyService {

    @Autowired
    private ClassifyMapper classifyMapper;

    @Override
    public Classify addClassify(Classify classify) {
        classify.setId(IDUtil.generaryId());
        classifyMapper.addClassify(classify);
        return classify;
    }

    @Override
    public void updateClassify(Classify classify) {
        if(classify.getId()==null){
            throw new ActionException("分类id能为空");
        }
        classifyMapper.updateClassify(classify);
    }

    @Override
    public void deleteClassify(Classify classify) {
        if(classify.getId()==null){
            throw new ActionException("分类id能为空");
        }
        classifyMapper.deleteClassify(classify);
    }

    @Override
    public List<Classify> queryClassify(Classify classify) {
        return classifyMapper.queryClassify(classify);
    }
}
