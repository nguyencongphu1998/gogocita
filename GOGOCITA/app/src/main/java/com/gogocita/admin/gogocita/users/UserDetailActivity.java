package com.gogocita.admin.gogocita.users;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.gogocita.admin.controllers.user.UserDetailsController;
import com.gogocita.admin.controllers.user.UsersController;
import com.gogocita.admin.entity.UserDetail;
import com.gogocita.admin.gogocita.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class UserDetailActivity extends AppCompatActivity {
    private UserDetailsController userDetailsController;
    private UsersController usersController;
    private ListView listView;
    private Button btnUpdate;
    private FirebaseUser user = null;
    private UserDetail userDetail;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userdetail);

        listView = (ListView) findViewById(R.id.listview_informationuser);
        btnUpdate = (Button) findViewById(R.id.button_updateuser);
        usersController = UsersController.getInstance(this,null);
        user = usersController.getUser();
        userDetailsController = UserDetailsController.getInstance(this);
        userDetailsController.getDetail(listView,user.getUid());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDetailActivity.this,UpdateUserDetailActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,UserMenuActivity.class));
        finish();
    }

}
