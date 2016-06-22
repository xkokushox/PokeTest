package com.freakybyte.poketest.controller.detail.di;

import com.freakybyte.poketest.controller.detail.DetailActivity;
import com.freakybyte.poketest.di.component.RealmComponent;
import com.freakybyte.poketest.di.module.WidgetModule;
import com.freakybyte.poketest.di.scope.ActivityScoped;

import dagger.Component;

/**
 * Created by Jose Torres in FreakyByte on 20/06/16.
 */
@ActivityScoped
@Component(dependencies = RealmComponent.class, modules = {WidgetModule.class, DetailModule.class})
public interface DetailComponent {
    void inject(DetailActivity activity);
}
