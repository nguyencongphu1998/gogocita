package com.gogocita.admin.controllers.service;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.gogocita.admin.constant.EntityName;
import com.gogocita.admin.entity.PartnerServiceBook;
import com.gogocita.admin.gogocita.R;
import com.gogocita.admin.helper.FirebaseListAdapter;
import com.gogocita.admin.helper.QueryFirebase;
import com.gogocita.admin.helper.ViewHolder;

import java.util.List;

public class ServiceBookController {
    private QueryFirebase queryFirebase;
    private static ServiceBookController serviceBookController = null;
    private Activity activity;
    private ProgressBar progressBar;

    private ServiceBookController(Activity activity, ProgressBar progressBar)
    {
        this.activity = activity;
        this.progressBar = progressBar;
    }

    public static ServiceBookController getInstance(Activity activity, ProgressBar progressBar){
        if (serviceBookController == null){
            serviceBookController = new ServiceBookController(activity,progressBar);
        }else {
            serviceBookController.progressBar = progressBar;
            serviceBookController.activity = activity;
        }
        return serviceBookController;
    }

    public void updateOrInsert(PartnerServiceBook partnerServiceBook){
        QueryFirebase<PartnerServiceBook> queryFirebase = QueryFirebase.getInstance(EntityName.PartnerServiceBooks);
        queryFirebase.Update(partnerServiceBook.toMapUpdate(),partnerServiceBook.getPartnerServiceBookID());

        progressBar.setVisibility(View.GONE);
        Toast.makeText(activity,"Đã đặt phòng thành công, vui lòng chở phản hồi của chủ homeStay!!!",Toast.LENGTH_LONG).show();
    }

    public void getAllServiceBooks(ListView listView, Context context){
        QueryFirebase<PartnerServiceBook> queryFirebase = QueryFirebase.getInstance(EntityName.PartnerServiceBooks);
        FirebaseListAdapter<PartnerServiceBook> serviceAdapter = new FirebaseListAdapter(queryFirebase.getReferenceToSearch(null,null,null),PartnerServiceBook.class,R.layout.item_book,context) {
            @Override
            protected void populateView(ViewHolder vh, Object model) {

            }

            @Override
            protected void setViewHolder(ViewHolder vh, View v) {

            }


            @Override
            protected List modifyArrayAdapter(List models)
            {

                return models;
            }
        };

    }
}
