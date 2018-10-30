package com.gogocita.admin.gogocita.service;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.gogocita.admin.constant.EntityName;
import com.gogocita.admin.entity.PartnerService;
import com.gogocita.admin.gogocita.R;

public class ServiceDetailActivity extends AppCompatActivity {
    private TextView serviceName,serviceDesc,serviceEvalution,serviceVote;
    private Button btnbook;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_service);
        init();
    }

    private void init()
    {
        btnbook = (Button) findViewById(R.id.btn_servicedetail_book);
    }

    private void setData()
    {
        Intent intent = getIntent();
        PartnerService partnerService = (PartnerService) intent.getSerializableExtra(EntityName.PartnerServices);
    }
}
