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
import com.gogocita.admin.dto.FilterServicesDto;
import com.gogocita.admin.entity.PartnerService;
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

import java.util.Comparator;
import java.util.Iterator;
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
                    //progressBar.setVisibility(View.GONE);
                    Intent intent = new Intent(activity,Step1Activity.class);
                    activity.startActivity(intent);
                }else {
                    Intent intent = new Intent(activity,activityClass);
                    intent.putExtra(EntityName.PartnerServices,model);
                    //progressBar.setVisibility(View.GONE);
                    activity.startActivity(intent);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void getAllServices(ListView listView, final Context context, final FilterServicesDto dto){
        QueryFirebase<PartnerService> queryFirebase = QueryFirebase.getInstance(EntityName.PartnerServices);
        FirebaseListAdapter<PartnerService> serviceAdapter = new FirebaseListAdapter(queryFirebase.getReferenceToSearch(null,null,null),PartnerService.class,R.layout.custom_services,context) {
            @Override
            protected void getViewHolder(ViewHolder vh, View v) {
                vh.setTextViewServiceName((TextView) v.findViewById(R.id.tv_listservice_name));
                vh.setTextViewServiceDescription((TextView) v.findViewById(R.id.tv_listservice_description));
                vh.setTextViewServiceEvalution((TextView) v.findViewById(R.id.tv_listservice_evalution));
                vh.setImageViewServiceCoverPhoto((ImageView) v.findViewById(R.id.iv_listservice_coverphoto));
                vh.setTextViewServiceCommentAmount((TextView) v.findViewById(R.id.tv_listservice_comment));
            }

            @Override
            protected void setViewHolder(ViewHolder vh, Object model) {
                if(((PartnerService)model).getPartnerServiceDesc().length() < 170)
                {
                    vh.getTextViewServiceDescription().setText(((PartnerService)model).getPartnerServiceDesc());
                }else {
                    vh.getTextViewServiceDescription().setText(((PartnerService)model).getPartnerServiceDesc().substring(0 , 170) + "...");
                }

                vh.getTextViewServiceName().setText(((PartnerService)model).getPartnerServiceName());
                vh.getTextViewServiceEvalution().setText(((PartnerService)model).getPartnerServiceEvalution() +"");
                vh.getTextViewServiceCommentAmount().setText(((PartnerService)model).getPartnerserviceFeedbackAmount() +"");
                Picasso.with(context)
                        .load(((PartnerService)model).getPartnerserviceCoverPhotoLink())
                        .placeholder(R.mipmap.ic_launcher)
                        .fit()
                        .centerCrop()
                        .into(vh.getImageViewServiceCoverPhoto());
            }

            @Override
            protected void addListener(ViewHolder vh, Object model) {

            }

            @Override
            protected List modifyArrayAdapter(List models)
            {
                if(dto != null){

                    if(!dto.getCountry().equals("")){
                        for (Iterator<PartnerService> iterator = models.iterator(); iterator.hasNext(); ) {
                            PartnerService value = iterator.next();
                            if(!value.getFk_LocationCountryID().equals(dto.getCountry())){
                                iterator.remove();
                            }
                        }
                    }

                    if(!dto.getCity().equals("")){
                        for (Iterator<PartnerService> iterator = models.iterator(); iterator.hasNext(); ) {
                            PartnerService value = iterator.next();
                            if(!value.getFk_LocationCityID().equals(dto.getCity())){
                                iterator.remove();
                            }
                        }
                    }

                    if(dto.getEvalutionSort().equals("asc")){
                        models.sort(new Comparator<PartnerService>() {
                            @Override
                            public int compare(PartnerService m1, PartnerService m2) {
                                if(m1.getPartnerServiceEvalution() == m2.getPartnerServiceEvalution()){
                                    return 0;
                                }
                                return m1.getPartnerServiceEvalution() > m2.getPartnerServiceEvalution() ? -1 : 1;
                            }
                        });
                    }

                    if(dto.getEvalutionSort().equals("desc")){
                        models.sort(new Comparator<PartnerService>() {
                            @Override
                            public int compare(PartnerService m1, PartnerService m2) {
                                if(m1.getPartnerServiceEvalution() == m2.getPartnerServiceEvalution()){
                                    return 0;
                                }
                                return m1.getPartnerServiceEvalution() < m2.getPartnerServiceEvalution() ? -1 : 1;
                            }
                        });
                    }
                }
                return models;
            }
        };

        listView.setAdapter(serviceAdapter);
    }

    public void updateEvalution(final int evalution,String partnerServiceId){
        final QueryFirebase queryFirebase = QueryFirebase.getInstance(EntityName.PartnerServices);
        queryFirebase.getReferenceToSearch(null,"partnerServiceID",partnerServiceId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot i: dataSnapshot.getChildren()) {
                    PartnerService partnerService = i.getValue(PartnerService.class);
                    if(partnerService == null){
                        Toast.makeText(activity,"Error!!!",Toast.LENGTH_SHORT).show(); break;
                    }else {
                        partnerService.setPartnerserviceFeedbackAmount(partnerService.getPartnerserviceFeedbackAmount() + 1);
                        partnerService.setPartnerServiceEvalution(evalution);
                        queryFirebase.Update(partnerService.toMapUpdateEvalution(),partnerService.getPartnerServiceID());

                        Toast.makeText(activity,"Send feedback successfully!!!",Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
