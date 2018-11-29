package com.gogocita.admin.entity;

import com.gogocita.admin.constant.EntityName;
import com.gogocita.admin.constant.EntityStatus;
import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class PartnerService extends GenerateId implements Serializable{
    private String partnerServiceID;
    private String status;
    private String fk_PartnerID;
    private String partnerServiceName;
    private int partnerServiceEvalution;
    private String partnerServiceAddressLine;
    private String fk_LocationCountryID;
    private String fk_LocationCityID;
    private String fk_LocationDistrictID;
    private boolean partnerServiceIsActive;
    private String fk_EmployeeID;
    private String partnerServiceDesc;
    private double partnerServicePrice;
    private float partnerServiceDiscount;
    private String partnerServiceConvinience;
    private String partnerserviceType;
    private String partnerserviceCoverPhotoLink;
    private String partnerserviceCoverPhotoID;
    private int partnerserviceFeedbackAmount;

    public PartnerService() {
    }

    public PartnerService(String partnerServiceID, String status, String fk_PartnerID, String partnerServiceName, int partnerServiceEvalution, String partnerServiceAddressLine, String fk_LocationCountryID, String fk_LocationCityID, String fk_LocationDistrictID, boolean partnerServiceIsActive, String fk_EmployeeID, String partnerServiceDesc, double partnerServicePrice, float partnerServiceDiscount, String partnerServiceConvinience,String serviceType,int partnerserviceFeedbackAmount)
    {
        this.partnerServiceID = partnerServiceID;
        this.status = status;
        this.fk_PartnerID = fk_PartnerID;
        this.partnerServiceName = partnerServiceName;
        this.partnerServiceEvalution = partnerServiceEvalution;
        this.partnerServiceAddressLine = partnerServiceAddressLine;
        this.fk_LocationCountryID = fk_LocationCountryID;
        this.fk_LocationCityID = fk_LocationCityID;
        this.fk_LocationDistrictID = fk_LocationDistrictID;
        this.partnerServiceIsActive = partnerServiceIsActive;
        this.fk_EmployeeID = fk_EmployeeID;
        this.partnerServiceDesc = partnerServiceDesc;
        this.partnerServicePrice = partnerServicePrice;
        this.partnerServiceDiscount = partnerServiceDiscount;
        this.partnerServiceConvinience = partnerServiceConvinience;
        this.partnerserviceType = serviceType;
        this.partnerserviceFeedbackAmount = partnerserviceFeedbackAmount;
    }

    public PartnerService(String fk_PartnerID, String partnerServiceName, int partnerServiceEvalution, String partnerServiceAddressLine, String fk_LocationCountryID, String fk_LocationCityID, String fk_LocationDistrictID, boolean partnerServiceIsActive, String fk_EmployeeID, String partnerServiceDesc, double partnerServicePrice, float partnerServiceDiscount, String partnerServiceConvinience,String serviceType)
    {
        this.partnerServiceID = generateId(EntityName.PartnerServices);
        this.status = EntityStatus.Alive;
        this.fk_PartnerID = fk_PartnerID;
        this.partnerServiceName = partnerServiceName;
        this.partnerServiceEvalution = partnerServiceEvalution;
        this.partnerServiceAddressLine = partnerServiceAddressLine;
        this.fk_LocationCountryID = fk_LocationCountryID;
        this.fk_LocationCityID = fk_LocationCityID;
        this.fk_LocationDistrictID = fk_LocationDistrictID;
        this.partnerServiceIsActive = partnerServiceIsActive;
        this.fk_EmployeeID = fk_EmployeeID;
        this.partnerServiceDesc = partnerServiceDesc;
        this.partnerServicePrice = partnerServicePrice;
        this.partnerServiceDiscount = partnerServiceDiscount;
        this.partnerServiceConvinience = partnerServiceConvinience;
        this.partnerserviceType = serviceType;
        this.partnerserviceFeedbackAmount = 0;
    }

    public String getPartnerserviceCoverPhotoID() {
        return partnerserviceCoverPhotoID;
    }

    public void setPartnerserviceCoverPhotoID(String partnerserviceCoverPhotoID) {
        this.partnerserviceCoverPhotoID = partnerserviceCoverPhotoID;
    }

    public String getPartnerServiceID() {
        return partnerServiceID;
    }

    public void setPartnerServiceID(String partnerServiceID) {
        this.partnerServiceID = partnerServiceID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFk_PartnerID() {
        return fk_PartnerID;
    }

    public void setFk_PartnerID(String fk_PartnerID) {
        this.fk_PartnerID = fk_PartnerID;
    }

    public String getPartnerServiceName() {
        return partnerServiceName;
    }

    public void setPartnerServiceName(String partnerServiceName) {
        this.partnerServiceName = partnerServiceName;
    }

    public int getPartnerServiceEvalution() {
        return partnerServiceEvalution;
    }

    public void setPartnerServiceEvalution(int partnerServiceEvalution) {
        this.partnerServiceEvalution = partnerServiceEvalution;
    }

    public String getPartnerServiceAddressLine() {
        return partnerServiceAddressLine;
    }

    public void setPartnerServiceAddressLine(String partnerServiceAddressLine) {
        this.partnerServiceAddressLine = partnerServiceAddressLine;
    }

    public String getFk_LocationCountryID() {
        return fk_LocationCountryID;
    }

    public void setFk_LocationCountryID(String fk_LocationCountryID) {
        this.fk_LocationCountryID = fk_LocationCountryID;
    }

    public String getFk_LocationCityID() {
        return fk_LocationCityID;
    }

    public void setFk_LocationCityID(String fk_LocationCityID) {
        this.fk_LocationCityID = fk_LocationCityID;
    }

    public String getFk_LocationDistrictID() {
        return fk_LocationDistrictID;
    }

    public void setFk_LocationDistrictID(String fk_LocationDistrictID) {
        this.fk_LocationDistrictID = fk_LocationDistrictID;
    }

    public boolean isPartnerServiceIsActive() {
        return partnerServiceIsActive;
    }

    public void setPartnerServiceIsActive(boolean partnerServiceIsActive) {
        this.partnerServiceIsActive = partnerServiceIsActive;
    }

    public String getFk_EmployeeID() {
        return fk_EmployeeID;
    }

    public void setFk_EmployeeID(String fk_EmployeeID) {
        this.fk_EmployeeID = fk_EmployeeID;
    }

    public String getPartnerServiceDesc() {
        return partnerServiceDesc;
    }

    public void setPartnerServiceDesc(String partnerServiceDesc) {
        this.partnerServiceDesc = partnerServiceDesc;
    }

    public double getPartnerServicePrice() {
        return partnerServicePrice;
    }

    public void setPartnerServicePrice(double partnerServicePrice) {
        this.partnerServicePrice = partnerServicePrice;
    }

    public float getPartnerServiceDiscount() {
        return partnerServiceDiscount;
    }

    public void setPartnerServiceDiscount(float partnerServiceDiscount) {
        this.partnerServiceDiscount = partnerServiceDiscount;
    }

    public String getPartnerServiceConvinience() {
        return partnerServiceConvinience;
    }

    public void setPartnerServiceConvinience(String partnerServiceConvinience) {
        this.partnerServiceConvinience = partnerServiceConvinience;
    }

    public String getPartnerserviceType() {
        return partnerserviceType;
    }

    public void setPartnerserviceType(String partnerserviceType) {
        this.partnerserviceType = partnerserviceType;
    }

    public String getPartnerserviceCoverPhotoLink() {
        return partnerserviceCoverPhotoLink;
    }

    public void setPartnerserviceCoverPhotoLink(String partnerserviceCoverPhotoLink) {
        this.partnerserviceCoverPhotoLink = partnerserviceCoverPhotoLink;
    }

    public int getPartnerserviceFeedbackAmount() {
        return partnerserviceFeedbackAmount;
    }

    public void setPartnerserviceFeedbackAmount(int partnerserviceFeedbackAmount) {
        this.partnerserviceFeedbackAmount = partnerserviceFeedbackAmount;
    }

    public String getServiceType() {
        return partnerserviceType;
    }

    public void setServiceType(String serviceType) {
        this.partnerserviceType = serviceType;
    }

    @Exclude
    public Map<String, Object> toMapUpdate() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", status);
        result.put("partnerServiceID", partnerServiceID);
        result.put("fk_PartnerID", fk_PartnerID);
        result.put("partnerServiceName", partnerServiceName);
        result.put("partnerServiceEvalution", partnerServiceEvalution);
        result.put("partnerServiceAddressLine", partnerServiceAddressLine);
        result.put("fk_LocationCountryID", fk_LocationCountryID);
        result.put("fk_LocationCityID", fk_LocationCityID);
        result.put("fk_LocationDistrictID", fk_LocationDistrictID);
        result.put("partnerServiceIsActive", partnerServiceIsActive);
        result.put("fk_EmployeeID", fk_EmployeeID);
        result.put("partnerServicePrice", partnerServicePrice);
        result.put("partnerServiceDiscount", partnerServiceDiscount);
        result.put("partnerServiceDesc", partnerServiceDesc);
        result.put("partnerServiceConvinience", partnerServiceConvinience);
        result.put("partnerserviceType", partnerserviceType);

        return result;
    }

    @Exclude
    public Map<String, Object> toMapUpdateCoverPhoto() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("partnerserviceCoverPhotoLink", partnerserviceCoverPhotoLink);
        result.put("partnerserviceCoverPhotoID", partnerserviceCoverPhotoID);

        return result;
    }

    @Exclude
    public Map<String, Object> toMapUpdateEvalution() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("partnerserviceFeedbackAmount", partnerserviceFeedbackAmount);
        result.put("partnerServiceEvalution", partnerServiceEvalution);

        return result;
    }

    @Exclude
    public Map<String, Object> toMapDelete() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", EntityStatus.Delete);

        return result;
    }

}
