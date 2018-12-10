package com.gogocita.admin.controllers.service;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.gogocita.admin.constant.EntityName;
import com.gogocita.admin.controllers.user.UserDetailsController;
import com.gogocita.admin.entity.PartnerService;
import com.gogocita.admin.entity.PartnerServiceFeedback;
import com.gogocita.admin.gogocita.R;
import com.gogocita.admin.helper.FirebaseListAdapter;
import com.gogocita.admin.helper.QueryFirebase;
import com.gogocita.admin.helper.ViewHolder;
import com.google.api.client.util.DateTime;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ServiceFeedbackController {
    private QueryFirebase queryFirebase;
    private static ServiceFeedbackController serviceFeedbackController = null;
    private ServiceController serviceController;
    private UserDetailsController userDetailsController;
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
        serviceFeedbackController.userDetailsController = UserDetailsController.getInstance(activity,progressBar);
        return serviceFeedbackController;
    }

    public void updateOrInsert(PartnerServiceFeedback partnerServiceFeedback){
        QueryFirebase<PartnerServiceFeedback> queryFirebase = QueryFirebase.getInstance(EntityName.PartnerServiceFeedbacks);
        queryFirebase.Insert(partnerServiceFeedback,partnerServiceFeedback.getpSFID());
    }


    public void updateEvalutionOfService(final String partnerServiceID){
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

    public void getAllFeedbacks(ListView listView, Context context, String customerID){
        QueryFirebase<PartnerServiceFeedback> queryFirebase = QueryFirebase.getInstance(EntityName.PartnerServiceFeedbacks);
        FirebaseListAdapter<PartnerServiceFeedback> serviceAdapter = new FirebaseListAdapter(queryFirebase.getReferenceToSearch(null,"fk_CustomerID",customerID),PartnerServiceFeedback.class,R.layout.custom_feedback_customer,context) {
            @Override
            protected void getViewHolder(ViewHolder vh, View v) {
                vh.setTextViewBookAddress((TextView) v.findViewById(R.id.tv_feedback_address));
                vh.setTextViewBookCheckIn((TextView) v.findViewById(R.id.tv_feedback_checkin));
                vh.setTextViewBookCheckOut((TextView) v.findViewById(R.id.tv_feedback_checkout));
                vh.setTextViewBookNameOfHomeStay((TextView) v.findViewById(R.id.tv_feedback_nameofhomestay));
                vh.setImageViewFeedbackNew((ImageView) v.findViewById(R.id.image_feedback_new));
            }

            @Override
            protected void setViewHolder(final ViewHolder vh, final Object model) {

                QueryFirebase queryFirebase = QueryFirebase.getInstance(EntityName.PartnerServices);
                queryFirebase.getReferenceToSearch(null,"partnerServiceID",((PartnerServiceFeedback) model).getFk_PartnerServiceID()).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot i: dataSnapshot.getChildren()) {
                            PartnerService partnerService = i.getValue(PartnerService.class);
                            if(partnerService == null){
                                Toast.makeText(activity,"Error!!!",Toast.LENGTH_SHORT).show(); break;
                            }else {
                                vh.getTextViewBookNameOfHomeStay().setText(partnerService.getPartnerServiceName());
                                vh.getTextViewBookAddress().setText(partnerService.getPartnerServiceAddressLine());
                                break;
                            }
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                vh.getTextViewBookCheckIn().setText(new SimpleDateFormat("MM-dd-yyyy").format(((PartnerServiceFeedback) model).getpSFEFrom()));
                vh.getTextViewBookCheckOut().setText(new SimpleDateFormat("MM-dd-yyyy").format(((PartnerServiceFeedback) model).getpSFETo()));
                if(((PartnerServiceFeedback) model).ispSFIsSend()){
                    vh.getImageViewFeedbackNew().setVisibility(View.GONE);
                }

            }

            @Override
            protected void addListener(final ViewHolder vh, final Object model) {

            }

            @Override
            protected List modifyArrayAdapter(List models)
            {
                for (Iterator<PartnerServiceFeedback> iterator = models.iterator(); iterator.hasNext(); ) {
                    PartnerServiceFeedback value = iterator.next();
                    if(value.getpSFETo().getTime() > System.currentTimeMillis()){
                        iterator.remove();
                    }
                }
                return models;
            }
        };
        listView.setAdapter(serviceAdapter);
    }


    public void getAllFeedbackPartners(ListView listView, Context context, String customerID){
        QueryFirebase<PartnerServiceFeedback> queryFirebase = QueryFirebase.getInstance(EntityName.PartnerServiceFeedbacks);
        FirebaseListAdapter<PartnerServiceFeedback> serviceAdapter = new FirebaseListAdapter(queryFirebase.getReferenceToSearch(null,"fk_PartnerID",customerID),PartnerServiceFeedback.class,R.layout.custom_feedback_homestay,context) {
            @Override
            protected void getViewHolder(ViewHolder vh, View v) {
                vh.setTextViewBookAddress((TextView) v.findViewById(R.id.tv_feedback_phone));
                vh.setTextViewBookCheckIn((TextView) v.findViewById(R.id.tv_feedback_checkin));
                vh.setTextViewBookCheckOut((TextView) v.findViewById(R.id.tv_feedback_checkout));
                vh.setTextViewBookNameOfHomeStay((TextView) v.findViewById(R.id.tv_feedback_name));
                vh.setTextViewFeedbackContent((TextView) v.findViewById(R.id.tv_feedback_content));
                vh.setTextViewFeedbackEvalution((TextView) v.findViewById(R.id.tv_feedback_evalution));
            }

            @Override
            protected void setViewHolder(final ViewHolder vh, final Object model) {

                QueryFirebase queryFirebase = QueryFirebase.getInstance(EntityName.UserDetails);
                queryFirebase.getReferenceToSearch(null,"fk_UserID",((PartnerServiceFeedback) model).getFk_CustomerID()).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        userDetailsController.getShortUserDetail(vh.getTextViewBookNameOfHomeStay(),null,vh.getTextViewBookAddress(),((PartnerServiceFeedback) model).getFk_PartnerID());
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                vh.getTextViewBookCheckIn().setText(new SimpleDateFormat("MM-dd-yyyy").format(((PartnerServiceFeedback) model).getpSFEFrom()));
                vh.getTextViewBookCheckOut().setText(new SimpleDateFormat("MM-dd-yyyy").format(((PartnerServiceFeedback) model).getpSFETo()));
                vh.getTextViewFeedbackContent().setText(((PartnerServiceFeedback) model).getpSFContent());
                vh.getTextViewFeedbackEvalution().setText(((PartnerServiceFeedback) model).getpSFEvalution()+"");

            }

            @Override
            protected void addListener(final ViewHolder vh, final Object model) {

            }

            @Override
            protected List modifyArrayAdapter(List models)
            {
                for (Iterator<PartnerServiceFeedback> iterator = models.iterator(); iterator.hasNext(); ) {
                    PartnerServiceFeedback value = iterator.next();
                    if(!value.ispSFIsSend()){
                        iterator.remove();
                    }
                }
                return models;
            }
        };
        listView.setAdapter(serviceAdapter);
    }

    public void getAllFeedbackServices(ListView listView, Context context, String serviceID){
        QueryFirebase<PartnerServiceFeedback> queryFirebase = QueryFirebase.getInstance(EntityName.PartnerServiceFeedbacks);
        FirebaseListAdapter<PartnerServiceFeedback> serviceAdapter = new FirebaseListAdapter(queryFirebase.getReferenceToSearch(null,"fk_PartnerServiceID",serviceID),PartnerServiceFeedback.class,R.layout.custom_feedback_content,context) {
            @Override
            protected void getViewHolder(ViewHolder vh, View v) {
                vh.setRatingBar((RatingBar) v.findViewById(R.id.rating_bar_container));
                vh.setTextViewBookNameOfHomeStay((TextView) v.findViewById(R.id.tv_feedback_name));
                vh.setTextViewFeedbackContent((TextView) v.findViewById(R.id.tv_feedback_content));
            }

            @Override
            protected void setViewHolder(final ViewHolder vh, final Object model) {

                QueryFirebase queryFirebase = QueryFirebase.getInstance(EntityName.UserDetails);
                queryFirebase.getReferenceToSearch(null,"fk_UserID",((PartnerServiceFeedback) model).getFk_CustomerID()).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        userDetailsController.getShortUserDetail(vh.getTextViewBookNameOfHomeStay(),null,null,((PartnerServiceFeedback) model).getFk_PartnerID());
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                vh.getTextViewFeedbackContent().setText(((PartnerServiceFeedback) model).getpSFContent());
                vh.getRatingBar().setRating(((PartnerServiceFeedback) model).getpSFEvalution());

            }

            @Override
            protected void addListener(final ViewHolder vh, final Object model) {

            }

            @Override
            protected List modifyArrayAdapter(List models)
            {
                for (Iterator<PartnerServiceFeedback> iterator = models.iterator(); iterator.hasNext(); ) {
                    PartnerServiceFeedback value = iterator.next();
                    if(!value.ispSFIsSend()){
                        iterator.remove();
                    }
                }
                return models;
            }
        };
        listView.setAdapter(serviceAdapter);
    }

    public void showAlertDialog(final PartnerServiceFeedback partnerServiceFeedback)
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
