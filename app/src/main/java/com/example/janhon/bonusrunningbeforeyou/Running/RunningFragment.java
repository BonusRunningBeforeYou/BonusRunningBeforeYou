package com.example.janhon.bonusrunningbeforeyou.Running;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crashlytics.android.Crashlytics;
import com.example.janhon.bonusrunningbeforeyou.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class RunningFragment extends Fragment implements
        OnMapReadyCallback {
    public GoogleMap map;
    private OdometerService odometer;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, //container傳入
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_running, container, false); //inflater 載入器,載入layout.fragment_score
        SupportMapFragment mapFragment = null;
        if (getFragmentManager() != null) {
            mapFragment = (SupportMapFragment) getChildFragmentManager()
                    .findFragmentById(R.id.map);
        }
        if (mapFragment != null)
            mapFragment.getMapAsync(this);
        return view;
    }

    @Override
    public void onMapReady(GoogleMap map) {
        this.map = map;
        setUpMap();


    }

    private void setUpMap() {
        if (ActivityCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            map.setMyLocationEnabled(true);
        }
        map.getUiSettings().setZoomControlsEnabled(true);

    }

    public void draw2D() {
        Polyline polyline = map.addPolyline(
                new PolylineOptions()
                        .add(new LatLng(odometer.getSrc().latitude, odometer.getSrc().longitude), new LatLng(odometer.getDest().latitude, odometer.getDest().longitude)) //緯經度放這邊. 根據記錄,描繪各個點把軌跡呈現.
                        .width(10)
                        .color(Color.MAGENTA)
                        .zIndex(1)); //z軸,數字越大,高度越高. default值為零.

        polyline.setWidth(10);

    }
}



