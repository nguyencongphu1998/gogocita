package com.gogocita.admin.entity;

import com.gogocita.admin.constant.EntityStatus;
import com.gogocita.admin.constant.EntityName;
import com.gogocita.admin.constant.PartnerServiceDateStatus;
import com.google.firebase.database.Exclude;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PartnerServiceBook extends GenerateId{
    private String partnerServiceBookID;
    private String fK_PartnerServiceID;
    private String fK_PartnerID;
    private String fk_CustomerID;
    private String status;
    private Date partnerServiceBookFrom;
    private Date partnerServiceBookTo;
    private String partnerServiceBookStatus;
    private PartnerService partnerService;

    public PartnerServiceBook() {
    }

    public PartnerServiceBook(String partnerServiceDateID,String fk_PartnerID, String fk_PartnerServiceID, String fk_CustomerID, String status, Date partnerServiceDateFrom, Date partnerServiceDateTo, String partnerServiceDateStatus) {
        this.partnerServiceBookID = partnerServiceDateID;
        this.fK_PartnerID = fk_PartnerID;
        this.fK_PartnerServiceID = fk_PartnerServiceID;
        this.status = status;
        this.partnerServiceBookFrom = partnerServiceDateFrom;
        this.partnerServiceBookTo = partnerServiceDateTo;
        this.partnerServiceBookStatus = partnerServiceDateStatus;
        this.fk_CustomerID = fk_CustomerID;
    }

    public PartnerServiceBook(String fk_PartnerServiceID, String fk_PartnerID, String fk_CustomerID, Date partnerServiceDateFrom, Date partnerServiceDateTo) {
        this.partnerServiceBookID = generateId(EntityName.PartnerServiceBooks);
        this.fK_PartnerServiceID = fk_PartnerServiceID;
        this.fK_PartnerID = fk_PartnerID;
        this.status = EntityStatus.Alive;
        this.partnerServiceBookFrom = partnerServiceDateFrom;
        this.partnerServiceBookTo = partnerServiceDateTo;
        this.partnerServiceBookStatus = PartnerServiceDateStatus.Pending;
        this.fk_CustomerID = fk_CustomerID;
    }

    public String getfK_PartnerServiceID() {
        return fK_PartnerServiceID;
    }

    public void setfK_PartnerServiceID(String fK_PartnerServiceID) {
        this.fK_PartnerServiceID = fK_PartnerServiceID;
    }

    public String getfK_PartnerID() {
        return fK_PartnerID;
    }

    public void setfK_PartnerID(String fK_PartnerID) {
        this.fK_PartnerID = fK_PartnerID;
    }

    public PartnerService getPartnerService() {
        return partnerService;
    }

    public void setPartnerService(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    public String getFk_CustomerID() {
        return fk_CustomerID;
    }

    public void setFk_CustomerID(String fk_CustomerID) {
        this.fk_CustomerID = fk_CustomerID;
    }

    public String getPartnerServiceBookID() {
        return partnerServiceBookID;
    }

    public void setPartnerServiceBookID(String partnerServiceDateID) {
        this.partnerServiceBookID = partnerServiceDateID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getPartnerServiceBookFrom() {
        return partnerServiceBookFrom;
    }

    public void setPartnerServiceBookFrom(Date partnerServiceBookFrom) {
        this.partnerServiceBookFrom = partnerServiceBookFrom;
    }

    public Date getPartnerServiceBookTo() {
        return partnerServiceBookTo;
    }

    public void setPartnerServiceBookTo(Date partnerServiceDateTo) {
        this.partnerServiceBookTo = partnerServiceDateTo;
    }

    public String getPartnerServiceBookStatus() {
        return partnerServiceBookStatus;
    }

    public void setPartnerServiceBookStatus(String partnerServiceDateStatus) {
        this.partnerServiceBookStatus = partnerServiceDateStatus;
    }

    @Exclude
    public Map<String, Object> toMapUpdate() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("fK_PartnerServiceID", fK_PartnerServiceID);
        result.put("fK_PartnerID", fK_PartnerID);
        result.put("fk_CustomerID", fk_CustomerID);
        result.put("status", status);
        result.put("partnerServiceBookFrom", partnerServiceBookFrom);
        result.put("partnerServiceBookTo", partnerServiceBookTo);
        result.put("partnerServiceBookStatus", partnerServiceBookStatus);

        return result;
    }

    @Exclude
    public Map<String, Object> toMapDelete() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", EntityStatus.Delete);

        return result;
    }
}
