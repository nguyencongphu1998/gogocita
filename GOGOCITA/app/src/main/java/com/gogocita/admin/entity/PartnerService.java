package com.gogocita.admin.entity;

import com.gogocita.admin.Constant.EntityStatus;
import com.gogocita.admin.helper.QueryFirebase;
import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class PartnerService {
    private String PartnerServiceID;
    private String Status;
    private String FK_PartnerID;
    private String PartnerServiceName;
    private int PartnerServiceEvalution;
    private String PartnerServiceAddressLine;
    private String FK_LocationCountryID;
    private String FK_LocationCityID;
    private String FK_LocationDistrictID;
    private boolean PartnerServiceIsActive;
    private String FK_EmployeeID;
    private String PartnerServiceDesc;
    private double PartnerServicePrice;
    private float PartnerServiceDiscount;

    public PartnerService(String status, String FK_PartnerID, String partnerServiceName, int partnerServiceEvalution, String partnerServiceAddressLine, String FK_LocationCountryID, String FK_LocationCityID, String FK_LocationDistrictID, boolean partnerServiceIsActive, String FK_EmployeeID, String partnerServiceDesc, double partnerServicePrice, float partnerServiceDiscount) {
        PartnerServiceID = id();
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

    public PartnerService(String partnerServiceID, String status, String FK_PartnerID, String partnerServiceName, int partnerServiceEvalution, String partnerServiceAddressLine, String FK_LocationCountryID, String FK_LocationCityID, String FK_LocationDistrictID, boolean partnerServiceIsActive, String FK_EmployeeID, String partnerServiceDesc, double partnerServicePrice, float partnerServiceDiscount) {
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

    public String getPartnerServiceID() {
        return PartnerServiceID;
    }

    public void setPartnerServiceID(String partnerServiceID) {
        PartnerServiceID = partnerServiceID;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getFK_PartnerID() {
        return FK_PartnerID;
    }

    public void setFK_PartnerID(String FK_PartnerID) {
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

    public String getFK_LocationCountryID() {
        return FK_LocationCountryID;
    }

    public void setFK_LocationCountryID(String FK_LocationCountryID) {
        this.FK_LocationCountryID = FK_LocationCountryID;
    }

    public String getFK_LocationCityID() {
        return FK_LocationCityID;
    }

    public void setFK_LocationCityID(String FK_LocationCityID) {
        this.FK_LocationCityID = FK_LocationCityID;
    }

    public String getFK_LocationDistrictID() {
        return FK_LocationDistrictID;
    }

    public void setFK_LocationDistrictID(String FK_LocationDistrictID) {
        this.FK_LocationDistrictID = FK_LocationDistrictID;
    }

    public boolean isPartnerServiceIsActive() {
        return PartnerServiceIsActive;
    }

    public void setPartnerServiceIsActive(boolean partnerServiceIsActive) {
        PartnerServiceIsActive = partnerServiceIsActive;
    }

    public String getFK_EmployeeID() {
        return FK_EmployeeID;
    }

    public void setFK_EmployeeID(String FK_EmployeeID) {
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

    public String id() {
        QueryFirebase firebase = new QueryFirebase("PartnerServices");
        return firebase.getNewKey();
    }

    @Override
    public String toString() {
        return "PartnerServices";
    }

    @Exclude
    public Map<String, Object> toMapUpdate() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", Status);
        result.put("fK_PartnerID", FK_PartnerID);
        result.put("partnerServiceName", PartnerServiceName);
        result.put("partnerServiceEvalution", PartnerServiceEvalution);
        result.put("partnerServiceAddressLine", PartnerServiceAddressLine);
        result.put("fK_LocationCountryID", FK_LocationCountryID);
        result.put("fK_LocationCityID", FK_LocationCityID);
        result.put("fK_LocationDistrictID", FK_LocationDistrictID);
        result.put("partnerServiceIsActive", PartnerServiceIsActive);
        result.put("fK_EmployeeID", FK_EmployeeID);
        result.put("partnerServicePrice", PartnerServicePrice);
        result.put("partnerServiceDiscount", PartnerServiceDiscount);
        result.put("partnerServiceDesc", PartnerServiceDesc);

        return result;
    }

    @Exclude
    public Map<String, Object> toMapDelete() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", EntityStatus.Delete);

        return result;
    }

}
