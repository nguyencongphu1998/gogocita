package com.gogocita.admin.gogocita;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ForgetPasswordActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_password);
    }

    public void btn_create(View v){
        Intent intent = new Intent(this, SingUpActivity.class);
        startActivity(intent);
    }
}
