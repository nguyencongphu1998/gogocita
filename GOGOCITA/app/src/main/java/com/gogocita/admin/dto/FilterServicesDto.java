package com.gogocita.admin.dto;

public class FilterServicesDto {
    private String city;
    private String evalutionSort;

    public FilterServicesDto() {
        city = "";
        evalutionSort = "";
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEvalutionSort() {
        return evalutionSort;
    }

    public void setEvalutionSort(String evalutionSort) {
        this.evalutionSort = evalutionSort;
    }
}
