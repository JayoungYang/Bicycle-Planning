package com.example.lee.bicycleplanning;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;

import com.example.lee.bicycleplanning.fragments.BaseContainerFragment;
import com.example.lee.bicycleplanning.fragments.FindPathContainerFragment;
import com.example.lee.bicycleplanning.fragments.ReviewFragment;
import com.example.lee.bicycleplanning.fragments.WishPathFragment;


public class MainActivity extends FragmentActivity {
    private final static String TAG_FIND_PATH = "findpath";
    private final static String TAG_WISH_PATH = "wishpath";
    private final static String TAG_REVIEW = "review";

    private FragmentTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        mTabHost.addTab(mTabHost.newTabSpec(TAG_FIND_PATH).setIndicator("길 찾기"),
                FindPathContainerFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec(TAG_WISH_PATH).setIndicator("가고픈 길"),
                WishPathFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec(TAG_REVIEW).setIndicator("리뷰"),
                ReviewFragment.class, null);
    }

    @Override
    public void onBackPressed() {
        boolean isPopFragment = false;
        String currentTabTag = mTabHost.getCurrentTabTag();
        if(currentTabTag.equals(TAG_FIND_PATH)) {
            isPopFragment = ((BaseContainerFragment)getSupportFragmentManager().findFragmentByTag(TAG_FIND_PATH)).popFragment();
        }
        if(!isPopFragment) {
            finish();
        }
    }
}