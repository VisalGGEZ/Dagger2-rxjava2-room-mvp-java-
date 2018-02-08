package com.visal_suos.javdagger2.di.components.activity;

import com.visal_suos.javdagger2.ui.activities.MainActivity;
import com.visal_suos.javdagger2.di.modules.MainActivityModule;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by v.suos on 1/18/2018.
 */

@Subcomponent(modules = MainActivityModule.class)
public interface MainActivityComponent extends AndroidInjector<MainActivity>{
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity>{}
}