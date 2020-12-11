package com.dgut.ssm.bean;

public class Goods {
    private Integer goodsId;
    private String name;
    private Double price;
    private Integer quantity;
    private boolean onSale;

    public Goods() {
    }

    public Goods(Integer goodsId, String name, Double price, Integer quantity, boolean onSale) {
        this.goodsId = goodsId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.onSale = onSale;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public boolean isOnSale() {
        return onSale;
    }
    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }
}
