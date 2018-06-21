package com.katekit.common.acitivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;

import com.katekit.common.R;


/**
 * Project Name：work1
 * Packagee Name：  com.katekit.nettest
 * Description：
 *
 * @author: huangmc
 * @date: 2016/3/2 10:35
 * Copyright (c) 2016年, Mr.huang . All Rights Reserved.
 */
public class ViewBaseActivity extends BaseActivity {
    ViewGroup flPublicLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_public_layout);
        flPublicLayout = (ViewGroup) findViewById(R.id.fl_public_layout);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


    }

    private Fragment currentFragment = null;


    public void changeFragment(Class classObject) {
        changeFragment(classObject, null);
    }

    public void changeFragment(Class classObject, Bundle bundle) {
        try {
            Class cls = Class.forName(classObject.getName());
            Fragment fragment = (Fragment) cls.newInstance();
            if (bundle != null) {
                fragment.setArguments(bundle);
            }
            if (currentFragment == null) {
                getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .add(R.id.fl_public_layout, fragment, fragment.getClass().getName()).commitAllowingStateLoss();
            } else {
                getSupportFragmentManager().beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .hide(currentFragment).remove(currentFragment).add(R.id.fl_public_layout, fragment, fragment.getClass().getName()).commitAllowingStateLoss();
            }
            currentFragment = fragment;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
