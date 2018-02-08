package com.visal_suos.javdagger2.di.modules;

import com.visal_suos.javdagger2.data.api.ApiService;
import com.visal_suos.javdagger2.data.room.batabase.MyDatabase;
import com.visal_suos.javdagger2.data.room.dao.HeroDao;
import com.visal_suos.javdagger2.mvp.model.MainModel;
import com.visal_suos.javdagger2.mvp.model.impl.MainModelImpl;
import com.visal_suos.javdagger2.mvp.presenter.impl.MainPresenterImpl;

import com.visal_suos.javdagger2.ui.activities.MainActivity;
import com.visal_suos.javdagger2.mvp.view.MainView;
import com.visal_suos.javdagger2.mvp.presenter.MainPresenter;
import com.visal_suos.javdagger2.utilities.NetworkUtils;


import dagger.Module;
import dagger.Provides;

/**
 * Created by v.suos on 1/18/2018.
 */
@Module
public class MainActivityModule {

    @Provides
    MainView provideMainView(MainActivity mainActivity) {
        return mainActivity;
    }

    @Provides
    MainPresenter provideMainPresenter(MainModel mainModel, MainView mainView) {
        MainPresenterImpl mainPresenter = new MainPresenterImpl(mainModel, mainView);
        return mainPresenter;
    }

    @Provides
    MainModel provideMainModel(ApiService apiService, HeroDao heroDao, NetworkUtils networkUtils) {
        return new MainModelImpl(apiService, heroDao, networkUtils);
    }

    @Provides
    public HeroDao provideHeroDao(MyDatabase myDatabase) {
        return myDatabase.heroDao();
    }

}