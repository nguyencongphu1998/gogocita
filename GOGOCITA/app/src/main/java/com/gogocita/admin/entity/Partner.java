package com.gogocita.admin.entity;

import com.gogocita.admin.Constant.EntityStatus;
import com.gogocita.admin.helper.QueryFirebase;
import com.google.firebase.database.Exclude;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Partner {
    private String partnerID;
    private String status;
    private String fk_UserID;
    private String partnerType;
    private Date partnerBirthDay;
    private String partnerJob;
    private String partnerPhone;
    private String partnerGender;
    private String partnerIDNumber;
    private String partnerEmail;
    private int fk_EmployeeID;
    private String partnerAvatar;
    private String partnerAddressLine;
    private String fk_LocationCountryID;
    private String fk_LocationCityID;
    private String fk_LocationDistrictID;
    private boolean partnerIsActive;
    private String partnerName;
    private long partnerAmount;

    public Partner() {
    }

    public Partner(String fk_UserID, String partnerType, Date partnerBirthDay, String partnerJob, String partnerPhone, String partnerGender, String partnerIDNumber, String partnerEmail, int fk_EmployeeID, String partnerAvatar, String partnerAddressLine, String fk_LocationCountryID, String fk_LocationCityID, String fk_LocationDistrictID, boolean partnerIsActive, String partnerName, long partnerAmount) {
        this.partnerID = generateId();
        this.status = EntityStatus.Alive;
        this.fk_UserID = fk_UserID;
        this.partnerType = partnerType;
        this.partnerBirthDay = partnerBirthDay;
        this.partnerJob = partnerJob;
        this.partnerPhone = partnerPhone;
        this.partnerGender = partnerGender;
        this.partnerIDNumber = partnerIDNumber;
        this.partnerEmail = partnerEmail;
        this.fk_EmployeeID = fk_EmployeeID;
        this.partnerAvatar = partnerAvatar;
        this.partnerAddressLine = partnerAddressLine;
        this.fk_LocationCountryID = fk_LocationCountryID;
        this.fk_LocationCityID = fk_LocationCityID;
        this.fk_LocationDistrictID = fk_LocationDistrictID;
        this.partnerIsActive = partnerIsActive;
        this.partnerName = partnerName;
        this.partnerAmount = partnerAmount;
    }

    public Partner(String partnerID, String status, String fk_UserID, String partnerType, Date partnerBirthDay, String partnerJob, String partnerPhone, String partnerGender, String partnerIDNumber, String partnerEmail, int fk_EmployeeID, String partnerAvatar, String partnerAddressLine, String fk_LocationCountryID, String fk_LocationCityID, String fk_LocationDistrictID, boolean partnerIsActive, String partnerName, long partnerAmount) {
        this.partnerID = partnerID;
        this.status = status;
        this.fk_UserID = fk_UserID;
        this.partnerType = partnerType;
        this.partnerBirthDay = partnerBirthDay;
        this.partnerJob = partnerJob;
        this.partnerPhone = partnerPhone;
        this.partnerGender = partnerGender;
        this.partnerIDNumber = partnerIDNumber;
        this.partnerEmail = partnerEmail;
        this.fk_EmployeeID = fk_EmployeeID;
        this.partnerAvatar = partnerAvatar;
        this.partnerAddressLine = partnerAddressLine;
        this.fk_LocationCountryID = fk_LocationCountryID;
        this.fk_LocationCityID = fk_LocationCityID;
        this.fk_LocationDistrictID = fk_LocationDistrictID;
        this.partnerIsActive = partnerIsActive;
        this.partnerName = partnerName;
        this.partnerAmount = partnerAmount;
    }

    public String generateId() {
        QueryFirebase firebase = new QueryFirebase("Partners");
        return firebase.getNewKey();
    }

    public String getPartnerID() {
        return partnerID;
    }

    public void setPartnerID(String partnerID) {
        this.partnerID = partnerID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFk_UserID() {
        return fk_UserID;
    }

    public void setFk_UserID(String fk_UserID) {
        this.fk_UserID = fk_UserID;
    }

    public String getPartnerType() {
        return partnerType;
    }

    public void setPartnerType(String partnerType) {
        this.partnerType = partnerType;
    }

    public Date getPartnerBirthDay() {
        return partnerBirthDay;
    }

    public void setPartnerBirthDay(Date partnerBirthDay) {
        this.partnerBirthDay = partnerBirthDay;
    }

    public String getPartnerJob() {
        return partnerJob;
    }

    public void setPartnerJob(String partnerJob) {
        this.partnerJob = partnerJob;
    }

    public String getPartnerPhone() {
        return partnerPhone;
    }

    public void setPartnerPhone(String partnerPhone) {
        this.partnerPhone = partnerPhone;
    }

    public String getPartnerGender() {
        return partnerGender;
    }

    public void setPartnerGender(String partnerGender) {
        this.partnerGender = partnerGender;
    }

    public String getPartnerIDNumber() {
        return partnerIDNumber;
    }

    public void setPartnerIDNumber(String partnerIDNumber) {
        this.partnerIDNumber = partnerIDNumber;
    }

    public String getPartnerEmail() {
        return partnerEmail;
    }

    public void setPartnerEmail(String partnerEmail) {
        this.partnerEmail = partnerEmail;
    }

    public int getFk_EmployeeID() {
        return fk_EmployeeID;
    }

    public void setFk_EmployeeID(int fk_EmployeeID) {
        this.fk_EmployeeID = fk_EmployeeID;
    }

    public String getPartnerAvatar() {
        return partnerAvatar;
    }

    public void setPartnerAvatar(String partnerAvatar) {
        this.partnerAvatar = partnerAvatar;
    }

    public String getPartnerAddressLine() {
        return partnerAddressLine;
    }

    public void setPartnerAddressLine(String partnerAddressLine) {
        this.partnerAddressLine = partnerAddressLine;
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

    public boolean isPartnerIsActive() {
        return partnerIsActive;
    }

    public void setPartnerIsActive(boolean partnerIsActive) {
        this.partnerIsActive = partnerIsActive;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public long getPartnerAmount() {
        return partnerAmount;
    }

    public void setPartnerAmount(long partnerAmount) {
        this.partnerAmount = partnerAmount;
    }

    @Override
    public String toString() {
        return "Partners";
    }

    @Exclude
    public Map<String, Object> toMapUpdate() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", status);
        result.put("fK_UserID", fk_UserID);
        result.put("partnerType", partnerType);
        result.put("partnerName", partnerName);
        result.put("partnerBirthDay", partnerBirthDay);
        result.put("partnerJob", partnerJob);
        result.put("partnerPhone", partnerPhone);
        result.put("partnerGender", partnerGender);
        result.put("partnerIDNumber", partnerIDNumber);
        result.put("partnerEmail", partnerEmail);
        result.put("fK_EmployeeID", fk_EmployeeID);
        result.put("partnerAvatar", partnerAvatar);
        result.put("partnerAddressLine", partnerAddressLine);
        result.put("fK_LocationCountryID", fk_LocationCountryID);
        result.put("fK_LocationCityID", fk_LocationCityID);
        result.put("fK_LocationDistrictID", fk_LocationDistrictID);
        result.put("partnerAmount", partnerAmount);
        result.put("partnerIsActive", partnerIsActive);

        return result;
    }

    @Exclude
    public Map<String, Object> toMapDelete() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", EntityStatus.Delete);

        return result;
    }

}
