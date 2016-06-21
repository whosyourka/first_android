package com.katekit.common.util;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;


public class LocationManagerUtil {

    private static LocationManagerUtil util;

    /** 经度 */
    private double xpoint =0.0;
    private double ypoint =0.0;

    public static LocationManagerUtil getInstace(){
        if(util == null) {
            util = new LocationManagerUtil();
        }

        return util;
    }

    public double getXpoint() {
        return xpoint;
    }

    public double getYpoint() {
        return ypoint;
    }

    public void initLocation(Context context) {
        LocationManager locationManager = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
        if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if(location != null){
//                xpoint = location.getLatitude();
//                ypoint = location.getLongitude();

                ypoint = location.getLatitude();
                xpoint = location.getLongitude();
            }
        }else{
            LocationListener locationListener = new LocationListener() {

                // Provider的状态在可用、暂时不可用和无服务三个状态直接切换时触发此函数
                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {

                }

                // Provider被enable时触发此函数，比如GPS被打开
                @Override
                public void onProviderEnabled(String provider) {

                }

                // Provider被disable时触发此函数，比如GPS被关闭
                @Override
                public void onProviderDisabled(String provider) {

                }

                //当坐标改变时触发此函数，如果Provider传进相同的坐标，它就不会被触发
                @Override
                public void onLocationChanged(Location location) {
                    if (location != null) {
//                        LogUtil.e("Map", "Location changed : Lat: "
//                                + location.getLatitude() + " Lng: "
//                                + location.getLongitude());
                    }
                }
            };
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,1000, 0,locationListener);
            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            if(location != null){
//                xpoint = location.getLatitude(); //经度
//                ypoint = location.getLongitude(); //纬度

                ypoint =  location.getLatitude(); //经度
                xpoint = location.getLongitude(); //纬度;
            }
        }
    }



}
