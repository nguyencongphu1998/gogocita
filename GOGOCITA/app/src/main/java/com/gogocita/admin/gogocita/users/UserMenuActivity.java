package com.gogocita.admin.gogocita.users;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.gogocita.admin.constant.EntityName;
import com.gogocita.admin.controllers.service.ServiceController;
import com.gogocita.admin.controllers.user.UserDetailsController;
import com.gogocita.admin.controllers.user.UsersController;
import com.gogocita.admin.entity.UserDetail;
import com.gogocita.admin.gogocita.R;
import com.gogocita.admin.gogocita.service.CreateNewServiceActivity;
import com.gogocita.admin.gogocita.service.ServicesActivity;
import com.gogocita.admin.gogocita.service.Step1Activity;
import com.gogocita.admin.helper.FirebaseListAdapter;
import com.gogocita.admin.helper.QueryFirebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class UserMenuActivity extends AppCompatActivity{
    private UserDetailsController userDetailsController;
    private ServiceController serviceController;
    private ProgressBar progressBar;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_user);
        progressBar = (ProgressBar)  findViewById(R.id.progressBar_userMenu);
        userDetailsController = UserDetailsController.getInstance(this,progressBar);
        serviceController = ServiceController.getInstance(this,progressBar);
    }

    public void gotoDashboard(View v){
        startActivity(new Intent(this,ServicesActivity.class));
        finish();
    }

    public void myProfile(View v){
        progressBar.setVisibility(View.VISIBLE);
        userDetailsController.getUserDetail(UserDetailActivity.class);
    }

    public void changePassword(View v){
        startActivity(new Intent(this, ChangePasswordActivity.class));
        finish();
    }

    public void updateMyProfile(View v){
        progressBar.setVisibility(View.VISIBLE);
        userDetailsController.getUserDetail(UpdateUserDetailActivity.class);
    }

    public void nextStep1(View v){
        progressBar.setVisibility(View.VISIBLE);
        serviceController.getServiceDetail(CreateNewServiceActivity.class);
    }

    public void singOut(View v){
        UsersController usersController = UsersController.getInstance(this,null);
        usersController.signOut();
    }
}
