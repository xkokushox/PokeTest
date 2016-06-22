package com.freakybyte.poketest.controller.detail.di;

import com.freakybyte.poketest.controller.detail.constuctors.DetailView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jose Torres in FreakyByte on 21/06/16.
 */
@Module
public class DetailModule {

    private final DetailView mView;

    public DetailModule(DetailView view) {
        mView = view;
    }

    @Provides
    DetailView provideTasksContractView() {
        return mView;
    }

}
