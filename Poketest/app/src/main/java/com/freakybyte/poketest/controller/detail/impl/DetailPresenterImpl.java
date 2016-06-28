package com.freakybyte.poketest.controller.detail.impl;

import com.freakybyte.poketest.controller.detail.constuctors.DetailPresenter;
import com.freakybyte.poketest.controller.detail.constuctors.DetailView;
import com.freakybyte.poketest.controller.detail.listener.OnRequestDetailListener;
import com.freakybyte.poketest.di.manager.RealmManager;
import com.freakybyte.poketest.model.summary.PokemonDetailModel;

import javax.inject.Inject;

/**
 * Created by Jose Torres in FreakyByte on 14/06/16.
 */
public class DetailPresenterImpl implements DetailPresenter, OnRequestDetailListener {

    private DetailView mView;
    private DetailInteractorImpl mInteractor;

    private RealmManager mRealManager;

    @Inject
    public DetailPresenterImpl(RealmManager mRealManager, DetailView mView) {
        this.mView = mView;
        mInteractor = new DetailInteractorImpl();
        this.mRealManager = mRealManager;
    }

    @Override
    public void onGetPokemonInformation(long id) {
        if (mView == null)
            return;

        mView.setPokemonItem(mRealManager.getPokemon(id));
        mView.showLoader("Loading", false);
        mInteractor.getPokemonDetailFromServer(this, id);
    }

    @Override
    public void onDestroy() {
        mView = null;
        mInteractor = null;
    }

    @Override
    public void onRequestFailed() {
        if (mView == null)
            return;

        mView.onErrorDownloading();
        mView.hideLoader();
    }

    @Override
    public void onRequestSuccess(PokemonDetailModel mPokemon) {
        if (mView == null)
            return;

        mView.updateInformation(mPokemon);
        mView.hideLoader();
    }

}
