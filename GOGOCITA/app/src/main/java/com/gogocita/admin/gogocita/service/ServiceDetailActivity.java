package com.gogocita.admin.gogocita.service;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterViewFlipper;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.gogocita.admin.constant.EntityName;
import com.gogocita.admin.constant.ServiceConvinience;
import com.gogocita.admin.controllers.service.ServiceFeedbackController;
import com.gogocita.admin.controllers.service.ServiceImageController;
import com.gogocita.admin.entity.PartnerService;
import com.gogocita.admin.gogocita.BaseMenuActivity;
import com.gogocita.admin.gogocita.R;
import com.gogocita.admin.helper.NonScrollListView;


public class ServiceDetailActivity extends BaseMenuActivity {
    private TextView serviceName,serviceDesc,serviceEvalution,serviceVote,serviceVote1;
    private EditText serviceAddress;
    private Button btnbook;
    private CheckBox serviceWifi,serviceBreakfast,serviceSwimming,serviceAc;
    private RatingBar ratingBar;
    private NonScrollListView lv_Feedback;
    private AdapterViewFlipper avf_images;
    private PartnerService partnerService;
    private ServiceImageController serviceImageController;
    private ServiceFeedbackController serviceFeedbackController;

    @Override
    protected void getWidget()
    {
        avf_images = (AdapterViewFlipper) findViewById(R.id.avf_serviceDetail_images);
        btnbook = (Button) findViewById(R.id.btn_contenofhomestay_book);
        serviceDesc = (TextView) findViewById(R.id.tv_contenofhomestay_desc);
        serviceEvalution = (TextView) findViewById(R.id.tv_contenofhomestay_evaluation);
        serviceName = (TextView) findViewById(R.id.tv_contenofhomestay_name);
        serviceVote = (TextView) findViewById(R.id.tv_servicedetail_vote);
        serviceVote1 = (TextView) findViewById(R.id.tv_servicedetail_vote1);
        serviceAddress = (EditText) findViewById(R.id.tv_contenofhomestay_address);
        serviceWifi = (CheckBox) findViewById(R.id.cb_contenofhomestay_wifi);
        serviceBreakfast = (CheckBox) findViewById(R.id.cb_contenofhomestay_freebreakfast);
        serviceSwimming = (CheckBox) findViewById(R.id.cb_contenofhomestay_swimmingpool);
        serviceAc = (CheckBox) findViewById(R.id.cb_contenofhomestay_ac);
        ratingBar = (RatingBar) findViewById(R.id.rating_bar_container);
        lv_Feedback = (NonScrollListView) findViewById(R.id.lv_feedback);
        serviceImageController = ServiceImageController.getInstance(this,null);
        serviceFeedbackController = ServiceFeedbackController.getInstance(this,null);
    }

    @Override
    protected void setWidget()
    {
        serviceImageController.getAllImages(avf_images,partnerService.getPartnerServiceID());
        serviceDesc.setText(partnerService.getPartnerServiceDesc());
        serviceEvalution.setText(partnerService.getPartnerServiceEvalution() + "");
        serviceName.setText(partnerService.getPartnerServiceName());
        serviceVote.setText(partnerService.getPartnerserviceFeedbackAmount() + "");
        serviceVote1.setText(partnerService.getPartnerserviceFeedbackAmount() + "");
        ratingBar.setRating((int) partnerService.getPartnerServiceEvalution());
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

        serviceFeedbackController.getAllFeedbackServices(lv_Feedback,this,partnerService.getPartnerServiceID());
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
