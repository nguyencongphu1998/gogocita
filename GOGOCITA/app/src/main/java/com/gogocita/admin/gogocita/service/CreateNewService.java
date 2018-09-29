package com.gogocita.admin.gogocita.service;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gogocita.admin.gogocita.R;

public class CreateNewService extends AppCompatActivity{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createnewservice);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,Step4Activity.class));
        finish();
    }
}
