package com.gogocita.admin.entity;

import com.gogocita.admin.constant.EntityName;
import com.gogocita.admin.helper.QueryFirebase;
import com.google.firebase.database.IgnoreExtraProperties;


@IgnoreExtraProperties
public class ConfigValue extends GenerateId{
    private String configValueID;
    private String configValueKey;
    private String configValueText;
    private String configValueGroup;

    public ConfigValue() {
    }

    public ConfigValue(String configValueKey, String configValueText, String configValueGroup) {
        this.configValueID = generateId(EntityName.ConfigValues);
        this.configValueKey = configValueKey;
        this.configValueText = configValueText;
        this.configValueGroup = configValueGroup;
    }

    public ConfigValue(String configValueID, String configValueKey, String configValueText, String configValueGroup) {
        this.configValueID = configValueID;
        this.configValueKey = configValueKey;
        this.configValueText = configValueText;
        this.configValueGroup = configValueGroup;
    }

    public String getConfigValueID() {
        return configValueID;
    }

    public void setConfigValueID(String configValueID) {
        this.configValueID = configValueID;
    }

    public String getConfigValueKey() {
        return configValueKey;
    }

    public void setConfigValueKey(String configValueKey) {
        this.configValueKey = configValueKey;
    }

    public String getConfigValueText() {
        return configValueText;
    }

    public void setConfigValueText(String configValueText) {
        this.configValueText = configValueText;
    }

    public String getConfigValueGroup() {
        return configValueGroup;
    }

    public void setConfigValueGroup(String configValueGroup) {
        this.configValueGroup = configValueGroup;
    }

    @Override
    public String toString() {
        return EntityName.ConfigValues;
    }
}
