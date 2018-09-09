package com.gogocita.admin.entity;

import com.gogocita.admin.Constant.EntityStatus;
import com.gogocita.admin.helper.QueryFirebase;
import com.google.firebase.database.Exclude;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PartnerServiceDate {
    private String PartnerServiceDateID;
    private String FK_PartnerServiceID;
    private String Status;
    private Date PartnerServiceDateFrom;
    private Date PartnerServiceDateTo;
    private String PartnerServiceDateStatus;

    public PartnerServiceDate(String FK_PartnerServiceID, String status, Date partnerServiceDateFrom, Date partnerServiceDateTo, String partnerServiceDateStatus) {
        PartnerServiceDateID = id();
        this.FK_PartnerServiceID = FK_PartnerServiceID;
        Status = status;
        PartnerServiceDateFrom = partnerServiceDateFrom;
        PartnerServiceDateTo = partnerServiceDateTo;
        PartnerServiceDateStatus = partnerServiceDateStatus;
    }

    public PartnerServiceDate(String partnerServiceDateID, String FK_PartnerServiceID, String status, Date partnerServiceDateFrom, Date partnerServiceDateTo, String partnerServiceDateStatus) {
        PartnerServiceDateID = partnerServiceDateID;
        this.FK_PartnerServiceID = FK_PartnerServiceID;
        Status = status;
        PartnerServiceDateFrom = partnerServiceDateFrom;
        PartnerServiceDateTo = partnerServiceDateTo;
        PartnerServiceDateStatus = partnerServiceDateStatus;
    }

    public String getPartnerServiceDateID() {
        return PartnerServiceDateID;
    }

    public void setPartnerServiceDateID(String partnerServiceDateID) {
        PartnerServiceDateID = partnerServiceDateID;
    }

    public String getFK_PartnerServiceID() {
        return FK_PartnerServiceID;
    }

    public void setFK_PartnerServiceID(String FK_PartnerServiceID) {
        this.FK_PartnerServiceID = FK_PartnerServiceID;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Date getPartnerServiceDateFrom() {
        return PartnerServiceDateFrom;
    }

    public void setPartnerServiceDateFrom(Date partnerServiceDateFrom) {
        PartnerServiceDateFrom = partnerServiceDateFrom;
    }

    public Date getPartnerServiceDateTo() {
        return PartnerServiceDateTo;
    }

    public void setPartnerServiceDateTo(Date partnerServiceDateTo) {
        PartnerServiceDateTo = partnerServiceDateTo;
    }

    public String getPartnerServiceDateStatus() {
        return PartnerServiceDateStatus;
    }

    public void setPartnerServiceDateStatus(String partnerServiceDateStatus) {
        PartnerServiceDateStatus = partnerServiceDateStatus;
    }

    public String id() {
        QueryFirebase firebase = new QueryFirebase("PartnerServiceDates");
        return firebase.getNewKey();
    }

    @Override
    public String toString() {
        return "PartnerServiceDates";
    }

    @Exclude
    public Map<String, Object> toMapUpdate() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("fK_PartnerServiceID", FK_PartnerServiceID);
        result.put("status", Status);
        result.put("partnerServiceDateFrom", PartnerServiceDateFrom);
        result.put("partnerServiceDateTo", PartnerServiceDateTo);
        result.put("partnerServiceDateStatus", PartnerServiceDateStatus);

        return result;
    }

    @Exclude
    public Map<String, Object> toMapDelete() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", EntityStatus.Delete);

        return result;
    }
}
