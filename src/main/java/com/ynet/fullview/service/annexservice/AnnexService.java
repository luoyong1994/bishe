package com.ynet.fullview.service.annexservice;

import com.ynet.fullview.model.Annex;
import com.ynet.fullview.model.OrderInfo;

import java.util.List;

public interface AnnexService {
    public void addAnnex(OrderInfo orderInfo);
    public void updateAnnex(OrderInfo orderInfo);
    public void deleteAnnex(OrderInfo orderInfo);
    public List<Annex> queryAnnex(OrderInfo orderInfo);
}
