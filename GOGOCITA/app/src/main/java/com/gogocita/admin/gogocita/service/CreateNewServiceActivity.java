package com.gogocita.admin.gogocita.service;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.gogocita.admin.constant.EntityName;
import com.gogocita.admin.constant.ServiceConvinience;
import com.gogocita.admin.constant.ServiceType;
import com.gogocita.admin.controllers.configvalue.ConfigValueController;
import com.gogocita.admin.controllers.service.ServiceController;
import com.gogocita.admin.controllers.user.UsersController;
import com.gogocita.admin.entity.Location;
import com.gogocita.admin.entity.PartnerService;
import com.gogocita.admin.gogocita.R;
import com.google.firebase.auth.FirebaseUser;

public class CreateNewServiceActivity extends AppCompatActivity{
    private EditText edtServiceName;
    private RadioButton rdbServiceTypeVilla;
    private RadioButton rdbServiceTypeGroundHouse;
    private RadioButton rdbServiceTypeBungalow;
    private RadioGroup rdgServiceType;
    private Spinner spCountry;
    private Spinner spDistrict;
    private Spinner spCity;
    private EditText edtServiceDesc;
    private EditText edtServicePrice;
    private EditText edtServiceAddress;
    private Button btnCreate;
    private Button btnUpload;
    private ProgressBar progressBar;
    private CheckBox cbAc;
    private CheckBox cbSwimming;
    private CheckBox cbWifi;
    private CheckBox cbBreakfast;
    private ConfigValueController configValueController;
    private UsersController usersController;
    private ServiceController serviceController;
    private FirebaseUser user = null;
    private String countryId;
    private String cityId;
    private String districtId;
    private String countryName;
    private String cityName;
    private String districtName;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createnewservice);

        init();
        setData();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,Step4Activity.class));
        finish();
    }

    public void uploadImage(View v)
    {
        //startActivity(new Intent(this,));
    }

    public void createdService(View v)
    {
        progressBar.setVisibility(View.VISIBLE);

        if(TextUtils.isEmpty(edtServiceName.getText())){
            Toast.makeText(getApplicationContext(),"ServiceName is required!!!",Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
            return;
        }

        if(TextUtils.isEmpty(edtServiceAddress.getText())){
            Toast.makeText(getApplicationContext(),"ServiceAddress is required!!!",Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
            return;
        }

        if(TextUtils.isEmpty(edtServiceDesc.getText())){
            Toast.makeText(getApplicationContext(),"ServiceDescription is required!!!",Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
            return;
        }

        if(TextUtils.isEmpty(edtServicePrice.getText())){
            Toast.makeText(getApplicationContext(),"ServicePrice is required!!!",Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
            return;
        }

        int idChecked = rdgServiceType.getCheckedRadioButtonId();
        String serviceType = null;
        switch (idChecked)
        {
            case R.id.radioButton_bungalow:
                serviceType = ServiceType.bungalow;
                break;
            case R.id.radioButton_villa:
                serviceType = ServiceType.villa;
                break;
            case R.id.radioButton_groundHouse:
                serviceType = ServiceType.groundHouse;
                break;
        }

        String convinience  = "";
        if(cbAc.isChecked()) convinience = convinience + ServiceConvinience.ac + "-";
        if(cbBreakfast.isChecked()) convinience = convinience + ServiceConvinience.freeBreakfast + "-";
        if(cbSwimming.isChecked()) convinience = convinience + ServiceConvinience.swimmingPool + "-";
        if(cbWifi.isChecked()) convinience = convinience + ServiceConvinience.wifi + "-";

        PartnerService userDetail = new PartnerService(
                user.getUid(),
                edtServiceName.getText().toString(),
                0,
                edtServiceAddress.getText().toString(),
                countryName,
                cityName,
                districtName,
                false,
                "",
                edtServiceDesc.getText().toString(),
                Double.parseDouble(edtServicePrice.getText().toString()),
                0,
                convinience,
                serviceType);
        serviceController.updateOrInsert(userDetail);
    }

    private void init()
    {
        edtServiceDesc = (EditText) findViewById(R.id.edt_createservice_desciption);
        edtServiceName = (EditText) findViewById(R.id.edt_createservice_name);
        edtServicePrice = (EditText) findViewById(R.id.edt_createservice_price);
        edtServiceAddress = (EditText) findViewById(R.id.edt_createservice_address);
        rdbServiceTypeBungalow = (RadioButton) findViewById(R.id.radioButton_bungalow);
        rdbServiceTypeGroundHouse = (RadioButton) findViewById(R.id.radioButton_groundHouse);
        rdbServiceTypeVilla = (RadioButton) findViewById(R.id.radioButton_villa);
        rdgServiceType = (RadioGroup) findViewById(R.id.radioGroup_Type);
        spCity = (Spinner) findViewById(R.id.spinner_City);
        spDistrict = (Spinner) findViewById(R.id.spinner_District);
        spCountry = (Spinner) findViewById(R.id.spinner_Nationality);
        btnCreate = (Button) findViewById(R.id.btn_createnewservice_complete);
        btnUpload = (Button) findViewById(R.id.btn_uploadimage);
        progressBar = (ProgressBar) findViewById(R.id.progressBar_createNewService);
        cbAc = (CheckBox)  findViewById(R.id.checkbox_ac);
        cbSwimming = (CheckBox) findViewById(R.id.checkbox_swimmingpool);
        cbWifi = (CheckBox) findViewById(R.id.checkbox_wifi);
        cbBreakfast = (CheckBox) findViewById(R.id.checkbox_freebreakfast);

        configValueController = ConfigValueController.getInstance(this);
        usersController = UsersController.getInstance(this,progressBar);
        serviceController = ServiceController.getInstance(this,progressBar);

        usersController.checkAuthorize();
        user = usersController.getUser();
    }

    private void setData()
    {
        Intent intent = getIntent();
        PartnerService partnerService = (PartnerService) intent.getSerializableExtra(EntityName.PartnerServices);
        if(partnerService != null){
            edtServiceName.setText(partnerService.getPartnerServiceName());
            edtServiceAddress.setText(partnerService.getPartnerServiceAddressLine());
            edtServiceDesc.setText(partnerService.getPartnerServiceDesc());
            edtServicePrice.setText(partnerService.getPartnerServicePrice()+"");
            if(partnerService.getPartnerServiceConvinience() != null)
            {
                String[] serviceConviniences = partnerService.getPartnerServiceConvinience().split("-");
                for (String serviceConvinience: serviceConviniences)
                {
                    if(serviceConvinience.equals(ServiceConvinience.ac))
                    {
                        cbAc.setChecked(true);
                    }

                    if(serviceConvinience.equals(ServiceConvinience.freeBreakfast))
                    {
                        cbBreakfast.setChecked(true);
                    }

                    if(serviceConvinience.equals(ServiceConvinience.wifi))
                    {
                        cbWifi.setChecked(true);
                    }

                    if(serviceConvinience.equals(ServiceConvinience.swimmingPool))
                    {
                        cbSwimming.setChecked(true);
                    }
                }
            }

            if(partnerService.getServiceType().equals(ServiceType.bungalow)) rdbServiceTypeBungalow.setChecked(true);
            if(partnerService.getServiceType().equals(ServiceType.villa)) rdbServiceTypeVilla.setChecked(true);
            if(partnerService.getServiceType().equals(ServiceType.groundHouse)) rdbServiceTypeGroundHouse.setChecked(true);

            configValueController.getCountry(spCountry);

            spCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    countryId = ((Location) spCountry.getSelectedItem()).getLocationID();
                    countryName = ((Location) spCountry.getSelectedItem()).getLocationName();
                    configValueController.getCitys(countryId,spCity);
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

            spCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    cityId = ((Location) spCity.getSelectedItem()).getLocationID();
                    cityName = ((Location) spCity.getSelectedItem()).getLocationName();
                    configValueController.getDistricts(countryId,cityId,spDistrict);
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

            spDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    districtId = ((Location) spDistrict.getSelectedItem()).getLocationID();
                    districtName = ((Location) spDistrict.getSelectedItem()).getLocationName();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }
    }
}
