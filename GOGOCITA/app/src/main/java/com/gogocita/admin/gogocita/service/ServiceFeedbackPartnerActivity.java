package com.gogocita.admin.gogocita.service;

import android.widget.ListView;
import android.widget.ProgressBar;

import com.gogocita.admin.controllers.service.ServiceFeedbackController;
import com.gogocita.admin.gogocita.BaseMenuActivity;
import com.gogocita.admin.gogocita.R;
import com.google.firebase.auth.FirebaseAuth;

public class ServiceFeedbackPartnerActivity extends BaseMenuActivity {
    private ListView listView;
    private ServiceFeedbackController serviceFeedbackController;
    @Override
    protected void init() {

    }

    @Override
    protected void setWidget() {
        serviceFeedbackController = ServiceFeedbackController.getInstance(this,null);
        serviceFeedbackController.getAllFeedbackPartners(listView,this, FirebaseAuth.getInstance().getUid());
    }

    @Override
    protected void getWidget() {
        listView = (ListView) findViewById(R.id.listview_feedback_homestay);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    @Override
    protected void addListener() {

    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.list_feedback_homestay);
    }
}
