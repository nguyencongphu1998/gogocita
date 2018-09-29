package com.gogocita.admin.gogocita.users;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.gogocita.admin.controllers.configvalue.ConfigValueController;
import com.gogocita.admin.controllers.user.UserDetailsController;
import com.gogocita.admin.controllers.user.UsersController;
import com.gogocita.admin.entity.ConfigValue;
import com.gogocita.admin.entity.Location;
import com.gogocita.admin.entity.UserDetail;
import com.gogocita.admin.gogocita.R;
import com.google.firebase.auth.FirebaseUser;

import java.util.Date;

public class UpdateUserDetailActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private Spinner spinner_gender;
    private Spinner spinner_country;
    private Spinner spinner_city;
    private Spinner spinner_distric;
    private EditText editText_firstName;
    private EditText editText_lastName;
    private EditText editText_birthDay;
    private EditText editText_phone;
    private EditText editText_job;
    private EditText editText_idNumber;
    private EditText editText_addressline;
    private String gender;
    private String countryId;
    private String cityId;
    private String districtId;
    private String countryName;
    private String cityName;
    private String districtName;
    private Button btnUpdate;

    private ConfigValueController configValueController;
    private UsersController usersController;
    private UserDetailsController userDetailController;
    private FirebaseUser user = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userdetail_update);

        spinner_gender = (Spinner) findViewById(R.id.spinner_Gender);
        spinner_country = (Spinner) findViewById(R.id.spinner_Nationality);
        spinner_city = (Spinner) findViewById(R.id.spinner_City);
        spinner_distric = (Spinner) findViewById(R.id.spinner_District);
        editText_firstName = (EditText) findViewById(R.id.EditText_Firstname);
        editText_lastName = (EditText) findViewById(R.id.EditText_Lastname);
        editText_birthDay = (EditText) findViewById(R.id.EditText_Birthday);
        editText_phone = (EditText) findViewById(R.id.EditText_Handphone);
        editText_job = (EditText) findViewById(R.id.EditText_Job);
        editText_idNumber = (EditText) findViewById(R.id.EditText_IdentityCard);
        editText_addressline = (EditText) findViewById(R.id.EditText_Address);
        btnUpdate = (Button) findViewById(R.id.button_updateprofile);
        progressBar = (ProgressBar) findViewById(R.id.progressBar_updateinformation);


        configValueController = ConfigValueController.getInstance(this);
        usersController = UsersController.getInstance(this,progressBar);
        userDetailController = UserDetailsController.getInstance(this);

        usersController.checkAuthorize();
        user = usersController.getUser();

        configValueController.getGenders(spinner_gender);

        spinner_gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                gender = ((ConfigValue) spinner_gender.getSelectedItem()).getConfigValueKey();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        configValueController.getCountry(spinner_country);

        spinner_country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                countryId = ((Location) spinner_country.getSelectedItem()).getLocationID();
                countryName = ((Location) spinner_country.getSelectedItem()).getLocationName();
                configValueController.getCitys(countryId,spinner_city);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner_city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                cityId = ((Location) spinner_city.getSelectedItem()).getLocationID();
                cityName = ((Location) spinner_city.getSelectedItem()).getLocationName();
                configValueController.getDistricts(countryId,cityId,spinner_distric);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner_distric.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                districtId = ((Location) spinner_distric.getSelectedItem()).getLocationID();
                districtName = ((Location) spinner_distric.getSelectedItem()).getLocationName();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);

                try{
                    Date a = new Date(editText_birthDay.getText().toString());
                }catch(Exception ex) {

                    Toast.makeText(UpdateUserDetailActivity.this,"BirthDay is invalid!!!",Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                    return;
                }


                UserDetail userDetail = new UserDetail(
                        user.getUid(),
                        editText_lastName.getText().toString(),
                        editText_firstName.getText().toString(),
                        new Date(editText_birthDay.getText().toString()),
                        editText_phone.getText().toString(),
                        gender,
                        editText_job.getText().toString(),
                        editText_idNumber.getText().toString(),
                        user.getEmail(),
                        null,
                        editText_addressline.getText().toString(),
                        countryName,
                        cityName,
                        districtName,
                        true);
                userDetailController.updateOrInsert(userDetail,progressBar);
            }
        });
    }
}
