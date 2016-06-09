package com.freakybyte.poketest.controller.home.ui;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.freakybyte.poketest.R;
import com.freakybyte.poketest.controller.MainActivity;
import com.freakybyte.poketest.controller.adapter.PokeListAdapter;
import com.freakybyte.poketest.controller.dialog.ProgressDialog;
import com.freakybyte.poketest.controller.home.constructors.HomePresenter;
import com.freakybyte.poketest.controller.home.constructors.HomeView;
import com.freakybyte.poketest.controller.home.impl.HomePresenterImpl;
import com.freakybyte.poketest.controller.listener.RecyclerListListener;
import com.freakybyte.poketest.db.RealmManager;
import com.freakybyte.poketest.util.DebugUtils;

/**
 * Created by Jose Torres in FreakyByte on 19/04/16.
 */
public class HomeActivity extends MainActivity implements HomeView, RecyclerListListener, View.OnClickListener {
    public static final String TAG = "HomeActivity";

    private RecyclerView mRecyclerView;
    private TextView txtEmptyView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ProgressDialog mLoaderDialog;
    private Toolbar mToolbar;
    private PokeListAdapter mAdapter;

    private HomePresenter mPresenter;

    private RealmManager mRealmManager;
    private LinearLayoutManager mLayoutManager;

    private boolean bLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setSupportActionBar(getToolbar());

        bLoading = true;

        mPresenter = new HomePresenterImpl(this);
        mRealmManager = new RealmManager(this);

        getSwipeRefreshLayout().setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.onRefreshFoodList();
            }
        });
        getListFood().addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0) {
                    if (!bLoading && ((getLayoutManager().getChildCount() + getLayoutManager().findFirstVisibleItemPosition()) >= getLayoutManager().getItemCount())) {
                        DebugUtils.logDebug(TAG, "onScrolled:: End of list");
                        bLoading = true;
                        mPresenter.getMoreItems(getListAdapter().getItemCount());
                    }
                }

            }
        });

        getListFood().setAdapter(getListAdapter());

        mPresenter.getItems();
    }

    @Override
    public void showLoader(final String sMessage, final boolean bCancelable) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mLoaderDialog == null || !mLoaderDialog.isShowing()) {
                    mLoaderDialog = new ProgressDialog(HomeActivity.this, sMessage);
                    mLoaderDialog.setCancelable(bCancelable);
                    mLoaderDialog.show();
                }
            }
        });
    }

    @Override
    public void hideLoader() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                bLoading = false;
                getSwipeRefreshLayout().setRefreshing(false);
                if (mLoaderDialog != null)
                    mLoaderDialog.dismiss();
            }
        });
    }

    @Override
    public void fillAdapter() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                getListAdapter().getListPokemon().clear();
                getListAdapter().getListPokemon().addAll(mRealmManager.getAllPokemons());
                refreshAdapter();
            }
        });
    }

    @Override
    public void addNewItemsToAdapter() {
        getListAdapter().getListPokemon().addAll(mRealmManager.getNewPokemons(getListAdapter().getItemCount()));
        refreshAdapter();
    }

    @Override
    public void refreshAdapter() {
        getTxtEmptyView().setVisibility(getListAdapter().getListPokemon().isEmpty() ? View.VISIBLE : View.GONE);
        getListFood().setVisibility(getListAdapter().getListPokemon().isEmpty() ? View.GONE : View.VISIBLE);
        getListAdapter().notifyDataSetChanged();
    }

    @Override
    public void onErrorLoading() {
        if (getListAdapter().getListPokemon().isEmpty())
            fillAdapter();
    }

    @Override
    public void OnItemClickListener(int iPosition) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            default:
                DebugUtils.logError(TAG, "OnClick:: view not handled " + v.getId());
                break;
        }
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDestroy();
        super.onDestroy();
    }

    private Toolbar getToolbar() {
        if (mToolbar == null)
            mToolbar = (Toolbar) findViewById(R.id.toolbar);
        return mToolbar;
    }

    private TextView getTxtEmptyView() {
        if (txtEmptyView == null)
            txtEmptyView = (TextView) findViewById(R.id.txt_empty_list);
        return txtEmptyView;
    }

    private SwipeRefreshLayout getSwipeRefreshLayout() {
        if (swipeRefreshLayout == null)
            swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        return swipeRefreshLayout;
    }

    private LinearLayoutManager getLayoutManager() {
        if (mLayoutManager == null)
            mLayoutManager = new LinearLayoutManager(HomeActivity.this);
        return mLayoutManager;
    }

    private RecyclerView getListFood() {
        if (mRecyclerView == null) {
            mRecyclerView = (RecyclerView) findViewById(R.id.list_food);
            mRecyclerView.setLayoutManager(getLayoutManager());
        }
        return mRecyclerView;
    }

    private PokeListAdapter getListAdapter() {
        if (mAdapter == null)
            mAdapter = new PokeListAdapter(HomeActivity.this, HomeActivity.this);
        return mAdapter;
    }
}
