package com.tradeapps.vt.mapstest2;

import java.util.Locale;


public class CustomAddress {

    private Locale mLocale;
    private String mLocality;
    private String mPremises;
    private String mPostalCode;
    private String mCountryName;
    private double mLatitude;
    private double mLongitude;

    public CustomAddress(String locality, String premises, String postalCode, String countryName, double lat, double lng){
        mLocality = locality;
        mPremises = premises;
        mPostalCode = postalCode;
        mCountryName = countryName;
        mLatitude = lat;
        mLongitude = lng;
    }

    public Locale getmLocale() {
        return mLocale;
    }

    public void setmLocale(Locale mLocale) {
        this.mLocale = mLocale;
    }

    public String getmLocality() {
        return mLocality;
    }

    public void setmLocality(String mLocality) {
        this.mLocality = mLocality;
    }

    public String getmPremises() {
        return mPremises;
    }

    public void setmPremises(String mPremises) {
        this.mPremises = mPremises;
    }

    public String getmPostalCode() {
        return mPostalCode;
    }

    public void setmPostalCode(String mPostalCode) {
        this.mPostalCode = mPostalCode;
    }


    public String getmCountryName() {
        return mCountryName;
    }

    public void setmCountryName(String mCountryName) {
        this.mCountryName = mCountryName;
    }

    public double getmLatitude() {
        return mLatitude;
    }

    public void setmLatitude(double mLatitude) {
        this.mLatitude = mLatitude;
    }

    public double getmLongitude() {
        return mLongitude;
    }

    public void setmLongitude(double mLongitude) {
        this.mLongitude = mLongitude;
    }

    @Override
    public String toString() {
        return ""+mPremises+","+mLocality+
                ","+mPostalCode+","+mCountryName;
    }


}
