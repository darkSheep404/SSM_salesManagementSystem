package com.dgut.ssm.bean;

import java.sql.Date;

public class BuyForm {
    private Integer formId;
    private Integer goodsId;
    private Integer quantity;
    private boolean deliveryStatus;

    public BuyForm() {
    }

    @Override
    public String toString() {
        return "BuyForm{" +
                "formId=" + formId +
                ", goodsId=" + goodsId +
                ", quantity=" + quantity +
                ", deliveryStatus=" + deliveryStatus +
                '}';
    }

    public BuyForm(Integer formId, Integer goodsId, Integer quantity, boolean deliveryStatus) {
        this.formId = formId;
        this.goodsId = goodsId;
        this.quantity = quantity;
        this.deliveryStatus = deliveryStatus;
    }

    public Integer getFormId() {
        return formId;
    }

    public void setFormId(Integer formId) {
        this.formId = formId;
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

    public boolean isDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(boolean deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}
