package com.gogocita.admin.dto;

public class FilterServicesDto {
    private String city;
    private String country;
    private String evalutionSort;

    public FilterServicesDto() {
        city = "";
        evalutionSort = "";
        country = "";
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
