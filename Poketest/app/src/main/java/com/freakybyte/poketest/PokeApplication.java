package com.freakybyte.poketest;

import android.app.Application;
import android.os.Handler;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.freakybyte.poketest.di.component.DaggerRealmComponent;
import com.freakybyte.poketest.di.component.RealmComponent;
import com.freakybyte.poketest.di.module.AppModule;
import com.freakybyte.poketest.di.module.RealmModule;

/**
 * Created by Jose Torres in FreakyByte on 19/04/16.
 */
public class PokeApplication extends Application {

    private static PokeApplication singleton;
    private Handler mHandler = new Handler();

    public static PokeApplication getInstance() {
        return singleton;
    }

    private RealmComponent mRealmComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
        Fresco.initialize(this);

    }


    public void handlerPost(Runnable runnable) {
        mHandler.post(runnable);
    }

    public RealmComponent getRealmComponent() {
        if (mRealmComponent == null)
            mRealmComponent = DaggerRealmComponent.builder().appModule(new AppModule(this)).realmModule(new RealmModule(this)).build();
        return mRealmComponent;
    }

}
