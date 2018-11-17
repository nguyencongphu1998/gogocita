package com.gogocita.admin.gogocita.service;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.gogocita.admin.constant.EntityName;
import com.gogocita.admin.controllers.configvalue.ConfigValueController;
import com.gogocita.admin.controllers.service.ServiceImageController;
import com.gogocita.admin.entity.ConfigValue;
import com.gogocita.admin.entity.PartnerServiceImage;
import com.gogocita.admin.gogocita.BaseMenuActivity;
import com.gogocita.admin.gogocita.R;
import com.gogocita.admin.helper.ImageAdapter;

import java.util.ArrayList;
import java.util.List;

public class ServiceImagesActivity extends BaseMenuActivity implements ImageAdapter.OnItemClickListener {
    private RecyclerView recyclerView;
    private ImageAdapter adapter;
    private ProgressBar progressCircle;
    private Spinner spinner_Type;
    private String imageType;
    private String serviceId;

    private List<PartnerServiceImage> images;
    private ServiceImageController serviceImageController;
    private ConfigValueController configValueController;

    @Override
    protected void addListener() {
        spinner_Type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                imageType = ((ConfigValue) spinner_Type.getSelectedItem()).getConfigValueKey();
                serviceImageController.getAllImages(images,adapter,serviceId,imageType);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.service_images);
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(this, "Normal click at position: " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onWhatEverClick(int position) {
        Toast.makeText(this, "Whatever click at position: " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDeleteClick(int position) {
        PartnerServiceImage selectedItem = images.get(position);
        serviceImageController.deleteImage(selectedItem);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void init()
    {

        progressCircle = findViewById(R.id.progress_circle);
        serviceImageController = ServiceImageController.getInstance(this,progressCircle);
        configValueController = ConfigValueController.getInstance(this);

        spinner_Type = findViewById(R.id.spinner_Type);
        configValueController.getServiceImageTypes(spinner_Type,true);

        Intent intent = getIntent();
        serviceId =  intent.getStringExtra(EntityName.PartnerServices);
        images = new ArrayList<PartnerServiceImage>();
    }

    @Override
    protected void setWidget() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ImageAdapter(ServiceImagesActivity.this, images);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(ServiceImagesActivity.this);
    }

    @Override
    protected void getWidget() {
        recyclerView = findViewById(R.id.recycler_view);
    }

    public void uploadImage(View v)
    {
        Intent i = new Intent(this,UploadServiceImageActivity.class);
        i.putExtra(EntityName.PartnerServices,serviceId);
        this.startActivity(i);
    }
}
