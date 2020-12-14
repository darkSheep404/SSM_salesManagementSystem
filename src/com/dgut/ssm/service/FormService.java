package com.dgut.ssm.service;

import com.dgut.ssm.bean.SaleLog;
import com.dgut.ssm.bean.SalesForm;
import com.dgut.ssm.dao.ContactDao;
import com.dgut.ssm.dao.FormDao;
import com.dgut.ssm.dao.GoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class FormService {
    @Autowired
    private FormDao formDao;
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private ContactDao contactDao;
    public boolean checkIfEnough(Integer id){
        int goodsId=formDao.getGoodsIdById(id);
        if(formDao.getQuantityById(id)<goodsDao.getQuantityById(goodsId))
            return true;
        else
            return false;
    }
    public SalesForm getSalesFormById(Integer id)
    {
        return formDao.getFormById(id);
    }
    /**
     * 生成发货单
     * 减少商品库存，设置发货状态为true，减少合同未发货数量？？？这个应该移到仓库管理员的发货了
     *
     *
     */
    public Boolean generateForm(@PathVariable("id") Integer id){
        //成功减少数量后，设置发货状态为true,减少合同未发货数量;
        goodsDao.reduceQuantityById(id,formDao.getQuantityById(id));
        formDao.finishForm(id);
        return true;
    }

    /**
     *
     * @param id
     * @return
     * 发货完成，设置表单状态已发货，减去合同未发货货物数量；
     */
    public Boolean finishForm(@PathVariable("id") Integer id)
    {
        contactDao.reduceUnfinishedNum(formDao.getContactidById(id));
        formDao.finishForm(id);
        return  true;
    }

    /**
     * 获取所有未发货的发货单
     * @return
     */
    public List<SalesForm> getAllRunningForm()
    {
        return formDao.getAllRunningForm();
    }

    public void InsertLog(SaleLog log){
        formDao.InsertLog(log);
    }
    public List<SaleLog> getLogs(){
         return formDao.getAllLog();
    }
}
