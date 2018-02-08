package com.visal_suos.javdagger2.di.modules;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.visal_suos.javdagger2.data.api.ApiService;
import com.visal_suos.javdagger2.data.room.batabase.MyDatabase;
import com.visal_suos.javdagger2.di.components.activity.MainActivityComponent;
import com.visal_suos.javdagger2.utilities.NetworkUtils;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by v.suos on 1/18/2018.
 */

@Module(subcomponents = {
        MainActivityComponent.class})
public class AppModule {

    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Singleton @Provides
    public Context provideContext(){
        return context;
    }

    @Singleton
    @Provides
    GsonConverterFactory provideGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Singleton
    @Provides
    @Named("ok-1")
    OkHttpClient provideOkHttpClient1() {
        return new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
    }

    @Singleton
    @Provides
    @Named("ok-2")
    OkHttpClient provideOkHttpClient2() {
        return new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    @Singleton
    @Provides
    RxJava2CallAdapterFactory provideRxJavaCallAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(@Named("ok-1") OkHttpClient client, GsonConverterFactory converterFactory, RxJava2CallAdapterFactory adapterFactory) {
        return new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/VisalGGEZ/udemy-forum/master/")
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(adapterFactory)
                .client(client)
                .build();
    }

    @Singleton
    @Provides
    ApiService provideApiService(Retrofit retrofit){
        return retrofit.create(ApiService.class);
    }

    @Singleton
    @Provides
    NetworkUtils provideNetworkUtils(Context application){
        return new NetworkUtils(application);
    }

    @Singleton @Provides
    public MyDatabase provideMyDatabase(Context application){
        return Room.databaseBuilder(application, MyDatabase.class, "my-db").build();
    }
}
