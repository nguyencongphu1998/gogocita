package com.gogocita.admin.controllers.user;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.gogocita.admin.constant.EntityName;
import com.gogocita.admin.controllers.configvalue.ConfigValueController;
import com.gogocita.admin.entity.ConfigValue;
import com.gogocita.admin.entity.Location;
import com.gogocita.admin.entity.PartnerServiceBook;
import com.gogocita.admin.entity.UserDetail;
import com.gogocita.admin.gogocita.R;
import com.gogocita.admin.gogocita.users.UpdateUserDetailActivity;
import com.gogocita.admin.gogocita.users.UserDetailActivity;
import com.gogocita.admin.helper.FirebaseListAdapter;
import com.gogocita.admin.helper.QueryFirebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserDetailsController {
    private QueryFirebase queryFirebase;
    private FirebaseUser user;
    private static UserDetailsController userDetailController = null;
    private Activity activity;
    private ProgressBar progressBar;

    private UserDetailsController(Activity activity,ProgressBar progressBar)
    {
        this.activity = activity;
        this.progressBar = progressBar;
        user = FirebaseAuth.getInstance().getCurrentUser();
    }

    public static UserDetailsController getInstance(Activity activity,ProgressBar progressBar){
        if (userDetailController == null){
            userDetailController = new UserDetailsController(activity,progressBar);
        }else {
            userDetailController.progressBar = progressBar;
            userDetailController.activity = activity;
        }
        return userDetailController;
    }

    public void updateOrInsert(UserDetail userDetail){
        QueryFirebase<UserDetail> queryFirebase = QueryFirebase.getInstance(EntityName.UserDetails);
        queryFirebase.Update(userDetail.toMapUpdate(),userDetail.getFk_UserID());

        progressBar.setVisibility(View.GONE);
        Toast.makeText(activity,"Update Success!!!",Toast.LENGTH_SHORT).show();
        getUserDetail(UserDetailActivity.class);
    }

    public void getUserDetail(final Class activityClass){
        QueryFirebase queryFirebase = QueryFirebase.getInstance(EntityName.UserDetails);

        queryFirebase.getReferenceToSearch(null,"fk_UserID",user.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                UserDetail model = dataSnapshot.child(user.getUid()).getValue(UserDetail.class);
                if(model == null){
                    Toast.makeText(activity,"Error!!!",Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(activity,activityClass);
                    intent.putExtra(EntityName.UserDetails,model);
                    activity.startActivity(intent);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void getShortUserDetail(final TextView name, final TextView email, final TextView phone, final String userId){
        if(userId != null){
            QueryFirebase queryFirebase = QueryFirebase.getInstance(EntityName.UserDetails);
            queryFirebase.getReferenceToSearch(null,"fk_UserID",userId).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    UserDetail userDetail = dataSnapshot.child(userId).getValue(UserDetail.class);
                    if(userDetail == null){
                        Toast.makeText(activity,"Error!!!",Toast.LENGTH_SHORT).show();
                    }else {
                        if(name != null){
                            name.setText(userDetail.getUserDetailFirstName() + " " + userDetail.getUserDetailLastName());
                        }

                        if(email != null){
                            email.setText(userDetail.getUserDetailEmail());
                        }

                        if(phone != null){
                            phone.setText(userDetail.getUserDetailPhone());
                        }
                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }
}
