package com.gogocita.admin.gogocita.service;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gogocita.admin.controllers.user.UsersController;

import com.gogocita.admin.gogocita.ComingSoonActivity;
import com.gogocita.admin.gogocita.R;


public class ServiceOptionActivity extends AppCompatActivity{
    private UsersController usersController;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_services);
        usersController = UsersController.getInstance(this,null);
    }

    public void btnTourisGuid(View v)
    {
        startActivity(new Intent(getApplicationContext(),ComingSoonActivity.class));
    }

    public void btnHomeStay(View v)
    {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                startActivity(new Intent(getApplicationContext(),ServicesActivity.class));
            }
            }, 1000);
    }

    @Override
    public void onStart() {
        super.onStart();

        usersController.checkAuthorizeLogin();
    }
}
