package com.freakybyte.poketest.di.module;

import android.content.Context;

import com.freakybyte.poketest.db.RealmManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jose Torres in FreakyByte on 21/06/16.
 */
@Module
public class RealmModule {
    private final Context app;

    public RealmModule(Context app) {
        this.app = app;
    }

    @Provides
    @Singleton
    RealmManager provideRealmManager() {
        return new RealmManager(app);
    }
}
