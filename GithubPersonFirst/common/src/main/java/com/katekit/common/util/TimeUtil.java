package com.katekit.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {

    private static final int S = 1000;
    private static final int M = 60 * S;
    private static final int H = 60 * M;
    private static final int D = 24 * H;

    /**
     * 生成时间戳
     *
     * @return
     */
    public static String generateTimestamp() {
        Date date = new Date(new Date().getTime());

        return getTimestampSDF().format(date);
    }

    /**
     * 取得时间戳的 SimpleDateFormat
     *
     * @return
     */
    private static SimpleDateFormat getTimestampSDF() {
        return new SimpleDateFormat("yyyyMMddHHmmss");
    }

    // 生成提交时间
    public static long getPublishTime() {
        return (System.currentTimeMillis() / 1000);
    }

    //离现在过了多久时间，返回秒
    public static long intervalTime(long oldTime) {
        return getPublishTime() - oldTime;
    }

    /**
     * 判斷當前時間和前一個時間的關係，并返回當前時間的描述
     * @param oldTime
     * @return
     */
    public static String transformTime(long oldTime) {
        return transformTime(oldTime * 1000, System.currentTimeMillis());
    }

    /**
     * 判断是否超过一天
     * @param oldTime
     * @param newTime
     * @return
     */
    public static boolean overOneDay(long oldTime, long newTime) {
        long diffTime = newTime - oldTime;

        Calendar oldDate = Calendar.getInstance();
        oldDate.setTimeInMillis(oldTime);
        extractDate(oldDate);
        Calendar newDate = Calendar.getInstance();
        newDate.setTimeInMillis(newTime);

        int diffDate = (int) ((newDate.getTimeInMillis() - oldDate.getTimeInMillis()) / D);

        if (diffDate == 0 || diffTime < 24 * H) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 前后时间比较，并返回比较结果
     * @param oldTime
     * @param newTime
     * @return
     */
    public static String transformTime(long oldTime, long newTime) {
        long diffTime = newTime - oldTime;
        if (diffTime < M) {
            return "刚刚";
        } else if (diffTime < H) {
            return diffTime / M + "分钟前";
        } else {
            Calendar oldDate = Calendar.getInstance();
            oldDate.setTimeInMillis(oldTime);
            extractDate(oldDate);
            Calendar newDate = Calendar.getInstance();
            newDate.setTimeInMillis(newTime);
            int diffDate = (int) ((newDate.getTimeInMillis() - oldDate.getTimeInMillis()) / D);
            if (diffDate == 0 || diffTime < 6 * H) {
                return diffTime / H + "小时前";
            } else if (diffDate == 1) {
                return "昨天";
            } else if (diffDate < 6) {
                return diffDate + "天前";
            } else if (oldDate.get(Calendar.YEAR) == newDate.get(Calendar.YEAR)) {
                SimpleDateFormat format = new SimpleDateFormat("MM月dd日");
                return format.format(oldDate.getTime());
            } else {
                SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
                return format.format(oldDate.getTime());
            }
        }
    }

    private static void extractDate(Calendar calendar) {
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
    }

    public static String time(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        Calendar curr = Calendar.getInstance();
        curr.setTimeInMillis(System.currentTimeMillis());
        if (calendar.get(Calendar.YEAR) == curr.get(Calendar.YEAR)) {
            SimpleDateFormat format = new SimpleDateFormat("MM月dd日");
            return format.format(calendar.getTime());
        } else {
            SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
            return format.format(calendar.getTime());
        }
    }


    /**
     * long转时间
     * @param time
     * @param formats
     * @return
     */
    public static String TimeStamp2Date(long time,String formats) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        SimpleDateFormat format = new SimpleDateFormat(formats);
        return format.format(calendar.getTime());
    }

    /**
     * long转时间 unix
     * @param timestampString
     * @param formats
     * @return
     */
    public static String TimeStamp2DateUnix(String timestampString, String formats) {
        Long timestamp = Long.parseLong(timestampString) * 1000;
        String date = new SimpleDateFormat(formats).format(new Date(timestamp));
        return date;
    }

    /**
     * 时间的处理 变成0：01
     * @param time
     * @return
     */
    public static String getSecondToTime(long time) {
        if (time <= 0) {
            return "0:00";
        }
        long secondnd = (time / 1000) / 60;
        long million = (time / 1000) % 60;
        String f = String.valueOf(secondnd);
        String m = million >= 10 ? String.valueOf(million) : "0"
                + String.valueOf(million);
        return f + ":" + m;
    }
    /**
     * 秒转时间
     * @param time
     * @return
     */
    public static String second2time(long time) {
        if (time <= 0) {
            return "0s";
        }
        long secondnd = (time / 1000) / 60;
        long million = (time / 1000) % 60;

        if (secondnd==0){
            return million+"s";
        }else{
            return secondnd+"m"+million+"s";
        }
    }


    /**
     * 相差几天
     * @param from
     * @param to
     * @return
     */
    public static long getDays(String from, String to) {
        SimpleDateFormat smdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date start = smdf.parse(from);
            Date end = smdf.parse(to);
            long intervalMilli = (end.getTime() - start.getTime()) / (24 * 60 * 60 * 1000);
            return intervalMilli;
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 相差几秒
     * @param from
     * @param to
     * @return
     */
    public static long getSecond(String from, String to) {
        SimpleDateFormat smdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date start = smdf.parse(from);
            Date end = smdf.parse(to);
            long intervalMilli = (end.getTime() - start.getTime()) / (1000);
            return intervalMilli;
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println(e.toString());
            return 0;
        }
    }


}
