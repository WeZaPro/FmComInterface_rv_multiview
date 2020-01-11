package com.example.fmcominterface_rv_multiview;

public class MyChidModel extends MyParentModel{

    private double result;

    public MyChidModel() {
    }

    public MyChidModel(double rates, double inputValue) {
        super(rates);
        this.result = rates*inputValue;
    }

    public MyChidModel(double rates, int imageFlags, String countryNames) {
        super(rates, imageFlags, countryNames);
    }

    public double getResult() {
        return result;
    }


}
