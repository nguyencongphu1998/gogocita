package com.gogocita.admin.gogocita.service;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.gogocita.admin.constant.EntityName;
import com.gogocita.admin.controllers.service.ServiceController;
import com.gogocita.admin.entity.PartnerService;
import com.gogocita.admin.gogocita.BaseMenuActivity;
import com.gogocita.admin.gogocita.R;

public class ServicesActivity extends BaseMenuActivity{
    private ListView listView;
    private ProgressBar progressBar;
    private ServiceController serviceController;
    public Toolbar toolbar;

    @Override
    protected void addListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),ServiceDetailActivity.class);
                intent.putExtra(EntityName.PartnerServices,(PartnerService)(adapterView.getAdapter()).getItem(i));
                getApplicationContext().startActivity(intent);
            }
        });
    }

    @Override
    protected void init()
    {

    }

    @Override
    protected void setWidget()
    {
        serviceController = ServiceController.getInstance(this,progressBar);

        serviceController.getAllServices(listView,this);
    }

    @Override
    protected void getWidget()
    {
        listView = (ListView) findViewById(R.id.list_service);
        progressBar = (ProgressBar) findViewById(R.id.progressBar_services);
    }

    @Override
    protected void setContentView(){
        setContentView(R.layout.list_service);
    }
}
