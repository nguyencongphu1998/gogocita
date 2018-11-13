package com.gogocita.admin.gogocita.service;

import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.gogocita.admin.controllers.service.ServiceBookController;
import com.gogocita.admin.gogocita.BaseMenuActivity;
import com.gogocita.admin.gogocita.R;

public class BooksActiviry extends BaseMenuActivity {
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
        serviceBookController.getAllServiceBooks(lvBook,this);
    }

    @Override
    protected void getWidget() {
        btnReturn = (Button) findViewById(R.id.btn_listbook_returnDashboard);
        lvBook = (ListView) findViewById(R.id.lv_books);
        progressBar = (ProgressBar) findViewById(R.id.progressBar_books);
    }

    @Override
    protected void addListener() {

    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.listbook);
    }
}
