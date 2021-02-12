package com.dgut.ssm.service;

import com.dgut.ssm.bean.*;
import com.dgut.ssm.dao.*;
import com.dgut.ssm.exception.GoodsQuantityNotEnoughException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FormService {
    @Autowired
    private FormDao formDao;
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private ContactDao contactDao;
    @Autowired
    private BuyformDao buyformDao;
    public Integer getGoodsId(Integer id)
    {
        return formDao.getGoodsIdById(id);
    }
    public int checkIfEnough(Integer id){
        int goodsId=formDao.getGoodsIdById(id);
        int res=goodsDao.getQuantityById(goodsId)-formDao.getQuantityById(id);
        return res;
    }
    public SalesForm getSalesFormById(Integer id)
    {
        return formDao.getFormById(id);
    }
    public BuyForm getBuyFormById(Integer id)
    {
        return buyformDao.getBuyFormById(id);
    }
    /**
     * 生成发货单
     * 减少商品库存，设置发货状态为true，减少合同未发货数量
     */
    @Transactional
    public Boolean generateForm(Integer id){
        //成功减少数量后，设置发货状态为true,减少合同未发货数量;
        goodsDao.reduceQuantityById(formDao.getGoodsIdById(id),formDao.getQuantityById(id));
        Integer res= goodsDao.getQuantityById(formDao.getGoodsIdById(id));
        if(res<0)
            throw new GoodsQuantityNotEnoughException("数量不足");
        formDao.runForm(id);
        return true;
    }

    /** 完成发货单*/
    public Boolean finishForm(Integer id)
    {
        contactDao.reduceUnfinishedNum(formDao.getContactidById(id));
        formDao.finishForm(id);
        return  true;
    }
    /*仓库管理员完成进货单,更改发货单状态，更改商品库存数值*/
    public Boolean finshBuyForm(Integer id){
        buyformDao.finishBuyForm(id);
        BuyForm buyForm= buyformDao.getBuyFormById(id);
        goodsDao.addQuantityById(buyForm.getGoodsId(),buyForm.getQuantity());
        return true;
    }

    /**
     * 获取所有未发货的发货单
     * @return
     */
    public List<SalesForm> getAllRunningForm()
    {
        return formDao.getAllRunningForm();
    }
    public List<BuyForm> getAllRunningBuyForm()
    {
        return buyformDao.getAllRunningBuyForm();
    }
    public void InsertLog(SaleLog log){
        formDao.InsertLog(log);
    }
    public void  InsertBuyLog(BuyLog log)
    {
        buyformDao.InsertLog(log);
    }
    public List<SaleLog> getLogs(){
         return formDao.getAllLog();
    }
    public List<BuyLog> getBuyLogs(){
       return buyformDao.getAllLogs();
    }
    public List<Goods>getAllGoods(){
        return goodsDao.getAllGods();
    }

    public List<SalesForm> getAllFormBeforeRun() {
        return formDao.getAllFormBeforeRun();
    }
}
