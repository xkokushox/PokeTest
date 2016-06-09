package com.freakybyte.poketest.controller.home.constructors;

/**
 * Created by Jose Torres in FreakyByte on 01/06/16.
 */
public interface HomeView {

    void showLoader(final String sMessage, final boolean bCancelable);

    void hideLoader();

    void fillAdapter();

    void addNewItemsToAdapter();

    void refreshAdapter();

    void onErrorLoading();
}
