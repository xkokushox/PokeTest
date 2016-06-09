package com.freakybyte.poketest.web;

import com.freakybyte.poketest.model.AllPokeModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Jose Torres in FreakyByte on 07/06/16.
 */
public interface MyApiEndpointInterface {

    @GET("pokemon/")
    Call<AllPokeModel> getAllPokemons();

    @GET("pokemon/?limit=40")
    Call<AllPokeModel> getNextPokemons(@Query("offset") int next);
}