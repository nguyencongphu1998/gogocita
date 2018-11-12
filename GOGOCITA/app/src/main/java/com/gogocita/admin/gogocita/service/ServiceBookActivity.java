package com.gogocita.admin.gogocita.service;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.view.View;

import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


import com.gogocita.admin.constant.EntityName;
import com.gogocita.admin.entity.PartnerService;
import com.gogocita.admin.gogocita.BaseMenuActivity;
import com.gogocita.admin.gogocita.ComingSoonActivity;
import com.gogocita.admin.gogocita.R;
import com.google.api.client.util.DateTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ServiceBookActivity extends BaseMenuActivity {
    EditText edt_CalanderCheckIn;
    EditText edt_CalanderCheckOut;
    ImageButton btn_CalanderCheckIn;
    ImageButton btn_CalanderCheckOut;
    EditText et_nameOfHomeStay;
    EditText et_priceOfHomeStay;
    EditText et_total;
    Button btn_book;
    Date checkin;
    Date checkout;
    PartnerService partnerService;

    @Override
    protected void init()
    {
        Intent intent = getIntent();
        partnerService = (PartnerService) intent.getSerializableExtra(EntityName.PartnerServices);
    }

    @Override
    protected void setWidget()
    {
        et_nameOfHomeStay.setText(partnerService.getPartnerServiceName());
        et_priceOfHomeStay.setText(partnerService.getPartnerServicePrice() + "");
    }

    @Override
    protected void getWidget()
    {
        edt_CalanderCheckIn = (EditText) findViewById(R.id.et_date_checkin);
        edt_CalanderCheckOut = (EditText) findViewById(R.id.et_date_checkout);
        btn_CalanderCheckIn = (ImageButton) findViewById(R.id.btn_calander_checkin);
        btn_CalanderCheckOut = (ImageButton) findViewById(R.id.btn_calander_checkout);
        et_nameOfHomeStay = (EditText) findViewById(R.id.et_homestay);
        et_priceOfHomeStay = (EditText) findViewById(R.id.et_price);
        et_total = (EditText) findViewById(R.id.et_total);
        btn_book = (Button) findViewById(R.id.btn_booknow);
    }

    @Override
    protected void addListener()
    {
        btn_CalanderCheckIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker(edt_CalanderCheckIn);
                btn_CalanderCheckOut.setClickable(true);
            }
        });

        btn_CalanderCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker(edt_CalanderCheckOut);


            }
        });

        btn_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),ComingSoonActivity.class));
                finish();
            }
        });
    }

    private void calculator()
    {
        if(edt_CalanderCheckIn.getText().toString().length() > 0 && edt_CalanderCheckOut.getText().toString().length() > 0){

            try{
                checkin = new SimpleDateFormat("dd/MM/yyyy").parse(edt_CalanderCheckIn.getText().toString());
                checkout = new SimpleDateFormat("dd/MM/yyyy").parse(edt_CalanderCheckOut.getText().toString());

                if(checkout.getTime() < checkin.getTime())
                {
                    Toast.makeText(getApplicationContext(),"Chọn ngày không hợp lệ",Toast.LENGTH_SHORT).show();
                }
                else {
                    Calendar c1 = Calendar.getInstance();
                    Calendar c2 = Calendar.getInstance();

                    c1.setTime(checkin);
                    c2.setTime(checkout);

                    long noDay = (c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);

                    et_total.setText((noDay * partnerService.getPartnerServicePrice()) + " VNĐ");
                }
            }catch (Exception ex)
            {
                Toast.makeText(getApplicationContext(),"Đã có lỗi xảy ra, vui lòng liên hệ với chúng tôi!!!",Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.form_book_homestay);
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
                calculator();
            }
        },year,month,date);
        datePickerDialog.show();
    }
}
