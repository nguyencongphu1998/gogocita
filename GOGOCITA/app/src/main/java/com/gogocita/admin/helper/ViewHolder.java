package com.gogocita.admin.helper;

import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ViewHolder {
    private CheckedTextView checkedTextViewSpinner;
    private TextView textViewServiceName;
    private TextView textViewServiceEvalution;
    private TextView textViewServiceDescription;
    private ImageView imageViewServiceCoverPhoto;
    private ImageView imageViewContentOfHomeStay;
    private TextView textViewBookNameOfHomeStay;
    private TextView textViewBookCheckIn;
    private TextView textViewBookCheckOut;
    private TextView textViewBookStatus;
    private TextView textViewBookAddress;
    private LinearLayout linearLayoutBook;

    public ViewHolder(){

    }

    public LinearLayout getLinearLayoutBook() {
        return linearLayoutBook;
    }

    public void setLinearLayoutBook(LinearLayout linearLayoutBook) {
        this.linearLayoutBook = linearLayoutBook;
    }

    public TextView getTextViewBookNameOfHomeStay() {
        return textViewBookNameOfHomeStay;
    }

    public void setTextViewBookNameOfHomeStay(TextView textViewBookNameOfHomeStay) {
        this.textViewBookNameOfHomeStay = textViewBookNameOfHomeStay;
    }

    public TextView getTextViewBookCheckIn() {
        return textViewBookCheckIn;
    }

    public void setTextViewBookCheckIn(TextView textViewBookCheckIn) {
        this.textViewBookCheckIn = textViewBookCheckIn;
    }

    public TextView getTextViewBookCheckOut() {
        return textViewBookCheckOut;
    }

    public void setTextViewBookCheckOut(TextView textViewBookCheckOut) {
        this.textViewBookCheckOut = textViewBookCheckOut;
    }

    public TextView getTextViewBookStatus() {
        return textViewBookStatus;
    }

    public void setTextViewBookStatus(TextView textViewBookStatus) {
        this.textViewBookStatus = textViewBookStatus;
    }

    public TextView getTextViewBookAddress() {
        return textViewBookAddress;
    }

    public void setTextViewBookAddress(TextView textViewBookAddress) {
        this.textViewBookAddress = textViewBookAddress;
    }

    public ImageView getImageViewContentOfHomeStay() {
        return imageViewContentOfHomeStay;
    }

    public void setImageViewContentOfHomeStay(ImageView imageViewContentOfHomeStay) {
        this.imageViewContentOfHomeStay = imageViewContentOfHomeStay;
    }

    public CheckedTextView getCheckedTextViewSpinner() {
        return checkedTextViewSpinner;
    }

    public void setCheckedTextViewSpinner(CheckedTextView checkedTextViewSpinner) {
        this.checkedTextViewSpinner = checkedTextViewSpinner;
    }

    public TextView getTextViewServiceName() {
        return textViewServiceName;
    }

    public void setTextViewServiceName(TextView textViewServiceName) {
        this.textViewServiceName = textViewServiceName;
    }

    public TextView getTextViewServiceEvalution() {
        return textViewServiceEvalution;
    }

    public void setTextViewServiceEvalution(TextView textViewServiceEvalution) {
        this.textViewServiceEvalution = textViewServiceEvalution;
    }

    public TextView getTextViewServiceDescription() {
        return textViewServiceDescription;
    }

    public void setTextViewServiceDescription(TextView textViewServiceDescription) {
        this.textViewServiceDescription = textViewServiceDescription;
    }

    public ImageView getImageViewServiceCoverPhoto() {
        return imageViewServiceCoverPhoto;
    }

    public void setImageViewServiceCoverPhoto(ImageView imageViewServiceCoverPhoto) {
        this.imageViewServiceCoverPhoto = imageViewServiceCoverPhoto;
    }
}
