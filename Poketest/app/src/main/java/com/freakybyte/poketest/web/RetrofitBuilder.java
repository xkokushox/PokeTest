package com.freakybyte.poketest.web;

import com.freakybyte.poketest.PokeApplication;
import com.freakybyte.poketest.R;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jose Torres in FreakyByte on 07/06/16.
 */
public class RetrofitBuilder {

    private static Retrofit retrofit;

    public static Retrofit getRetrofitBuilder() {
        if (retrofit == null)
            retrofit = new Retrofit.Builder()
                    .baseUrl(PokeApplication.getInstance().getString(R.string.url_base))
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        return retrofit;
    }
}
