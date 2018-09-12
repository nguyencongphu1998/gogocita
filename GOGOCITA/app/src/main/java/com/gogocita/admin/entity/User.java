package com.gogocita.admin.entity;


import com.gogocita.admin.constant.EntityName;
import com.gogocita.admin.helper.QueryFirebase;
import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class User {
    private String userID;
    private String userName;
    private String userPassword;
    private String userType;

    public User() {
    }

    public User(String userID, String userName, String userPassword, String userType) {
        this.userID = userID;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userType = userType;
    }

    public User(String userName, String userPassword, String userType) {
        this.userID = generateId();
        this.userName = userName;
        this.userPassword = userPassword;
        this.userType = userType;
    }

    public String generateId() {
        QueryFirebase firebase = new QueryFirebase(EntityName.Users);
        return firebase.getNewKey();
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
