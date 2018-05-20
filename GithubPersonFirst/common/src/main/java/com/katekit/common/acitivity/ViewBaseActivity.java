package com.katekit.common.acitivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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

    public void setFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().add(R.id.fl_public_layout, fragment, fragment.getTag()).commitAllowingStateLoss();
        currentFragment = fragment;
    }

    public void changeFragment(Fragment fragment) {
        if (fragment.isAdded()) {
            getSupportFragmentManager().beginTransaction().hide(currentFragment).show(fragment).commitAllowingStateLoss();
        } else {
            getSupportFragmentManager().beginTransaction().hide(currentFragment).add(R.id.fl_public_layout, fragment, fragment.getTag()).commitAllowingStateLoss();
        }
        currentFragment = fragment;
    }

}
