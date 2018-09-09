package com.gogocita.admin.entity;

import com.gogocita.admin.helper.QueryFirebase;
import com.google.firebase.database.IgnoreExtraProperties;


@IgnoreExtraProperties
public class ConfigValue{
    private String ConfigValueID;
    private String ConfigValueKey;
    private String ConfigValueText;
    private String ConfigValueGroup;

    public ConfigValue(String configValueKey, String configValueText, String configValueGroup) {
        ConfigValueID = Id();
        ConfigValueKey = configValueKey;
        ConfigValueText = configValueText;
        ConfigValueGroup = configValueGroup;
    }

    public String getConfigValueID() {
        return ConfigValueID;
    }

    public void setConfigValueID(String configValueID) {
        ConfigValueID = configValueID;
    }

    public String getConfigValueKey() {
        return ConfigValueKey;
    }

    public void setConfigValueKey(String configValueKey) {
        ConfigValueKey = configValueKey;
    }

    public String getConfigValueText() {
        return ConfigValueText;
    }

    public void setConfigValueText(String configValueText) {
        ConfigValueText = configValueText;
    }

    public String getConfigValueGroup() {
        return ConfigValueGroup;
    }

    public void setConfigValueGroup(String configValueGroup) {
        ConfigValueGroup = configValueGroup;
    }

    public String Id() {
        QueryFirebase firebase = new QueryFirebase("ConfigValues");
        return firebase.getNewKey();
    }

    @Override
    public String toString() {
        return "ConfigValues";
    }
}
