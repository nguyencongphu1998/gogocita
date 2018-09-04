package com.gogocita.admin.entity;

import java.util.Date;

public class PartnerServiceDate {
    private int PartnerServiceDateID;
    private int FK_PartnerServiceID;

    public PartnerServiceDate(int partnerServiceDateID, int FK_PartnerServiceID, String status, Date partnerServiceDateFrom, Date partnerServiceDateTo, String partnerServiceDateStatus) {
        PartnerServiceDateID = partnerServiceDateID;
        this.FK_PartnerServiceID = FK_PartnerServiceID;
        Status = status;
        PartnerServiceDateFrom = partnerServiceDateFrom;
        PartnerServiceDateTo = partnerServiceDateTo;
        PartnerServiceDateStatus = partnerServiceDateStatus;
    }

    public int getPartnerServiceDateID() {
        return PartnerServiceDateID;
    }

    public void setPartnerServiceDateID(int partnerServiceDateID) {
        PartnerServiceDateID = partnerServiceDateID;
    }

    public int getFK_PartnerServiceID() {
        return FK_PartnerServiceID;
    }

    public void setFK_PartnerServiceID(int FK_PartnerServiceID) {
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

    private String Status;
    private Date PartnerServiceDateFrom;
    private Date PartnerServiceDateTo;
    private String PartnerServiceDateStatus;

}
