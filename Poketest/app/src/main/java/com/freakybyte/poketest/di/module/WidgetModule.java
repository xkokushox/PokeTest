package com.freakybyte.poketest.di.module;

import com.freakybyte.poketest.PokeApplication;
import com.freakybyte.poketest.util.WidgetManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jose Torres in FreakyByte on 20/06/16.
 */
@Module
public class WidgetModule {
    private final PokeApplication app;

    public WidgetModule(PokeApplication app) {
        this.app = app;
    }

    @Provides
    @Singleton
    WidgetManager provideWidgetManager() {
        return new WidgetManager(app);
    }
}
