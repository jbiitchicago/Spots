package com.tradeapps.vt.mapstest2;

public class Swipe {

    private String timestamp;
    private double latitude;
    private double longitude;
    private double amount;
    private CustomAddress address;

    public Swipe(String timestamp, double amount, CustomAddress a){
        this.timestamp = timestamp;
        this.amount = amount;
        this.address = a;
        latitude = a.getmLatitude();
        longitude = a.getmLongitude();
    }

    public void setTimestamp(String d){
        timestamp = d;
    }
    public String getTimestamp(){
        return timestamp ;
    }

    public void setLatitude(double lat){
        latitude = lat;
    }

    public void setLongitude(double lng){
        longitude = lng;
    }

    public void setAddress(CustomAddress a){
        address = a;
    }

    public double getLatitude(){
        return latitude;
    }

    public double getLongitude(){
        return longitude;
    }

    public double getAmount(){
        return amount;
    }

    public CustomAddress getAddress(){
        return address;
    }

    @Override
    public String toString() {
        return "  DATE & TIME - "+timestamp+"  AMOUNT - Rs."+String.valueOf(amount)+
                "  LOCATION DETAILS - "+address.getmPremises()+","+address.getmLocality()+
                ","+address.getmPostalCode()+","+address.getmCountryName();
    }

}
