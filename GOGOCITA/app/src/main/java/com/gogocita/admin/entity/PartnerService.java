package com.gogocita.admin.entity;

public class PartnerService {
    private int PartnerServiceID;

    public int getPartnerServiceID() {
        return PartnerServiceID;
    }

    public void setPartnerServiceID(int partnerServiceID) {
        PartnerServiceID = partnerServiceID;
    }

    public String getStatus() {
        return Status;
    }

    public PartnerService(int partnerServiceID, String status, int FK_PartnerID, String partnerServiceName, int partnerServiceEvalution, String partnerServiceAddressLine, int FK_LocationCountryID, int FK_LocationCityID, int FK_LocationDistrictID, boolean partnerServiceIsActive, int FK_EmployeeID, String partnerServiceDesc, double partnerServicePrice, float partnerServiceDiscount) {
        PartnerServiceID = partnerServiceID;
        Status = status;
        this.FK_PartnerID = FK_PartnerID;
        PartnerServiceName = partnerServiceName;
        PartnerServiceEvalution = partnerServiceEvalution;
        PartnerServiceAddressLine = partnerServiceAddressLine;
        this.FK_LocationCountryID = FK_LocationCountryID;
        this.FK_LocationCityID = FK_LocationCityID;
        this.FK_LocationDistrictID = FK_LocationDistrictID;
        PartnerServiceIsActive = partnerServiceIsActive;
        this.FK_EmployeeID = FK_EmployeeID;
        PartnerServiceDesc = partnerServiceDesc;
        PartnerServicePrice = partnerServicePrice;
        PartnerServiceDiscount = partnerServiceDiscount;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public int getFK_PartnerID() {
        return FK_PartnerID;
    }

    public void setFK_PartnerID(int FK_PartnerID) {
        this.FK_PartnerID = FK_PartnerID;
    }

    public String getPartnerServiceName() {
        return PartnerServiceName;
    }

    public void setPartnerServiceName(String partnerServiceName) {
        PartnerServiceName = partnerServiceName;
    }

    public int getPartnerServiceEvalution() {
        return PartnerServiceEvalution;
    }

    public void setPartnerServiceEvalution(int partnerServiceEvalution) {
        PartnerServiceEvalution = partnerServiceEvalution;
    }

    public String getPartnerServiceAddressLine() {
        return PartnerServiceAddressLine;
    }

    public void setPartnerServiceAddressLine(String partnerServiceAddressLine) {
        PartnerServiceAddressLine = partnerServiceAddressLine;
    }

    public int getFK_LocationCountryID() {
        return FK_LocationCountryID;
    }

    public void setFK_LocationCountryID(int FK_LocationCountryID) {
        this.FK_LocationCountryID = FK_LocationCountryID;
    }

    public int getFK_LocationCityID() {
        return FK_LocationCityID;
    }

    public void setFK_LocationCityID(int FK_LocationCityID) {
        this.FK_LocationCityID = FK_LocationCityID;
    }

    public int getFK_LocationDistrictID() {
        return FK_LocationDistrictID;
    }

    public void setFK_LocationDistrictID(int FK_LocationDistrictID) {
        this.FK_LocationDistrictID = FK_LocationDistrictID;
    }

    public boolean isPartnerServiceIsActive() {
        return PartnerServiceIsActive;
    }

    public void setPartnerServiceIsActive(boolean partnerServiceIsActive) {
        PartnerServiceIsActive = partnerServiceIsActive;
    }

    public int getFK_EmployeeID() {
        return FK_EmployeeID;
    }

    public void setFK_EmployeeID(int FK_EmployeeID) {
        this.FK_EmployeeID = FK_EmployeeID;
    }

    public String getPartnerServiceDesc() {
        return PartnerServiceDesc;
    }

    public void setPartnerServiceDesc(String partnerServiceDesc) {
        PartnerServiceDesc = partnerServiceDesc;
    }

    public double getPartnerServicePrice() {
        return PartnerServicePrice;
    }

    public void setPartnerServicePrice(double partnerServicePrice) {
        PartnerServicePrice = partnerServicePrice;
    }

    public float getPartnerServiceDiscount() {
        return PartnerServiceDiscount;
    }

    public void setPartnerServiceDiscount(float partnerServiceDiscount) {
        PartnerServiceDiscount = partnerServiceDiscount;
    }

    private String Status;
    private int FK_PartnerID;
    private String PartnerServiceName;
    private int PartnerServiceEvalution;
    private String PartnerServiceAddressLine;
    private int FK_LocationCountryID;
    private int FK_LocationCityID;
    private int FK_LocationDistrictID;
    private boolean PartnerServiceIsActive;
    private int FK_EmployeeID;
    private String PartnerServiceDesc;
    private double PartnerServicePrice;
    private float PartnerServiceDiscount;

}
