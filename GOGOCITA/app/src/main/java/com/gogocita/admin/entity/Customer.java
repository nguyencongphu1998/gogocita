package com.gogocita.admin.entity;

import com.gogocita.admin.constant.EntityName;
import com.gogocita.admin.constant.EntityStatus;
import com.google.firebase.database.Exclude;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Customer extends GenerateId{
    private String customerID;
    private String status;
    private String fk_UserID;
    private String customerName;
    private Date customerBirthDay;
    private String customerPhone;
    private String customerGender;
    private String customerJob;
    private String customerNationality;
    private String customerPassportNumber;
    private String customerEmail;
    private String customerAvatar;
    private String customerAddressLine;
    private String customerAddressCountry;
    private String customerAddressCity;
    private String fk_EmployeeID;
    private boolean customerIsActive;
    private long customerAmount;

    public Customer() {
    }

    public Customer(String fk_UserID, String customerName, Date customerBirthDay, String customerPhone, String customerGender, String customerJob, String customerNationality, String customerPassportNumber, String customerEmail, String customerAvatar, String customerAddressLine, String customerAddressCountry, String customerAddressCity, String fk_EmployeeID, boolean customerIsActive, long customerAmount) {
        this.customerID = generateId(EntityName.Customers);
        this.status = EntityStatus.Alive;
        this.fk_UserID = fk_UserID;
        this.customerName = customerName;
        this.customerBirthDay = customerBirthDay;
        this.customerPhone = customerPhone;
        this.customerGender = customerGender;
        this.customerJob = customerJob;
        this.customerNationality = customerNationality;
        this.customerPassportNumber = customerPassportNumber;
        this.customerEmail = customerEmail;
        this.customerAvatar = customerAvatar;
        this.customerAddressLine = customerAddressLine;
        this.customerAddressCountry = customerAddressCountry;
        this.customerAddressCity = customerAddressCity;
        this.fk_EmployeeID = fk_EmployeeID;
        this.customerIsActive = customerIsActive;
        this.customerAmount = customerAmount;
    }

    public Customer(String customerID, String status, String fk_UserID, String customerName, Date customerBirthDay, String customerPhone, String customerGender, String customerJob, String customerNationality, String customerPassportNumber, String customerEmail, String customerAvatar, String customerAddressLine, String customerAddressCountry, String customerAddressCity, String fk_EmployeeID, boolean customerIsActive, long customerAmount) {
        this.customerID = customerID;
        this.status = status;
        this.fk_UserID = fk_UserID;
        this.customerName = customerName;
        this.customerBirthDay = customerBirthDay;
        this.customerPhone = customerPhone;
        this.customerGender = customerGender;
        this.customerJob = customerJob;
        this.customerNationality = customerNationality;
        this.customerPassportNumber = customerPassportNumber;
        this.customerEmail = customerEmail;
        this.customerAvatar = customerAvatar;
        this.customerAddressLine = customerAddressLine;
        this.customerAddressCountry = customerAddressCountry;
        this.customerAddressCity = customerAddressCity;
        this.fk_EmployeeID = fk_EmployeeID;
        this.customerIsActive = customerIsActive;
        this.customerAmount = customerAmount;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getCustomerBirthDay() {
        return customerBirthDay;
    }

    public void setCustomerBirthDay(Date customerBirthDay) {
        this.customerBirthDay = customerBirthDay;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerJob() {
        return customerJob;
    }

    public void setCustomerJob(String customerJob) {
        this.customerJob = customerJob;
    }

    public String getCustomerNationality() {
        return customerNationality;
    }

    public void setCustomerNationality(String customerNationality) {
        this.customerNationality = customerNationality;
    }

    public String getCustomerPassportNumber() {
        return customerPassportNumber;
    }

    public void setCustomerPassportNumber(String customerPassportNumber) {
        this.customerPassportNumber = customerPassportNumber;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAvatar() {
        return customerAvatar;
    }

    public void setCustomerAvatar(String customerAvatar) {
        this.customerAvatar = customerAvatar;
    }

    public String getCustomerAddressLine() {
        return customerAddressLine;
    }

    public void setCustomerAddressLine(String customerAddressLine) {
        this.customerAddressLine = customerAddressLine;
    }

    public String getCustomerAddressCountry() {
        return customerAddressCountry;
    }

    public void setCustomerAddressCountry(String customerAddressCountry) {
        this.customerAddressCountry = customerAddressCountry;
    }

    public String getCustomerAddressCity() {
        return customerAddressCity;
    }

    public void setCustomerAddressCity(String customerAddressCity) {
        this.customerAddressCity = customerAddressCity;
    }

    public String getFk_EmployeeID() {
        return fk_EmployeeID;
    }

    public void setFk_EmployeeID(String fk_EmployeeID) {
        this.fk_EmployeeID = fk_EmployeeID;
    }

    public boolean isCustomerIsActive() {
        return customerIsActive;
    }

    public void setCustomerIsActive(boolean customerIsActive) {
        this.customerIsActive = customerIsActive;
    }

    public long getCustomerAmount() {
        return customerAmount;
    }

    public void setCustomerAmount(long customerAmount) {
        this.customerAmount = customerAmount;
    }

    @Exclude
    public Map<String, Object> toMapUpdate() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", status);
        result.put("fK_UserID", fk_UserID);
        result.put("customerName", customerName);
        result.put("customerBirthDay", customerBirthDay);
        result.put("customerPhone", customerPhone);
        result.put("customerGender", customerGender);
        result.put("customerJob", customerJob);
        result.put("customerNationality", customerNationality);
        result.put("customerPassportNumber", customerPassportNumber);
        result.put("customerEmail", customerEmail);
        result.put("customerAvatar", customerAvatar);
        result.put("customerAddressCountry", customerAddressCountry);
        result.put("fK_EmployeeID", fk_EmployeeID);
        result.put("customerAmount", customerAmount);
        result.put("customerIsActive", customerIsActive);

        return result;
    }

    @Exclude
    public Map<String, Object> toMapDelete() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", EntityStatus.Delete);

        return result;
    }
}
