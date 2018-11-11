package com.gogocita.admin.gogocita;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gogocita.admin.gogocita.service.ServicesActivity;

public class ComingSoonActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comming_soon);
    }

    public void goToDashBoard(View v){
        startActivity(new Intent(this,ServicesActivity.class));
        finish();
    }
}
