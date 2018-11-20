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

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.gogocita.admin.controllers.user.UsersController;
import com.gogocita.admin.gogocita.R;

public class LoginActivity extends AppCompatActivity {
    private EditText inputEmail;
    private EditText inputPassword;
    private Button btnLogin;
    private LoginButton loginFace;
    private ProgressBar progressBar;
    private UsersController usersController;
    private CallbackManager callbackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        setContentView(R.layout.login);

        getWidget();
        setWidget();
        addListener();
    }

    private void getWidget()
    {
        btnLogin = (Button) findViewById(R.id.btn_login);
        inputEmail = (EditText) findViewById(R.id.et_user_login);
        progressBar = (ProgressBar) findViewById(R.id.progressBar_login);
        inputPassword = (EditText) findViewById(R.id.et_password_login);
        loginFace = findViewById(R.id.btn_fb);
    }

    private void setWidget()
    {
        usersController = UsersController.getInstance(LoginActivity.this ,progressBar);
    }

    private void addListener()
    {
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

         callbackManager = CallbackManager.Factory.create();

        loginFace.setReadPermissions("email", "public_profile");
        loginFace.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                usersController.handleFacebookAccessToken(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
    }

    public void btn_create(View v){
        Intent intent = new Intent(this, SingUpActivity.class);
        startActivity(intent);
        finish();
    }

    public void forgotPassword(View v){
        startActivity(new Intent(this, ForgetPasswordActivity.class));
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Pass the activity result back to the Facebook SDK
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
