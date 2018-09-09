package com.gogocita.admin.entity;

import com.gogocita.admin.Constant.EntityStatus;
import com.gogocita.admin.helper.QueryFirebase;
import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class PartnerServiceImage {
    private String PartnerServiceImageID;
    private String Status;
    private String FK_PartnerServiceID;
    private String PartnerServiceImageLink;
    private String PartnerServiceImageType;

    public PartnerServiceImage(String partnerServiceImageID, String status, String FK_PartnerServiceID, String partnerServiceImageLink, String partnerServiceImageType) {
        PartnerServiceImageID = partnerServiceImageID;
        Status = status;
        this.FK_PartnerServiceID = FK_PartnerServiceID;
        PartnerServiceImageLink = partnerServiceImageLink;
        PartnerServiceImageType = partnerServiceImageType;
    }

    public PartnerServiceImage(String status, String FK_PartnerServiceID, String partnerServiceImageLink, String partnerServiceImageType) {
        PartnerServiceImageID = id();
        Status = status;
        this.FK_PartnerServiceID = FK_PartnerServiceID;
        PartnerServiceImageLink = partnerServiceImageLink;
        PartnerServiceImageType = partnerServiceImageType;
    }

    public String getPartnerServiceImageID() {
        return PartnerServiceImageID;
    }

    public void setPartnerServiceImageID(String partnerServiceImageID) {
        PartnerServiceImageID = partnerServiceImageID;
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

    public String getPartnerServiceImageLink() {
        return PartnerServiceImageLink;
    }

    public void setPartnerServiceImageLink(String partnerServiceImageLink) {
        PartnerServiceImageLink = partnerServiceImageLink;
    }

    public String getPartnerServiceImageType() {
        return PartnerServiceImageType;
    }

    public void setPartnerServiceImageType(String partnerServiceImageType) {
        PartnerServiceImageType = partnerServiceImageType;
    }

    public String id() {
        QueryFirebase firebase = new QueryFirebase("PartnerServiceImages");
        return firebase.getNewKey();
    }

    @Override
    public String toString() {
        return "PartnerServiceImages";
    }

    @Exclude
    public Map<String, Object> toMapUpdate() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", Status);
        result.put("fK_PartnerServiceID", FK_PartnerServiceID);
        result.put("partnerServiceImageLink", PartnerServiceImageLink);
        result.put("partnerServiceImageType", PartnerServiceImageType);

        return result;
    }

    @Exclude
    public Map<String, Object> toMapDelete() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", EntityStatus.Delete);

        return result;
    }
}
