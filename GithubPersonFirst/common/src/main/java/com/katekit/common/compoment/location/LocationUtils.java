package com.katekit.common.compoment.location;

/**
 * Created by zhanghang on 2017/8/30.
 * <p>
 * ��ȡ���Ⱥ�ά�ȹ�����
 * <p>
 * ʹ�ã�
 * LocationUtils.getInstance(this).loadPosition(new LocationListener).start();
 * <p>
 * ע�����
 * 1.��ʹ�ñ�������ǰ������Ȩ�ޣ�
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
//                        double longitude = aMapLocation.getLongitude();//��ȡ����
//                        double latitue = aMapLocation.getLatitude();//��ȡγ��
//                        onPositonResult.onResult(longitude, latitue);
//                        //ֹͣ��λ��
//                        stop();
//                        return;
//                    } else {
//                        //��λʧ��ʱ����ͨ��ErrCode�������룩��Ϣ��ȷ��ʧ�ܵ�ԭ��errInfo�Ǵ�����Ϣ������������
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
//        mLocationClient.stopLocation();//ֹͣ��λ�󣬱��ض�λ���񲢲��ᱻ����
//        mLocationClient.onDestroy();//���ٶ�λ�ͻ��ˣ�ͬʱ���ٱ��ض�λ����
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
//        }//���
//
////        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
////        //��ȡ���п��õ�λ���ṩ��
////        String locationProvider = "";
////        List<String> providers = locationManager.getProviders(true);
////        if (providers.contains(LocationManager.GPS_PROVIDER)) {
////            //�����GPS
////            locationProvider = LocationManager.GPS_PROVIDER;
////        } else if (providers.contains(LocationManager.NETWORK_PROVIDER)) {
////            //�����Network
////            locationProvider = LocationManager.NETWORK_PROVIDER;
////        }
////        if (!TextUtils.isEmpty(locationProvider)) {
////            Location location = locationManager.getLastKnownLocation(locationProvider);
////            if (location != null) {
////                //��Ϊ��,��ʾ����λ�þ�γ��
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
