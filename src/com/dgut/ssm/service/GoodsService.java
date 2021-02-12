package com.dgut.ssm.service;

import com.dgut.ssm.bean.Goods;
import com.dgut.ssm.bean.GoodsSearchCondition;
import com.dgut.ssm.dao.GoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {
    @Autowired
    private GoodsDao dao;
    public List<Goods>getAllGoods()
    {
        System.out.println(dao.getAllGods());
        return dao.getAllGods();
    }
    public Goods getGoodsById(Integer id)
    {
        return dao.getGoodsById(id);
    }
    public void updateGoods(Goods goods)
    {
        dao.update(goods);
    }
    public int delGoodsByid(Integer id)
    {
        int affected= dao.DelGoodsById(id);
        return affected;

    }
    public void AddGoods(Goods goods)
    {
        dao.AddGoods(goods);
    }
    public void disable(Integer id)
    {
        dao.disable(id);
    }
    public List<Goods> searchGoodsByCondition(GoodsSearchCondition goodsSearchCondition)
    {
        return dao.searchGoodsByCondition(goodsSearchCondition);
    }
}
