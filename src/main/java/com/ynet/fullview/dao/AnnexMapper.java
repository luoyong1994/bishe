package com.ynet.fullview.dao;

import com.ynet.fullview.model.Annex;
import com.ynet.fullview.model.OrderInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnexMapper {
    public void addAnnex(OrderInfo orderInfo);
    public void updateAnnex(OrderInfo orderInfo);
    public void deleteAnnex(OrderInfo orderInfo);
    public List<Annex> queryAnnex(OrderInfo orderInfo);
}