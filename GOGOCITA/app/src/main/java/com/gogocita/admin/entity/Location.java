package com.gogocita.admin.entity;

public class Location {
    private String LocationID;
    private String LocationType;
    private String LocationName;
    public Location(String locationID, String locationType, String locationName) {
        LocationID = locationID;
        LocationType = locationType;
        LocationName = locationName;
    }

    public String getLocationID() {
        return LocationID;
    }

    public void setLocationID(String locationID) {
        LocationID = locationID;
    }

    public String getLocationType() {
        return LocationType;
    }

    public void setLocationType(String locationType) {
        LocationType = locationType;
    }

    public String getLocationName() {
        return LocationName;
    }

    public void setLocationName(String locationName) {
        LocationName = locationName;
    }
}
