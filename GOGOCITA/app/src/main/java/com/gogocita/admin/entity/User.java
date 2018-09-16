package com.gogocita.admin.entity;


import com.gogocita.admin.constant.EntityName;
import com.gogocita.admin.helper.QueryFirebase;
import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class User extends GenerateId {
    private String userID;
    private String userName;
    private String userPassword;
    private String userType;

    public User() {
    }

    public User(String userID, String userName, String userType) {
        this.userID = userID;
        this.userName = userName;
        this.userType = userType;
    }

    public User(String userID, String userType) {
        this.userID = userID;
        this.userType = userType;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Exclude
    public Map<String, Object> toMapUpdate() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("userName", userName);
        result.put("password", userPassword);
        result.put("userType", userType);

        return result;
    }
}
