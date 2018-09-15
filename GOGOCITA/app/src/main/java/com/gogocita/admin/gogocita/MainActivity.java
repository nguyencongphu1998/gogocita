package com.gogocita.admin.gogocita;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;



public class MainActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

//        listView = (ListView)findViewById(R.id.listView);
//
//        QueryFirebase<ConfigValue> a = new QueryFirebase<>(EntityName.ConfigValues);
//
//
//        FirebaseListAdapter<ConfigValue> b = new FirebaseListAdapter(a.getReference1(),ConfigValue.class,android.R.layout.simple_list_item_1,this) {
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
