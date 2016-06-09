package com.freakybyte.poketest;

import android.app.Application;
import android.os.Handler;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Jose Torres in FreakyByte on 19/04/16.
 */
public class PokeApplication extends Application {

    private static PokeApplication singleton;
    private Handler mHandler = new Handler();

    public static PokeApplication getInstance() {
        return singleton;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
        Fresco.initialize(this);
    }

    public void handlerPost(Runnable runnable) {
        mHandler.post(runnable);
    }
}
