package com.gogocita.admin.entity;

import com.gogocita.admin.Constant.EntityStatus;
import com.gogocita.admin.helper.QueryFirebase;
import com.google.firebase.database.Exclude;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Partner {
    private String PartnerID;
    private String Status;
    private String FK_UserID;
    private String PartnerType;
    private Date PartnerBirthDay;
    private String PartnerJob;
    private String PartnerPhone;
    private String PartnerGender;
    private String PartnerIDNumber;
    private String PartnerEmail;
    private int FK_EmployeeID;
    private String PartnerAvatar;
    private String PartnerAddressLine;
    private String FK_LocationCountryID;
    private String FK_LocationCityID;
    private String FK_LocationDistrictID;
    private boolean PartnerIsActive;
    private String PartnerName;
    private long PartnerAmount;

    public Partner(String partnerID, String status, String FK_UserID, String partnerType, Date partnerBirthDay, String partnerJob, String partnerPhone, String partnerGender, String partnerIDNumber, String partnerEmail, int FK_EmployeeID, String partnerAvatar, String partnerAddressLine, String FK_LocationCountryID, String FK_LocationCityID, String FK_LocationDistrictID, boolean partnerIsActive, String partnerName, long partnerAmount) {
        PartnerID = partnerID;
        Status = status;
        this.FK_UserID = FK_UserID;
        PartnerType = partnerType;
        PartnerBirthDay = partnerBirthDay;
        PartnerJob = partnerJob;
        PartnerPhone = partnerPhone;
        PartnerGender = partnerGender;
        PartnerIDNumber = partnerIDNumber;
        PartnerEmail = partnerEmail;
        this.FK_EmployeeID = FK_EmployeeID;
        PartnerAvatar = partnerAvatar;
        PartnerAddressLine = partnerAddressLine;
        this.FK_LocationCountryID = FK_LocationCountryID;
        this.FK_LocationCityID = FK_LocationCityID;
        this.FK_LocationDistrictID = FK_LocationDistrictID;
        PartnerIsActive = partnerIsActive;
        PartnerName = partnerName;
        PartnerAmount = partnerAmount;
    }

    public Partner(String status, String FK_UserID, String partnerType, Date partnerBirthDay, String partnerJob, String partnerPhone, String partnerGender, String partnerIDNumber, String partnerEmail, int FK_EmployeeID, String partnerAvatar, String partnerAddressLine, String FK_LocationCountryID, String FK_LocationCityID, String FK_LocationDistrictID, boolean partnerIsActive, String partnerName, long partnerAmount) {
        PartnerID = id();
        Status = status;
        this.FK_UserID = FK_UserID;
        PartnerType = partnerType;
        PartnerBirthDay = partnerBirthDay;
        PartnerJob = partnerJob;
        PartnerPhone = partnerPhone;
        PartnerGender = partnerGender;
        PartnerIDNumber = partnerIDNumber;
        PartnerEmail = partnerEmail;
        this.FK_EmployeeID = FK_EmployeeID;
        PartnerAvatar = partnerAvatar;
        PartnerAddressLine = partnerAddressLine;
        this.FK_LocationCountryID = FK_LocationCountryID;
        this.FK_LocationCityID = FK_LocationCityID;
        this.FK_LocationDistrictID = FK_LocationDistrictID;
        PartnerIsActive = partnerIsActive;
        PartnerName = partnerName;
        PartnerAmount = partnerAmount;
    }

    public String getPartnerID() {
        return PartnerID;
    }

    public void setPartnerID(String partnerID) {
        PartnerID = partnerID;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getFK_UserID() {
        return FK_UserID;
    }

    public void setFK_UserID(String FK_UserID) {
        this.FK_UserID = FK_UserID;
    }

    public String getPartnerType() {
        return PartnerType;
    }

    public void setPartnerType(String partnerType) {
        PartnerType = partnerType;
    }

    public Date getPartnerBirthDay() {
        return PartnerBirthDay;
    }

    public void setPartnerBirthDay(Date partnerBirthDay) {
        PartnerBirthDay = partnerBirthDay;
    }

    public String getPartnerJob() {
        return PartnerJob;
    }

    public void setPartnerJob(String partnerJob) {
        PartnerJob = partnerJob;
    }

    public String getPartnerPhone() {
        return PartnerPhone;
    }

    public void setPartnerPhone(String partnerPhone) {
        PartnerPhone = partnerPhone;
    }

    public String getPartnerGender() {
        return PartnerGender;
    }

    public void setPartnerGender(String partnerGender) {
        PartnerGender = partnerGender;
    }

    public String getPartnerIDNumber() {
        return PartnerIDNumber;
    }

    public void setPartnerIDNumber(String partnerIDNumber) {
        PartnerIDNumber = partnerIDNumber;
    }

    public String getPartnerEmail() {
        return PartnerEmail;
    }

    public void setPartnerEmail(String partnerEmail) {
        PartnerEmail = partnerEmail;
    }

    public int getFK_EmployeeID() {
        return FK_EmployeeID;
    }

    public void setFK_EmployeeID(int FK_EmployeeID) {
        this.FK_EmployeeID = FK_EmployeeID;
    }

    public String getPartnerAvatar() {
        return PartnerAvatar;
    }

    public void setPartnerAvatar(String partnerAvatar) {
        PartnerAvatar = partnerAvatar;
    }

    public String getPartnerAddressLine() {
        return PartnerAddressLine;
    }

    public void setPartnerAddressLine(String partnerAddressLine) {
        PartnerAddressLine = partnerAddressLine;
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

    public boolean isPartnerIsActive() {
        return PartnerIsActive;
    }

    public void setPartnerIsActive(boolean partnerIsActive) {
        PartnerIsActive = partnerIsActive;
    }

    public String getPartnerName() {
        return PartnerName;
    }

    public void setPartnerName(String partnerName) {
        PartnerName = partnerName;
    }

    public long getPartnerAmount() {
        return PartnerAmount;
    }

    public void setPartnerAmount(long partnerAmount) {
        PartnerAmount = partnerAmount;
    }

    public String id() {
        QueryFirebase firebase = new QueryFirebase("Partners");
        return firebase.getNewKey();
    }

    @Override
    public String toString() {
        return "Partners";
    }

    @Exclude
    public Map<String, Object> toMapUpdate() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", Status);
        result.put("fK_UserID", FK_UserID);
        result.put("partnerType", PartnerType);
        result.put("partnerName", PartnerName);
        result.put("partnerBirthDay", PartnerBirthDay);
        result.put("partnerJob", PartnerJob);
        result.put("partnerPhone", PartnerPhone);
        result.put("partnerGender", PartnerGender);
        result.put("partnerIDNumber", PartnerIDNumber);
        result.put("partnerEmail", PartnerEmail);
        result.put("fK_EmployeeID", FK_EmployeeID);
        result.put("partnerAvatar", PartnerAvatar);
        result.put("partnerAddressLine", PartnerAddressLine);
        result.put("fK_LocationCountryID", FK_LocationCountryID);
        result.put("fK_LocationCityID", FK_LocationCityID);
        result.put("fK_LocationDistrictID", FK_LocationDistrictID);
        result.put("partnerAmount", PartnerAmount);
        result.put("partnerIsActive", PartnerIsActive);

        return result;
    }

    @Exclude
    public Map<String, Object> toMapDelete() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", EntityStatus.Delete);

        return result;
    }

}
