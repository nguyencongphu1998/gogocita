package com.gogocita.admin.gogocita.users;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gogocita.admin.controllers.user.UsersController;
import com.gogocita.admin.gogocita.R;
import com.gogocita.admin.gogocita.service.Step1Activity;

public class UserMenuActivity extends AppCompatActivity{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_user);
    }

    public void myProfile(View v){
        startActivity(new Intent(this, UserDetailActivity.class));
        finish();
    }

    public void changePassword(View v){
        startActivity(new Intent(this, ChangePasswordActivity.class));
        finish();
    }

    public void updateMyProfile(View v){
        startActivity(new Intent(this, UpdateUserDetailActivity.class));
        finish();
    }

    public void nextStep1(View v){
        startActivity(new Intent(this, Step1Activity.class));
        finish();
    }

    public void singOut(View v){
        UsersController usersController = UsersController.getInstance(this,null);
        usersController.signOut();
    }
}
