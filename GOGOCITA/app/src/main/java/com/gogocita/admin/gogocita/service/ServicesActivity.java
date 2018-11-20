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
import com.gogocita.admin.controllers.user.UsersController;
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
    private ImageButton btnReset;
    private Spinner spinnerCity;
    private Spinner spinnerCountry;
    private ServiceController serviceController;
    private UsersController usersController;
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

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterDto = new FilterServicesDto();
                serviceController.getAllServices(listView,getApplicationContext(), filterDto);
            }
        });

        spinnerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                filterDto.setCountry(((Location) spinnerCountry.getSelectedItem()).getLocationName());
                serviceController.getAllServices(listView,getApplicationContext(), filterDto);

                configValueController.getCitys(((Location) spinnerCountry.getSelectedItem()).getLocationID(),spinnerCity);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                filterDto.setCity(((Location) spinnerCity.getSelectedItem()).getLocationName());
                serviceController.getAllServices(listView,getApplicationContext(), filterDto);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    protected void init()
    {
        filterDto = new FilterServicesDto();
        configValueController = ConfigValueController.getInstance(getApplicationContext());
        usersController = UsersController.getInstance(this,progressBar);
    }

    @Override
    protected void setWidget()
    {
        serviceController = ServiceController.getInstance(this,progressBar);

        serviceController.getAllServices(listView,this, filterDto);

        configValueController.getCountry(spinnerCountry);
    }

    @Override
    protected void getWidget()
    {
        listView = (ListView) findViewById(R.id.list_service);
        progressBar = (ProgressBar) findViewById(R.id.progressBar_services);
        spinnerCity = (Spinner) findViewById(R.id.spinner_search_city);
        spinnerCountry = (Spinner) findViewById(R.id.spinner_search_country);
        btnAsc = (ImageButton) findViewById(R.id.btn_search_asc);
        btnDesc = (ImageButton) findViewById(R.id.btn_search_desc);
        btnReset = (ImageButton) findViewById(R.id.btn_search_reset);
    }

    @Override
    protected void setContentView(){
        setContentView(R.layout.list_service);
    }

    @Override
    public void onStart() {
        super.onStart();

        usersController.checkAuthorizeLogin();
    }
}
