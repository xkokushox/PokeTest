package com.freakybyte.poketest.controller.home.listener;

/**
 * Created by Jose Torres in FreakyByte on 01/06/16.
 */
public interface OnRequestItemsListener {

    void onRequestFailed();

    void onRequestSuccess();

    void onRequestMoreData();

}
