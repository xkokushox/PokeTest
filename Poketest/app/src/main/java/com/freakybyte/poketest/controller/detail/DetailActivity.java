package com.freakybyte.poketest.controller.detail;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
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
import com.freakybyte.poketest.R;
import com.freakybyte.poketest.controller.MainActivity;
import com.freakybyte.poketest.controller.detail.constuctors.DetailPresenter;
import com.freakybyte.poketest.controller.detail.constuctors.DetailView;
import com.freakybyte.poketest.controller.detail.impl.DetailPresenterImpl;
import com.freakybyte.poketest.controller.dialog.ProgressDialog;
import com.freakybyte.poketest.db.RealmManager;
import com.freakybyte.poketest.model.PokeModel;
import com.freakybyte.poketest.model.summary.PokemonDetailModel;
import com.freakybyte.poketest.util.PokeTestUtil;

/**
 * Created by Jose Torres in FreakyByte on 14/06/16.
 */
public class DetailActivity extends MainActivity implements DetailView {

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
    private TextView mTxtPokemonHeight;
    private TextView mTxtPokemonWeight;
    private TextView mTxtPokemonAbilities;
    private TextView mTxtPokemonMoves;


    private ProgressDialog mLoaderDialog;

    private DetailPresenter mPresenter;

    private PokeModel mPokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);

        mPokemon = RealmManager.getPokemon(getIntent().getLongExtra(TAG_ID, 1));

        setSupportActionBar(getToolbar());

        getCollapsingToolbar().setTitle(mPokemon.getName());

        mPresenter = new DetailPresenterImpl(this);

        mPresenter.onGetPokemonInformation(mPokemon.getId());

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
                getTxtPokemonHeight().setText(String.format(getString(R.string.txt_detail_height), PokeTestUtil.getHeight(mPokemonDetail.getHeight())));
                getTxtPokemonWeight().setText(String.format(getString(R.string.txt_detail_weight), PokeTestUtil.getWeight(mPokemonDetail.getWeight())));
                getTxtPokemonAbilities().setText(PokeTestUtil.getAbilities(mPokemonDetail.getAbilities()));
                getTxtPokemonMoves().setText(PokeTestUtil.getMoves(mPokemonDetail.getMoves()));
                getImgPokemon().setImageURI(PokeTestUtil.getUrlStringToFullPokemon(mPokemon.getId()));
                getImgSpriteOne().setImageURI(mPokemonDetail.getSprites().getBackDefault());
                getImgSpriteTwo().setImageURI(mPokemonDetail.getSprites().getFrontDefault());
                getImgSpriteThree().setImageURI(mPokemonDetail.getSprites().getBackShiny());
                getImgSpriteFour().setImageURI(mPokemonDetail.getSprites().getFrontShiny());
            }
        });
    }

    @Override
    public void onErrorDownloading() {
        finish();
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
        if (mTxtPokemonHeight == null)
            mTxtPokemonHeight = (TextView) findViewById(R.id.txtPokemonHeight);
        return mTxtPokemonHeight;
    }

    private TextView getTxtPokemonWeight() {
        if (mTxtPokemonWeight == null)
            mTxtPokemonWeight = (TextView) findViewById(R.id.txtPokemonWeight);
        return mTxtPokemonWeight;
    }

    private TextView getTxtPokemonAbilities() {
        if (mTxtPokemonAbilities == null)
            mTxtPokemonAbilities = (TextView) findViewById(R.id.txtPokemonAbilities);
        return mTxtPokemonAbilities;
    }

    private TextView getTxtPokemonMoves() {
        if (mTxtPokemonMoves == null)
            mTxtPokemonMoves = (TextView) findViewById(R.id.txtPokemonMoves);
        return mTxtPokemonMoves;
    }
}
