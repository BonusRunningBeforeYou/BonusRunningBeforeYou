package com.example.janhon.bonusrunningbeforeyou.Running;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.LocationManager;
import android.os.Binder;
import android.os.IBinder;

import java.io.IOException;
import java.security.Provider;
import java.util.List;

import android.os.Bundle;
import android.location.LocationListener;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class OdometerService extends Service {
    private final IBinder binder = new OdometerBinder();
    private LocationListener listener;
    private LocationManager locationManager;
    public static final String PERMISSION_STRING = Manifest.permission.ACCESS_FINE_LOCATION;
    private static double distanceInKilometers;
    private static Location lastLocation = null;
    private GoogleMap map;
    private Geocoder geocoder;
    private LatLng latitude;
    private LatLng longitude;
    private LatLng[] latLngs ;



    public OdometerService() {
    }

    public class OdometerBinder extends Binder {
        OdometerService getOdometer() {
            return OdometerService.this;
        }

    }



    @Override
    public IBinder onBind(Intent intent) {

        return binder;
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");

    }


    @Override
    public void onCreate() {
        super.onCreate();
        listener = new LocationListener() {


            @Override
            public void onLocationChanged(Location location) {
                if (lastLocation == null) {
                    lastLocation = location;
                }
                distanceInKilometers += location.distanceTo(lastLocation);
                lastLocation = location;

                //LatLng latLng = new LatLng(location.getLongitude(),location.getLatitude());

//                draw2D();
//
//                for(int i = 0 ; i <=latLngs.length ;i++) {
//                    latLngs[i] = latLng;
//                    //showLatlng(latLngs);
//                }

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ContextCompat.checkSelfPermission(this, PERMISSION_STRING) == PackageManager.PERMISSION_GRANTED) {
            String provider = locationManager.getBestProvider(new Criteria(), true);
            if (provider != null) {
                locationManager.requestLocationUpdates(provider, 1000, 1, listener);
            }
        }


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (locationManager != null && listener != null) {
            if (ContextCompat.checkSelfPermission(this, PERMISSION_STRING) == PackageManager.PERMISSION_GRANTED) {
                locationManager.removeUpdates(listener);
            }
            locationManager = null;
            listener = null;
        }
    }

    public double getDistance() {
        return distanceInKilometers / 1000;
    }


//    private void draw2D() {
//        Polyline polyline = map.addPolyline(
//                new PolylineOptions()
//                        .add(latLngs) //緯經度放這邊. 根據記錄,描繪各個點把軌跡呈現.
//                        .width(5)
//                        .color(Color.MAGENTA)
//                        .zIndex(1)); //z軸,數字越大,高度越高. default值為零.
//
//        polyline.setWidth(20);
//    }


//    public LatLng[] showLatlng(LatLng... latLngs) {  //參數列表  Vargs, 用來解決不定參數的個數問題.
//        return this.latLngs;
//    }


//    private String name;
//    private double price;
//    public Book(String name, double price) {
//        super();
//        this.name = name ;
//        this.price = price ;
//    }
//
//    public void show() {
//        System.out.println(name);
//        System.out.println(price);
//    }
//
//    public static void showBooks(Book...books ) {  //參數列表  Vargs, 用來解決不定參數的個數問題.
//        for(Book book : books) {
//            book.show();
//        }
//    }

}

