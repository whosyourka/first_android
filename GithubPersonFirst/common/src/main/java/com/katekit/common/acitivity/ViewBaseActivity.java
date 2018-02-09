package com.katekit.common.acitivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.katekit.common.R;
import com.katekit.common.util.listener.PreventDoubleClickListener;


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
    Toolbar toolbar;
    ViewGroup flPublicLayout;
    TextView tvTitle;
    RelativeLayout rlTitleBar;
    LinearLayout tvTitleLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_public_layout);
        rlTitleBar = (RelativeLayout) findViewById(R.id.rl_title_bar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        flPublicLayout = (ViewGroup) findViewById(R.id.fl_public_layout);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvTitleLayout = (LinearLayout) findViewById(R.id.tv_title_layout);

        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.btn_bar_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewBaseActivity.this.finish();
            }
        });
        getSupportActionBar().setDisplayShowTitleEnabled(false);


    }

    public void backArrowDisappear() {
        toolbar.setNavigationIcon(null);
    }

    public void setLeftOnclickListener(PreventDoubleClickListener preventDoubleClickListener) {
        toolbar.setNavigationOnClickListener(preventDoubleClickListener);
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    public void setTitle(String string) {
        tvTitle.setText(string);
    }

    public ViewGroup getTitleBar() {
        return rlTitleBar;
    }

    public LinearLayout getTitleMsgLayout() {
        return tvTitleLayout;
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
