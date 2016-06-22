package com.freakybyte.poketest.controller.home.di;

import com.freakybyte.poketest.controller.home.ui.HomeActivity;
import com.freakybyte.poketest.di.module.WidgetModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Jose Torres in FreakyByte on 21/06/16.
 */
@Singleton
@Component(modules = {HomePresenterModule.class, WidgetModule.class})
public interface HomeComponent {
    void inject(HomeActivity activity);
}
