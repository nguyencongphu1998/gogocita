package com.gogocita.admin.entity;

import com.gogocita.admin.constant.EntityName;
import com.gogocita.admin.constant.EntityStatus;
import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class PartnerServicesConvenience extends GenerateId{
    private String pSCID;
    private String status;
    private String fk_PartnerServiceID;
    private String pSCType;
    private String pSCName;
    private String pSCDesc;

    public PartnerServicesConvenience() {
    }

    public PartnerServicesConvenience(String pSCID, String status, String fk_PartnerServiceID, String pSCType, String pSCName, String pSCDesc) {
        this.pSCID = pSCID;
        this.status = status;
        this.fk_PartnerServiceID = fk_PartnerServiceID;
        this.pSCType = pSCType;
        this.pSCName = pSCName;
        this.pSCDesc = pSCDesc;
    }

    public PartnerServicesConvenience(String fk_PartnerServiceID, String pSCType, String pSCName, String pSCDesc) {
        this.pSCID = generateId(EntityName.PartnerServiceConveniences);
        this.status = EntityStatus.Alive;
        this.fk_PartnerServiceID = fk_PartnerServiceID;
        this.pSCType = pSCType;
        this.pSCName = pSCName;
        this.pSCDesc = pSCDesc;
    }

    public String getpSCID() {
        return pSCID;
    }

    public void setpSCID(String pSCID) {
        this.pSCID = pSCID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFk_PartnerServiceID() {
        return fk_PartnerServiceID;
    }

    public void setFk_PartnerServiceID(String fk_PartnerServiceID) {
        this.fk_PartnerServiceID = fk_PartnerServiceID;
    }

    public String getpSCType() {
        return pSCType;
    }

    public void setpSCType(String pSCType) {
        this.pSCType = pSCType;
    }

    public String getpSCName() {
        return pSCName;
    }

    public void setpSCName(String pSCName) {
        this.pSCName = pSCName;
    }

    public String getpSCDesc() {
        return pSCDesc;
    }

    public void setpSCDesc(String pSCDesc) {
        this.pSCDesc = pSCDesc;
    }

    @Exclude
    public Map<String, Object> toMapUpdate() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", status);
        result.put("fK_PartnerServiceID", fk_PartnerServiceID);
        result.put("pSCType", pSCType);
        result.put("pSCName", pSCName);
        result.put("pSCDesc", pSCDesc);

        return result;
    }

    @Exclude
    public Map<String, Object> toMapDelete() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", EntityStatus.Delete);

        return result;
    }
}
