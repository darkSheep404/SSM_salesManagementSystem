package com.dgut.ssm.dao;

import com.dgut.ssm.bean.Custom;
import com.dgut.ssm.bean.CustomSearchCondition;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomDao {
    public List<Custom> getAllCustom();
    public void delCustom(Integer id);
    public Custom getCustomById(Integer id);
    //根据字段名写，不能通用
    public void InsertCustom(Custom custom);
    public void updateCustom(Custom custom);

    List<Custom> searchCustomByCondition(CustomSearchCondition customSearchCondition);
}
