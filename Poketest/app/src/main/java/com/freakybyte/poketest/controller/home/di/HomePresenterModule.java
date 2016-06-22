package com.freakybyte.poketest.controller.home.di;

import com.freakybyte.poketest.controller.home.constructors.HomeView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jose Torres in FreakyByte on 21/06/16.
 */

@Module
public class HomePresenterModule {

    private final HomeView mView;

    public HomePresenterModule(HomeView view) {
        mView = view;
    }

    @Provides
    HomeView provideTasksContractView() {
        return mView;
    }

}
