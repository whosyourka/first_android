package com.katekit.common.location;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by 黄明灿 on 2018/1/10 10:34.
 * Describe :
 * <p>
 * 以下为危险权限，需申请
 * group:android.permission-group.CONTACTS
 * permission:android.permission.WRITE_CONTACTS
 * permission:android.permission.GET_ACCOUNTS
 * permission:android.permission.READ_CONTACTS
 * <p>
 * group:android.permission-group.PHONE
 * permission:android.permission.READ_CALL_LOG
 * permission:android.permission.READ_PHONE_STATE
 * permission:android.permission.CALL_PHONE
 * permission:android.permission.WRITE_CALL_LOG
 * permission:android.permission.USE_SIP
 * permission:android.permission.PROCESS_OUTGOING_CALLS
 * permission:com.android.voicemail.permission.ADD_VOICEMAIL
 * <p>
 * group:android.permission-group.CALENDAR
 * permission:android.permission.READ_CALENDAR
 * permission:android.permission.WRITE_CALENDAR
 * <p>
 * group:android.permission-group.CAMERA
 * permission:android.permission.CAMERA
 * <p>
 * group:android.permission-group.SENSORS
 * permission:android.permission.BODY_SENSORS
 * <p>
 * group:android.permission-group.LOCATION
 * permission:android.permission.ACCESS_FINE_LOCATION
 * permission:android.permission.ACCESS_COARSE_LOCATION
 * <p>
 * group:android.permission-group.STORAGE
 * permission:android.permission.READ_EXTERNAL_STORAGE
 * permission:android.permission.WRITE_EXTERNAL_STORAGE
 * <p>
 * group:android.permission-group.MICROPHONE
 * permission:android.permission.RECORD_AUDIO
 * <p>
 * group:android.permission-group.SMS
 * permission:android.permission.READ_SMS
 * permission:android.permission.RECEIVE_WAP_PUSH
 * permission:android.permission.RECEIVE_MMS
 * permission:android.permission.RECEIVE_SMS
 * permission:android.permission.SEND_SMS
 * permission:android.permission.READ_CELL_BROADCASTS
 * <p>
 * 检查权限 请求权限 处理权限请求响应 失败则提示
 * 或者提示客户并打开本应用信息界面，由用户自己手动开启这个权限。(注释)
 * <p>
 * target sdk >= 23  低于 23要做判断
 * <p>
 * 实际代码建议：放在开头或者在需要对应的权限前启用 checkPermission
 */
public class CheckPermissionsUtils {
    public static final int PERMISSON_REQUESTCODE = 0;

    public interface PermissionListener {

        /**
         * 通过授权
         *
         * @param permission
         */
        void permissionGranted(@NonNull String[] permission);

        /**
         * 拒绝授权
         *
         * @param permission
         */
        void permissionDenied(@NonNull String[] permission);
    }

    private static CheckPermissionsUtils instance;
    private PermissionListener mPermissionListener;


    private CheckPermissionsUtils() {
    }

    public static CheckPermissionsUtils getInstance() {
        if (instance == null) {
            synchronized (CheckPermissionsUtils.class) {
                if (instance == null) {
                    instance = new CheckPermissionsUtils();
                }
            }
        }
        return instance;
    }

    public void setPermissionListener(PermissionListener permissionListener) {
        this.mPermissionListener = permissionListener;
    }

    public void checkPermission(Context context, String[] permissionList) {
        if (Build.VERSION.SDK_INT >= 23 && context.getApplicationInfo().targetSdkVersion >= 23) {
            checkPermissions(context, permissionList);
        } else {
            if (hasPermission(context, permissionList)) {
                mPermissionListener.permissionDenied(permissionList);
            } else {
                mPermissionListener.permissionGranted(permissionList);
            }
        }
    }

    private boolean hasPermission(Context context, String[] permissionList) {
        List<String> arrays = findDeniedPermissions(context, permissionList);
        return arrays != null && arrays.size() > 0;
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void checkPermissions(Context context, String[] permissions) {
        List<String> needRequestPermissonList = findDeniedPermissions(context, permissions);
        if (null != needRequestPermissonList && needRequestPermissonList.size() > 0) {
            String[] array = needRequestPermissonList.toArray(new String[needRequestPermissonList.size()]);
            Intent intent = new Intent(context, CheckPermissionsActivity.class);
            intent.putExtra("permissions", array);
            context.startActivity(intent);
        } else {
            mPermissionListener.permissionGranted(permissions);
        }
    }

    /**
     * 获取权限集中需要申请权限的列表
     *
     * @param permissions
     * @return
     * @since 2.5.0
     */
    @TargetApi(Build.VERSION_CODES.M)
    private List<String> findDeniedPermissions(Context context, String[] permissions) {
        List<String> needRequestPermissonList = new ArrayList<String>();
        for (String perm : permissions) {
            if ((context.checkSelfPermission(perm) != PackageManager.PERMISSION_GRANTED)
//                    || context.shouldShowRequestPermissionRationale(perm)
                    ) {
                needRequestPermissonList.add(perm);
            }
        }
        return needRequestPermissonList;
    }


    /**
     * @param requestCode
     * @param permissions
     * @param paramArrayOfInt 权限返回处理结果
     */
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] paramArrayOfInt) {
        if (requestCode == PERMISSON_REQUESTCODE) {
            if (!verifyPermissions(paramArrayOfInt)) {
                showMissingPermissionDialog();
            } else {
                mPermissionListener.permissionGranted(permissions);
            }
        }
        mPermissionListener.permissionDenied(permissions);
    }

    private boolean verifyPermissions(int[] grantResults) {
        for (int result : grantResults) {
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }


    /**
     * 显示提示信息
     */
    private void showMissingPermissionDialog() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
//        builder.setTitle(R.string.notifyTitle);
//        builder.setMessage(R.string.notifyMsg);
//
//        // 拒绝, 退出应用
//        builder.setNegativeButton(R.string.cancel,
//                new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        activity.finish();
//                    }
//                });
//
//        builder.setPositiveButton(R.string.setting,
//                new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        startAppSettings();
//                    }
//                });
//
//        builder.setCancelable(false);
//
//        builder.show();
    }

    /**
     * 启动应用的设置
     */
    private void startAppSettings() {
//        Intent intent = new Intent(
//                Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
//        intent.setData(Uri.parse("package:" + activity.getPackageName()));
//        activity.startActivity(intent);
    }


}
