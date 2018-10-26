package com.gogocita.admin.controllers.service;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.gogocita.admin.constant.EntityName;
import com.gogocita.admin.entity.PartnerService;
import com.gogocita.admin.entity.UserDetail;
import com.gogocita.admin.gogocita.R;
import com.gogocita.admin.gogocita.service.Step1Activity;
import com.gogocita.admin.helper.FirebaseListAdapter;
import com.gogocita.admin.helper.QueryFirebase;
import com.gogocita.admin.helper.ViewHolder;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ServiceController {
    private QueryFirebase queryFirebase;
    private static ServiceController serviceController = null;
    private Activity activity;
    private ProgressBar progressBar;

    private ServiceController(Activity activity, ProgressBar progressBar)
    {
        this.activity = activity;
        this.progressBar = progressBar;
    }

    public static ServiceController getInstance(Activity activity, ProgressBar progressBar){
        if (serviceController == null){
            serviceController = new ServiceController(activity,progressBar);
        }else {
            serviceController.progressBar = progressBar;
            serviceController.activity = activity;
        }
        return serviceController;
    }

    public void updateOrInsert(PartnerService partnerService){
        QueryFirebase<PartnerService> queryFirebase = QueryFirebase.getInstance(EntityName.PartnerServices);
        queryFirebase.Update(partnerService.toMapUpdate(),partnerService.getFk_PartnerID());

        progressBar.setVisibility(View.GONE);
        Toast.makeText(activity,"Update Success!!!",Toast.LENGTH_SHORT).show();
    }

    public void updateCoverPhoto(PartnerService partnerService,String partnerId){
        QueryFirebase<PartnerService> queryFirebase = QueryFirebase.getInstance(EntityName.PartnerServices);
        queryFirebase.Update(partnerService.toMapUpdateCoverPhoto(),partnerId);
    }

    public void getServiceDetail(final Class activityClass){
        QueryFirebase<PartnerService> queryFirebase = QueryFirebase.getInstance(EntityName.PartnerServices);
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        queryFirebase.getReferenceToSearch(null,"fk_PartnerID",user.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                PartnerService model = dataSnapshot.child(user.getUid()).getValue(PartnerService.class);
                if(model == null){
                    progressBar.setVisibility(View.GONE);
                    Intent intent = new Intent(activity,Step1Activity.class);
                    activity.startActivity(intent);
                }else {
                    Intent intent = new Intent(activity,activityClass);
                    intent.putExtra(EntityName.PartnerServices,model);
                    progressBar.setVisibility(View.GONE);
                    activity.startActivity(intent);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void getAllServices(ListView listView, final Context context){
        QueryFirebase<PartnerService> queryFirebase = QueryFirebase.getInstance(EntityName.PartnerServices);
        FirebaseListAdapter<PartnerService> serviceAdapter = new FirebaseListAdapter(queryFirebase.getReferenceToSearch(null,null,null),PartnerService.class,R.layout.custom_services,context) {
            @Override
            protected void populateView(ViewHolder vh, Object model) {
                vh.getTextViewServiceDescription().setText(((PartnerService)model).getPartnerServiceDesc());
                vh.getTextViewServiceName().setText(((PartnerService)model).getPartnerServiceName());
                vh.getTextViewServiceEvalution().setText(((PartnerService)model).getPartnerServiceEvalution() +"");
                Picasso.with(context)
                        .load(((PartnerService)model).getPartnerserviceCoverPhotoLink())
                        .placeholder(R.mipmap.ic_launcher)
                        .fit()
                        .centerCrop()
                        .into(vh.getImageViewServiceCoverPhoto());
            }

            @Override
            protected void setViewHolder(ViewHolder vh, View v) {
                vh.setTextViewServiceName((TextView) v.findViewById(R.id.tv_listservice_name));
                vh.setTextViewServiceDescription((TextView) v.findViewById(R.id.tv_listservice_description));
                vh.setTextViewServiceEvalution((TextView) v.findViewById(R.id.tv_listservice_evalution));
                vh.setTextViewServiceEvalution((TextView) v.findViewById(R.id.tv_listservice_evalution));
                vh.setImageViewServiceCoverPhoto((ImageView) v.findViewById(R.id.iv_listservice_coverphoto));
            }


            @Override
            protected List modifyArrayAdapter(List models) {
                return models;
            }
        };

        listView.setAdapter(serviceAdapter);
    }
}
