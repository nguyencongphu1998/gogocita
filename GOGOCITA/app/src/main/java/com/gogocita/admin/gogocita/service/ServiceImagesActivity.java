package com.gogocita.admin.gogocita.service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.gogocita.admin.gogocita.R;
import com.gogocita.admin.helper.ImageAdapter;

import java.util.ArrayList;
import java.util.List;

public class ServiceImagesActivity extends AppCompatActivity implements ImageAdapter.OnItemClickListener {
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_images);

        init();
        setData();
        addListener();
    }

    private void addListener() {
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

    private void init()
    {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        progressCircle = findViewById(R.id.progress_circle);
        spinner_Type = findViewById(R.id.spinner_Type);
        images = new ArrayList<PartnerServiceImage>();
        adapter = new ImageAdapter(ServiceImagesActivity.this, images);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(ServiceImagesActivity.this);
        serviceImageController = ServiceImageController.getInstance(this,progressCircle);
        configValueController = ConfigValueController.getInstance(this);
    }

    private void setData()
    {
        configValueController.getServiceImageTypes(spinner_Type);
        Intent intent = getIntent();
        serviceId =  intent.getStringExtra(EntityName.PartnerServices);
    }

    public void uploadImage(View v)
    {
        Intent i = new Intent(this,UploadServiceImageActivity.class);
        i.putExtra(EntityName.PartnerServices,serviceId);
        this.startActivity(i);
    }
}
