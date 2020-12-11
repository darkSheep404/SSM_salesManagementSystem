package com.dgut.ssm.bean;

public class User {
    private String userName;
    private String userPw;
    private String userType;

    public User(String userName, String userPw, String userType) {
        this.userName = userName;
        this.userPw = userPw;
        this.userType = userType;
    }

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
