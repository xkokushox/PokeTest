package com.freakybyte.poketest.controller.home.constructors;

/**
 * Created by Jose Torres in FreakyByte on 01/06/16.
 */
public interface HomePresenter {
    void getItems();

    void getMoreItems(int nItems);

    void onRefreshFoodList();

    void onDestroy();
}
