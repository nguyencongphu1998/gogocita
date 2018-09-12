package com.gogocita.admin.entity;

import com.gogocita.admin.constant.EntityName;
import com.gogocita.admin.constant.EntityStatus;
import com.gogocita.admin.helper.QueryFirebase;
import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Booking {
    private String bookingID;
    private String status;
    private String fK_CustomerID;
    private String fK_PartnerServiceDateID;
    private String bookingStatus;
    private String bookingComment;
    private int bookingEvalution;

    public Booking() {
    }

    public Booking(String fK_CustomerID, String fK_PartnerServiceDateID, String bookingStatus, String bookingComment, int bookingEvalution) {
        this.bookingID = generateId();
        this.status = EntityStatus.Alive;
        this.fK_CustomerID = fK_CustomerID;
        this.fK_PartnerServiceDateID = fK_PartnerServiceDateID;
        this.bookingStatus = bookingStatus;
        this.bookingComment = bookingComment;
        this.bookingEvalution = bookingEvalution;
    }

    public Booking(String bookingID, String status, String fK_CustomerID, String fK_PartnerServiceDateID, String bookingStatus, String bookingComment, int bookingEvalution) {
        this.bookingID = bookingID;
        this.status = status;
        this.fK_CustomerID = fK_CustomerID;
        this.fK_PartnerServiceDateID = fK_PartnerServiceDateID;
        this.bookingStatus = bookingStatus;
        this.bookingComment = bookingComment;
        this.bookingEvalution = bookingEvalution;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getfK_CustomerID() {
        return fK_CustomerID;
    }

    public void setfK_CustomerID(String fK_CustomerID) {
        this.fK_CustomerID = fK_CustomerID;
    }

    public String getfK_PartnerServiceDateID() {
        return fK_PartnerServiceDateID;
    }

    public void setfK_PartnerServiceDateID(String fK_PartnerServiceDateID) {
        this.fK_PartnerServiceDateID = fK_PartnerServiceDateID;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getBookingComment() {
        return bookingComment;
    }

    public void setBookingComment(String bookingComment) {
        this.bookingComment = bookingComment;
    }

    public int getBookingEvalution() {
        return bookingEvalution;
    }

    public void setBookingEvalution(int bookingEvalution) {
        this.bookingEvalution = bookingEvalution;
    }

    public String generateId() {
        QueryFirebase firebase = new QueryFirebase(EntityName.Bookings);
        return firebase.getNewKey();
    }

    @Exclude
    public Map<String, Object> toMapUpdate() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", status);
        result.put("fK_CustomerID", fK_CustomerID);
        result.put("bookingStatus", bookingStatus);
        result.put("bookingComment", bookingComment);
        result.put("bookingEvalution", bookingEvalution);

        return result;
    }

    @Exclude
    public Map<String, Object> toMapDelete() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", EntityStatus.Delete);

        return result;
    }
}
