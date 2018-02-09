package com.katekit.common.compoment.location;

/**
 * Created by »ÆÃ÷²Ó on 2017/9/5 10:47.
 */

public class LocationInfo {
    private String longitude;
    private String latigude;

    public LocationInfo() {
    }

    public LocationInfo(String longitude, String latigude) {
        this.longitude = longitude;
        this.latigude = latigude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatigude() {
        return latigude;
    }

    public void setLatigude(String latigude) {
        this.latigude = latigude;
    }
}
