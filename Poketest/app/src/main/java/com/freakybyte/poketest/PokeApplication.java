package com.freakybyte.poketest;

import android.app.Application;
import android.os.Handler;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.freakybyte.poketest.di.component.DaggerWidgetComponent;
import com.freakybyte.poketest.di.component.WidgetComponent;
import com.freakybyte.poketest.di.module.WidgetModule;

/**
 * Created by Jose Torres in FreakyByte on 19/04/16.
 */
public class PokeApplication extends Application {

    private static PokeApplication singleton;
    private Handler mHandler = new Handler();

    private WidgetComponent widgetComponent;

    public static PokeApplication getInstance() {
        return singleton;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
        Fresco.initialize(this);

        widgetComponent = DaggerWidgetComponent.builder().widgetModule(new WidgetModule(this)).build();

    }


    public void handlerPost(Runnable runnable) {
        mHandler.post(runnable);
    }

    public WidgetComponent getWidgetComponent() {
        return this.widgetComponent;
    }

}
