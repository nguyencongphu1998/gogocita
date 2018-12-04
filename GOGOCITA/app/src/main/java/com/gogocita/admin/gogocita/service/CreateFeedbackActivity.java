package com.gogocita.admin.gogocita.service;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.Toast;

import com.gogocita.admin.constant.EntityName;
import com.gogocita.admin.controllers.service.ServiceFeedbackController;
import com.gogocita.admin.entity.PartnerServiceFeedback;
import com.gogocita.admin.gogocita.BaseMenuActivity;
import com.gogocita.admin.gogocita.R;

public class CreateFeedbackActivity  extends BaseMenuActivity {
    private EditText edt_content;
    private Button btn_send;
    private static PartnerServiceFeedback partnerServiceFeedback;
    private ServiceFeedbackController serviceFeedbackController;
    private RatingBar ratingBar;
    @Override
    protected void init() {
        Intent intent = getIntent();
        partnerServiceFeedback = (PartnerServiceFeedback) intent.getSerializableExtra(EntityName.PartnerServiceFeedbacks);
    }

    @Override
    protected void setWidget() {
        if(partnerServiceFeedback.ispSFIsSend()){
            btn_send.setVisibility(View.GONE);
            edt_content.setEnabled(false);
            edt_content.setText(partnerServiceFeedback.getpSFContent());
        }
    }

    @Override
    protected void getWidget() {
        edt_content = (EditText) findViewById(R.id.ev_feedback_content);
        btn_send = (Button) findViewById(R.id.btn_feedback_send);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        ratingBar = (RatingBar) findViewById(R.id.rating_bar_container);
        serviceFeedbackController = ServiceFeedbackController.getInstance(this,progressBar);
    }

    @Override
    protected void addListener() {
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(edt_content.getText().toString())) {
                    Toast.makeText(CreateFeedbackActivity.this, "Content is empty!", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                btn_send.setEnabled(false);
                partnerServiceFeedback.setpSFIsSend(true);
                partnerServiceFeedback.setpSFContent(edt_content.getText().toString());
                partnerServiceFeedback.setpSFEvalution((int)ratingBar.getRating());
                serviceFeedbackController.showAlertDialog(partnerServiceFeedback);
            }
        });
    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.feedback_customer);
    }
}
