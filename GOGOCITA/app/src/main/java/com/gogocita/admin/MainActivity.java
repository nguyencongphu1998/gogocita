package com.gogocita.admin;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.gogocita.admin.gogocita.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public Toolbar toolbar;
    public TabLayout tabLayout;
    public ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.idItem1) {
            Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        } else if (id == R.id.idItem2) {
            Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        } else if (id == R.id.idItem3) {
            Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        } else if (id == R.id.idItem4) {
            Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        } else if (id == R.id.idItem5) {
            Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        } else if (id == R.id.idItem6) {
            Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        } else if (id == R.id.idItem7) {
            Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
