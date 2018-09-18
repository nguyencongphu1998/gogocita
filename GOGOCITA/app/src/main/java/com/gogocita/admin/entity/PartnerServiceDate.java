package com.gogocita.admin.entity;

import com.gogocita.admin.Constant.EntityStatus;
import com.gogocita.admin.Constant.EntityName;
import com.gogocita.admin.helper.QueryFirebase;
import com.google.firebase.database.Exclude;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PartnerServiceDate extends GenerateId{
    private String partnerServiceDateID;
    private String fk_PartnerServiceID;
    private String status;
    private Date partnerServiceDateFrom;
    private Date partnerServiceDateTo;
    private String partnerServiceDateStatus;

    public PartnerServiceDate() {
    }

    public PartnerServiceDate(String partnerServiceDateID, String fk_PartnerServiceID, String status, Date partnerServiceDateFrom, Date partnerServiceDateTo, String partnerServiceDateStatus) {
        this.partnerServiceDateID = partnerServiceDateID;
        this.fk_PartnerServiceID = fk_PartnerServiceID;
        this.status = status;
        this.partnerServiceDateFrom = partnerServiceDateFrom;
        this.partnerServiceDateTo = partnerServiceDateTo;
        this.partnerServiceDateStatus = partnerServiceDateStatus;
    }

    public PartnerServiceDate(String fk_PartnerServiceID, Date partnerServiceDateFrom, Date partnerServiceDateTo, String partnerServiceDateStatus) {
        this.partnerServiceDateID = generateId(EntityName.PartnerServiceDates);
        this.fk_PartnerServiceID = fk_PartnerServiceID;
        this.status = EntityStatus.Alive;
        this.partnerServiceDateFrom = partnerServiceDateFrom;
        this.partnerServiceDateTo = partnerServiceDateTo;
        this.partnerServiceDateStatus = partnerServiceDateStatus;
    }

    public String getPartnerServiceDateID() {
        return partnerServiceDateID;
    }

    public void setPartnerServiceDateID(String partnerServiceDateID) {
        this.partnerServiceDateID = partnerServiceDateID;
    }

    public String getFk_PartnerServiceID() {
        return fk_PartnerServiceID;
    }

    public void setFk_PartnerServiceID(String fk_PartnerServiceID) {
        this.fk_PartnerServiceID = fk_PartnerServiceID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getPartnerServiceDateFrom() {
        return partnerServiceDateFrom;
    }

    public void setPartnerServiceDateFrom(Date partnerServiceDateFrom) {
        this.partnerServiceDateFrom = partnerServiceDateFrom;
    }

    public Date getPartnerServiceDateTo() {
        return partnerServiceDateTo;
    }

    public void setPartnerServiceDateTo(Date partnerServiceDateTo) {
        this.partnerServiceDateTo = partnerServiceDateTo;
    }

    public String getPartnerServiceDateStatus() {
        return partnerServiceDateStatus;
    }

    public void setPartnerServiceDateStatus(String partnerServiceDateStatus) {
        this.partnerServiceDateStatus = partnerServiceDateStatus;
    }

    @Exclude
    public Map<String, Object> toMapUpdate() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("fK_PartnerServiceID", fk_PartnerServiceID);
        result.put("status", status);
        result.put("partnerServiceDateFrom", partnerServiceDateFrom);
        result.put("partnerServiceDateTo", partnerServiceDateTo);
        result.put("partnerServiceDateStatus", partnerServiceDateStatus);

        return result;
    }

    @Exclude
    public Map<String, Object> toMapDelete() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", EntityStatus.Delete);

        return result;
    }
}
