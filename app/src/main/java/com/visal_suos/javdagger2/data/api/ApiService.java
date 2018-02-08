package com.visal_suos.javdagger2.data.api;

import com.visal_suos.javdagger2.data.response.HeroesResponse;
import com.visal_suos.javdagger2.data.response.ShortInfoHero;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import retrofit2.http.GET;

/**
 * Created by v.suos on 1/18/2018.
 */

public interface ApiService {
    @GET("json-test.json")
    Maybe<List<HeroesResponse>> getHeroes();

    @GET("shortheroes.json")
    Maybe<List<ShortInfoHero>> getShortInfo();
}
