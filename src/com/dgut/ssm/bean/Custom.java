package com.dgut.ssm.bean;

public class Custom {
    private Integer customId;
    private String customName;
    private String customPhone;
    private String customCompany;

    public Custom(Integer customId, String customName, String customPhone, String customCompany) {
        this.customId = customId;
        this.customName = customName;
        this.customPhone = customPhone;
        this.customCompany = customCompany;
    }

    public Custom() {
    }

    @Override
    public String toString() {
        return "Custom{" +
                "customId=" + customId +
                ", customName='" + customName + '\'' +
                ", customPhone='" + customPhone + '\'' +
                ", customCompany='" + customCompany + '\'' +
                '}';
    }

    public Integer getCustomId() {
        return customId;
    }

    public void setCustomId(Integer customId) {
        this.customId = customId;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public String getCustomPhone() {
        return customPhone;
    }

    public void setCustomPhone(String customPhone) {
        this.customPhone = customPhone;
    }

    public String getCustomCompany() {
        return customCompany;
    }

    public void setCustomCompany(String customCompany) {
        this.customCompany = customCompany;
    }
}
