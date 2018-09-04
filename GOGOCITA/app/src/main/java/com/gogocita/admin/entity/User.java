package com.gogocita.admin.entity;


public class User {
    private int UserID;
    private String UserName;
    private String Password;

    public User(int userID, String userName, String password, String userType) {
        UserID = userID;
        UserName = userName;
        Password = password;
        UserType = userType;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String userType) {
        UserType = userType;
    }

    private String UserType;

}
