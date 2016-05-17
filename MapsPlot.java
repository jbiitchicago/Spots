package com.tradeapps.vt.mapstest2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MapsPlot extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_plot);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;



        //**************MODIFY THE MAP TO DISPLAY MULTIPLE LOCATIONS*************************
        CustomAddress ca1 = new CustomAddress("Koramangala", "Koramangala 5th Block",
                "560076", "India",12.9354922,77.6146399);
        CustomAddress ca2 = new CustomAddress("Bannerghatta main road","Garuda Mall",
                "560076", "India",12.9730008,77.6207025);
        String timeStamp1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
        String timeStamp2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
        double amt1 = 4000;
        double amt2 = 2000;

        LatLng pos1 = new LatLng(ca1.getmLatitude(),ca1.getmLongitude());
        LatLng pos2 = new LatLng(ca2.getmLatitude(), ca2.getmLongitude());
        Marker marker1 = mMap.addMarker( new MarkerOptions().position(pos1));
        mMap.addMarker(new MarkerOptions().position(pos1).title(ca1.toString()).snippet("Get 10% off at TGIF  on Saturday|   " +
                "Get 30% off at Rajdhani this weekend!"));
        marker1.showInfoWindow();

        mMap.addMarker(new MarkerOptions().position(pos2).title(ca2.toString()).snippet("Get 10% off at TGIF  on Saturday|" +
        "Get 30% at Rajdhani this weekend!"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(pos2));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
        //***********************************************************************************
    }

    public void onQuit(View v){
        finish();
    }

    public void onGetHome(View v){
        Intent i = new Intent(this, TimeRangeSelection.class);
        startActivity(i);
        finish();
    }

    public void onListViewSelection(View v){
        Intent i = new Intent(this, SwipeListActivity.class);
        startActivity(i);
    }
}
