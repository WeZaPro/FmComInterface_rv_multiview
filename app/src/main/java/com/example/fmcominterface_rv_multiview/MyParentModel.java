package com.example.fmcominterface_rv_multiview;

import android.os.Parcel;
import android.os.Parcelable;

public class MyParentModel implements Parcelable {

    private double rates;
    private int imageFlags;
    private String countryNames;

    public MyParentModel() {
    }

    public MyParentModel(double rates, int imageFlags, String countryNames) {
        this.rates = rates;
        this.imageFlags = imageFlags;
        this.countryNames = countryNames;
    }

    public MyParentModel(double rates) {
        this.rates = rates;
    }

    protected MyParentModel(Parcel in) {
        rates = in.readDouble();
        imageFlags = in.readInt();
        countryNames = in.readString();
    }

    public static final Creator<MyParentModel> CREATOR = new Creator<MyParentModel>() {
        @Override
        public MyParentModel createFromParcel(Parcel in) {
            return new MyParentModel(in);
        }

        @Override
        public MyParentModel[] newArray(int size) {
            return new MyParentModel[size];
        }
    };

    public double getRates() {
        return rates;
    }

    public void setRates(double rates) {
        this.rates = rates;
    }

    public int getImageFlags() {
        return imageFlags;
    }

    public void setImageFlags(int imageFlags) {
        this.imageFlags = imageFlags;
    }

    public String getCountryNames() {
        return countryNames;
    }

    public void setCountryNames(String countryNames) {
        this.countryNames = countryNames;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(rates);
        parcel.writeInt(imageFlags);
        parcel.writeString(countryNames);
    }
}
