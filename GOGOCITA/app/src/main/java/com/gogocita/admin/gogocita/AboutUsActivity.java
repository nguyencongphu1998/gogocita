package com.gogocita.admin.gogocita;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class AboutUsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
