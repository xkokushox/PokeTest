package com.freakybyte.poketest.di.component;

import com.freakybyte.poketest.di.manager.RealmManager;
import com.freakybyte.poketest.di.module.AppModule;
import com.freakybyte.poketest.di.module.RealmModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Jose Torres in FreakyByte on 21/06/16.
 */
@Singleton
@Component(modules = {RealmModule.class, AppModule.class})
public interface RealmComponent {
    RealmManager getRealmManager();
}
