package com.gogocita.admin.entity;

import com.gogocita.admin.constant.EntityName;
import com.gogocita.admin.constant.EntityStatus;
import com.google.firebase.database.Exclude;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UserDetail extends GenerateId {
    private String userDetailID;
    private String status;
    private String fk_UserID;
    private String userDetailName;
    private Date userDetailBirthDay;
    private String userDetailPhone;
    private String userDetailGender;
    private String userDetailJob;
    private String userDetailPassportNumber;
    private String userDetailEmail;
    private String userDetailAvatar;
    private String userDetailAddressLine;
    private String userDetailAddressCountry;
    private String userDetailAddressCity;
    private String userDetailAddressDistrict;
    private String fk_EmployeeID;
    private boolean userDetailIsActive;
    private long userDetailAmount;

    public UserDetail() {
    }

    public UserDetail(String fk_UserID, String userDetailName, Date userDetailBirthDay, String userDetailPhone, String userDetailGender, String userDetailJob, String userDetailPassportNumber, String userDetailEmail, String userDetailAvatar, String userDetailAddressLine, String userDetailAddressCountry, String userDetailAddressCity, String userDetailAddressDistrict, String fk_EmployeeID, boolean userDetailIsActive) {
        this.userDetailID = generateId(EntityName.UserDetails);
        this.status = EntityStatus.Alive;
        this.fk_UserID = fk_UserID;
        this.userDetailName = userDetailName;
        this.userDetailBirthDay = userDetailBirthDay;
        this.userDetailPhone = userDetailPhone;
        this.userDetailGender = userDetailGender;
        this.userDetailJob = userDetailJob;
        this.userDetailPassportNumber = userDetailPassportNumber;
        this.userDetailEmail = userDetailEmail;
        this.userDetailAvatar = userDetailAvatar;
        this.userDetailAddressLine = userDetailAddressLine;
        this.userDetailAddressCountry = userDetailAddressCountry;
        this.userDetailAddressCity = userDetailAddressCity;
        this.userDetailAddressDistrict = userDetailAddressDistrict;
        this.fk_EmployeeID = fk_EmployeeID;
        this.userDetailIsActive = userDetailIsActive;
        this.userDetailAmount = 0;
    }

    public UserDetail(String userDetailID, String status, String fk_UserID, String userDetailName, Date userDetailBirthDay, String userDetailPhone, String userDetailGender, String userDetailJob, String userDetailPassportNumber, String userDetailEmail, String userDetailAvatar, String userDetailAddressLine, String userDetailAddressCountry, String userDetailAddressCity, String userDetailAddressDistrict, String fk_EmployeeID, boolean userDetailIsActive, long userDetailAmount) {
        this.userDetailID = userDetailID;
        this.status = status;
        this.fk_UserID = fk_UserID;
        this.userDetailName = userDetailName;
        this.userDetailBirthDay = userDetailBirthDay;
        this.userDetailPhone = userDetailPhone;
        this.userDetailGender = userDetailGender;
        this.userDetailJob = userDetailJob;
        this.userDetailPassportNumber = userDetailPassportNumber;
        this.userDetailEmail = userDetailEmail;
        this.userDetailAvatar = userDetailAvatar;
        this.userDetailAddressLine = userDetailAddressLine;
        this.userDetailAddressCountry = userDetailAddressCountry;
        this.userDetailAddressCity = userDetailAddressCity;
        this.userDetailAddressDistrict = userDetailAddressDistrict;
        this.fk_EmployeeID = fk_EmployeeID;
        this.userDetailIsActive = userDetailIsActive;
        this.userDetailAmount = userDetailAmount;
    }

    public String getUserDetailID() {
        return userDetailID;
    }

    public void setUserDetailID(String userDetailID) {
        this.userDetailID = userDetailID;
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

    public String getUserDetailName() {
        return userDetailName;
    }

    public void setUserDetailName(String userDetailName) {
        this.userDetailName = userDetailName;
    }

    public Date getUserDetailBirthDay() {
        return userDetailBirthDay;
    }

    public void setUserDetailBirthDay(Date userDetailBirthDay) {
        this.userDetailBirthDay = userDetailBirthDay;
    }

    public String getUserDetailPhone() {
        return userDetailPhone;
    }

    public void setUserDetailPhone(String userDetailPhone) {
        this.userDetailPhone = userDetailPhone;
    }

    public String getUserDetailGender() {
        return userDetailGender;
    }

    public void setUserDetailGender(String userDetailGender) {
        this.userDetailGender = userDetailGender;
    }

    public String getUserDetailJob() {
        return userDetailJob;
    }

    public void setUserDetailJob(String userDetailJob) {
        this.userDetailJob = userDetailJob;
    }

    public String getUserDetailPassportNumber() {
        return userDetailPassportNumber;
    }

    public void setUserDetailPassportNumber(String userDetailPassportNumber) {
        this.userDetailPassportNumber = userDetailPassportNumber;
    }

    public String getUserDetailEmail() {
        return userDetailEmail;
    }

    public void setUserDetailEmail(String userDetailEmail) {
        this.userDetailEmail = userDetailEmail;
    }

    public String getUserDetailAvatar() {
        return userDetailAvatar;
    }

    public void setUserDetailAvatar(String userDetailAvatar) {
        this.userDetailAvatar = userDetailAvatar;
    }

    public String getUserDetailAddressLine() {
        return userDetailAddressLine;
    }

    public void setUserDetailAddressLine(String userDetailAddressLine) {
        this.userDetailAddressLine = userDetailAddressLine;
    }

    public String getUserDetailAddressCountry() {
        return userDetailAddressCountry;
    }

    public void setUserDetailAddressCountry(String userDetailAddressCountry) {
        this.userDetailAddressCountry = userDetailAddressCountry;
    }

    public String getUserDetailAddressCity() {
        return userDetailAddressCity;
    }

    public void setUserDetailAddressCity(String userDetailAddressCity) {
        this.userDetailAddressCity = userDetailAddressCity;
    }

    public String getUserDetailAddressDistrict() {
        return userDetailAddressDistrict;
    }

    public void setUserDetailAddressDistrict(String userDetailAddressDistrict) {
        this.userDetailAddressDistrict = userDetailAddressDistrict;
    }

    public String getFk_EmployeeID() {
        return fk_EmployeeID;
    }

    public void setFk_EmployeeID(String fk_EmployeeID) {
        this.fk_EmployeeID = fk_EmployeeID;
    }

    public boolean isUserDetailIsActive() {
        return userDetailIsActive;
    }

    public void setUserDetailIsActive(boolean userDetailIsActive) {
        this.userDetailIsActive = userDetailIsActive;
    }

    public long getUserDetailAmount() {
        return userDetailAmount;
    }

    public void setUserDetailAmount(long userDetailAmount) {
        this.userDetailAmount = userDetailAmount;
    }

    @Exclude
    public Map<String, Object> toMapUpdate() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("customerName", userDetailName);
        result.put("customerBirthDay", userDetailBirthDay);
        result.put("customerPhone", userDetailPhone);
        result.put("customerGender", userDetailGender);
        result.put("customerJob", userDetailJob);
        result.put("customerPassportNumber", userDetailPassportNumber);
        result.put("userDetailAddressLine", userDetailAddressLine);
        result.put("customerAddressCountry", userDetailAddressCountry);
        result.put("customerAddressCity", userDetailAddressCity);
        result.put("customerAddressDistrict", userDetailAddressDistrict);

        return result;
    }

    @Exclude
    public Map<String, Object> toMapDelete() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", EntityStatus.Delete);

        return result;
    }
}
