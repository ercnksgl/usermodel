package com.ek.email.usermodel.storage;


public class UserModel {
    private String userToken;
    private String fullName;
    private String surName;

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getName() {
        return fullName;
    }

    public void setName(String fullName) {
        this.fullName = fullName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userToken='" + userToken + '\'' +
                ", fullName='" + fullName + '\'' +
                ", surName='" + surName + '\'' +
                '}';
    }
}
