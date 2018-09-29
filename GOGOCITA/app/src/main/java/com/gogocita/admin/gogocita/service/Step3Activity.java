package com.gogocita.admin.gogocita.service;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gogocita.admin.gogocita.R;
import com.gogocita.admin.gogocita.users.LoginActivity;

public class Step3Activity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step3home_stay);
    }

    public void nextStep4(View v){
        startActivity(new Intent(this,Step4Activity.class));
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,Step2Activity.class));
        finish();
    }
}
