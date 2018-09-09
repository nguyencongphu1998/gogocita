package com.gogocita.admin.entity;


import com.gogocita.admin.helper.QueryFirebase;
import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class User {
    private String UserID;
    private String UserName;
    private String Password;
    private String UserType;

    public User(String userName, String password, String userType) {
        UserID = id();
        UserName = userName;
        Password = password;
        UserType = userType;
    }

    public User(String userID, String userName, String password, String userType) {
        UserID = userID;
        UserName = userName;
        Password = password;
        UserType = userType;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
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

    public String id() {
        QueryFirebase firebase = new QueryFirebase("Users");
        return firebase.getNewKey();
    }

    @Override
    public String toString() {
        return "Users";
    }

    @Exclude
    public Map<String, Object> toMapUpdate() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("userName", UserName);
        result.put("password", Password);
        result.put("userType", UserType);

        return result;
    }
}
