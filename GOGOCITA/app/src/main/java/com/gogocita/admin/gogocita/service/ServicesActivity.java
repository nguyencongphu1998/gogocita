package com.gogocita.admin.gogocita.service;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.gogocita.admin.constant.EntityName;
import com.gogocita.admin.controllers.service.ServiceController;
import com.gogocita.admin.entity.PartnerService;
import com.gogocita.admin.gogocita.R;

public class ServicesActivity extends AppCompatActivity {
    private ListView listView;
    private ProgressBar progressBar;
    private ServiceController serviceController;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_service);
        init();
        setData();
        addListener();
    }

    private void addListener() {
        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplication(),ServiceDetailActivity.class);
                intent.putExtra(EntityName.PartnerServices,(PartnerService)listView.getSelectedItem());
                getApplication().startActivity(intent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void init()
    {
        listView = (ListView) findViewById(R.id.list_service);
        progressBar = (ProgressBar) findViewById(R.id.progressBar_services);
    }

    private void setData()
    {
        serviceController = ServiceController.getInstance(this,progressBar);

        serviceController.getAllServices(listView,this);

        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //gender = ((ConfigValue) spinner_gender.getSelectedItem()).getConfigValueKey();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
