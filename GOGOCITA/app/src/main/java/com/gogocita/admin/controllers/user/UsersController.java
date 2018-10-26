package com.gogocita.admin.controllers.user;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;

import android.widget.Toast;
import android.view.View;

import com.gogocita.admin.constant.EntityName;
import com.gogocita.admin.entity.User;
import com.gogocita.admin.entity.UserDetail;
import com.gogocita.admin.gogocita.service.ServiceOptionActivity;
import com.gogocita.admin.gogocita.users.ForgetPasswordAccessMail;
import com.gogocita.admin.gogocita.users.LoginActivity;
import com.gogocita.admin.gogocita.users.SingUpSuccessActivity;
import com.gogocita.admin.gogocita.users.UpdateUserDetailActivity;
import com.gogocita.admin.gogocita.users.UserDetailActivity;
import com.gogocita.admin.gogocita.users.UserMenuActivity;
import com.gogocita.admin.helper.QueryFirebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.widget.ProgressBar;


public class UsersController {
    private FirebaseAuth auth;
    private FirebaseUser user = null;
    private ProgressBar progressBar;
    private Activity activity;
    private static UsersController usersController = null;

    public FirebaseUser getUser() {
        return user;
    }

    private UsersController(ProgressBar progressBar, Activity activity)
    {
        auth = FirebaseAuth.getInstance();
        this.progressBar = progressBar;
        user = FirebaseAuth.getInstance().getCurrentUser();
        this.activity = activity;
    }

    public static UsersController getInstance(Activity activity, ProgressBar progressBar){
        if (usersController == null){
            usersController = new UsersController(progressBar,activity);
        }else {
            usersController.progressBar = progressBar;
            usersController.activity = activity;
        }

        usersController.activity = activity;
        return usersController;
    }

    public void checkAuthorize()
    {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null) {
            activity.startActivity(new Intent(activity, LoginActivity.class));
            activity.finish();
        }

    }

    public void checkAuthorizeLogin()
    {
        FirebaseAuth.AuthStateListener authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    activity.startActivity(new Intent(activity, LoginActivity.class));
                    activity.finish();
                }else {
                    activity.startActivity(new Intent(activity, UserMenuActivity.class));
                    activity.finish();
                }
            }
        };
    }

    public void singUp(final String email, final String password, String repassword,final String userType)
    {
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        progressBar.setVisibility(View.GONE);

                        if (!task.isSuccessful())
                        {
                            Toast.makeText(activity, "Authentication failed." + task.getException(),
                                    Toast.LENGTH_SHORT).show();
                        }
                        else {
                            user = FirebaseAuth.getInstance().getCurrentUser();
                            QueryFirebase<User> queryFirebase = QueryFirebase.getInstance(com.gogocita.admin.constant.EntityName.Users);
                            queryFirebase.Insert(new User(user.getUid(),email,userType) ,user.getUid());

                            QueryFirebase<UserDetail> queryFirebaseUserDetail = QueryFirebase.getInstance(EntityName.UserDetails);
                            queryFirebaseUserDetail.Insert(new UserDetail(user.getUid(),user.getEmail()),user.getUid());

                            activity.startActivity(new Intent(activity,SingUpSuccessActivity.class));
                            activity.finish();
                        }
                    }
                });
    }


    public void singIn(String email, final String password)
    {
        checkAuthorizeLogin();

        progressBar.setVisibility(View.VISIBLE);

        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);
                        if (!task.isSuccessful()) {
                            Toast.makeText(activity, "Password or email is wrong", Toast.LENGTH_LONG).show();
                        }
                        else {
                            user = FirebaseAuth.getInstance().getCurrentUser();
                            activity.startActivity(new Intent(activity, ServiceOptionActivity.class));
                            activity.finish();
                        }
                    }
                });
    }

    public void changePassword(String newPassword)
    {
        progressBar.setVisibility(View.VISIBLE);
        if (user != null)
        {
            if (newPassword.length() < 6)
            {
                Toast.makeText(activity, "Password too short, enter minimum 6 characters", Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.GONE);
            }
            else {
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
                                activity.startActivity(new Intent(activity,ForgetPasswordAccessMail.class));
                                activity.finish();
                            } else {
                                Toast.makeText(activity, "Account is not exist!", Toast.LENGTH_SHORT).show();
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
        activity.startActivity(new Intent(activity,LoginActivity.class));
        activity.finish();
    }


}
