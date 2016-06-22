package com.freakybyte.poketest.controller.home.di;

import com.freakybyte.poketest.controller.home.ui.HomeActivity;
import com.freakybyte.poketest.di.component.RealmComponent;
import com.freakybyte.poketest.di.module.WidgetModule;
import com.freakybyte.poketest.di.scope.ActivityScoped;

import dagger.Component;

/**
 * Created by Jose Torres in FreakyByte on 21/06/16.
 */
@ActivityScoped
@Component(dependencies = RealmComponent.class, modules = {HomeModule.class, WidgetModule.class})
public interface HomeComponent {
    void inject(HomeActivity activity);
}
