package com.katekit.common.compoment.location;

/**
 * Created by zhanghang on 2017/8/30.
 * <p>
 * 获取精度和维度工具类
 * <p>
 * 使用：
 * LocationUtils.getInstance(this).loadPosition(new LocationListener).start();
 * <p>
 * 注意事项：
 * 1.在使用本工具类前，请检查权限，
 */

public class LocationUtils {

//    private static LocationUtils instance;
//    private AMapLocationClient mLocationClient = null;
//    private AMapLocationListener mapLocationListener = null;
//    private AMapLocationClientOption mLocationOption = null;
//
//
//    private LocationUtils(Context context) {
//        mLocationClient = new AMapLocationClient(context);
//        mLocationOption = new AMapLocationClientOption();
//        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
////        mLocationOption.setOnceLocation(true);
////        mLocationOption.setOnceLocationLatest(true);
////        mLocationOption.setLocationCacheEnable(false);
//        mLocationOption.setInterval(2000);
//    }
//
//
//    public static LocationUtils getInstance(Context context) {
//        if (instance == null) {
//            synchronized (LocationUtils.class) {
//                if (instance == null) {
//                    instance = new LocationUtils(context);
//                }
//            }
//        }
//        return instance;
//    }
//
//
//    public LocationUtils loadPosition(final OnPositonResult onPositonResult) {
//
//
//        mapLocationListener = new AMapLocationListener() {
//            @Override
//            public void onLocationChanged(AMapLocation aMapLocation) {
//
//                if (aMapLocation != null) {
//                    if (aMapLocation.getErrorCode() == 0) {
//                        double longitude = aMapLocation.getLongitude();//获取经度
//                        double latitue = aMapLocation.getLatitude();//获取纬度
//                        onPositonResult.onResult(longitude, latitue);
//                        //停止定位。
//                        stop();
//                        return;
//                    } else {
//                        //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
//                        Log.e("AmapError", "location Error, ErrCode:"
//                                + aMapLocation.getErrorCode() + ", errInfo:"
//                                + aMapLocation.getErrorInfo());
//                        onPositonResult.onFail(aMapLocation.getErrorCode());
//                    }
//                }
////                start();
//            }
//        };
//
//        mLocationClient.setLocationOption(mLocationOption);
//        mLocationClient.setLocationListener(mapLocationListener);
//        return instance;
//    }
//
//    public void start() {
//        mLocationClient.startLocation();
//    }
//
//
//    private void stop() {
//        mLocationClient.stopLocation();//停止定位后，本地定位服务并不会被销毁
//        mLocationClient.onDestroy();//销毁定位客户端，同时销毁本地定位服务。
//    }
//
//    public interface OnPositonResult {
//        void onResult(double longitude, double latigude);
//
//        void onFail(int errorCode);
//    }
//
//    public static LocationInfo getLocation(Context context) {
//        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission
//                .ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//        }//检查
//
////        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
////        //获取所有可用的位置提供器
////        String locationProvider = "";
////        List<String> providers = locationManager.getProviders(true);
////        if (providers.contains(LocationManager.GPS_PROVIDER)) {
////            //如果是GPS
////            locationProvider = LocationManager.GPS_PROVIDER;
////        } else if (providers.contains(LocationManager.NETWORK_PROVIDER)) {
////            //如果是Network
////            locationProvider = LocationManager.NETWORK_PROVIDER;
////        }
////        if (!TextUtils.isEmpty(locationProvider)) {
////            Location location = locationManager.getLastKnownLocation(locationProvider);
////            if (location != null) {
////                //不为空,显示地理位置经纬度
////                return new LocationInfo(location.getLongitude()+"",location.getLatitude()+"");
////            }
////        }
//
//        final LocationInfo locationInfo = new LocationInfo();
//        final CountDownLatch latch = new CountDownLatch(1);
//        LocationUtils.getInstance(context).loadPosition(new OnPositonResult() {
//            @Override
//            public void onResult(double longitude, double latigude) {
//                locationInfo.setLatigude(latigude+"");
//                locationInfo.setLongitude(longitude+"");
//                Log.i("location",longitude+":onResult");
//                latch.countDown();
//            }
//
//            @Override
//            public void onFail(int errorCode) {
//                Log.i("location",errorCode+":onfail");
////                latch.countDown();
//             }
//        }).start();
//        try {
//            latch.await();
//        } catch (InterruptedException e) {
//        }
//        return locationInfo;
//    }
//
//    private static int checkSelfPermission(String accessFineLocation) {
//        return 0;
//    }


}
