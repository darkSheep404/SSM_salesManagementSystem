package com.dgut.ssm.bean;

public class SalesForm {
    private Integer contactId;
    private Integer formId;
    private Integer goodsId;
    private Integer quantity;
    private boolean generateStatus;//是否生成，由采购单变为发货单
    private boolean deliveryStatus;//是否已发货

    @Override
    public String toString() {
        return "SalesForm{" +
                "contactId=" + contactId +
                ", formId=" + formId +
                ", goodsId=" + goodsId +
                ", quantity=" + quantity +
                ", generateStatus=" + generateStatus +
                ", deliveryStatus=" + deliveryStatus +
                '}';
    }
    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
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

    public boolean isGenerateStatus() {
        return generateStatus;
    }

    public void setGenerateStatus(boolean generateStatus) {
        this.generateStatus = generateStatus;
    }

    public boolean isDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(boolean deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}
