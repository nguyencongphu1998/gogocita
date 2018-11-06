package com.gogocita.admin.gogocita.users;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.gogocita.admin.constant.EntityName;
import com.gogocita.admin.controllers.user.UserDetailsController;
import com.gogocita.admin.controllers.user.UsersController;
import com.gogocita.admin.entity.UserDetail;
import com.gogocita.admin.gogocita.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.text.SimpleDateFormat;


public class UserDetailActivity extends AppCompatActivity {
    private TextView tv_firstName;
    private TextView tv_lastName;
    private TextView tv_birthDay;
    private TextView tv_phone;
    private TextView tv_gender;
    private TextView tv_job;
    private TextView tv_idnumber;
    private TextView tv_address;
    private TextView tv_country;
    private TextView tv_city;
    private TextView tv_district;
    private UserDetailsController userDetailsController;
    private Button btnUpdate;
    private ProgressBar progressBar;
    private UserDetail userDetail;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userdetail);

        init();
        getWidget();
        setWidget();
        addListener();
    }

    private void init()
    {
        Intent intent = getIntent();
        userDetail = (UserDetail) intent.getSerializableExtra(EntityName.UserDetails);
    }

    private void getWidget()
    {
        progressBar = findViewById(R.id.progressBar_userDetail);
        btnUpdate = (Button) findViewById(R.id.button_updateuser);
        tv_firstName = (TextView) findViewById(R.id.textview_firstname);
        tv_lastName = (TextView) findViewById(R.id.textview_lastname);
        tv_birthDay = (TextView) findViewById(R.id.textview_birthday);
        tv_phone = (TextView) findViewById(R.id.textview_phone);
        tv_gender = (TextView) findViewById(R.id.textview_gender);
        tv_job = (TextView) findViewById(R.id.textview_job);
        tv_idnumber = (TextView) findViewById(R.id.textview_idnumber);
        tv_address = (TextView) findViewById(R.id.textview_address);
        tv_country = (TextView) findViewById(R.id.textview_country);
        tv_city = (TextView) findViewById(R.id.textview_city);
        tv_district = (TextView) findViewById(R.id.textview_district);
    }

    private void setWidget()
    {
        userDetailsController = UserDetailsController.getInstance(this,progressBar);
        tv_firstName.setText(userDetail.getUserDetailFirstName());
        tv_lastName.setText(userDetail.getUserDetailLastName());
        tv_birthDay.setText(new SimpleDateFormat("MM-dd-yyyy").format(userDetail.getUserDetailBirthDay()));
        tv_phone.setText(userDetail.getUserDetailPhone());
        tv_gender.setText(userDetail.getUserDetailGender());
        tv_job.setText(userDetail.getUserDetailJob());
        tv_idnumber.setText(userDetail.getUserDetailPassportNumber());
        tv_address.setText(userDetail.getUserDetailAddressLine());
        tv_country.setText(userDetail.getUserDetailAddressCountry());
        tv_city.setText(userDetail.getUserDetailAddressCity());
        tv_district.setText(userDetail.getUserDetailAddressDistrict());
    }

    private void addListener()
    {
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userDetailsController.getUserDetail(UpdateUserDetailActivity.class);
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,UserMenuActivity.class));
        finish();
    }

}
