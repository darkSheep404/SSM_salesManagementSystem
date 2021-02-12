package com.dgut.ssm.bean;

import java.sql.Date;

public class BuyLog {
    private Integer id;
    private Date date;
    private Integer goodsId;
    private Integer quantity;

    public BuyLog() {
    }

    public BuyLog(Integer id, Date date, Integer goodsId, Integer quantity) {
        this.id = id;
        this.date = date;
        this.goodsId = goodsId;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
