package com.gogocita.admin.controllers.service;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.gogocita.admin.constant.EntityName;
import com.gogocita.admin.entity.PartnerService;
import com.gogocita.admin.entity.UserDetail;
import com.gogocita.admin.gogocita.service.Step1Activity;
import com.gogocita.admin.helper.QueryFirebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

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
        }
        return serviceController;
    }

    public void updateOrInsert(PartnerService partnerService){
        QueryFirebase<UserDetail> queryFirebase = QueryFirebase.getInstance(EntityName.PartnerServices);
        queryFirebase.Update(partnerService.toMapUpdate(),partnerService.getFk_PartnerID());

        progressBar.setVisibility(View.GONE);
        Toast.makeText(activity,"Update Success!!!",Toast.LENGTH_SHORT).show();
    }

    public void getServiceDetail(final Class activityClass){
        QueryFirebase queryFirebase = QueryFirebase.getInstance(EntityName.PartnerServices);
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        queryFirebase.getReferenceToSearch(null,"fK_PartnerID",user.getUid()).addValueEventListener(new ValueEventListener() {
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
}
