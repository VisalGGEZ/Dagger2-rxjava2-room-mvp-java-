package com.visal_suos.javdagger2.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.visal_suos.javdagger2.R;
import com.visal_suos.javdagger2.data.response.ShortInfoHero;
import com.visal_suos.javdagger2.mvp.presenter.MainPresenter;
import com.visal_suos.javdagger2.mvp.view.MainView;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity implements MainView{

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainPresenter.getHeroes();
    }

    @Override
    public void onHeroesLoaded(List<ShortInfoHero> heroesResponse) {
        List<ShortInfoHero> heroesResponse1 = heroesResponse;
    }

}
