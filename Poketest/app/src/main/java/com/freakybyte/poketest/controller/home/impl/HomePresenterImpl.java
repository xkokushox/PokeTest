package com.freakybyte.poketest.controller.home.impl;


import com.freakybyte.poketest.controller.home.constructors.HomePresenter;
import com.freakybyte.poketest.controller.home.constructors.HomeView;
import com.freakybyte.poketest.controller.home.listener.OnRequestItemsListener;

/**
 * Created by Jose Torres in FreakyByte on 01/06/16.
 */
public class HomePresenterImpl implements HomePresenter, OnRequestItemsListener {

    private HomeView mHomeView;
    private HomeInteractorImpl mHomeInteractor;

    public HomePresenterImpl(HomeView homeView) {
        mHomeView = homeView;
        mHomeInteractor = new HomeInteractorImpl();
    }

    @Override
    public void getItems() {
        if (mHomeView == null)
            return;

        mHomeView.showLoader("Loading", false);
        mHomeInteractor.getItemsFromServer(this);
    }

    @Override
    public void getMoreItems(int nItems) {
        if (mHomeView == null)
            return;

        mHomeInteractor.getMoreItemsFromServer(nItems, this);
    }

    @Override
    public void onRefreshFoodList() {
        if (mHomeView == null)
            return;

        mHomeInteractor.getItemsFromServer(this);
    }


    @Override
    public void onDestroy() {
        mHomeView = null;
        mHomeInteractor = null;
    }

    @Override
    public void onRequestFailed() {
        mHomeView.onErrorLoading();
        mHomeView.hideLoader();
    }

    @Override
    public void onRequestSuccess() {
        mHomeView.fillAdapter();
        mHomeView.hideLoader();
    }

    @Override
    public void onRequestMoreData() {
        mHomeView.addNewItemsToAdapter();
        mHomeView.hideLoader();
    }

}
