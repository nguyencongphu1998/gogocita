package com.gogocita.admin.entity;

import com.gogocita.admin.Constant.EntityStatus;
import com.gogocita.admin.helper.QueryFirebase;
import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class PartnerServicesConvenience {
    private String PSCID;
    private String Status;
    private String FK_PartnerServiceID;
    private String PSCType;
    private String PSCName;
    private String PSCDesc;

    public PartnerServicesConvenience(String status, String FK_PartnerServiceID, String PSCType, String PSCName, String PSCDesc) {
        this.PSCID = id();
        Status = status;
        this.FK_PartnerServiceID = FK_PartnerServiceID;
        this.PSCType = PSCType;
        this.PSCName = PSCName;
        this.PSCDesc = PSCDesc;
    }

    public PartnerServicesConvenience(String PSCID, String status, String FK_PartnerServiceID, String PSCType, String PSCName, String PSCDesc) {
        this.PSCID = PSCID;
        Status = status;
        this.FK_PartnerServiceID = FK_PartnerServiceID;
        this.PSCType = PSCType;
        this.PSCName = PSCName;
        this.PSCDesc = PSCDesc;
    }

    public String getPSCID() {
        return PSCID;
    }

    public void setPSCID(String PSCID) {
        this.PSCID = PSCID;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getFK_PartnerServiceID() {
        return FK_PartnerServiceID;
    }

    public void setFK_PartnerServiceID(String FK_PartnerServiceID) {
        this.FK_PartnerServiceID = FK_PartnerServiceID;
    }

    public String getPSCType() {
        return PSCType;
    }

    public void setPSCType(String PSCType) {
        this.PSCType = PSCType;
    }

    public String getPSCName() {
        return PSCName;
    }

    public void setPSCName(String PSCName) {
        this.PSCName = PSCName;
    }

    public String getPSCDesc() {
        return PSCDesc;
    }

    public void setPSCDesc(String PSCDesc) {
        this.PSCDesc = PSCDesc;
    }

    public String id() {
        QueryFirebase firebase = new QueryFirebase("PartnerServicesConveniences");
        return firebase.getNewKey();
    }

    @Override
    public String toString() {
        return "PartnerServicesConveniences";
    }

    @Exclude
    public Map<String, Object> toMapUpdate() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", Status);
        result.put("fK_PartnerServiceID", FK_PartnerServiceID);
        result.put("pSCType", PSCType);
        result.put("pSCName", PSCName);
        result.put("pSCDesc", PSCDesc);

        return result;
    }

    @Exclude
    public Map<String, Object> toMapDelete() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", EntityStatus.Delete);

        return result;
    }
}
