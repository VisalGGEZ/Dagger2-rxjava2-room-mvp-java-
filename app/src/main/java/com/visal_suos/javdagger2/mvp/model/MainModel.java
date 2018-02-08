package com.visal_suos.javdagger2.mvp.model;

import com.visal_suos.javdagger2.mvp.presenter.MainPresenter;
import com.visal_suos.javdagger2.mvp.presenter.callbacks.MainPresenterCallback;

/**
 * Created by v.suos on 2/5/2018.
 */

public interface MainModel {

    void getHeroes();

    void setCallListener(MainPresenterCallback mainPresenterCallback);
}
