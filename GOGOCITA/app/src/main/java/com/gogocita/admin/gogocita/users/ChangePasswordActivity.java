package com.gogocita.admin.gogocita.users;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.gogocita.admin.controllers.user.UsersController;
import com.gogocita.admin.gogocita.BaseMenuActivity;
import com.gogocita.admin.gogocita.R;
import com.gogocita.admin.gogocita.service.ServicesActivity;

public class ChangePasswordActivity extends BaseMenuActivity {
    private EditText inputNewPassword, inputReNewPassword;
    private ProgressBar progressBar;
    private Button btnResetPassword;
    private UsersController usersController;

    @Override
    protected void init() {

    }

    @Override
    protected void getWidget()
    {
        inputNewPassword = (EditText) findViewById(R.id.editView_password);
        inputReNewPassword = (EditText) findViewById(R.id.editView_repassword);
        progressBar = (ProgressBar) findViewById(R.id.progressBar_changepassword);
        btnResetPassword = (Button) findViewById(R.id.btn_resetpassword);
    }

    @Override
    protected void setWidget()
    {
        usersController = UsersController.getInstance(ChangePasswordActivity.this ,progressBar);
    }

    @Override
    protected void addListener()
    {
        btnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(inputNewPassword.getText().toString())) {
                    Toast.makeText(ChangePasswordActivity.this, "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(inputReNewPassword.getText().toString())) {
                    Toast.makeText(ChangePasswordActivity.this, "Enter rePassword!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!inputNewPassword.getText().toString().equals(inputReNewPassword.getText().toString())) {
                    Toast.makeText(ChangePasswordActivity.this, "Password is not the same as RePassword!", Toast.LENGTH_SHORT).show();
                    return;
                }
                btnResetPassword.setVisibility(View.VISIBLE);
                usersController.changePassword(inputNewPassword.getText().toString());

            }
        });
    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.changepassword);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,ServicesActivity.class));
        finish();
    }
}
