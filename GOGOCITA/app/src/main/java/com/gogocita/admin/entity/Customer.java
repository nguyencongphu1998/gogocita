package com.gogocita.admin.entity;

import com.gogocita.admin.Constant.EntityStatus;
import com.gogocita.admin.helper.QueryFirebase;
import com.google.firebase.database.Exclude;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Customer {
    private String CustomerID;
    private String Status;
    private String FK_UserID;
    private String CustomerName;
    private Date CustomerBirthDay;
    private String CustomerPhone;
    private String CustomerGender;
    private String CustomerJob;
    private String CustomerNationality;
    private String CustomerPassportNumber;
    private String CustomerEmail;
    private String CustomerAvatar;
    private String CustomerAddressLine;
    private String CustomerAddressCountry;
    private String CustomerAddressCity;
    private String FK_EmployeeID;
    private boolean CustomerIsActive;
    private long CustomerAmount;

    public Customer(String status, String FK_UserID, String customerName, Date customerBirthDay, String customerPhone, String customerGender, String customerJob, String customerNationality, String customerPassportNumber, String customerEmail, String customerAvatar, String customerAddressLine, String customerAddressCountry, String customerAddressCity, String FK_EmployeeID, boolean customerIsActive, long customerAmount) {
        CustomerID = id();
        Status = status;
        this.FK_UserID = FK_UserID;
        CustomerName = customerName;
        CustomerBirthDay = customerBirthDay;
        CustomerPhone = customerPhone;
        CustomerGender = customerGender;
        CustomerJob = customerJob;
        CustomerNationality = customerNationality;
        CustomerPassportNumber = customerPassportNumber;
        CustomerEmail = customerEmail;
        CustomerAvatar = customerAvatar;
        CustomerAddressLine = customerAddressLine;
        CustomerAddressCountry = customerAddressCountry;
        CustomerAddressCity = customerAddressCity;
        this.FK_EmployeeID = FK_EmployeeID;
        CustomerIsActive = customerIsActive;
        CustomerAmount = customerAmount;
    }

    public Customer(String customerID, String status, String FK_UserID, String customerName, Date customerBirthDay, String customerPhone, String customerGender, String customerJob, String customerNationality, String customerPassportNumber, String customerEmail, String customerAvatar, String customerAddressLine, String customerAddressCountry, String customerAddressCity, String FK_EmployeeID, boolean customerIsActive, long customerAmount) {
        CustomerID = customerID;
        Status = status;
        this.FK_UserID = FK_UserID;
        CustomerName = customerName;
        CustomerBirthDay = customerBirthDay;
        CustomerPhone = customerPhone;
        CustomerGender = customerGender;
        CustomerJob = customerJob;
        CustomerNationality = customerNationality;
        CustomerPassportNumber = customerPassportNumber;
        CustomerEmail = customerEmail;
        CustomerAvatar = customerAvatar;
        CustomerAddressLine = customerAddressLine;
        CustomerAddressCountry = customerAddressCountry;
        CustomerAddressCity = customerAddressCity;
        this.FK_EmployeeID = FK_EmployeeID;
        CustomerIsActive = customerIsActive;
        CustomerAmount = customerAmount;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
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

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public Date getCustomerBirthDay() {
        return CustomerBirthDay;
    }

    public void setCustomerBirthDay(Date customerBirthDay) {
        CustomerBirthDay = customerBirthDay;
    }

    public String getCustomerPhone() {
        return CustomerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        CustomerPhone = customerPhone;
    }

    public String getCustomerGender() {
        return CustomerGender;
    }

    public void setCustomerGender(String customerGender) {
        CustomerGender = customerGender;
    }

    public String getCustomerJob() {
        return CustomerJob;
    }

    public void setCustomerJob(String customerJob) {
        CustomerJob = customerJob;
    }

    public String getCustomerNationality() {
        return CustomerNationality;
    }

    public void setCustomerNationality(String customerNationality) {
        CustomerNationality = customerNationality;
    }

    public String getCustomerPassportNumber() {
        return CustomerPassportNumber;
    }

    public void setCustomerPassportNumber(String customerPassportNumber) {
        CustomerPassportNumber = customerPassportNumber;
    }

    public String getCustomerEmail() {
        return CustomerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        CustomerEmail = customerEmail;
    }

    public String getCustomerAvatar() {
        return CustomerAvatar;
    }

    public void setCustomerAvatar(String customerAvatar) {
        CustomerAvatar = customerAvatar;
    }

    public String getCustomerAddressLine() {
        return CustomerAddressLine;
    }

    public void setCustomerAddressLine(String customerAddressLine) {
        CustomerAddressLine = customerAddressLine;
    }

    public String getCustomerAddressCountry() {
        return CustomerAddressCountry;
    }

    public void setCustomerAddressCountry(String customerAddressCountry) {
        CustomerAddressCountry = customerAddressCountry;
    }

    public String getCustomerAddressCity() {
        return CustomerAddressCity;
    }

    public void setCustomerAddressCity(String customerAddressCity) {
        CustomerAddressCity = customerAddressCity;
    }

    public String getFK_EmployeeID() {
        return FK_EmployeeID;
    }

    public void setFK_EmployeeID(String FK_EmployeeID) {
        this.FK_EmployeeID = FK_EmployeeID;
    }

    public boolean isCustomerIsActive() {
        return CustomerIsActive;
    }

    public void setCustomerIsActive(boolean customerIsActive) {
        CustomerIsActive = customerIsActive;
    }

    public long getCustomerAmount() {
        return CustomerAmount;
    }

    public void setCustomerAmount(long customerAmount) {
        CustomerAmount = customerAmount;
    }

    public String id() {
        QueryFirebase firebase = new QueryFirebase("Customers");
        return firebase.getNewKey();
    }

    @Override
    public String toString() {
        return "Customers";
    }

    @Exclude
    public Map<String, Object> toMapUpdate() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", Status);
        result.put("fK_UserID", FK_UserID);
        result.put("customerName", CustomerName);
        result.put("customerBirthDay", CustomerBirthDay);
        result.put("customerPhone", CustomerPhone);
        result.put("customerGender", CustomerGender);
        result.put("customerJob", CustomerJob);
        result.put("customerNationality", CustomerNationality);
        result.put("customerPassportNumber", CustomerPassportNumber);
        result.put("customerEmail", CustomerEmail);
        result.put("customerAvatar", CustomerAvatar);
        result.put("customerAddressCountry", CustomerAddressCountry);
        result.put("fK_EmployeeID", FK_EmployeeID);
        result.put("customerAmount", CustomerAmount);
        result.put("customerIsActive", CustomerIsActive);

        return result;
    }

    @Exclude
    public Map<String, Object> toMapDelete() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", EntityStatus.Delete);

        return result;
    }
}
