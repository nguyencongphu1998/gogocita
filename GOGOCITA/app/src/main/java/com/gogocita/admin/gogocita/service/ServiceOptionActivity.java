package com.gogocita.admin.gogocita.service;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gogocita.admin.gogocita.CommingSoonActivity;
import com.gogocita.admin.gogocita.R;
import com.gogocita.admin.gogocita.users.UserMenuActivity;

public class ServiceOptionActivity extends AppCompatActivity{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_services);
    }

    public void btnTourisGuid(View v)
    {
        startActivity(new Intent(getApplicationContext(),CommingSoonActivity.class));
    }

    public void btnHomeStay(View v)
    {
        startActivity(new Intent(getApplicationContext(),UserMenuActivity.class));
    }
}
