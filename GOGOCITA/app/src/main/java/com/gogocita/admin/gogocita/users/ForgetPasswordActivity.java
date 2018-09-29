package com.gogocita.admin.gogocita.users;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.gogocita.admin.controllers.user.UsersController;
import com.gogocita.admin.gogocita.R;

public class ForgetPasswordActivity extends AppCompatActivity {
    private Button btnSendMail;
    private EditText inputEmail;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_password);

        btnSendMail = (Button) findViewById(R.id.bt_sendmail);
        inputEmail = (EditText) findViewById(R.id.et_email);
        progressBar = (ProgressBar) findViewById(R.id.progressBar_forgetpassword);

        final UsersController usersController = UsersController.getInstance(ForgetPasswordActivity.this ,progressBar);

        btnSendMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(inputEmail.getText().toString())) {
                    Toast.makeText(ForgetPasswordActivity.this, "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }
                usersController.forgotPassword(inputEmail.getText().toString());
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,LoginActivity.class));
        finish();
    }
}
