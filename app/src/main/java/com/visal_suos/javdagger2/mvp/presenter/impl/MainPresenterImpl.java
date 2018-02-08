package com.visal_suos.javdagger2.mvp.presenter.impl;

import com.visal_suos.javdagger2.data.response.ShortInfoHero;
import com.visal_suos.javdagger2.mvp.model.MainModel;
import com.visal_suos.javdagger2.mvp.presenter.MainPresenter;
import com.visal_suos.javdagger2.mvp.presenter.callbacks.MainPresenterCallback;
import com.visal_suos.javdagger2.mvp.view.MainView;

import java.util.List;

/**
 * Created by v.suos on 2/7/2018.
 */

public class MainPresenterImpl implements MainPresenter, MainPresenterCallback {

    private MainModel mainModel;
    private MainView mainView;

    public MainPresenterImpl(MainModel mainModel, MainView mainView){
        this.mainModel = mainModel;
        this.mainModel.setCallListener(this);
        this.mainView = mainView;
    }

    @Override
    public void getHeroes() {
        mainModel.getHeroes();
    }

    @Override
    public void onHeroesLoaded(List<ShortInfoHero> heroesResponses) {
        mainView.onHeroesLoaded(heroesResponses);
    }
}
