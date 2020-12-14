package com.dgut.ssm.bean;

public class Salesman {
    private Integer salesmanId;
    private String salesmanName;
    private String salesmanPhone;

    public Salesman(Integer salesmanId, String salesmanName, String salesmanPhone) {
        this.salesmanId = salesmanId;
        this.salesmanName = salesmanName;
        this.salesmanPhone = salesmanPhone;
    }

    public Salesman() {
    }

    @Override
    public String toString() {
        return "Salesman{" +
                "salesmanId=" + salesmanId +
                ", salesmanName='" + salesmanName + '\'' +
                ", salesmanPhone='" + salesmanPhone + '\'' +
                '}';
    }

    public String getSalesmanPhone() {
        return salesmanPhone;
    }

    public void setSalesmanPhone(String salesmanPhone) {
        this.salesmanPhone = salesmanPhone;
    }

    public Integer getSalesmanId() {
        return salesmanId;
    }

    public void setSalesmanId(Integer salesmanId) {
        this.salesmanId = salesmanId;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }


}
