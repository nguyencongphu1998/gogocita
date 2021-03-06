package com.gogocita.admin.controllers.configvalue;


import android.content.Context;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.Spinner;
import android.widget.TextView;

import com.gogocita.admin.constant.EntityName;
import com.gogocita.admin.constant.ServiceImageType;
import com.gogocita.admin.entity.ConfigValue;
import com.gogocita.admin.entity.Location;
import com.gogocita.admin.gogocita.R;
import com.gogocita.admin.helper.FirebaseListAdapter;
import com.gogocita.admin.helper.QueryFirebase;
import com.gogocita.admin.helper.ViewHolder;


import java.util.List;

public class ConfigValueController {
    private QueryFirebase queryFirebase;
    private static ConfigValueController configValueController = null;
    private Context context;
    private FirebaseListAdapter<Location> locationCityAdapter;
    private FirebaseListAdapter<Location> locationDistrictAdapter;
    FirebaseListAdapter<ConfigValue> genderAdapter;

    private ConfigValueController(Context context)
    {
        this.context = context;
    }

    public static ConfigValueController getInstance(Context context){
        if (configValueController == null){
            configValueController = new ConfigValueController(context);
        }else {
            configValueController.context = context;
        }
        return configValueController;
    }

    public void getServiceImageTypes(Spinner spinner_serviceImageType, final boolean check){
        queryFirebase = QueryFirebase.getInstance(EntityName.ConfigValues);
        FirebaseListAdapter<ConfigValue> genderAdapter = new FirebaseListAdapter(queryFirebase.getReferenceToSearch(null,"configValueGroup","PartnerServiceImageType"),ConfigValue.class, R.layout.custom_spinner,context) {

            @Override
            protected void getViewHolder(ViewHolder vh, View v) {
                vh.setCheckedTextViewSpinner((CheckedTextView) v.findViewById(R.id.checktextviewspnner));

            }

            @Override
            protected void setViewHolder(ViewHolder vh, Object model) {
                vh.getCheckedTextViewSpinner().setText(((ConfigValue)model).getConfigValueText());

            }

            @Override
            protected void addListener(ViewHolder vh, Object model) {

            }

            @Override
            protected List modifyArrayAdapter(List models) {
                if(check){
                    for (ConfigValue i : (List<ConfigValue>) models) {
                        if(i.getConfigValueKey().equals(ServiceImageType.coverPhoto))
                            models.remove(i);
                    }
                }
                return models;
            }
        };

        spinner_serviceImageType.setAdapter(genderAdapter);

    }

    public void getGenders(Spinner spinner_gender){
        queryFirebase = QueryFirebase.getInstance(EntityName.ConfigValues);
        genderAdapter = new FirebaseListAdapter(queryFirebase.getReferenceToSearch(null,"configValueGroup","GenderType"),ConfigValue.class, R.layout.custom_spinner,context) {

            @Override
            protected void getViewHolder(ViewHolder vh, View v) {
                vh.setCheckedTextViewSpinner((CheckedTextView) v.findViewById(R.id.checktextviewspnner));
            }

            @Override
            protected void setViewHolder(ViewHolder vh, Object model) {
                vh.getCheckedTextViewSpinner().setText(((ConfigValue)model).getConfigValueText());

            }

            @Override
            protected void addListener(ViewHolder vh, Object model) {

            }

            @Override
            protected List modifyArrayAdapter(List models) {
                return models;
            }
        };

        spinner_gender.setAdapter(genderAdapter);

    }

    public void getCountry(Spinner spinner_country){
        queryFirebase = QueryFirebase.getInstance(EntityName.Locations);
        FirebaseListAdapter<Location> locationCountryAdapter = new FirebaseListAdapter(queryFirebase.getReferenceToSearch(null,"locationType","Country"),Location.class,R.layout.custom_spinner,context) {

            @Override
            protected void getViewHolder(ViewHolder vh, View v) {
                vh.setCheckedTextViewSpinner((CheckedTextView) v.findViewById(R.id.checktextviewspnner));

            }

            @Override
            protected void setViewHolder(ViewHolder vh, Object model) {
                vh.getCheckedTextViewSpinner().setText(((Location)model).getLocationName());

            }

            @Override
            protected void addListener(ViewHolder vh, Object model) {

            }

            @Override
            protected List modifyArrayAdapter(List models) {
                return models;
            }
        };

        spinner_country.setAdapter(locationCountryAdapter);
    }

    public void getDistricts(String countryId,String cityId,Spinner spinner_distric){
        queryFirebase = QueryFirebase.getInstance(EntityName.Locations);
        locationDistrictAdapter = new FirebaseListAdapter(queryFirebase.getReferenceToSearch(new String[]{countryId,cityId},"locationType","District"),Location.class,R.layout.custom_spinner,context) {

            @Override
            protected void getViewHolder(ViewHolder vh, View v) {
                vh.setCheckedTextViewSpinner((CheckedTextView) v.findViewById(R.id.checktextviewspnner));

            }

            @Override
            protected void setViewHolder(ViewHolder vh, Object model) {
                vh.getCheckedTextViewSpinner().setText(((Location)model).getLocationName());

            }

            @Override
            protected void addListener(ViewHolder vh, Object model) {

            }

            @Override
            protected List modifyArrayAdapter(List models) {
                return models;
            }
        };

        spinner_distric.setAdapter(locationDistrictAdapter);
    }

    public void getCitys(String countryId,Spinner spinner_city){
        queryFirebase = QueryFirebase.getInstance(EntityName.Locations);
        locationCityAdapter = new FirebaseListAdapter(queryFirebase.getReferenceToSearch(new String[]{countryId},"locationType","City"),Location.class,R.layout.custom_spinner,context) {

            @Override
            protected void getViewHolder(ViewHolder vh, View v) {
                vh.setCheckedTextViewSpinner((CheckedTextView) v.findViewById(R.id.checktextviewspnner));
            }

            @Override
            protected void setViewHolder(ViewHolder vh, Object model) {
                vh.getCheckedTextViewSpinner().setText(((Location)model).getLocationName());
            }

            @Override
            protected void addListener(ViewHolder vh, Object model) {

            }

            @Override
            protected List modifyArrayAdapter(List models) {
                return models;
            }
        };
        spinner_city.setAdapter(locationCityAdapter);
    }

    public void selectLocationCityItem(String value, Spinner spinner){
        for(int i = 0; i < locationCityAdapter.getCount(); i++){
            if(((Location)locationCityAdapter.getItem(i)).getLocationName().equals(value))
            {
                spinner.setSelection(i);
            }
        }
    }

    public void selectLocationCountryItem(String value, Spinner spinner){
        for(int i = 0; i < locationDistrictAdapter.getCount(); i++){
            if(((Location)locationDistrictAdapter.getItem(i)).getLocationName().equals(value))
            {
                spinner.setSelection(i);
            }
        }
    }

    public void selectGenderItem(String value, Spinner spinner){
        for(int i = 0; i < genderAdapter.getCount(); i++){
            if(((ConfigValue)genderAdapter.getItem(i)).getConfigValueText().equals(value))
            {
                spinner.setSelection(i);
            }
        }
    }
}
