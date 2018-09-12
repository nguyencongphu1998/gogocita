package com.gogocita.admin.gogocita;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.gogocita.admin.constant.EntityName;
import com.gogocita.admin.entity.ConfigValue;
import com.gogocita.admin.helper.QueryFirebase;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);

        QueryFirebase<ConfigValue> a = new QueryFirebase<>(EntityName.ConfigValues);
        ArrayList<ConfigValue> list = new ArrayList<>();

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);

        a.getAll(list,adapter);

        listView.setAdapter(adapter);

    }
}
