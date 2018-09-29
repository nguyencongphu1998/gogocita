package com.gogocita.admin.controllers.user;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.gogocita.admin.constant.EntityName;
import com.gogocita.admin.entity.UserDetail;
import com.gogocita.admin.gogocita.R;
import com.gogocita.admin.gogocita.users.UserDetailActivity;
import com.gogocita.admin.helper.FirebaseListAdapter;
import com.gogocita.admin.helper.QueryFirebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


import java.text.SimpleDateFormat;
import java.util.List;

public class UserDetailsController {
    private QueryFirebase queryFirebase;
    private FirebaseUser user;
    private static UserDetailsController userDetailController = null;
    private Activity activity;

    private UserDetailsController(Activity activity)
    {
        this.activity = activity;
    }

    public static UserDetailsController getInstance(Activity activity){
        if (userDetailController == null){
            userDetailController = new UserDetailsController(activity);
        }
        return userDetailController;
    }

    public void updateOrInsert(UserDetail userDetail, ProgressBar progressBar){
        QueryFirebase<UserDetail> queryFirebase = QueryFirebase.getInstance(EntityName.UserDetails);
        queryFirebase.Update(userDetail.toMapUpdate(),userDetail.getFk_UserID());
        Toast.makeText(activity,"Update Success!!!",Toast.LENGTH_SHORT).show();
        progressBar.setVisibility(View.GONE);
        activity.startActivity(new Intent(activity, UserDetailActivity.class));
        activity.finish();
    }

    public void getDetail(ListView listView,String userID){
        queryFirebase = QueryFirebase.getInstance(EntityName.UserDetails);
        user = FirebaseAuth.getInstance().getCurrentUser();
        FirebaseListAdapter<UserDetail> userDetailAdapter = new FirebaseListAdapter(queryFirebase.getReferenceToSearch(null,"fk_UserID",user.getUid()),UserDetail.class,R.layout.custom_listview_userdetail,activity) {
            @Override
            protected void populateView(View v, Object model) {
                ((TextView) v.findViewById(R.id.textview_firstname)).setText(((UserDetail)model).getUserDetailFirstName());
                ((TextView) v.findViewById(R.id.textview_lastname)).setText(((UserDetail)model).getUserDetailLastName());
                ((TextView) v.findViewById(R.id.textview_birthday)).setText(new SimpleDateFormat("MM-dd-yyyy").format(((UserDetail)model).getUserDetailBirthDay()));
                ((TextView) v.findViewById(R.id.textview_phone)).setText(((UserDetail)model).getUserDetailPhone());
                ((TextView) v.findViewById(R.id.textview_gender)).setText(((UserDetail)model).getUserDetailGender());
                ((TextView) v.findViewById(R.id.textview_job)).setText(((UserDetail)model).getUserDetailJob());
                ((TextView) v.findViewById(R.id.textview_idnumber)).setText(((UserDetail)model).getUserDetailPassportNumber());
                ((TextView) v.findViewById(R.id.textview_address)).setText(((UserDetail)model).getUserDetailAddressLine());
                ((TextView) v.findViewById(R.id.textview_country)).setText(((UserDetail)model).getUserDetailAddressCountry());
                ((TextView) v.findViewById(R.id.textview_city)).setText(((UserDetail)model).getUserDetailAddressCity());
                ((TextView) v.findViewById(R.id.textview_district)).setText(((UserDetail)model).getUserDetailAddressDistrict());
            }

            @Override
            protected List modifyArrayAdapter(List models)
            {
                return models;
            }
        };
        listView.setAdapter(userDetailAdapter);
    }

    public void getDetailToUpdate(ListView listView,String userID){
        queryFirebase = QueryFirebase.getInstance(EntityName.UserDetails);
        user = FirebaseAuth.getInstance().getCurrentUser();
        FirebaseListAdapter<UserDetail> locationCountryAdapter = new FirebaseListAdapter(queryFirebase.getReferenceToSearch(null,"fk_UserID",user.getUid()),UserDetail.class,R.layout.test,activity) {
            @Override
            protected void populateView(View v, Object model) {
                ((EditText) v.findViewById(R.id.mEditText_Firstname)).setText(((UserDetail)model).getUserDetailFirstName());
                ((EditText) v.findViewById(R.id.mEditText_Lastname)).setText(((UserDetail)model).getUserDetailLastName());
                ((EditText) v.findViewById(R.id.mEditText_Birthday)).setText(new SimpleDateFormat("MM-dd-yyyy").format(((UserDetail)model).getUserDetailBirthDay()));
                            }

            @Override
            protected List modifyArrayAdapter(List models)
            {
                return models;
            }
        };
        listView.setAdapter(locationCountryAdapter);
    }
}
