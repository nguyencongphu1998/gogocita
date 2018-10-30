package com.gogocita.admin.entity;

import com.gogocita.admin.constant.EntityName;

public class Location extends GenerateId {
    private String locationID;
    private String locationType;
    private String locationName;

    public Location() {
    }

    public Location(String locationID, String locationType, String locationName) {
        this.locationID = locationID;
        this.locationType = locationType;
        this.locationName = locationName;
    }

    public Location(String locationType, String locationName) {
        this.locationID = generateId(EntityName.Locations);
        this.locationType = locationType;
        this.locationName = locationName;
    }

    public String getLocationID() {
        return locationID;
    }

    public void setLocationID(String locationID) {
        this.locationID = locationID;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
