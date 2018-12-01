package com.gogocita.admin.gogocita.service;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.gogocita.admin.constant.EntityName;
import com.gogocita.admin.controllers.service.ServiceFeedbackController;
import com.gogocita.admin.entity.PartnerServiceFeedback;
import com.gogocita.admin.gogocita.BaseMenuActivity;
import com.gogocita.admin.gogocita.R;
import com.google.firebase.auth.FirebaseAuth;

public class ServiceFeedbackCustomerActivity extends BaseMenuActivity {
    private ListView listView;
    private ServiceFeedbackController serviceFeedbackController;
    @Override
    protected void init() {

    }

    @Override
    protected void setWidget() {
        serviceFeedbackController = ServiceFeedbackController.getInstance(this,null);
        serviceFeedbackController.getAllFeedbacks(listView,this, FirebaseAuth.getInstance().getUid());
    }

    @Override
    protected void getWidget() {
        listView = (ListView) findViewById(R.id.listview_feedback);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    @Override
    protected void addListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),CreateFeedbackActivity.class);
                intent.putExtra(EntityName.PartnerServiceFeedbacks,(PartnerServiceFeedback)(adapterView.getAdapter()).getItem(i));
                getApplicationContext().startActivity(intent);
            }
        });
    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.list_feedback_customer);
    }
}
