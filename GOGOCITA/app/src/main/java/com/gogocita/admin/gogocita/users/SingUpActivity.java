package com.gogocita.admin.gogocita.users;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.gogocita.admin.constant.UserType;
import com.gogocita.admin.controllers.user.UsersController;
import com.gogocita.admin.gogocita.R;
import com.google.firebase.auth.FirebaseAuth;


public class SingUpActivity extends AppCompatActivity {
    private EditText inputEmail, inputPassword, inputRePassword;
    private Button btnSignUp;
    private ProgressBar progressBar;
    private FirebaseAuth auth;
    private RadioGroup radioGroup;
    private CheckBox checkBox;
    private UsersController usersController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singup);

        getWidget();
        setWidget();
        addListener();
    }

    private void getWidget()
    {
        btnSignUp = (Button) findViewById(R.id.button_singup);
        inputEmail = (EditText) findViewById(R.id.editView_email);
        inputPassword = (EditText) findViewById(R.id.editView_password);
        inputRePassword = (EditText) findViewById(R.id.editView_repassword);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup_usertype);
        checkBox = (CheckBox) findViewById(R.id.checkbox_conditions);
    }

    private void setWidget()
    {
        usersController = UsersController.getInstance(SingUpActivity.this ,progressBar);
    }

    private void addListener()
    {
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkBox.isChecked())
                {
                    Toast.makeText(SingUpActivity.this,"Please approve our conditions!!!",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(inputEmail.getText().toString())) {
                    Toast.makeText(SingUpActivity.this, "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(inputPassword.getText().toString())) {
                    Toast.makeText(SingUpActivity.this, "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(inputRePassword.getText().toString())) {
                    Toast.makeText(SingUpActivity.this, "Enter rePassword!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!inputPassword.getText().toString().equals(inputRePassword.getText().toString())) {
                    Toast.makeText(SingUpActivity.this, "Password is not the same as RePassword!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (inputPassword.getText().toString().length() < 6) {
                    Toast.makeText(SingUpActivity.this, "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                int idChecked = radioGroup.getCheckedRadioButtonId();
                String userType = null;
                switch (idChecked)
                {
                    case R.id.radioButton_customer:
                        userType = UserType.customer;
                        break;
                    case R.id.radioButton_homestay:
                        userType = UserType.homeStay;
                        break;
                    case R.id.radioButton_tourisguider:
                        userType = UserType.tourisGuider;
                        break;
                }
                usersController.singUp(inputEmail.getText().toString(),inputPassword.getText().toString(),inputRePassword.getText().toString(),userType);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,LoginActivity.class));
        fileList();
    }
}