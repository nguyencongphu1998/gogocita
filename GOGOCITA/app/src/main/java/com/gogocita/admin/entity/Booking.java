package com.gogocita.admin.entity;

public class Booking {
    private int BookingID;
    private String Status;
    private int FK_CustomerID;
    private int FK_PartnerServiceDateID;
    private String BookingStatus;
    //private String BookingPaymentMethod;
    private String BookingComment;
    private int BookingEvalution;

    public Booking(int bookingID, String status, int FK_CustomerID, int FK_PartnerServiceDateID, String bookingStatus, String bookingComment, int bookingEvalution) {
        BookingID = bookingID;
        Status = status;
        this.FK_CustomerID = FK_CustomerID;
        this.FK_PartnerServiceDateID = FK_PartnerServiceDateID;
        BookingStatus = bookingStatus;
        BookingComment = bookingComment;
        BookingEvalution = bookingEvalution;
    }

    public int getBookingID() {
        return BookingID;
    }

    public void setBookingID(int bookingID) {
        BookingID = bookingID;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public int getFK_CustomerID() {
        return FK_CustomerID;
    }

    public void setFK_CustomerID(int FK_CustomerID) {
        this.FK_CustomerID = FK_CustomerID;
    }

    public int getFK_PartnerServiceDateID() {
        return FK_PartnerServiceDateID;
    }

    public void setFK_PartnerServiceDateID(int FK_PartnerServiceDateID) {
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
}
