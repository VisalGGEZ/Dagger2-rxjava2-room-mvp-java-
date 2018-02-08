package com.visal_suos.javdagger2.mvp.view;

import com.visal_suos.javdagger2.data.response.HeroesResponse;
import com.visal_suos.javdagger2.data.response.ShortInfoHero;

import java.util.List;

/**
 * Created by v.suos on 1/18/2018.
 */

public interface MainView{
    void onHeroesLoaded(List<ShortInfoHero> heroesResponse);
}
