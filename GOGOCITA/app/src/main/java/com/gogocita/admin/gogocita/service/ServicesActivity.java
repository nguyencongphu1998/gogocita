package com.gogocita.admin.gogocita.service;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.gogocita.admin.constant.EntityName;
import com.gogocita.admin.constant.FilterSort;
import com.gogocita.admin.controllers.configvalue.ConfigValueController;
import com.gogocita.admin.controllers.service.ServiceController;
import com.gogocita.admin.dto.FilterServicesDto;
import com.gogocita.admin.entity.Location;
import com.gogocita.admin.entity.PartnerService;
import com.gogocita.admin.gogocita.BaseMenuActivity;
import com.gogocita.admin.gogocita.R;

public class ServicesActivity extends BaseMenuActivity{
    private ListView listView;
    private ProgressBar progressBar;
    private ImageButton btnDesc;
    private ImageButton btnAsc;
    private Spinner spinnerCity;
    private ServiceController serviceController;
    private ConfigValueController configValueController;
    private FilterServicesDto filterDto;


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

        btnDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterDto.setEvalutionSort(FilterSort.desc);
                serviceController.getAllServices(listView,getApplicationContext(), filterDto);
            }
        });

        btnAsc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterDto.setEvalutionSort(FilterSort.asc);
                serviceController.getAllServices(listView,getApplicationContext(), filterDto);
            }
        });

        spinnerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                filterDto.setCity(((Location) spinnerCity.getSelectedItem()).getLocationName());
                serviceController.getAllServices(listView,getApplicationContext(), filterDto);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    protected void init()
    {
        filterDto = new FilterServicesDto();
        configValueController = ConfigValueController.getInstance(getApplicationContext());
    }

    @Override
    protected void setWidget()
    {
        serviceController = ServiceController.getInstance(this,progressBar);

        serviceController.getAllServices(listView,this, filterDto);

        configValueController.getCity(spinnerCity);
    }

    @Override
    protected void getWidget()
    {
        listView = (ListView) findViewById(R.id.list_service);
        progressBar = (ProgressBar) findViewById(R.id.progressBar_services);
        spinnerCity = (Spinner) findViewById(R.id.spinner_search_city);
        btnAsc = (ImageButton) findViewById(R.id.btn_search_asc);
        btnDesc = (ImageButton) findViewById(R.id.btn_search_desc);
    }

    @Override
    protected void setContentView(){
        setContentView(R.layout.list_service);
    }
}
