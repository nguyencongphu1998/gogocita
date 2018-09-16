package com.gogocita.admin.entity;

import com.gogocita.admin.helper.QueryFirebase;

public class GenerateId {

    protected String generateId(String entityName)
    {
        QueryFirebase firebase = QueryFirebase.getInstance(entityName);
        return firebase.getNewKey();
    }
}
