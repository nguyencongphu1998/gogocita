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
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),ServiceDetailActivity.class);
                intent.putExtra(EntityName.PartnerServices,(PartnerService)(adapterView.getAdapter()).getItem(i));
                getApplicationContext().startActivity(intent);
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
    }
}
