package com.dgut.ssm.service;

import com.dgut.ssm.bean.Custom;
import com.dgut.ssm.bean.CustomSearchCondition;
import com.dgut.ssm.dao.CustomDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomService {
    @Autowired
    private CustomDao dao;
    public List<Custom> getAllCustom()
    {
        return dao.getAllCustom();
    }
    public Custom getCustomById(Integer id)
    {
        return dao.getCustomById(id);
    }
    public void updateCustom(Custom custom)
    {
        dao.updateCustom(custom);
    }

    public void AddCustom(Custom custom)
    {
        dao.InsertCustom(custom);
    }

    public List<Custom> searchCustomByCondition(CustomSearchCondition customSearchCondition) {
        return dao.searchCustomByCondition(customSearchCondition);
    }
}
