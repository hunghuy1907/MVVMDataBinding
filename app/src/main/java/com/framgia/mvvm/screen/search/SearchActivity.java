package com.framgia.mvvm.screen.search;

import android.os.Bundle;
import com.framgia.demodatabinding.screen.base.BaseActivity;

public class SearchActivity extends BaseActivity {
    @Override
    protected int getLayoutResources() {
        return com.framgia.demodatabinding.R.layout.activity_main;
    }

    @Override
    protected void initComponents() {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        getSupportFragmentManager().beginTransaction().add(com.framgia.demodatabinding.R.id.frame_main, SearchFragment.getInstance())
                .commit();
    }
}
