package com.freakybyte.poketest.controller.detail.impl;

import com.freakybyte.poketest.controller.detail.constuctors.DetailInteractor;
import com.freakybyte.poketest.controller.detail.listener.OnRequestDetailListener;
import com.freakybyte.poketest.model.summary.PokemonDetailModel;
import com.freakybyte.poketest.util.DebugUtils;
import com.freakybyte.poketest.web.MyApiEndpointInterface;
import com.freakybyte.poketest.web.RetrofitBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jose Torres in FreakyByte on 14/06/16.
 */
public class DetailInteractorImpl implements DetailInteractor {

    public static final String TAG = "HomeInteractorImpl";

    @Override
    public void getPokemonDetailFromServer(final OnRequestDetailListener mListener, long id) {
        DebugUtils.logDebug(TAG, "GetPokemonDetailFromServer: Start");

        MyApiEndpointInterface apiService = RetrofitBuilder.getRetrofitBuilder().create(MyApiEndpointInterface.class);

        Call<PokemonDetailModel> call = apiService.getDetailPokemon("pokemon/" + id + "/");
        call.enqueue(new Callback<PokemonDetailModel>() {
            @Override
            public void onResponse(Call<PokemonDetailModel> call, Response<PokemonDetailModel> response) {

                switch (response.code()) {
                    case 200:
                        mListener.onRequestSuccess(response.body());
                        break;
                    default:
                        DebugUtils.logError("GetPokemonDetailFromServer:: Error Code:: " + response.code());
                        mListener.onRequestFailed();
                        break;
                }
            }

            @Override
            public void onFailure(Call<PokemonDetailModel> call, Throwable t) {
                DebugUtils.logError("GetPokemonDetailFromServer:: onFailure:: " + t.getLocalizedMessage());
                mListener.onRequestFailed();
            }

        });
    }
}
