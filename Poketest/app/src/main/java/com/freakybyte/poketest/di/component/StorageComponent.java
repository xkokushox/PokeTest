package com.freakybyte.poketest.di.component;

import com.freakybyte.poketest.controller.detail.DetailActivity;
import com.freakybyte.poketest.controller.home.ui.HomeActivity;
import com.freakybyte.poketest.di.module.StorageModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Jose Torres in FreakyByte on 20/06/16.
 */

@Singleton
@Component(modules = {StorageModule.class})
public interface StorageComponent {
    void inject(HomeActivity activity);
    void inject(DetailActivity activity);
}
