package com.mr_wang.ttg.application;

import android.app.Application;

import org.xutils.x;

/**
 * Created by MR_Wang on 2017/2/22.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
