package com.ynet.fullview.service.annexserviceImpl;

import com.ynet.fullview.dao.AnnexMapper;
import com.ynet.fullview.model.Annex;
import com.ynet.fullview.model.OrderInfo;
import com.ynet.fullview.service.annexservice.AnnexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnnexServiceImpl implements AnnexService {

    @Autowired
    private AnnexMapper annexMapper;


    @Override
    public void addAnnex(OrderInfo orderInfo) {
        annexMapper.addAnnex(orderInfo);
    }

    @Override
    public void updateAnnex(OrderInfo orderInfo) {
        annexMapper.updateAnnex(orderInfo);
    }

    @Override
    public void deleteAnnex(OrderInfo orderInfo) {
        annexMapper.deleteAnnex(orderInfo);
    }

    @Override
    public List<Annex> queryAnnex(OrderInfo orderInfo) {
        return annexMapper.queryAnnex(orderInfo);
    }
}
