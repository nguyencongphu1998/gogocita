package com.gogocita.admin.gogocita.service;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.gogocita.admin.constant.EntityName;
import com.gogocita.admin.constant.ServiceConvinience;
import com.gogocita.admin.entity.PartnerService;
import com.gogocita.admin.gogocita.R;
import com.squareup.picasso.Picasso;

public class ServiceDetailActivity extends AppCompatActivity {
    private TextView serviceName,serviceDesc,serviceEvalution,serviceVote;
    private EditText serviceAddress;
    private ImageView serviceCoverPhoto;
    private Button btnbook;
    private CheckBox serviceWifi,serviceBreakfast,serviceSwimming,serviceAc;
    private PartnerService partnerService;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_homestay);
        init();
        getWidget();
        setWidget();
        addListener();
    }

    private void getWidget()
    {
        serviceCoverPhoto = (ImageView) findViewById(R.id.image_contenofhomestay_avatar);
        btnbook = (Button) findViewById(R.id.btn_contenofhomestay_book);
        serviceDesc = (TextView) findViewById(R.id.tv_contenofhomestay_desc);
        serviceEvalution = (TextView) findViewById(R.id.tv_contenofhomestay_evaluation);
        serviceName = (TextView) findViewById(R.id.tv_contenofhomestay_name);
        serviceAddress = (EditText) findViewById(R.id.tv_contenofhomestay_address);
        serviceWifi = (CheckBox) findViewById(R.id.cb_contenofhomestay_wifi);
        serviceBreakfast = (CheckBox) findViewById(R.id.cb_contenofhomestay_freebreakfast);
        serviceSwimming = (CheckBox) findViewById(R.id.cb_contenofhomestay_swimmingpool);
        serviceAc = (CheckBox) findViewById(R.id.cb_contenofhomestay_ac);;
    }
    private void setWidget()
    {
        Picasso.with(this)
                .load(partnerService.getPartnerserviceCoverPhotoLink())
                .placeholder(R.mipmap.ic_launcher)
                .fit()
                .centerCrop()
                .into(serviceCoverPhoto);
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

    private void init()
    {
        Intent intent = getIntent();
        partnerService = (PartnerService) intent.getSerializableExtra(EntityName.PartnerServices);
    }

    private void addListener()
    {

    }
}
