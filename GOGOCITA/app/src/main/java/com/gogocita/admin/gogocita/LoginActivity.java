package com.gogocita.admin.gogocita;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_partner);
    }

    public void btn_create(View v){
        Intent intent = new Intent(this, SingUpActivity.class);
        startActivity(intent);
    }

    public void btn_forgotpassword(View v){
        Intent intent = new Intent(this, ForgetPasswordActivity.class);
        startActivity(intent);
    }
}
