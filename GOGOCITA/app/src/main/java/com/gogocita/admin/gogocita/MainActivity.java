package com.gogocita.admin.gogocita;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.gogocita.admin.entity.ConfigValue;
import com.gogocita.admin.helper.QueryFirebase;
import com.google.firebase.database.DatabaseReference;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        QueryFirebase a = new QueryFirebase("ConfigValues");
        List<ConfigValue> b = a.getAll();
    }
}
