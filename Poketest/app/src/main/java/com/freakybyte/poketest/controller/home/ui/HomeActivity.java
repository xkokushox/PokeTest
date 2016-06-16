package com.freakybyte.poketest.controller.home.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.freakybyte.poketest.R;
import com.freakybyte.poketest.controller.MainActivity;
import com.freakybyte.poketest.controller.detail.DetailActivity;
import com.freakybyte.poketest.controller.dialog.ProgressDialog;
import com.freakybyte.poketest.controller.home.adapter.PokeListAdapter;
import com.freakybyte.poketest.controller.home.constructors.HomePresenter;
import com.freakybyte.poketest.controller.home.constructors.HomeView;
import com.freakybyte.poketest.controller.home.impl.HomePresenterImpl;
import com.freakybyte.poketest.controller.listener.RecyclerListListener;
import com.freakybyte.poketest.model.PokeModel;
import com.freakybyte.poketest.util.DebugUtils;
import com.freakybyte.poketest.util.WidgetUtils;

import java.util.List;

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
    private LinearLayout mLayoutToolbarWrapper;
    private PokeListAdapter mAdapter;

    private HomePresenter mPresenter;

    private LinearLayoutManager mLayoutManager;

    private boolean bLoading;
    private boolean bLoadMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setSupportActionBar(getToolbar());

        bLoading = true;
        bLoadMore = true;

        mPresenter = new HomePresenterImpl(this);

        getSwipeRefreshLayout().setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.onRefreshFoodList();
            }
        });
        getListPokemons().addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0) {
                    if (!bLoading && bLoadMore && ((getLayoutManager().getChildCount() + getLayoutManager().findFirstVisibleItemPosition()) >= getLayoutManager().getItemCount())) {
                        WidgetUtils.createShortToast(R.string.txt_retrieve_more_pokemons);
                        bLoading = true;
                        mPresenter.getMoreItems(getListAdapter().getItemCount());
                    }
                }

            }
        });

        getListPokemons().setAdapter(getListAdapter());

        getLayoutToolbarWrapper().setOnClickListener(HomeActivity.this);

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
    public void fillAdapter(final List<PokeModel> listPokemon) {
        bLoadMore = listPokemon.size() > 0;
        getListAdapter().getListPokemon().clear();
        getListAdapter().getListPokemon().addAll(listPokemon);
    }

    @Override
    public void addNewItemsToAdapter(List<PokeModel> listPokemon) {
        bLoadMore = listPokemon.size() > 0;
        getListAdapter().getListPokemon().addAll(listPokemon);
    }

    @Override
    public void refreshAdapter() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                getTxtEmptyView().setVisibility(getListAdapter().getListPokemon().isEmpty() ? View.VISIBLE : View.GONE);
                getListAdapter().notifyDataSetChanged();
                DebugUtils.logDebug(TAG, "TotalPokemons:: " + getListAdapter().getItemCount());
            }
        });
    }

    @Override
    public void onErrorLoading() {
        WidgetUtils.createShortToast(R.string.error_service_retrieve);
    }

    @Override
    public void OnItemClickListener(SimpleDraweeView imgPokemon, int iPosition) {

        Intent mIntent = new Intent(HomeActivity.this, DetailActivity.class);
        mIntent.putExtra(DetailActivity.TAG_ID, getListAdapter().getListPokemon().get(iPosition).getId());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, imgPokemon, getString(R.string.activity_image_trans));
            startActivity(mIntent, options.toBundle());
        } else
            startActivity(mIntent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layoutToolbarWrapper:
                getListPokemons().smoothScrollToPosition(0);
                break;
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

    private RecyclerView getListPokemons() {
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

    private LinearLayout getLayoutToolbarWrapper() {
        if (mLayoutToolbarWrapper == null)
            mLayoutToolbarWrapper = (LinearLayout) findViewById(R.id.layoutToolbarWrapper);
        return mLayoutToolbarWrapper;
    }
}
