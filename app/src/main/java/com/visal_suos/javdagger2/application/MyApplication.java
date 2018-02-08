package com.visal_suos.javdagger2.application;

import android.app.Activity;
import android.app.Application;

import com.visal_suos.javdagger2.di.components.DaggerAppComponent;
import com.visal_suos.javdagger2.di.modules.AppModule;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by v.suos on 1/18/2018.
 */

public class MyApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build()
                .inject(this);
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }
}
