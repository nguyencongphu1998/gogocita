package com.gogocita.admin.gogocita.users;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.gogocita.admin.controllers.user.UsersController;
import com.gogocita.admin.gogocita.R;

public class ChangePasswordActivity extends AppCompatActivity {
    private EditText inputNewPassword, inputReNewPassword;
    private ProgressBar progressBar;
    private Button btnResetPassword;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changepassword);
        inputNewPassword = (EditText) findViewById(R.id.editView_password);
        inputReNewPassword = (EditText) findViewById(R.id.editView_repassword);
        progressBar = (ProgressBar) findViewById(R.id.progressBar_changepassword);
        btnResetPassword = (Button) findViewById(R.id.btn_resetpassword);

        final UsersController usersController = UsersController.getInstance(ChangePasswordActivity.this ,progressBar);

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
}
