package com.freakybyte.poketest.controller.detail;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.freakybyte.poketest.PokeApplication;
import com.freakybyte.poketest.R;
import com.freakybyte.poketest.controller.MainActivity;
import com.freakybyte.poketest.controller.detail.constuctors.DetailView;
import com.freakybyte.poketest.controller.detail.di.DaggerDetailComponent;
import com.freakybyte.poketest.controller.detail.di.DetailModule;
import com.freakybyte.poketest.controller.detail.impl.DetailPresenterImpl;
import com.freakybyte.poketest.controller.dialog.ProgressDialog;
import com.freakybyte.poketest.di.module.WidgetModule;
import com.freakybyte.poketest.model.PokeModel;
import com.freakybyte.poketest.model.summary.PokemonDetailModel;
import com.freakybyte.poketest.ui.textview.AutoFitTxtView;
import com.freakybyte.poketest.util.AndroidUtil;
import com.freakybyte.poketest.util.PokeTestUtil;
import com.freakybyte.poketest.di.manager.WidgetManager;

import javax.inject.Inject;

/**
 * Created by Jose Torres in FreakyByte on 14/06/16.
 */
public class DetailActivity extends MainActivity implements DetailView {

    @Inject
    public WidgetManager mWidgetManager;

    @Inject
    public DetailPresenterImpl mPresenter;

    public static final String TAG = "DetailActivity";
    public static final String TAG_ID = "PokemonID";

    private Toolbar mToolbar;
    private CollapsingToolbarLayout mCollapsingToolbar;
    private SimpleDraweeView mImageAnimation;
    private SimpleDraweeView mImgPokemon;
    private SimpleDraweeView imgSpriteOne;
    private SimpleDraweeView imgSpriteTwo;
    private SimpleDraweeView imgSpriteThree;
    private SimpleDraweeView imgSpriteFour;
    private TextView txtPokemonHeight;
    private TextView txtPokemonWeight;
    private TextView txtPokemonAbilities;
    private TextView txtPokemonMoves;
    private AutoFitTxtView txtTypeOne;
    private AutoFitTxtView txtTypeTwo;

    private ProgressDialog mLoaderDialog;

    private PokeModel mPokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);

        DaggerDetailComponent.builder()
                .realmComponent(((PokeApplication) getApplication()).getRealmComponent())
                .widgetModule(new WidgetModule(this)).detailModule(new DetailModule(this)).build().inject(this);

        setSupportActionBar(getToolbar());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getToolbar().setNavigationIcon(getResources().getDrawable(R.drawable.vector_icon_back_navigation));
        getToolbar().setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mPresenter.onGetPokemonInformation(getIntent().getLongExtra(TAG_ID, 1));

        showAnimation();
    }


    @Override
    public void setPokemonItem(PokeModel pokemon) {
        mPokemon = pokemon;

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                getImgPokemon().setImageURI(PokeTestUtil.getUrlStringToFullPokemon(mPokemon.getId()));
                getCollapsingToolbar().setTitle(AndroidUtil.getCapitalizeWord(mPokemon.getName()));
            }
        });
    }

    @Override
    public void showAnimation() {
        ControllerListener controllerListener = new BaseControllerListener<ImageInfo>() {
            @Override
            public void onFinalImageSet(
                    String id, @Nullable ImageInfo imageInfo, @Nullable Animatable anim) {
                if (anim != null) {
                    anim.start();
                }
            }
        };

        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(Uri.parse(String.format(getString(R.string.url_pokemon_gif), mPokemon.getName())))
                .setTapToRetryEnabled(true)
                .setControllerListener(controllerListener)
                .setAutoPlayAnimations(true)
                .build();
        getImageAnimation().setController(controller);

        GenericDraweeHierarchyBuilder builder = new GenericDraweeHierarchyBuilder(getResources());
        GenericDraweeHierarchy hierarchy = builder
                .setProgressBarImage(new ProgressBarDrawable())
                .build();
        getImageAnimation().setHierarchy(hierarchy);
    }

    @Override
    public void showLoader(final String sMessage, final boolean bCancelable) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mLoaderDialog == null || !mLoaderDialog.isShowing()) {
                    mLoaderDialog = new ProgressDialog(DetailActivity.this, sMessage);
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
                if (mLoaderDialog != null)
                    mLoaderDialog.dismiss();
            }
        });
    }

    @Override
    public void updateInformation(final PokemonDetailModel mPokemonDetail) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                if (mPokemonDetail.getTypes().size() > 1) {
                    getTxtTypeOne().setVisibility(View.VISIBLE);
                    PokeTestUtil.setType(mPokemonDetail.getTypes().get(0).getType().getName(), getTxtTypeOne());
                    getTxtTypeTwo().setVisibility(View.VISIBLE);
                    PokeTestUtil.setType(mPokemonDetail.getTypes().get(1).getType().getName(), getTxtTypeTwo());
                } else {
                    getTxtTypeOne().setVisibility(View.VISIBLE);
                    PokeTestUtil.setType(mPokemonDetail.getTypes().get(0).getType().getName(), getTxtTypeOne());
                    getTxtTypeTwo().setVisibility(View.GONE);
                }

                getTxtPokemonHeight().setText(String.format(getString(R.string.txt_detail_height), PokeTestUtil.getHeight(mPokemonDetail.getHeight())));
                getTxtPokemonWeight().setText(String.format(getString(R.string.txt_detail_weight), PokeTestUtil.getWeight(mPokemonDetail.getWeight())));
                getTxtPokemonAbilities().setText(PokeTestUtil.getAbilities(mPokemonDetail.getAbilities()));
                getTxtPokemonMoves().setText(PokeTestUtil.getMoves(mPokemonDetail.getMoves()));
                getImgSpriteOne().setImageURI(mPokemonDetail.getSprites().getBackDefault());
                getImgSpriteTwo().setImageURI(mPokemonDetail.getSprites().getFrontDefault());
                getImgSpriteThree().setImageURI(mPokemonDetail.getSprites().getBackShiny());
                getImgSpriteFour().setImageURI(mPokemonDetail.getSprites().getFrontShiny());
            }
        });
    }

    @Override
    public void onErrorDownloading() {
        mWidgetManager.createShortToast(R.string.error_service_retrieve_detail);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh:
                mPresenter.onGetPokemonInformation(getIntent().getLongExtra(TAG_ID, 1));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
        mPresenter = null;
    }

    private Toolbar getToolbar() {
        if (mToolbar == null)
            mToolbar = (Toolbar) findViewById(R.id.toolbar);
        return mToolbar;
    }

    private SimpleDraweeView getImageAnimation() {
        if (mImageAnimation == null)
            mImageAnimation = (SimpleDraweeView) findViewById(R.id.imgAnimation);
        return mImageAnimation;
    }

    private SimpleDraweeView getImgPokemon() {
        if (mImgPokemon == null)
            mImgPokemon = (SimpleDraweeView) findViewById(R.id.imgPokemon);
        return mImgPokemon;
    }

    private SimpleDraweeView getImgSpriteOne() {
        if (imgSpriteOne == null)
            imgSpriteOne = (SimpleDraweeView) findViewById(R.id.imgSpriteOne);
        return imgSpriteOne;
    }

    private SimpleDraweeView getImgSpriteTwo() {
        if (imgSpriteTwo == null)
            imgSpriteTwo = (SimpleDraweeView) findViewById(R.id.imgSpriteTwo);
        return imgSpriteTwo;
    }

    private SimpleDraweeView getImgSpriteThree() {
        if (imgSpriteThree == null)
            imgSpriteThree = (SimpleDraweeView) findViewById(R.id.imgSpriteThree);
        return imgSpriteThree;
    }

    private SimpleDraweeView getImgSpriteFour() {
        if (imgSpriteFour == null)
            imgSpriteFour = (SimpleDraweeView) findViewById(R.id.imgSpriteFour);
        return imgSpriteFour;
    }

    private CollapsingToolbarLayout getCollapsingToolbar() {
        if (mCollapsingToolbar == null)
            mCollapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        return mCollapsingToolbar;
    }

    private TextView getTxtPokemonHeight() {
        if (txtPokemonHeight == null)
            txtPokemonHeight = (TextView) findViewById(R.id.txtPokemonHeight);
        return txtPokemonHeight;
    }

    private TextView getTxtPokemonWeight() {
        if (txtPokemonWeight == null)
            txtPokemonWeight = (TextView) findViewById(R.id.txtPokemonWeight);
        return txtPokemonWeight;
    }

    private TextView getTxtPokemonAbilities() {
        if (txtPokemonAbilities == null)
            txtPokemonAbilities = (TextView) findViewById(R.id.txtPokemonAbilities);
        return txtPokemonAbilities;
    }

    private TextView getTxtPokemonMoves() {
        if (txtPokemonMoves == null)
            txtPokemonMoves = (TextView) findViewById(R.id.txtPokemonMoves);
        return txtPokemonMoves;
    }

    private AutoFitTxtView getTxtTypeOne() {
        if (txtTypeOne == null)
            txtTypeOne = (AutoFitTxtView) findViewById(R.id.txtTypeOne);
        return txtTypeOne;
    }

    private AutoFitTxtView getTxtTypeTwo() {
        if (txtTypeTwo == null)
            txtTypeTwo = (AutoFitTxtView) findViewById(R.id.txtTypeTwo);
        return txtTypeTwo;
    }
}
