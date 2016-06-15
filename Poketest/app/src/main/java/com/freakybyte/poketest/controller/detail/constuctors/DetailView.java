package com.freakybyte.poketest.controller.detail.constuctors;

import com.freakybyte.poketest.model.summary.PokemonDetailModel;

/**
 * Created by Jose Torres in FreakyByte on 14/06/16.
 */
public interface DetailView {
    void showLoader(final String sMessage, final boolean bCancelable);

    void hideLoader();

    void updateInformation(PokemonDetailModel mPokemon);

    void onErrorDownloading();
}
