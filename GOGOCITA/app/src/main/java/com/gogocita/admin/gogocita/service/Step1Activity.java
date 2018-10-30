package com.gogocita.admin.gogocita.service;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gogocita.admin.gogocita.R;
import com.gogocita.admin.gogocita.users.LoginActivity;
import com.gogocita.admin.gogocita.users.UserMenuActivity;

public class Step1Activity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step1home_stay);
    }

    public void nextStep2(View v){
        startActivity(new Intent(this,Step2Activity.class));
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,UserMenuActivity.class));
        finish();
    }
}
