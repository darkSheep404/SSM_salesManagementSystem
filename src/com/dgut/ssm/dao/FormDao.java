package com.dgut.ssm.dao;

import com.dgut.ssm.bean.SaleLog;
import com.dgut.ssm.bean.SalesForm;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormDao {
    public void runForm(Integer id);//生成发货单
    public void finishForm(Integer id);//完成发货
    public Integer getQuantityById(Integer id);//获取本单商品数量
    public Integer getGoodsIdById(Integer id);//获取本单商品id
    public Integer getContactidById(Integer id);
    public List<SalesForm> getAllRunningForm();//获取所有生成发货单但是并未发货的表单
    public SalesForm getFormById(Integer id);
    public void InsertLog(SaleLog log);
    public List<SaleLog> getAllLog();
    public List<SalesForm> getFormListByContactId(Integer id);
    public void insertForm(Integer contactId,Integer goodsId,Integer quantity);
    List<SalesForm> getAllFormBeforeRun();/*返回所有未生成发货单的*/
}
