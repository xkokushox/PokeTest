package com.freakybyte.poketest.di.component;

import android.app.Application;

import com.freakybyte.poketest.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Jose Torres in FreakyByte on 19/06/16.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(Application application);

}
