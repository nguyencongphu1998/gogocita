package com.gogocita.admin.gogocita.service;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.gogocita.admin.controllers.service.ServiceBookController;
import com.gogocita.admin.gogocita.BaseMenuActivity;
import com.gogocita.admin.gogocita.R;
import com.google.firebase.auth.FirebaseAuth;

public class HistoryOrdersActivity extends BaseMenuActivity {
    private Button btnReturn;
    private ListView lvBook;
    private ProgressBar progressBar;
    private ServiceBookController serviceBookController;
    @Override
    protected void init() {

    }

    @Override
    protected void setWidget() {
        serviceBookController = ServiceBookController.getInstance(this,null);
        serviceBookController.getAllServiceBooksOfHomeStay(lvBook,this, FirebaseAuth.getInstance().getUid());
    }

    @Override
    protected void getWidget() {
        btnReturn = (Button) findViewById(R.id.btn_listbook_returnDashboard);
        lvBook = (ListView) findViewById(R.id.lv_books);
        progressBar = (ProgressBar) findViewById(R.id.progressBar_books);
    }

    @Override
    protected void addListener() {
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ServicesActivity.class));
                finish();
            }
        });
    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.listbook);
    }
}
