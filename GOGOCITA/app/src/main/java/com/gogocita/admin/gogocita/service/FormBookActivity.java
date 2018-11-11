package com.gogocita.admin.gogocita.service;

import android.app.DatePickerDialog;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;


import com.gogocita.admin.gogocita.R;

import java.util.Calendar;

public class FormBookActivity extends AppCompatActivity {
    EditText edt_CalanderCheckIn;
    EditText edt_CalanderCheckOut;
    ImageButton btn_CalanderCheckIn;
    ImageButton btn_CalanderCheckOut;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_book_homestay);
        getWidget();
        setWidget();
        addListener();
    }

    private void setWidget() {

    }

    private void getWidget() {
        edt_CalanderCheckIn = (EditText) findViewById(R.id.et_date_checkin);
        edt_CalanderCheckOut = (EditText) findViewById(R.id.et_date_checkout);
        btn_CalanderCheckIn = (ImageButton) findViewById(R.id.btn_calander_checkin);
        btn_CalanderCheckOut = (ImageButton) findViewById(R.id.btn_calander_checkout);
    }
    private void addListener()
    {
        btn_CalanderCheckIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker(edt_CalanderCheckIn);
            }
        });

        btn_CalanderCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker(edt_CalanderCheckOut);
            }
        });
    }
    private void datePicker(final EditText edt){
        final Calendar cal = Calendar.getInstance();
        final int date = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                cal.set(year,month,dayOfMonth);
                edt.setText(cal.get(Calendar.DATE) + "/" +(cal.get(Calendar.MONTH)+1) +"/"+ cal.get(Calendar.YEAR));
            }
        },year,month,date);
        datePickerDialog.show();
    }
}
