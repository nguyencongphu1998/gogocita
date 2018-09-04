package com.gogocita.admin.entity;

public class PartnerServiceImage {
    private int PartnerServiceImageID;

    public PartnerServiceImage(int partnerServiceImageID, String status, int FK_PartnerServiceID, int partnerServiceImageLink, int partnerServiceImageType) {
        PartnerServiceImageID = partnerServiceImageID;
        Status = status;
        this.FK_PartnerServiceID = FK_PartnerServiceID;
        PartnerServiceImageLink = partnerServiceImageLink;
        PartnerServiceImageType = partnerServiceImageType;
    }

    public int getPartnerServiceImageID() {
        return PartnerServiceImageID;
    }

    public void setPartnerServiceImageID(int partnerServiceImageID) {
        PartnerServiceImageID = partnerServiceImageID;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public int getFK_PartnerServiceID() {
        return FK_PartnerServiceID;
    }

    public void setFK_PartnerServiceID(int FK_PartnerServiceID) {
        this.FK_PartnerServiceID = FK_PartnerServiceID;
    }

    public int getPartnerServiceImageLink() {
        return PartnerServiceImageLink;
    }

    public void setPartnerServiceImageLink(int partnerServiceImageLink) {
        PartnerServiceImageLink = partnerServiceImageLink;
    }

    public int getPartnerServiceImageType() {
        return PartnerServiceImageType;
    }

    public void setPartnerServiceImageType(int partnerServiceImageType) {
        PartnerServiceImageType = partnerServiceImageType;
    }

    private String Status;
    private int FK_PartnerServiceID;
    private int PartnerServiceImageLink;
    private int PartnerServiceImageType;

}
