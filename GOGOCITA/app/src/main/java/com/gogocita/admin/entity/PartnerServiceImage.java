package com.gogocita.admin.entity;

import com.gogocita.admin.constant.EntityName;
import com.gogocita.admin.constant.EntityStatus;
import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class PartnerServiceImage extends GenerateId{
    private String partnerServiceImageID;
    private String status;
    private String fK_PartnerServiceID;
    private String partnerServiceImageLink;
    private String partnerServiceImageType;
    private String partnerServiceImageDesc;

    public PartnerServiceImage() {
    }

    public PartnerServiceImage(String status, String fk_PartnerServiceID, String partnerServiceImageLink, String partnerServiceImageType, String partnerServiceImageDesc) {
        this.partnerServiceImageID = partnerServiceImageID;
        this.status = status;
        this.fK_PartnerServiceID = fk_PartnerServiceID;
        this.partnerServiceImageLink = partnerServiceImageLink;
        this.partnerServiceImageType = partnerServiceImageType;
        this.partnerServiceImageDesc = partnerServiceImageDesc;
    }

    public PartnerServiceImage(String fk_PartnerServiceID, String partnerServiceImageLink, String partnerServiceImageType, String partnerServiceImageDesc) {
        this.partnerServiceImageID = generateId(EntityName.PartnerServiceImages);
        this.status = EntityStatus.Alive;
        this.fK_PartnerServiceID = fk_PartnerServiceID;
        this.partnerServiceImageLink = partnerServiceImageLink;
        this.partnerServiceImageType = partnerServiceImageType;
        this.partnerServiceImageDesc = partnerServiceImageDesc;
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
        return fK_PartnerServiceID;
    }

    public void setFk_PartnerServiceID(String fk_PartnerServiceID) {
        this.fK_PartnerServiceID = fk_PartnerServiceID;
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

    public String getPartnerServiceImageDesc() {
        return partnerServiceImageDesc;
    }

    public void setPartnerServiceImageDesc(String partnerServiceImageDesc) {
        this.partnerServiceImageDesc = partnerServiceImageDesc;
    }

    @Exclude
    public Map<String, Object> toMapUpdate() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", status);
        result.put("partnerServiceImageID", partnerServiceImageID);
        result.put("fK_PartnerServiceID", fK_PartnerServiceID);
        result.put("partnerServiceImageLink", partnerServiceImageLink);
        result.put("partnerServiceImageType", partnerServiceImageType);
        result.put("partnerServiceImageDesc", partnerServiceImageDesc);

        return result;
    }

    @Exclude
    public Map<String, Object> toMapDelete() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", EntityStatus.Delete);

        return result;
    }
}
