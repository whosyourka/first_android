package com.katekit.common.location;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

import io.reactivex.annotations.NonNull;

public class CheckPermissionsActivity extends Activity {

    public boolean isCheck = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onResume() {
        super.onResume();
        if (isCheck) {
            String[] array = getIntent().getExtras().getStringArray("permissions");
            requestPermissions(array, CheckPermissionsUtils.PERMISSON_REQUESTCODE);
        }
        isCheck = false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        CheckPermissionsUtils.getInstance().onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
