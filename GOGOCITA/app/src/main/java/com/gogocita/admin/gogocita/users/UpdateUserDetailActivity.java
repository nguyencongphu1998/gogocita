package com.gogocita.admin.gogocita.users;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.gogocita.admin.constant.EntityName;
import com.gogocita.admin.controllers.configvalue.ConfigValueController;
import com.gogocita.admin.controllers.user.UserDetailsController;
import com.gogocita.admin.controllers.user.UsersController;
import com.gogocita.admin.entity.ConfigValue;
import com.gogocita.admin.entity.Location;
import com.gogocita.admin.entity.UserDetail;
import com.gogocita.admin.gogocita.BaseMenuActivity;
import com.gogocita.admin.gogocita.R;
import com.google.firebase.auth.FirebaseUser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UpdateUserDetailActivity extends BaseMenuActivity {
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
    private ImageButton btn_CalanderCheckIn;

    private ListView listView;

    private ConfigValueController configValueController;
    private UsersController usersController;
    private UserDetailsController userDetailsController;
    private FirebaseUser user = null;
    private UserDetail userDetail;
    private boolean isCheckCity = true;
    private boolean isCheckDistrict = true;
    private boolean isGender = true;

    @Override
    protected void init() {
        Intent intent = getIntent();
        userDetail = (UserDetail) intent.getSerializableExtra(EntityName.UserDetails);
    }

    @Override
    protected void getWidget()
    {
        spinner_gender = (Spinner) findViewById(R.id.spinner_Gender);
        spinner_country = (Spinner) findViewById(R.id.spinner_Nationality);
        btn_CalanderCheckIn = (ImageButton) findViewById(R.id.btn_calander_checkin);
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
    }

    @Override
    protected void setWidget()
    {
        configValueController = ConfigValueController.getInstance(this);
        usersController = UsersController.getInstance(this,progressBar);
        user = usersController.getUser();
        userDetailsController = UserDetailsController.getInstance(this,progressBar);
        editText_firstName.setText(userDetail.getUserDetailFirstName());
        editText_lastName.setText(userDetail.getUserDetailLastName());
        editText_addressline.setText(userDetail.getUserDetailAddressLine());
        editText_idNumber.setText(userDetail.getUserDetailPassportNumber());
        editText_job.setText(userDetail.getUserDetailJob());
        editText_phone.setText(userDetail.getUserDetailPhone());
        editText_birthDay.setText(new SimpleDateFormat("MM/dd/yyyy").format(userDetail.getUserDetailBirthDay()));
    }

    @Override
    protected void addListener()
    {
        configValueController.getGenders(spinner_gender);
        spinner_gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(!TextUtils.isEmpty(userDetail.getUserDetailGender()) && isGender){
                    configValueController.selectGenderItem(userDetail.getUserDetailGender(),spinner_gender);
                    isGender = false;
                }
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
                if(!TextUtils.isEmpty(userDetail.getUserDetailAddressCity()) && isCheckCity){
                    configValueController.selectLocationCityItem(userDetail.getUserDetailAddressCity(),spinner_city);
                    isCheckCity = false;
                }
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
                if(!TextUtils.isEmpty(userDetail.getUserDetailAddressDistrict()) && isCheckDistrict){
                    configValueController.selectLocationCountryItem(userDetail.getUserDetailAddressDistrict(),spinner_distric);
                    isCheckDistrict = false;
                }
                districtId = ((Location) spinner_distric.getSelectedItem()).getLocationID();
                districtName = ((Location) spinner_distric.getSelectedItem()).getLocationName();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btn_CalanderCheckIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker(editText_birthDay);
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


                UserDetail userDetail = null;
                try {
                    userDetail = new UserDetail(
                            user.getUid(),
                            editText_lastName.getText().toString(),
                            editText_firstName.getText().toString(),
                            new SimpleDateFormat("dd/MM/yyyy").parse(editText_birthDay.getText().toString()),
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
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                userDetailsController.updateOrInsert(userDetail);
            }
        });
    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.userdetail_update);
    }

    private void datePicker(final EditText edt){
        final Calendar cal = Calendar.getInstance();
        final int date = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                cal.set(year,month,dayOfMonth);
                edt.setText(cal.get(Calendar.DATE) + "/" +(cal.get(Calendar.MONTH)+1) +"/"+ cal.get(Calendar.YEAR));
            }
        },year,month,date);
        datePickerDialog.show();
    }
}
