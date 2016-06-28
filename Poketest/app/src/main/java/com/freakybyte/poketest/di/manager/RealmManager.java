package com.freakybyte.poketest.di.manager;

import android.content.Context;

import com.freakybyte.poketest.model.PokeModel;
import com.freakybyte.poketest.util.DebugUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.realm.DynamicRealm;
import io.realm.FieldAttribute;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import io.realm.RealmResults;
import io.realm.RealmSchema;
import io.realm.Sort;

/**
 * Created by Jose Torres in FreakyByte on 07/06/16.
 */
public class RealmManager {
    public static final String TAG = "RealmManager";

    private Realm mRealm;
    private RealmMigration mRealMigration;
    private RealmConfiguration mRealmConfiguration;

    private Context mContext;

    @Inject
    public RealmManager(Context context) {
        this.mContext = context;
    }

    private Realm getRealm() {
        if (mRealm == null)
            mRealm = Realm.getInstance(getRealmConfiguration());
        return mRealm;
    }

    private RealmConfiguration getRealmConfiguration() {
        if (mRealmConfiguration == null) {
            mRealmConfiguration = new RealmConfiguration.Builder(mContext)
                    .deleteRealmIfMigrationNeeded().schemaVersion(1).migration(getRealMigration()).build();

        }
        return mRealmConfiguration;
    }

    private RealmMigration getRealMigration() {
        if (mRealMigration == null) {
            mRealMigration = new RealmMigration() {
                @Override
                public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {

                    RealmSchema schema = realm.getSchema();
                    if (oldVersion == 0) {
                        schema.get("PokeModel").addField("id", long.class, FieldAttribute.PRIMARY_KEY);
                        oldVersion++;
                    }

                }
            };
        }
        return mRealMigration;
    }

    public ArrayList<PokeModel> getAllPokemons() {
        RealmResults<PokeModel> rPokemons = getRealm().where(PokeModel.class).findAll();
        rPokemons = rPokemons.sort("id", Sort.ASCENDING);
        ArrayList<PokeModel> aPokemons = new ArrayList<>();

        for (int a = 0; a < rPokemons.size(); a++)
            aPokemons.add(rPokemons.get(a));


        return aPokemons;
    }

    public PokeModel getPokemon(long idPokemon) {
        RealmResults<PokeModel> aPokemons = getRealm().where(PokeModel.class).equalTo("id", idPokemon).findAll();
        return aPokemons.get(0);
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
            getRealm().executeTransactionAsync(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    String[] aString = mPokemon.getUrl().split("/");
                    mPokemon.setId(Long.parseLong(aString[aString.length - 1]));
                    realm.copyToRealmOrUpdate(mPokemon);
                }
            });
        } catch (Exception ex) {
            DebugUtils.getSingleton().logError(TAG, "insertPokemon:: " + ex.getLocalizedMessage());
        }
    }
}
