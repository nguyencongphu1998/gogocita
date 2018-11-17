package com.gogocita.admin.helper;

import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {
    private CheckedTextView checkedTextViewSpinner;
    private TextView textViewServiceName;
    private TextView textViewServiceEvalution;
    private TextView textViewServiceDescription;
    private ImageView imageViewServiceCoverPhoto;
    private ImageView imageViewContentOfHomeStay;

    public ViewHolder(){

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
