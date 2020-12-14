package com.dgut.ssm.bean;

import java.sql.Date;

public class SaleLog {
    private Integer id;
    private Integer goodsId;
    private Date date;
    private Integer quantity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "SaleLog{" +
                "id=" + id +
                ", goodsId=" + goodsId +
                ", date=" + date +
                ", quantity=" + quantity +
                '}';
    }

    public SaleLog(Integer id, Integer goodsId, Date date, Integer quantity) {
        this.id = id;
        this.goodsId = goodsId;
        this.date = date;
        this.quantity = quantity;
    }

    public SaleLog() {
    }
}
