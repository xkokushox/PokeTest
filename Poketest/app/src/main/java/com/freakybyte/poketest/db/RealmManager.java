package com.freakybyte.poketest.db;

import android.content.Context;

import com.freakybyte.poketest.model.PokeModel;
import com.freakybyte.poketest.util.DebugUtils;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by Jose Torres in FreakyByte on 07/06/16.
 */
public class RealmManager {
    public static final String TAG = "RealmManager";

    private Realm mRrealm;
    private Context mContext;

    public RealmManager(Context mContext) {
        this.mContext = mContext;
    }

    public Realm getRealm() {
        if (mRrealm == null) {
            RealmConfiguration realmConfig = new RealmConfiguration.Builder(mContext).build();
            mRrealm = Realm.getInstance(realmConfig);
        }
        return mRrealm;
    }

    public ArrayList<PokeModel> getAllPokemons() {
        final RealmResults<PokeModel> rPokemons = getRealm().where(PokeModel.class).findAll();

        ArrayList<PokeModel> aPokemons = new ArrayList<>();

        for (int a = 0; a < rPokemons.size(); a++)
            aPokemons.add(rPokemons.get(a));


        return aPokemons;
    }

    public ArrayList<PokeModel> getNewPokemons(int iItems) {
        final RealmResults<PokeModel> rPokemons = getRealm().where(PokeModel.class).findAll();

        ArrayList<PokeModel> aPokemons = new ArrayList<>();

        for (int a = iItems; a < rPokemons.size(); a++)
            aPokemons.add(rPokemons.get(a));


        return aPokemons;
    }

    public void insertAllPokemons(List<PokeModel> aPokemon) {
        deleteAllPokemons();
        for (int a = 0; a < aPokemon.size(); a++) {
            insertPokemon(aPokemon.get(a));
        }
    }

    public void insertNewPokemons(List<PokeModel> aPokemon) {
        for (int a = 0; a < aPokemon.size(); a++) {
            insertPokemon(aPokemon.get(a));
        }
    }

    public void deleteAllPokemons() {
        final RealmResults<PokeModel> rPokemons = getRealm().where(PokeModel.class).findAll();
        getRealm().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                rPokemons.deleteAllFromRealm();
            }
        });

    }

    public void insertPokemon(final PokeModel mPokemon) {
        try {
            getRealm().executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    PokeModel mRealm = getRealm().createObject(PokeModel.class);
                    mRealm.setName(mPokemon.getName());
                    mRealm.setUrl(mPokemon.getUrl());
                }
            });
        } catch (Exception ex) {
            DebugUtils.logError(TAG, "insertPokemon:: " + ex.getLocalizedMessage());
        }

    }
}
