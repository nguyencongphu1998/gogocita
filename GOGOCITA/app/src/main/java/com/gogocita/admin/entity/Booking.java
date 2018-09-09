package com.gogocita.admin.entity;

import com.gogocita.admin.Constant.EntityStatus;
import com.gogocita.admin.helper.QueryFirebase;
import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Booking {
    private String BookingID;
    private String Status;
    private String FK_CustomerID;
    private String FK_PartnerServiceDateID;
    private String BookingStatus;
    //private String BookingPaymentMethod;
    private String BookingComment;
    private int BookingEvalution;

    public Booking(String bookingID, String status, String FK_CustomerID, String FK_PartnerServiceDateID, String bookingStatus, String bookingComment, int bookingEvalution) {
        BookingID = bookingID;
        Status = status;
        this.FK_CustomerID = FK_CustomerID;
        this.FK_PartnerServiceDateID = FK_PartnerServiceDateID;
        BookingStatus = bookingStatus;
        BookingComment = bookingComment;
        BookingEvalution = bookingEvalution;
    }

    public Booking(String status, String FK_CustomerID, String FK_PartnerServiceDateID, String bookingStatus, String bookingComment, int bookingEvalution) {
        BookingID = id();
        Status = status;
        this.FK_CustomerID = FK_CustomerID;
        this.FK_PartnerServiceDateID = FK_PartnerServiceDateID;
        BookingStatus = bookingStatus;
        BookingComment = bookingComment;
        BookingEvalution = bookingEvalution;
    }

    public String getBookingID() {
        return BookingID;
    }

    public void setBookingID(String bookingID) {
        BookingID = bookingID;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getFK_CustomerID() {
        return FK_CustomerID;
    }

    public void setFK_CustomerID(String FK_CustomerID) {
        this.FK_CustomerID = FK_CustomerID;
    }

    public String getFK_PartnerServiceDateID() {
        return FK_PartnerServiceDateID;
    }

    public void setFK_PartnerServiceDateID(String FK_PartnerServiceDateID) {
        this.FK_PartnerServiceDateID = FK_PartnerServiceDateID;
    }

    public String getBookingStatus() {
        return BookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        BookingStatus = bookingStatus;
    }

    public String getBookingComment() {
        return BookingComment;
    }

    public void setBookingComment(String bookingComment) {
        BookingComment = bookingComment;
    }

    public int getBookingEvalution() {
        return BookingEvalution;
    }

    public void setBookingEvalution(int bookingEvalution) {
        BookingEvalution = bookingEvalution;
    }

    public String id() {
        QueryFirebase firebase = new QueryFirebase("Bookings");
        return firebase.getNewKey();
    }

    @Override
    public String toString() {
        return "Bookings";
    }

    @Exclude
    public Map<String, Object> toMapUpdate() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", Status);
        result.put("fK_CustomerID", FK_CustomerID);
        result.put("bookingStatus", BookingStatus);
        result.put("bookingComment", BookingComment);
        result.put("bookingEvalution", BookingEvalution);

        return result;
    }

    @Exclude
    public Map<String, Object> toMapDelete() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", EntityStatus.Delete);

        return result;
    }
}
