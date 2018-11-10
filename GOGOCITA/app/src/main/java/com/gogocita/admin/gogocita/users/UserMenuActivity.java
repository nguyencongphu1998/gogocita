package com.gogocita.admin.gogocita.users;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

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
    private Button btnDashBoard;
    private Button btnMyProfile;
    private Button btnUpdateMyProfile;
    private Button btnSeeCalendar;
    private Button btnHistory;
    private Button btnChangePassWord;
    private Button btnSignOut;
    private Button btnCreateMyService;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_user);
        progressBar = (ProgressBar)  findViewById(R.id.progressBar_userMenu);
        userDetailsController = UserDetailsController.getInstance(this,progressBar);
        serviceController = ServiceController.getInstance(this,progressBar);
        getWidget();
        myButtonEven();
    }

    public void gotoDashboard(View v){
        startActivity(new Intent(this, ServicesActivity.class));
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

    public void singOut(){
        UsersController usersController = UsersController.getInstance(this,null);
        usersController.signOut();
    }
    private void getWidget()  {
        btnDashBoard = (Button) findViewById(R.id.btn_dashboard);
        btnMyProfile = (Button) findViewById(R.id.btn_myprofile);
        btnUpdateMyProfile= (Button) findViewById(R.id.btn_updatemyprofile);
        btnCreateMyService = (Button) findViewById(R.id.btncreatemyservice);
        btnChangePassWord = (Button) findViewById(R.id.btn_changpassword);
        btnSeeCalendar = (Button) findViewById(R.id.btn_seecalender);
        btnHistory = (Button) findViewById(R.id.btn_history);
        btnSignOut = (Button) findViewById(R.id.btn_signout);
    }
    public void myButtonEven(){
        btnDashBoard.setOnClickListener(new MyButtonEven());
        btnMyProfile.setOnClickListener(new MyButtonEven());
        btnUpdateMyProfile.setOnClickListener(new MyButtonEven());
        btnCreateMyService.setOnClickListener(new MyButtonEven());
        btnSeeCalendar.setOnClickListener(new MyButtonEven());
        btnChangePassWord.setOnClickListener(new MyButtonEven());
        btnHistory.setOnClickListener(new MyButtonEven());
        btnSignOut.setOnClickListener(new MyButtonEven());
    }
    public void showAlertDialog(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("GOGOCITA");
        builder.setMessage("Do you want signout?");
        builder.setCancelable(false);
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                singOut();
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                builder.setCancelable(true);
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
    class MyButtonEven implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_dashboard:
                    gotoDashboard(v);
                    break;
                case R.id.btn_myprofile:
                    myProfile(v);
                    break;
                case R.id.btn_updatemyprofile:
                    updateMyProfile(v);
                    break;
                case R.id.btncreatemyservice:
                    nextStep1(v);
                    break;
                case R.id.btn_seecalender:
                    break;
                case R.id.btn_changpassword:
                    changePassword(v);
                    break;
                case R.id.btn_history:
                    break;
                case R.id.btn_signout:
                    showAlertDialog();
                    break;

            }
        }
    }
}
