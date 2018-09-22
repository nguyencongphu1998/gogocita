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

public class LoginActivity extends AppCompatActivity {
    private EditText inputEmail;
    private EditText inputPassword;
    private Button btnLogin;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        btnLogin = (Button) findViewById(R.id.btn_login);
        inputEmail = (EditText) findViewById(R.id.et_email);
        progressBar = (ProgressBar) findViewById(R.id.progressBar_login);
        inputPassword = (EditText) findViewById(R.id.et_password);

        final UsersController usersController = UsersController.getInstance(LoginActivity.this ,progressBar);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(inputEmail.getText().toString())) {
                    Toast.makeText(LoginActivity.this, "Enter your email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(inputPassword.getText().toString()))
                {
                    Toast.makeText(LoginActivity.this,"Enter your password!!!",Toast.LENGTH_SHORT).show();
                    return;
                }

                usersController.singIn(inputEmail.getText().toString(),inputPassword.getText().toString());
            }
        });
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
