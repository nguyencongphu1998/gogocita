package com.gogocita.admin.gogocita.service;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterViewFlipper;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.gogocita.admin.constant.EntityName;
import com.gogocita.admin.constant.ServiceConvinience;
import com.gogocita.admin.controllers.service.ServiceImageController;
import com.gogocita.admin.entity.PartnerService;
import com.gogocita.admin.gogocita.BaseMenuActivity;
import com.gogocita.admin.gogocita.R;
import com.squareup.picasso.Picasso;

public class ServiceDetailActivity extends BaseMenuActivity {
    private TextView serviceName,serviceDesc,serviceEvalution,serviceVote;
    private EditText serviceAddress;
    private Button btnbook;
    private CheckBox serviceWifi,serviceBreakfast,serviceSwimming,serviceAc;
    private AdapterViewFlipper avf_images;
    private PartnerService partnerService;
    private ServiceImageController serviceImageController;

    @Override
    protected void getWidget()
    {
        avf_images = (AdapterViewFlipper) findViewById(R.id.avf_serviceDetail_images);
        btnbook = (Button) findViewById(R.id.btn_contenofhomestay_book);
        serviceDesc = (TextView) findViewById(R.id.tv_contenofhomestay_desc);
        serviceEvalution = (TextView) findViewById(R.id.tv_contenofhomestay_evaluation);
        serviceName = (TextView) findViewById(R.id.tv_contenofhomestay_name);
        serviceAddress = (EditText) findViewById(R.id.tv_contenofhomestay_address);
        serviceWifi = (CheckBox) findViewById(R.id.cb_contenofhomestay_wifi);
        serviceBreakfast = (CheckBox) findViewById(R.id.cb_contenofhomestay_freebreakfast);
        serviceSwimming = (CheckBox) findViewById(R.id.cb_contenofhomestay_swimmingpool);
        serviceAc = (CheckBox) findViewById(R.id.cb_contenofhomestay_ac);
        serviceImageController = ServiceImageController.getInstance(this,null);
    }

    @Override
    protected void setWidget()
    {
        serviceImageController.getAllImages(avf_images,partnerService.getPartnerServiceID());
        serviceDesc.setText(partnerService.getPartnerServiceDesc());
        serviceEvalution.setText(partnerService.getPartnerServiceEvalution() +"");
        serviceName.setText(partnerService.getPartnerServiceName());
        serviceAddress.setText(partnerService.getPartnerServiceAddressLine()
                + " , " + partnerService.getFk_LocationDistrictID()
                + " , " + partnerService.getFk_LocationCityID()
                + " , " + partnerService.getFk_LocationCountryID() + ".");
        if (partnerService.getPartnerServiceConvinience() != null) {
            String[] serviceConviniences = partnerService.getPartnerServiceConvinience().split("-");
            for (String serviceConvinience : serviceConviniences) {
                if (serviceConvinience.equals(ServiceConvinience.ac)) {
                    serviceAc.setChecked(true);
                }

                if (serviceConvinience.equals(ServiceConvinience.freeBreakfast)) {
                    serviceBreakfast.setChecked(true);
                }

                if (serviceConvinience.equals(ServiceConvinience.wifi)) {
                    serviceWifi.setChecked(true);
                }

                if (serviceConvinience.equals(ServiceConvinience.swimmingPool)) {
                    serviceSwimming.setChecked(true);
                }
            }
        }
    }

    @Override
    protected void init()
    {
        Intent intent = getIntent();
        partnerService = (PartnerService) intent.getSerializableExtra(EntityName.PartnerServices);
    }

    @Override
    protected void addListener()
    {
        btnbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ServiceBookActivity.class);
                intent.putExtra(EntityName.PartnerServices,partnerService);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.content_homestay);
    }
}
