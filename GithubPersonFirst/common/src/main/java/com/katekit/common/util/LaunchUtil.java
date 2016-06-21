package com.katekit.common.util;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;


public class LaunchUtil {

    public static final String FRAGMENT = "fragment";

    public static void launchActivity(Context context, Class<? extends Activity> cls,
                                      Class<? extends Fragment> clsFragment, Bundle bundle) {
        Intent intent = new Intent(context, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.putExtra(FRAGMENT, clsFragment);
        context.startActivity(intent);
    }

//    public static void launchSubActivity(Context context, Class<? extends Fragment> clsFragment, Bundle bundle) {
//        Intent intent = new Intent(context, BaseActivity.class);
//        if (bundle != null) {
//            intent.putExtras(bundle);
//        }
//        intent.putExtra(FRAGMENT, clsFragment);
//        context.startActivity(intent);
//    }
//
//    public static void launchSubActivityForResult(Fragment fragment, Class<? extends Fragment> clsFragment, Bundle bundle, int requestCode){
//        Intent intent = new Intent(fragment.getActivity(), BaseActivity.class);
//        if (bundle != null) {
//            intent.putExtras(bundle);
//        }
//        intent.putExtra(FRAGMENT, clsFragment);
//        fragment.startActivityForResult(intent, requestCode);
//    }

    public static void launchPhone(Context context, String phone) {
        Intent m_intent = new Intent();
        m_intent.setAction("android.intent.action.CALL");
        //m_intent.addCategory("android.intent.category.DEFAULT");
        m_intent.setData(Uri.parse("tel:" + phone));
        context.startActivity(m_intent); //说明： 此方法内部会自动为Intent添加类别: android.intent.category.DEFAULT
    }

}