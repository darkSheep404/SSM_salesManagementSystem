package com.dgut.ssm.service;

import com.dgut.ssm.bean.Salesman;
import com.dgut.ssm.bean.SalesmanSearchCondition;
import com.dgut.ssm.dao.SalesmanDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesmanService {
    @Autowired
    private SalesmanDao dao;
    public List<Salesman>getAllSalesman()
    {
        return dao.getAllSalesman();
    }
    public Salesman getSalesmanById(Integer id)
    {
        return dao.getSalesmanById(id);
    }
    public void updateSalesman(Salesman salesman)
    {
        dao.updateSalesman(salesman);
    }

    public void AddSalesman(Salesman salesman)
    {
        dao.InsertSalesman(salesman);
    }

    public List<Salesman> searchSalesmanByCondition(SalesmanSearchCondition salesmanSearchCondition) {
        return dao.searchSalesmanByCondition(salesmanSearchCondition);
    }
}
