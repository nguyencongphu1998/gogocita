package com.gogocita.admin.controllers;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;

import android.text.TextUtils;
import android.widget.Toast;
import android.view.View;

import com.gogocita.admin.entity.User;
import com.gogocita.admin.gogocita.MainActivity;
import com.gogocita.admin.gogocita.SingUpSuccessActivity;
import com.gogocita.admin.helper.QueryFirebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;


public class UsersController extends AppCompatActivity {
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseUser user = null;
    private ProgressBar progressBar;
    private final Activity activity;
    private static UsersController usersController = null;

    private UsersController(ProgressBar progressBar,Activity activity)
    {
        auth = FirebaseAuth.getInstance();
        this.progressBar = progressBar;
        user = FirebaseAuth.getInstance().getCurrentUser();
        this.activity = activity;
    }

    public static UsersController getInstance(Activity activity, ProgressBar progressBar){
        if (usersController == null){
            usersController = new UsersController(progressBar,activity);
        }
        return usersController;
    }

    public void CheckAuthorize()
    {
        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    //startActivity(new Intent(activity, LoginActivity.class)); Miss LoginActivity
                    finish();
                }
            }
        };
    }

    public void singUp(final String email, final String password, String repassword,final String userType)
    {

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(activity, "Enter email address!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(activity, "Enter password!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(repassword)) {
            Toast.makeText(activity, "Enter rePassword!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!repassword.equals(password)) {
            Toast.makeText(activity, "Password is not the same as RePassword!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.length() < 6) {
            Toast.makeText(activity, "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        //create user
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //Toast.makeText(activity, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(activity, "Authentication failed." + task.getException(),
                                    Toast.LENGTH_SHORT).show();
                        } else {

                            user = FirebaseAuth.getInstance().getCurrentUser();
                            QueryFirebase<User> queryFirebase = QueryFirebase.getInstance(com.gogocita.admin.constant.EntityName.Users);
                            queryFirebase.Insert(new User(user.getUid(),email,userType) ,user.getUid());

                            startActivity(new Intent(activity, SingUpSuccessActivity.class));
                            finish();
                        }
                    }
                });

    }


    public void singIn(String email, final String password)
    {
        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(activity, MainActivity.class));
            finish();
        }

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(activity, "Enter email address!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(activity, "Enter password!", Toast.LENGTH_SHORT).show();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        //authenticate user
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        progressBar.setVisibility(View.GONE);
                        if (!task.isSuccessful()) {
                            // there was an error
                            if (password.length() < 6) {
                                Toast.makeText(activity, "Password too short!." + task.getException(),
                                        Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(activity, "Password is wrong", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Intent intent = new Intent(activity, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
    }

    public void changePassword(String newPassword)
    {
        progressBar.setVisibility(View.VISIBLE);
        if (user != null && !newPassword.trim().equals(""))
        {
            if (newPassword.length() < 6)
            {
                Toast.makeText(activity, "Password too short, enter minimum 6 characters", Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.GONE);
            } else {
                user.updatePassword(newPassword.trim())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(activity, "Password is updated, sign in with new password!", Toast.LENGTH_SHORT).show();
                                    progressBar.setVisibility(View.GONE);
                                } else {
                                    Toast.makeText(activity, "Failed to update password!", Toast.LENGTH_SHORT).show();
                                    progressBar.setVisibility(View.GONE);
                                }
                            }
                        });
            }
        } else if (newPassword.equals(""))
        {
            Toast.makeText(activity, "Enter your password", Toast.LENGTH_LONG).show();
            progressBar.setVisibility(View.GONE);
        }
    }

    public void forgotPassword(String email)
    {
        progressBar.setVisibility(View.VISIBLE);
        if (!email.trim().equals("")) {
            auth.sendPasswordResetEmail(email.trim())
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(activity, "Reset password email is sent!", Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                            } else {
                                Toast.makeText(activity, "Failed to send reset email!", Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                            }
                        }
                    });
        } else {
            Toast.makeText(activity, "Enter email!", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
        }
    }

    public void signOut()
    {
        auth.signOut();
    }


}
