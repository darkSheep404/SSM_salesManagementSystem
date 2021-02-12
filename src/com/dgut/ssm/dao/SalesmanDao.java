package com.dgut.ssm.dao;

import com.dgut.ssm.bean.Salesman;

import java.util.List;

public interface Salesman {
    public List<Salesman> getAllSalesman();
    public void delSalesman(Integer id);
    public void getSalesmanById(Integer id);
    //根据字段名写，不能通用
    public void InsertSalesman(Salesman salesman);
    public void updateSalesman(Salesman salesman);
}
