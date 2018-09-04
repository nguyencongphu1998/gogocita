package com.gogocita.admin.entity;

import java.util.Date;

public class Partner {
    private int ParnerID;

    public int getParnerID() {
        return ParnerID;
    }

    public void setParnerID(int parnerID) {
        ParnerID = parnerID;
    }

    public int getFK_UserID() {
        return FK_UserID;
    }

    public void setFK_UserID(int FK_UserID) {
        this.FK_UserID = FK_UserID;
    }

    public String getParnerType() {
        return ParnerType;
    }

    public void setParnerType(String parnerType) {
        ParnerType = parnerType;
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

    public String getPartneridnumber() {
        return Partneridnumber;
    }

    public void setPartneridnumber(String partneridnumber) {
        Partneridnumber = partneridnumber;
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

    private int FK_UserID;
    private String ParnerType;
    private Date PartnerBirthDay;
    private String PartnerJob;

    public Partner(int parnerID, int FK_UserID, String parnerType, Date partnerBirthDay, String partnerJob, String partnerPhone, String partnerGender, String partneridnumber, String partnerEmail, int FK_EmployeeID, String partnerAvatar, String partnerAddressLine, int FK_LocationCountryID, int FK_LocationCityID, int FK_LocationDistrictID, boolean partnerIsActive, String partnerName) {
        ParnerID = parnerID;
        this.FK_UserID = FK_UserID;
        ParnerType = parnerType;
        PartnerBirthDay = partnerBirthDay;
        PartnerJob = partnerJob;
        PartnerPhone = partnerPhone;
        PartnerGender = partnerGender;
        Partneridnumber = partneridnumber;
        PartnerEmail = partnerEmail;
        this.FK_EmployeeID = FK_EmployeeID;
        PartnerAvatar = partnerAvatar;
        PartnerAddressLine = partnerAddressLine;
        this.FK_LocationCountryID = FK_LocationCountryID;
        this.FK_LocationCityID = FK_LocationCityID;
        this.FK_LocationDistrictID = FK_LocationDistrictID;
        PartnerIsActive = partnerIsActive;
        PartnerName = partnerName;
    }

    private String PartnerPhone;
    private String PartnerGender;
    private String Partneridnumber;
    private String PartnerEmail;
    private int FK_EmployeeID;
    private String PartnerAvatar;
    private String PartnerAddressLine;
    private int FK_LocationCountryID;
    private int FK_LocationCityID;
    private int FK_LocationDistrictID;
    private boolean PartnerIsActive;
    private String PartnerName;

}
