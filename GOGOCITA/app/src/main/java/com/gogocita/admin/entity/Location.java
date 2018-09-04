package com.gogocita.admin.entity;

public class Location {
    private int LocationID;

    public Location(int locationID, String locationType, String locationName, int FK_LocationParentID) {
        LocationID = locationID;
        LocationType = locationType;
        LocationName = locationName;
        this.FK_LocationParentID = FK_LocationParentID;
    }

    public int getLocationID() {
        return LocationID;
    }

    public void setLocationID(int locationID) {
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

    public int getFK_LocationParentID() {
        return FK_LocationParentID;
    }

    public void setFK_LocationParentID(int FK_LocationParentID) {
        this.FK_LocationParentID = FK_LocationParentID;
    }

    private String LocationType;
    private String LocationName;
    private int FK_LocationParentID;

}
