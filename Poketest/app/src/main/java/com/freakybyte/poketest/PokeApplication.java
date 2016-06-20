package com.freakybyte.poketest;

import android.app.Application;
import android.os.Handler;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.freakybyte.poketest.di.component.DaggerStorageComponent;
import com.freakybyte.poketest.di.component.StorageComponent;
import com.freakybyte.poketest.di.module.StorageModule;

/**
 * Created by Jose Torres in FreakyByte on 19/04/16.
 */
public class PokeApplication extends Application {

    private static PokeApplication singleton;
    private Handler mHandler = new Handler();

    private StorageComponent storageComponent;

    public static PokeApplication getInstance() {
        return singleton;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
        Fresco.initialize(this);

        storageComponent = DaggerStorageComponent.builder().storageModule(new StorageModule(this)).build();

    }


    public void handlerPost(Runnable runnable) {
        mHandler.post(runnable);
    }

    public StorageComponent getStorageComponent() {
        return this.storageComponent;
    }

}
