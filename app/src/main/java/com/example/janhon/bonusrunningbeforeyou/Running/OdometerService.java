package com.example.janhon.bonusrunningbeforeyou.Running;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.LocationManager;
import android.os.Binder;
import android.os.IBinder;

import java.security.Provider;
import android.os.Bundle;
import android.location.LocationListener;
import android.location.Location;
import android.support.v4.content.ContextCompat;

public class OdometerService extends Service {
    private final IBinder binder = new OdometerBinder();
    private LocationListener listener;
    private LocationManager locationManager;
    public static final String PERMISSION_STRING = Manifest.permission.ACCESS_FINE_LOCATION;
    private static double distanceInKilometers;
    private static Location lastLocation = null;

    public OdometerService() {
    }

    public  class  OdometerBinder extends Binder {
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
    public void onCreate(){
        super.onCreate();
        listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
            if(lastLocation == null){
                lastLocation = location;
            }
            distanceInKilometers += location.distanceTo(lastLocation);
            lastLocation = location;
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
        if(ContextCompat.checkSelfPermission(this,PERMISSION_STRING) == PackageManager.PERMISSION_GRANTED){
            String provider = locationManager.getBestProvider(new Criteria(),true);
            if(provider != null){
                locationManager.requestLocationUpdates(provider, 1000,1,listener);
            }
        }


    }

        @Override
        public void  onDestroy(){
        super.onDestroy();
        if(locationManager != null && listener != null){
            if(ContextCompat.checkSelfPermission(this, PERMISSION_STRING) == PackageManager.PERMISSION_GRANTED){
                locationManager.removeUpdates(listener);
            }
            locationManager = null;
            listener = null;
        }
    }

         public double getDistance(){
             return distanceInKilometers;
         }

}
