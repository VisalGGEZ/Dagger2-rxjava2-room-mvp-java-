package com.visal_suos.javdagger2.mvp.model.impl;

import android.util.Log;

import com.visal_suos.javdagger2.data.api.ApiService;
import com.visal_suos.javdagger2.data.response.ShortInfoHero;
import com.visal_suos.javdagger2.data.room.dao.HeroDao;
import com.visal_suos.javdagger2.data.room.entity.Hero;
import com.visal_suos.javdagger2.data.room.mapper.HeroMapper;
import com.visal_suos.javdagger2.mvp.model.MainModel;
import com.visal_suos.javdagger2.mvp.presenter.callbacks.MainPresenterCallback;
import com.visal_suos.javdagger2.utilities.NetworkUtils;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by v.suos on 2/5/2018.
 */

public class MainModelImpl implements MainModel {

    private HeroDao heroDao;
    private NetworkUtils networkUtils;
    private ApiService apiService;
    private MainPresenterCallback callback;

    public MainModelImpl(ApiService apiService, HeroDao heroDao, NetworkUtils networkUtils) {
        this.apiService = apiService;
        this.heroDao = heroDao;
        this.networkUtils = networkUtils;
    }

    @Override
    public void getHeroes() {
        Maybe<List<ShortInfoHero>> heroList;
        if (networkUtils.isNetAvailable()) {
            heroList = apiService.getShortInfo().subscribeOn(Schedulers.newThread());
        } else {
            heroList = heroDao.getAll().
                    subscribeOn(Schedulers.computation())
                    .map(heroes -> HeroMapper.convert(heroes));
        }

        Maybe<List<ShortInfoHero>> listHeroesCache = heroList.cache();

        listHeroesCache.observeOn(Schedulers.computation())
                .subscribe(heroesResponse -> {
                    if (networkUtils.isNetAvailable()) {
                        //when data were fetched insert'em into hero
                        long[] roweffect = heroDao.insertAsList(HeroMapper.map(heroesResponse));

                        Log.d(callback.TAG, roweffect.length + " rows effected");
                    }
                }, throwable -> {
                    Log.d(callback.TAG, throwable.toString());
                });

        listHeroesCache.observeOn(AndroidSchedulers.mainThread())
                .subscribe(heroesResponse -> {
                    Log.d(callback.TAG, heroesResponse.size() + "");
                    //go on
                    callback.onHeroesLoaded(heroesResponse);
                }, throwable -> {
                    Log.d(callback.TAG, throwable.toString());
                });

    }

    @Override
    public void setCallListener(MainPresenterCallback mainPresenterCallback) {
        callback = mainPresenterCallback;
    }
}
