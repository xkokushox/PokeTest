package com.freakybyte.poketest.controller.home.constructors;


import com.freakybyte.poketest.controller.home.listener.OnRequestItemsListener;

/**
 * Created by Jose Torres in FreakyByte on 01/06/16.
 */
public interface HomeInteractor {

    void getItemsFromServer(OnRequestItemsListener mListener);

    void getMoreItemsFromServer(int nItems, OnRequestItemsListener mListener);
}
