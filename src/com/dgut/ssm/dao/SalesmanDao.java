package com.dgut.ssm.dao;

import com.dgut.ssm.bean.Salesman;
import com.dgut.ssm.bean.SalesmanSearchCondition;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SalesmanDao {
    public List<Salesman> getAllSalesman();
    public void delSalesman(Integer id);
    public Salesman getSalesmanById(Integer id);
    //根据字段名写，不能通用
    public void InsertSalesman(Salesman salesman);
    public void updateSalesman(Salesman salesman);
    List<Salesman> searchSalesmanByCondition(SalesmanSearchCondition salesmanSearchCondition);
}
