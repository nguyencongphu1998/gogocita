package com.gogocita.admin.entity;

import java.util.Date;

public class Customer {
    private int CustomerID;
    private String Status;
    private int FK_UserID;
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
    private int FK_EmployeeID;

    public Customer(int customerID, String status, int FK_UserID, String customerName, Date customerBirthDay, String customerPhone, String customerGender, String customerJob, String customerNationality, String customerPassportNumber, String customerEmail, String customerAvatar, String customerAddressLine, String customerAddressCountry, String customerAddressCity, int FK_EmployeeID, boolean customerIsActive) {
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
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public int getFK_UserID() {
        return FK_UserID;
    }

    public void setFK_UserID(int FK_UserID) {
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

    public int getFK_EmployeeID() {
        return FK_EmployeeID;
    }

    public void setFK_EmployeeID(int FK_EmployeeID) {
        this.FK_EmployeeID = FK_EmployeeID;
    }

    public boolean isCustomerIsActive() {
        return CustomerIsActive;
    }

    public void setCustomerIsActive(boolean customerIsActive) {
        CustomerIsActive = customerIsActive;
    }

    private boolean CustomerIsActive;

}
