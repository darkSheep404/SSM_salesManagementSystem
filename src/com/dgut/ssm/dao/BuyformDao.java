package com.dgut.ssm.dao;

import com.dgut.ssm.bean.BuyLog;
import com.dgut.ssm.bean.SalesForm;
import com.dgut.ssm.bean.BuyForm;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BuyformDao {
    public void insertBuyForm(@Param("goodsId") Integer goodsId,@Param("quantity") Integer quantity);
    public void finishBuyForm(Integer id);
    public List<BuyForm> getAllRunningBuyForm();/*查出所有未进货的进货单*/
    public BuyForm getBuyFormById(Integer id);
    public void InsertLog(BuyLog log);
    public List<BuyLog> getAllLogs();
}
