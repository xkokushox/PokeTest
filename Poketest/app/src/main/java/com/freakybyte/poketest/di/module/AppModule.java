package com.freakybyte.poketest.di.module;

import android.app.Application;

import com.freakybyte.poketest.PokeApplication;
import com.freakybyte.poketest.di.scope.ForApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jose Torres in FreakyByte on 17/06/16.
 */

@Module
public class AppModule {

    private final PokeApplication app;

    public AppModule(PokeApplication app) {
        this.app = app;
    }

    @Provides
    @Singleton
    @ForApplication
    public Application providesApplication() {
        return app;
    }


}
