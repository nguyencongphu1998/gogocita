package com.gogocita.admin.entity;

public class PartnerServicesConvenience {
    private int PSCID;
    private String Status;
    private int FK_PartnerServiceID;
    private String PSCType;
    private String PSCName;
    private String PSCDesc;

    public PartnerServicesConvenience(int PSCID, String status, int FK_PartnerServiceID, String PSCType, String PSCName, String PSCDesc) {
        this.PSCID = PSCID;
        Status = status;
        this.FK_PartnerServiceID = FK_PartnerServiceID;
        this.PSCType = PSCType;
        this.PSCName = PSCName;
        this.PSCDesc = PSCDesc;
    }

    public int getPSCID() {
        return PSCID;
    }

    public void setPSCID(int PSCID) {
        this.PSCID = PSCID;
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
}
