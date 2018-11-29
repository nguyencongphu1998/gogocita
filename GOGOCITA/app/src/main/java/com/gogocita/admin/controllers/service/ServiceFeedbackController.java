package com.gogocita.admin.controllers.service;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.ProgressBar;

import com.gogocita.admin.constant.EntityName;
import com.gogocita.admin.entity.PartnerServiceFeedback;
import com.gogocita.admin.helper.QueryFirebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class ServiceFeedbackController {
    private QueryFirebase queryFirebase;
    private static ServiceFeedbackController serviceFeedbackController = null;
    private ServiceController serviceController;
    private Activity activity;
    private ProgressBar progressBar;

    private ServiceFeedbackController(Activity activity, ProgressBar progressBar)
    {
        this.activity = activity;
        this.progressBar = progressBar;
    }

    public static ServiceFeedbackController getInstance(Activity activity, ProgressBar progressBar){
        if (serviceFeedbackController == null){
            serviceFeedbackController = new ServiceFeedbackController(activity,progressBar);
        }else {
            serviceFeedbackController.progressBar = progressBar;
            serviceFeedbackController.activity = activity;
        }
        serviceFeedbackController.serviceController = ServiceController.getInstance(activity,progressBar);
        return serviceFeedbackController;
    }

    public void updateOrInsert(PartnerServiceFeedback partnerServiceFeedback){
        QueryFirebase<PartnerServiceFeedback> queryFirebase = QueryFirebase.getInstance(EntityName.PartnerServiceFeedbacks);
        queryFirebase.Insert(partnerServiceFeedback,partnerServiceFeedback.getpSFID());
    }


    private void updateEvalutionOfService(final String partnerServiceID){
        QueryFirebase queryFirebase = QueryFirebase.getInstance(EntityName.PartnerServiceFeedbacks);
        queryFirebase.getReferenceToSearch(null,"fk_PartnerServiceID", partnerServiceID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){
                int evalution = 4;
                for (DataSnapshot i: dataSnapshot.getChildren()) {
                    PartnerServiceFeedback partnerServiceFeedback = i.getValue(PartnerServiceFeedback.class);
                    evalution += partnerServiceFeedback.getpSFEvalution();
                }
                evalution /= (dataSnapshot.getChildrenCount() + 1);
                serviceController.updateEvalution(evalution,partnerServiceID);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void showAlertDialog(final PartnerServiceFeedback partnerServiceFeedback)
    {
        final AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("GOGOCITA");
        builder.setMessage("Are u sure for this action?");
        builder.setCancelable(false);
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                updateOrInsert(partnerServiceFeedback);
                updateEvalutionOfService(partnerServiceFeedback.getFk_PartnerServiceID());
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                builder.setCancelable(true);
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}
