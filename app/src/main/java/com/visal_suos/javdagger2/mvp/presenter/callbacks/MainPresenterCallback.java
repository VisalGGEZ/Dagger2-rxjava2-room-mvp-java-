package com.visal_suos.javdagger2.mvp.presenter.callbacks;

import com.visal_suos.javdagger2.data.response.ShortInfoHero;

import java.util.List;

/**
 * Created by v.suos on 2/6/2018.
 */

public interface MainPresenterCallback {
    String TAG = "MainPresenterCallback";
    void onHeroesLoaded(List<ShortInfoHero> heroesResponses);
}
