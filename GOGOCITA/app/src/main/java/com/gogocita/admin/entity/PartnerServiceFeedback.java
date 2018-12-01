package com.gogocita.admin.entity;

import com.gogocita.admin.constant.EntityName;
import com.gogocita.admin.constant.EntityStatus;
import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PartnerServiceFeedback extends GenerateId implements Serializable {
    private String pSFID;
    private String status;
    private String fk_PartnerServiceID;
    private String fk_CustomerID;
    private String fk_PartnerServiceBookID;
    private String fk_PartnerID;
    private int pSFEvalution;
    private String pSFContent;
    private boolean pSFIsSend;
    private Date pSFEFrom;
    private Date pSFETo;

    public PartnerServiceFeedback() {
    }

    public PartnerServiceFeedback(String pSFID, String status, String fk_PartnerServiceID, String fk_CustomerID, int pSFEvalution, String pSFContent, boolean isSend, String fk_PartnerServiceBookID) {
        this.pSFID = pSFID;
        this.status = status;
        this.fk_PartnerServiceID = fk_PartnerServiceID;
        this.fk_CustomerID = fk_CustomerID;
        this.pSFEvalution = pSFEvalution;
        this.pSFContent = pSFContent;
        this.pSFIsSend = isSend;
        this.fk_PartnerServiceBookID = fk_PartnerServiceBookID;
    }

    public PartnerServiceFeedback(String fk_PartnerServiceID, String fk_CustomerID, String fk_PartnerServiceBookID, int pSFEvalution, String pSFContent, boolean isSend, Date pSFEFrom, Date pSFETo, String fk_PartnerID) {
        this.pSFID = generateId(EntityName.PartnerServiceFeedbacks);
        this.status = EntityStatus.Alive;
        this.fk_PartnerServiceID = fk_PartnerServiceID;
        this.fk_CustomerID = fk_CustomerID;
        this.pSFEvalution = pSFEvalution;
        this.pSFContent = pSFContent;
        this.pSFIsSend = isSend;
        this.fk_PartnerServiceBookID = fk_PartnerServiceBookID;
        this.pSFEFrom = pSFEFrom;
        this.pSFETo = pSFETo;
        this.fk_PartnerID = fk_PartnerID;
    }

    public String getFk_PartnerID() {
        return fk_PartnerID;
    }

    public void setFk_PartnerID(String fk_PartnerID) {
        this.fk_PartnerID = fk_PartnerID;
    }

    public Date getpSFEFrom() {
        return pSFEFrom;
    }

    public void setpSFEFrom(Date pSFEFrom) {
        this.pSFEFrom = pSFEFrom;
    }

    public Date getpSFETo() {
        return pSFETo;
    }

    public void setpSFETo(Date pSFETo) {
        this.pSFETo = pSFETo;
    }

    public String getFk_PartnerServiceBookID() {
        return fk_PartnerServiceBookID;
    }

    public void setFk_PartnerServiceBookID(String fk_PartnerServiceBookID) {
        this.fk_PartnerServiceBookID = fk_PartnerServiceBookID;
    }

    public boolean ispSFIsSend() {
        return pSFIsSend;
    }

    public void setpSFIsSend(boolean pSFIsSend) {
        this.pSFIsSend = pSFIsSend;
    }

    public String getpSFID() {
        return pSFID;
    }

    public void setpSFID(String pSFID) {
        this.pSFID = pSFID;
    }

    public String getFk_CustomerID() {
        return fk_CustomerID;
    }

    public void setFk_CustomerID(String fk_CustomerID) {
        this.fk_CustomerID = fk_CustomerID;
    }

    public int getpSFEvalution() {
        return pSFEvalution;
    }

    public void setpSFEvalution(int pSFEvalution) {
        this.pSFEvalution = pSFEvalution;
    }

    public String getpSFContent() {
        return pSFContent;
    }

    public void setpSFContent(String pSFContent) {
        this.pSFContent = pSFContent;
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


    @Exclude
    public Map<String, Object> toMapUpdate() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("fk_PartnerServiceID", fk_PartnerServiceID);
        result.put("fk_CustomerID", fk_CustomerID);
        result.put("pSFEvalution", pSFEvalution);
        result.put("pSFContent", pSFContent);
        result.put("pSFIsSend", pSFIsSend);
        result.put("fk_PartnerServiceBookID", fk_PartnerServiceBookID);
        result.put("pSFEFrom", pSFEFrom);
        result.put("pSFETo", pSFETo);
        result.put("fk_PartnerID", fk_PartnerID);

        return result;
    }

    @Exclude
    public Map<String, Object> toMapDelete() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", EntityStatus.Delete);

        return result;
    }
}
