package com.gogocita.admin.gogocita;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.gogocita.admin.controllers.service.ServiceController;
import com.gogocita.admin.controllers.user.UserDetailsController;
import com.gogocita.admin.controllers.user.UsersController;
import com.gogocita.admin.gogocita.service.CreateNewServiceActivity;
import com.gogocita.admin.gogocita.service.ServicesActivity;
import com.gogocita.admin.gogocita.users.ChangePasswordActivity;
import com.gogocita.admin.gogocita.users.UpdateUserDetailActivity;
import com.gogocita.admin.gogocita.users.UserDetailActivity;

public abstract class BaseMenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private UserDetailsController userDetailsController;
    private ServiceController serviceController;
    public Toolbar toolbar;
    public ProgressBar progressBar;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView();
        init();
        getWidget();
        setWidget();
        addListener();
        getMenu();
    }

    private void getMenu()
    {
        userDetailsController = UserDetailsController.getInstance(this,progressBar);
        serviceController = ServiceController.getInstance(this,progressBar);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.activity_menu_drawer, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.btn_dashboard:
                item.setActionView(new ProgressBar(this));
                item.getActionView().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        gotoDashboard();
                    }
                }, 1000);
                break;
            case R.id.btn_myprofile:
                item.setActionView(new ProgressBar(this));
                item.getActionView().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        myProfile();
                    }
                }, 1000);
                break;
            case R.id.btn_updatemyprofile:
                item.setActionView(new ProgressBar(this));
                item.getActionView().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        updateMyProfile();
                    }
                }, 1000);
                break;
            case R.id.btncreatemyservice:
                nextStep1();
                break;
            case R.id.btn_seecalender:
                comingSoon();
                break;
            case R.id.btn_changpassword:
                changePassword();
                break;
            case R.id.btn_history:
                comingSoon();
                break;
            case R.id.btn_aboutus:
                aboutUs();
                break;
            case R.id.btn_signout:
                showAlertDialog();
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void showAlertDialog()
    {
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

    public void gotoDashboard(){
        startActivity(new Intent(this, ServicesActivity.class));
        finish();
    }

    public void myProfile(){
        userDetailsController.getUserDetail(UserDetailActivity.class);
    }

    public void changePassword(){
        startActivity(new Intent(this, ChangePasswordActivity.class));
        finish();
    }

    public void comingSoon(){
        startActivity(new Intent(this, ComingSoonActivity.class));
        finish();
    }

    public void aboutUs(){
        startActivity(new Intent(this, AboutUsActivity.class));
    }

    public void updateMyProfile(){
        userDetailsController.getUserDetail(UpdateUserDetailActivity.class);
    }

    public void nextStep1(){
        serviceController.getServiceDetail(CreateNewServiceActivity.class);
    }

    public void singOut(){
        UsersController usersController = UsersController.getInstance(this,null);
        usersController.signOut();
    }

    protected abstract void init();
    protected abstract void setWidget();
    protected abstract void getWidget();
    protected abstract void addListener();
    protected abstract void setContentView();
}
