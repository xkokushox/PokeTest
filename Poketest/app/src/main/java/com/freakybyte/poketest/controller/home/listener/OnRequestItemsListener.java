package com.freakybyte.poketest.controller.home.listener;

import com.freakybyte.poketest.model.PokeModel;

import java.util.List;

/**
 * Created by Jose Torres in FreakyByte on 01/06/16.
 */
public interface OnRequestItemsListener {

    void onRequestFailed();

    void onRequestSuccess(List<PokeModel> listPokemon);

    void onRequestMoreData(List<PokeModel> listPokemon);

    void onRequestBackup(List<PokeModel> listPokemon);

}
