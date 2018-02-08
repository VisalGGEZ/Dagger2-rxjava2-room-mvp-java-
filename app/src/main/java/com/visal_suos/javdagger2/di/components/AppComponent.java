package com.visal_suos.javdagger2.di.components;

import com.visal_suos.javdagger2.application.MyApplication;
import com.visal_suos.javdagger2.di.modules.AppModule;
import com.visal_suos.javdagger2.di.builders.ActivityBuilder;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by v.suos on 1/18/2018.
 */
@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        ActivityBuilder.class})
public interface AppComponent {

//    @Component.Builder
//    interface Builder{
//        @BindsInstance Builder application(ApplicationInfo applicationInfo);
//        AppComponent build();
//    }

    void inject(MyApplication app);
}