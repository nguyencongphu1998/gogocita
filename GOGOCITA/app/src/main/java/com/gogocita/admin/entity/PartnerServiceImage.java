package com.gogocita.admin.entity;

import com.gogocita.admin.Constant.EntityStatus;
import com.gogocita.admin.helper.QueryFirebase;
import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class PartnerServiceImage {
    private String partnerServiceImageID;
    private String status;
    private String fk_PartnerServiceID;
    private String partnerServiceImageLink;
    private String partnerServiceImageType;

    public PartnerServiceImage() {
    }

    public PartnerServiceImage(String partnerServiceImageID, String status, String fk_PartnerServiceID, String partnerServiceImageLink, String partnerServiceImageType) {
        this.partnerServiceImageID = partnerServiceImageID;
        this.status = status;
        this.fk_PartnerServiceID = fk_PartnerServiceID;
        this.partnerServiceImageLink = partnerServiceImageLink;
        this.partnerServiceImageType = partnerServiceImageType;
    }

    public PartnerServiceImage(String fk_PartnerServiceID, String partnerServiceImageLink, String partnerServiceImageType) {
        this.partnerServiceImageID = generateId();
        this.status = EntityStatus.Alive;
        this.fk_PartnerServiceID = fk_PartnerServiceID;
        this.partnerServiceImageLink = partnerServiceImageLink;
        this.partnerServiceImageType = partnerServiceImageType;
    }

    public String getPartnerServiceImageID() {
        return partnerServiceImageID;
    }

    public void setPartnerServiceImageID(String partnerServiceImageID) {
        this.partnerServiceImageID = partnerServiceImageID;
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

    public String getPartnerServiceImageLink() {
        return partnerServiceImageLink;
    }

    public void setPartnerServiceImageLink(String partnerServiceImageLink) {
        this.partnerServiceImageLink = partnerServiceImageLink;
    }

    public String getPartnerServiceImageType() {
        return partnerServiceImageType;
    }

    public void setPartnerServiceImageType(String partnerServiceImageType) {
        this.partnerServiceImageType = partnerServiceImageType;
    }

    public String generateId() {
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
        result.put("status", status);
        result.put("fK_PartnerServiceID", fk_PartnerServiceID);
        result.put("partnerServiceImageLink", partnerServiceImageLink);
        result.put("partnerServiceImageType", partnerServiceImageType);

        return result;
    }

    @Exclude
    public Map<String, Object> toMapDelete() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", EntityStatus.Delete);

        return result;
    }
}
