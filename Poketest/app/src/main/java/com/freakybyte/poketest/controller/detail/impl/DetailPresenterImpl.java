package com.freakybyte.poketest.controller.detail.impl;

import com.freakybyte.poketest.controller.detail.constuctors.DetailPresenter;
import com.freakybyte.poketest.controller.detail.constuctors.DetailView;
import com.freakybyte.poketest.controller.detail.listener.OnRequestDetailListener;
import com.freakybyte.poketest.db.RealmManager;
import com.freakybyte.poketest.model.summary.PokemonDetailModel;

import javax.inject.Inject;

/**
 * Created by Jose Torres in FreakyByte on 14/06/16.
 */
public class DetailPresenterImpl implements DetailPresenter, OnRequestDetailListener {

    private DetailView mView;
    private DetailInteractorImpl mInteractor;

    @Inject
    public DetailPresenterImpl(DetailView mView) {
        this.mView = mView;
        mInteractor = new DetailInteractorImpl();
    }

    @Override
    public void onGetPokemonInformation(long id) {
        if (mView == null)
            return;

        mView.setPokemonItem(RealmManager.getInstance().getPokemon(id));
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
