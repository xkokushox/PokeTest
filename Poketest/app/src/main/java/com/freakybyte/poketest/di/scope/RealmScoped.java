package com.freakybyte.poketest.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Jose Torres in FreakyByte on 21/06/16.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface RealmScoped {
}
