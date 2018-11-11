package com.gogocita.admin.gogocita.service;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.gogocita.admin.constant.EntityName;
import com.gogocita.admin.controllers.configvalue.ConfigValueController;
import com.gogocita.admin.controllers.service.ServiceImageController;
import com.gogocita.admin.entity.ConfigValue;
import com.gogocita.admin.entity.PartnerServiceImage;
import com.gogocita.admin.gogocita.BaseMenuActivity;
import com.gogocita.admin.gogocita.R;
import com.google.firebase.storage.StorageTask;
import com.squareup.picasso.Picasso;

public class UploadServiceImageActivity extends BaseMenuActivity {
    private static final int PICK_IMAGE_REQUEST = 1;
    private Button buttonChooseImage,buttonUpload;
    private TextView textViewShowUploads;
    private Spinner spinner_imageType;
    private EditText editTextFileName;
    private ImageView imageView;
    private ProgressBar progressBar;
    private Uri imageUri;
    private String imageType;
    private static String serviceId;
    private ServiceImageController serviceImageController;
    private ConfigValueController configValueController;
    private StorageTask uploadTask;

    @Override
    protected void addListener()
    {
        spinner_imageType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                imageType = ((ConfigValue) spinner_imageType.getSelectedItem()).getConfigValueKey();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        buttonChooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });

        buttonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (uploadTask != null && uploadTask.isInProgress()) {
                    Toast.makeText(UploadServiceImageActivity.this, "Upload in progress", Toast.LENGTH_SHORT).show();
                } else {
                    uploadFile();
                }
            }
        });

        textViewShowUploads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImagesActivity();
            }
        });
    }

    @Override
    protected void setContentView()
    {
        setContentView(R.layout.upload_service_image);
    }

    private void openFileChooser()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    //Load ảnh
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            imageUri = data.getData();

            Picasso.with(this).load(imageUri).into(imageView);
        }
    }

    private String getFileExtension(Uri uri)
    {
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }

    private void uploadFile()
    {
        if (imageUri != null) {
            PartnerServiceImage image = new PartnerServiceImage(
                    serviceId,
                    "",
                    imageType,
                    editTextFileName.getText().toString().trim());

            serviceImageController.uploadImage(imageUri,image,getFileExtension(imageUri),uploadTask);

        } else {
            Toast.makeText(this, "No file selected", Toast.LENGTH_SHORT).show();
        }
    }

    private void openImagesActivity()
    {
        Intent i = new Intent(this,ServiceImagesActivity.class);
        i.putExtra(EntityName.PartnerServices,serviceId);
        this.startActivity(i);
    }

    @Override
    protected void init()
    {
        Intent intent = getIntent();
        serviceId =  intent.getStringExtra(EntityName.PartnerServices);
        configValueController = ConfigValueController.getInstance(this);
    }

    @Override
    protected void setWidget()
    {
        serviceImageController = ServiceImageController.getInstance(this,progressBar);
        configValueController.getServiceImageTypes(spinner_imageType);
    }

    @Override
    protected void getWidget()
    {
        buttonChooseImage = (Button) findViewById(R.id.button_uploadimages_image);
        buttonUpload = (Button) findViewById(R.id.button_uploadimages_upload);
        textViewShowUploads = (TextView) findViewById(R.id.textView_uploadimages_showuploads);
        editTextFileName = (EditText) findViewById(R.id.textView_uploadimages_name);
        spinner_imageType = (Spinner) findViewById(R.id.spinner_uploadimages_type);
        imageView = (ImageView) findViewById(R.id.imageView_uploadimages_image);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
    }
}

