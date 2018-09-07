package com.example.janhon.bonusrunningbeforeyou.Running;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Point;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.LocationManager;
import android.os.Binder;
import android.os.IBinder;

import java.io.IOException;
import java.security.Provider;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.location.LocationListener;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.crashlytics.android.Crashlytics;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import io.fabric.sdk.android.Fabric;

public class OdometerService extends Service {
    private final IBinder binder = new OdometerBinder();
    private LocationListener listener;
    private LocationManager locationManager;
    public static final String PERMISSION_STRING = Manifest.permission.ACCESS_FINE_LOCATION;
    private static double distanceInKilometers;
    private static Location lastLocation = null;
    private static List<LatLng> points = new ArrayList<>();  // list of latlng
    private static LatLng src ;
    private static LatLng dest ;

//    public void enableDebugMode() {
//        // [START crash_enable_debug_mode]
//        final Fabric fabric = new Fabric.Builder(this)
//                .kits(new Crashlytics())
//                .debuggable(true)  // Enables Crashlytics debugger
//                .build();
//        Fabric.with(fabric);
//        // [END crash_enable_debug_mode]
//    }
//
//    public void enableAtRuntime() {
//        // [START crash_enable_at_runtime]
//        Fabric.with(this, new Crashlytics());
//        // [END crash_enable_at_runtime]
//    }





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

        //firebase用程式碼
        //enableDebugMode();
        //enableAtRuntime();
        //Crashlytics.log(Log.DEBUG, "tag", "message"); //回傳當機時再啟用即可.


        listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                if (lastLocation == null) {
                    lastLocation = location;
                }
                distanceInKilometers += location.distanceTo(lastLocation);
                lastLocation = location;

                do {
                    points.add((new LatLng(lastLocation.getLatitude(), lastLocation.getLongitude())));
                    for (int i = 0; i < points.size() - 1; i++) {
                        src = points.get(i);
                        dest = points.get(i + 1);
                    }
                } while ((distanceInKilometers != location.distanceTo(lastLocation)));


                //Crashlytics.log(Log.DEBUG, "tag", "valueOfLocation" + location.getLatitude() + "&" + location.getLongitude());
                //Log.d("tag", "valueOfLocation" + location.getLatitude() + "&" + location.getLongitude());

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

    public LatLng getSrc() {
        for (int i = 0; i < points.size() - 1; i++) {
             src = points.get(i);
        }
        return src;
    }

    public LatLng getDest() {
        for (int i = 0; i < points.size() - 1; i++) {
             dest = points.get(i + 1);
        }
        return dest;
    }

}

