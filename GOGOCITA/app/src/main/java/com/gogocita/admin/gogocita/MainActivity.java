package com.gogocita.admin.gogocita;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.ProgressBar;


public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);


        listView = (ListView)findViewById(R.id.listView);

        //UsersController a = UsersController.getInstance(this,progressBar);
        //a.singUp(this,"nguyencongphucoin@gmail.com","123456","Customer");
        //a.signOut();
//        FirebaseListAdapter<ConfigValue> b = new FirebaseListAdapter(a.getReferenceToSearch(null,"configValueGroup","PartnerServiceImageType"),ConfigValue.class,android.R.layout.simple_list_item_1,this) {
//            @Override
//            protected void populateView(View v, Object model) {
//                TextView tv = (TextView) v;
//                ((TextView) v).setText(((ConfigValue)model).getConfigValueText());
//            }
//
//            @Override
//            protected List modifyArrayAdapter(List models) {
//                return models;
//            }
//        };
//        listView.setAdapter(b);
    }
}