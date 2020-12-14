package com.dgut.ssm.bean;

import java.util.List;

public class Contact {
    private int contactId;
    private Integer notdelivery;
    private Custom custom;
    private Salesman salesman;
    private List<SalesForm> salesForms;
    private boolean runStatus;//履行状态
    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public Integer getNotdelivery() {
        return notdelivery;
    }

    public void setNotdelivery(Integer notdelivery) {
        this.notdelivery = notdelivery;
    }

    public Custom getCustom() {
        return custom;
    }

    public void setCustom(Custom custom) {
        this.custom = custom;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }

    public List<SalesForm> getSalesForms() {
        return salesForms;
    }

    public void setSalesForms(List<SalesForm> salesForms) {
        this.salesForms = salesForms;
    }

    public boolean isRunStatus() {
        return runStatus;
    }

    public void setRunStatus(boolean runStatus) {
        this.runStatus = runStatus;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactId=" + contactId +
                ", notdelivery=" + notdelivery +
                ", custom=" + custom +
                ", salesman=" + salesman +
                ", salesForms=" + salesForms +
                ", runStatus=" + runStatus +
                '}';
    }
}
