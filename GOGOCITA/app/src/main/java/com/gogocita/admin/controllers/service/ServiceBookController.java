package com.gogocita.admin.controllers.service;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.gogocita.admin.constant.EntityName;
import com.gogocita.admin.constant.PartnerServiceDateStatus;
import com.gogocita.admin.entity.PartnerService;
import com.gogocita.admin.entity.PartnerServiceBook;
import com.gogocita.admin.gogocita.R;
import com.gogocita.admin.gogocita.service.ServiceDetailActivity;
import com.gogocita.admin.helper.FirebaseListAdapter;
import com.gogocita.admin.helper.QueryFirebase;
import com.gogocita.admin.helper.ViewHolder;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
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

    public void getAllServiceBooks(ListView listView, Context context, String customerID){
        QueryFirebase<PartnerServiceBook> queryFirebase = QueryFirebase.getInstance(EntityName.PartnerServiceBooks);
        FirebaseListAdapter<PartnerServiceBook> serviceAdapter = new FirebaseListAdapter(queryFirebase.getReferenceToSearch(null,"fk_CustomerID",customerID),PartnerServiceBook.class,R.layout.item_customer,context) {
            @Override
            protected void populateView(final ViewHolder vh, final Object model) {
                QueryFirebase queryFirebase = QueryFirebase.getInstance(EntityName.PartnerServices);
                queryFirebase.getReferenceToSearch(null,"partnerServiceID",((PartnerServiceBook) model).getfK_PartnerServiceID()).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot i: dataSnapshot.getChildren()) {
                            PartnerService partnerService = i.getValue(PartnerService.class);
                            if(partnerService == null){
                                Toast.makeText(activity,"Error!!!",Toast.LENGTH_SHORT).show(); break;
                            }else {
                                vh.getTextViewBookNameOfHomeStay().setText(partnerService.getPartnerServiceName());
                                vh.getTextViewBookAddress().setText(partnerService.getPartnerServiceAddressLine());
                                ((PartnerServiceBook)model).setPartnerService(partnerService);
                                break;
                            }
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                vh.getTextViewBookStatus().setText(((PartnerServiceBook) model).getPartnerServiceBookStatus());
                vh.getTextViewBookCheckIn().setText(new SimpleDateFormat("MM-dd-yyyy").format(((PartnerServiceBook) model).getPartnerServiceBookFrom()));
                vh.getTextViewBookCheckOut().setText(new SimpleDateFormat("MM-dd-yyyy").format(((PartnerServiceBook) model).getPartnerServiceBookTo()));
                if(((PartnerServiceBook) model).getPartnerServiceBookStatus().equals(PartnerServiceDateStatus.Pending)){
                    vh.getTextViewBookStatus().setBackgroundResource(R.color.pending);
                }else if(((PartnerServiceBook) model).getPartnerServiceBookStatus().equals(PartnerServiceDateStatus.Cancel)){
                    vh.getTextViewBookStatus().setBackgroundResource(R.color.cancel);
                }else {
                    vh.getTextViewBookStatus().setBackgroundResource(R.color.confirm);
                }

                vh.getTextViewBookNameOfHomeStay().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(activity,ServiceDetailActivity.class);
                        intent.putExtra(EntityName.PartnerServices, ((PartnerServiceBook) model).getPartnerService());
                        activity.startActivity(intent);
                    }
                });
            }

            @Override
            protected void setViewHolder(ViewHolder vh, View v) {
                vh.setTextViewBookStatus((TextView) v.findViewById(R.id.tv_book_status));
                vh.setTextViewBookAddress((TextView) v.findViewById(R.id.tv_book_address));
                vh.setTextViewBookCheckIn((TextView) v.findViewById(R.id.tv_book_checkin));
                vh.setTextViewBookCheckOut((TextView) v.findViewById(R.id.tv_book_checkout));
                vh.setTextViewBookNameOfHomeStay((TextView) v.findViewById(R.id.tv_book_nameofhomestay));
                vh.setLinearLayoutBook((LinearLayout) v.findViewById(R.id.backgroud_book));
            }


            @Override
            protected List modifyArrayAdapter(List models)
            {
                return models;
            }
        };
        listView.setAdapter(serviceAdapter);
    }

    private void getServiceDetail(final String serviceID){
        QueryFirebase queryFirebase = QueryFirebase.getInstance(EntityName.PartnerServices);
        queryFirebase.getReferenceToSearch(null,"partnerServiceID",serviceID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                PartnerService model = dataSnapshot.getValue(PartnerService.class);
                if(model == null){
                    Toast.makeText(activity,"Error!!!",Toast.LENGTH_SHORT).show();
                }else {

                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
