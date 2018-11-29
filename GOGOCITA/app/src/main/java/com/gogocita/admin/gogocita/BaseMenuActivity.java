package com.gogocita.admin.gogocita;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
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
import android.widget.TextView;

import com.gogocita.admin.controllers.service.ServiceController;
import com.gogocita.admin.controllers.user.UserDetailsController;
import com.gogocita.admin.controllers.user.UsersController;
import com.gogocita.admin.gogocita.service.BooksActiviry;
import com.gogocita.admin.gogocita.service.CreateNewServiceActivity;
import com.gogocita.admin.gogocita.service.HistoryOrdersActivity;
import com.gogocita.admin.gogocita.service.ServicesActivity;
import com.gogocita.admin.gogocita.users.ChangePasswordActivity;
import com.gogocita.admin.gogocita.users.UpdateUserDetailActivity;
import com.gogocita.admin.gogocita.users.UserDetailActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Locale;

public abstract class BaseMenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private UserDetailsController userDetailsController;
    private UsersController usersController;
    private ServiceController serviceController;
    public Toolbar toolbar;
    public ProgressBar progressBar;
    private TextView tv_userName;
    private TextView tv_userEmail;
    private static final int  timeDelayMiliSeconds= 1000;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
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
        usersController = UsersController.getInstance(this,progressBar);

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
        setHeaderView(navigationView);

    }

    private void setHeaderView(NavigationView navigationView){
        View headerView = navigationView.inflateHeaderView(R.layout.nav_header_main);
        tv_userEmail = (TextView) headerView.findViewById(R.id.menu_email);
        tv_userName = (TextView) headerView.findViewById(R.id.menu_userName);
        userDetailsController.getShortUserDetail(tv_userName,tv_userEmail,null,FirebaseAuth.getInstance().getUid());
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
                }, timeDelayMiliSeconds);
                break;
            case R.id.btn_myprofile:
                item.setActionView(new ProgressBar(this));
                item.getActionView().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        myProfile();
                    }
                }, timeDelayMiliSeconds);
                break;
            case R.id.btn_updatemyprofile:
                item.setActionView(new ProgressBar(this));
                item.getActionView().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        updateMyProfile();
                    }
                }, timeDelayMiliSeconds);
                break;
            case R.id.btncreatemyservice:
                nextStep1();
                break;
            case R.id.btn_seecalender:
                item.setActionView(new ProgressBar(this));
                item.getActionView().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        seecalender();
                    }
                },timeDelayMiliSeconds);
                break;
            case R.id.btn_changpassword:
                changePassword();
                break;
            case R.id.btn_changelanguage:
                showAlertLangguageDialog();
                break;
            case R.id.btn_history:
                item.setActionView(new ProgressBar(this));
                item.getActionView().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        history();
                    }
                }, timeDelayMiliSeconds);
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

    public void showAlertLangguageDialog()
    {
        final String[] listItems = {"Viet Nam", "English"};
        AlertDialog.Builder mBuilder1 = new AlertDialog.Builder(BaseMenuActivity.this);
        mBuilder1.setTitle("GOGOCITA");
        mBuilder1.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                if(i == 0){
                    setLocale("vi");
                    recreate();
                }else{
                    setLocale("en");
                    recreate();
                }
            }
        });
        AlertDialog alertDialog = mBuilder1.create();
        alertDialog.show();

    }

    private void setLocale(String lang){
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale= locale;
        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("",MODE_PRIVATE).edit();
        editor.putString("My lang",lang);
        editor.apply();
    }

    public  void loadLocale(){
        SharedPreferences preferences = getSharedPreferences("",MODE_PRIVATE);
        String language = preferences.getString("My lang","");
        setLocale(language);
    }

    public void showAlertDialog()
    {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("GOGOCITA");
        builder.setMessage(getString(R.string.do_you_want_signout));
        builder.setCancelable(false);
        builder.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                singOut();
            }
        });
        builder.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
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

    public void seecalender(){
        startActivity(new Intent(this, HistoryOrdersActivity.class));
        finish();
    }

    public void history(){
        startActivity(new Intent(this, BooksActiviry.class));
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

    @Override
    public void onStart() {
        super.onStart();

        usersController.checkAuthorizeLogin();
    }

    protected abstract void init();
    protected abstract void setWidget();
    protected abstract void getWidget();
    protected abstract void addListener();
    protected abstract void setContentView();
}
