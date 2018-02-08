package com.visal_suos.javdagger2.di.builders;

import android.app.Activity;

import com.visal_suos.javdagger2.ui.activities.MainActivity;
import com.visal_suos.javdagger2.di.components.activity.MainActivityComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by v.suos on 1/18/2018.
 */

@Module
public abstract class ActivityBuilder {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindMainActivity(MainActivityComponent.Builder builder);

}
