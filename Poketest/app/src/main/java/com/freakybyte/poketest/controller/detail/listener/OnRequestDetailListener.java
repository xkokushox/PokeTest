package com.freakybyte.poketest.controller.detail.listener;

import com.freakybyte.poketest.model.summary.PokemonDetailModel;

/**
 * Created by Jose Torres in FreakyByte on 14/06/16.
 */
public interface OnRequestDetailListener {

    void onRequestFailed();

    void onRequestSuccess(PokemonDetailModel mPokemon);
}
