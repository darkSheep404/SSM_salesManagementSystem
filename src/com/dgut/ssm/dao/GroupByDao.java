package com.dgut.ssm.dao;

import com.dgut.ssm.bean.Contact;
import com.dgut.ssm.bean.CustomGroup;
import com.dgut.ssm.bean.Goods;
import com.dgut.ssm.bean.SalesmanGroup;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GroupByDao {
    public List<Goods> groupByGoods();
    public List<CustomGroup> groupByCustom();
    public List<SalesmanGroup> groupBySalesman();
}
