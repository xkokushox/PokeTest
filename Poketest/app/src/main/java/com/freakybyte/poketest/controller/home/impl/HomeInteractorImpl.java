package com.freakybyte.poketest.controller.home.impl;


import com.freakybyte.poketest.controller.home.constructors.HomeInteractor;
import com.freakybyte.poketest.controller.home.listener.OnRequestItemsListener;
import com.freakybyte.poketest.di.manager.RealmManager;
import com.freakybyte.poketest.model.AllPokeModel;
import com.freakybyte.poketest.util.DebugUtils;
import com.freakybyte.poketest.web.MyApiEndpointInterface;
import com.freakybyte.poketest.web.RetrofitBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jose Torres in FreakyByte on 01/06/16.
 */
public class HomeInteractorImpl implements HomeInteractor {

    public static final String TAG = "HomeInteractorImpl";

    private RealmManager mRealManager;

    public HomeInteractorImpl(RealmManager mRealManager) {
        this.mRealManager = mRealManager;
    }

    @Override
    public void getItemsFromServer(final OnRequestItemsListener mListener) {
        DebugUtils.getSingleton().logDebug(TAG, "GetItemsFromServer: Start");

        MyApiEndpointInterface apiService = RetrofitBuilder.getRetrofitBuilder().create(MyApiEndpointInterface.class);

        Call<AllPokeModel> call = apiService.getAllPokemons();
        call.enqueue(new Callback<AllPokeModel>() {
            @Override
            public void onResponse(Call<AllPokeModel> call, Response<AllPokeModel> response) {

                switch (response.code()) {
                    case 200:
                        AllPokeModel aPokemons = response.body();

                        DebugUtils.getSingleton().logDebug(TAG, "GetItemsFromServer: Num Pokemons:: " + aPokemons.getResults().size());
                        DebugUtils.getSingleton().logDebug(TAG, "GetItemsFromServer: Total Pokemons:: " + aPokemons.getCount());

                        mRealManager.insertAllPokemons(aPokemons.getResults());

                        mListener.onRequestSuccess(aPokemons.getResults());
                        break;
                    default:
                        DebugUtils.getSingleton().logError("GetItemsFromServer:: Error Code:: " + response.code());
                        mListener.onRequestBackup(mRealManager.getAllPokemons());
                        mListener.onRequestFailed();
                        break;
                }
            }

            @Override
            public void onFailure(Call<AllPokeModel> call, Throwable t) {
                DebugUtils.getSingleton().logError("GetItemsFromServer:: onFailure:: " + t.getLocalizedMessage());
                mListener.onRequestBackup(mRealManager.getAllPokemons());
                mListener.onRequestFailed();
            }

        });
    }

    @Override
    public void getMoreItemsFromServer(final int nItems, final OnRequestItemsListener mListener) {
        DebugUtils.getSingleton().logDebug(TAG, "getMoreItemsFromServer: Start");

        MyApiEndpointInterface apiService = RetrofitBuilder.getRetrofitBuilder().create(MyApiEndpointInterface.class);

        Call<AllPokeModel> call = apiService.getNextPokemons(nItems + 40);
        call.enqueue(new Callback<AllPokeModel>() {
            @Override
            public void onResponse(Call<AllPokeModel> call, Response<AllPokeModel> response) {

                switch (response.code()) {
                    case 200:
                        AllPokeModel aPokemons = response.body();

                        DebugUtils.getSingleton().logDebug(TAG, "getMoreItemsFromServer: Num Pokemons:: " + aPokemons.getResults().size());

                        mRealManager.insertNewPokemons(aPokemons.getResults());

                        mListener.onRequestMoreData(aPokemons.getResults());
                        break;
                    default:
                        DebugUtils.getSingleton().logError("GetItemsFromServer:: Error Code:: " + response.code());
                        mListener.onRequestFailed();
                        break;
                }
            }

            @Override
            public void onFailure(Call<AllPokeModel> call, Throwable t) {
                DebugUtils.getSingleton().logError("GetItemsFromServer:: onFailure:: " + t.getLocalizedMessage());
                mListener.onRequestFailed();
            }

        });
    }
}
