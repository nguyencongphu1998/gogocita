package com.gogocita.admin.gogocita.users;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.gogocita.admin.gogocita.CommingSoonActivity;
import com.gogocita.admin.gogocita.R;
import com.gogocita.admin.gogocita.service.ServiceOptionActivity;


public class SingUpSuccessActivity extends AppCompatActivity {
    private Button btnReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singup_success);

        btnReturn = (Button) findViewById(R.id.btn_return);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ServiceOptionActivity.class));
                finish();
            }
        });

    }
}
