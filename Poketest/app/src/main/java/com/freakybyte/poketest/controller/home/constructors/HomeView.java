package com.freakybyte.poketest.controller.home.constructors;

import com.freakybyte.poketest.model.PokeModel;

import java.util.List;

/**
 * Created by Jose Torres in FreakyByte on 01/06/16.
 */
public interface HomeView {

    void showLoader(final String sMessage, final boolean bCancelable);

    void hideLoader();

    void fillAdapter(List<PokeModel> listPokemon);

    void addNewItemsToAdapter(List<PokeModel> listPokemon);

    void refreshAdapter();

    void onErrorLoading();
}
