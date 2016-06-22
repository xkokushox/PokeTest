package com.freakybyte.poketest.di.scope;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;


import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Jose Torres in FreakyByte on 19/06/16.
 */
@Qualifier
@Retention(RUNTIME)
public @interface ForApplication {

}