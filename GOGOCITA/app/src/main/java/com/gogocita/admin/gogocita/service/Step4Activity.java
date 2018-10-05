package com.gogocita.admin.gogocita.service;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gogocita.admin.gogocita.R;

public class Step4Activity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step4home_stay);
    }

    public void createNewService(View v){
        startActivity(new Intent(this,CreateNewServiceActivity.class));
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,Step3Activity.class));
        finish();
    }
}
