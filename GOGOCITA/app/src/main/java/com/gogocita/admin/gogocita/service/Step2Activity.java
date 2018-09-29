package com.gogocita.admin.gogocita.service;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gogocita.admin.gogocita.R;
import com.gogocita.admin.gogocita.users.LoginActivity;

public class Step2Activity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step2home_stay);
    }

    public void nextStep3(View v){
        startActivity(new Intent(this,Step3Activity.class));
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,Step1Activity.class));
        finish();
    }
}
