package com.freakybyte.poketest.di.module;

import android.content.Context;

import com.freakybyte.poketest.util.WidgetManager;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jose Torres in FreakyByte on 20/06/16.
 */
@Module
public class WidgetModule {
    private final Context app;

    public WidgetModule(Context app) {
        this.app = app;
    }

    @Provides
    WidgetManager provideWidgetManager() {
        return new WidgetManager(app);
    }
}
