package com.visal_suos.javdagger2.mvp.model.base;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by v.suos on 2/5/2018.
 */

public abstract class BaseModel {

    protected <T> void subscribe(Flowable<T> observable, Observer<T> observer) {
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(t -> {});
    }

}
