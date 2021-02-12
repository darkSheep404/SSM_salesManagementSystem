package com.dgut.ssm.service;

import com.dgut.ssm.bean.Contact;
import com.dgut.ssm.bean.CustomGroup;
import com.dgut.ssm.bean.Goods;
import com.dgut.ssm.bean.SalesmanGroup;
import com.dgut.ssm.dao.GroupByDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupByService {
    @Autowired
    private GroupByDao dao;
    public List<Goods> groupByGoods()
    {
        return dao.groupByGoods();
    }

    public List<CustomGroup> groupByCustom() {
        return dao.groupByCustom();
    }
    public List<SalesmanGroup> groupBySalesman() {
        return dao.groupBySalesman();
    }
   /* public List<Contact> groupByCustom();
    public List<Contact> groupBySalesman();*/
}
