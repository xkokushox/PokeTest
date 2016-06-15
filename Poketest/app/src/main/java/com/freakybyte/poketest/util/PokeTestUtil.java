package com.freakybyte.poketest.util;

import com.freakybyte.poketest.PokeApplication;
import com.freakybyte.poketest.R;
import com.freakybyte.poketest.model.summary.AbilityModel;
import com.freakybyte.poketest.model.summary.MoveModel;

import java.util.List;

/**
 * Created by Jose Torres in FreakyByte on 14/06/16.
 */
public class PokeTestUtil {

    public static String getUrlStringToFullPokemon(long id) {
        if (id < 10) {
            return String.format(PokeApplication.getInstance().getString(R.string.url_pokemon_full), "00" + id);
        } else if (id < 100) {
            return String.format(PokeApplication.getInstance().getString(R.string.url_pokemon_full), "0" + id);
        } else
            return String.format(PokeApplication.getInstance().getString(R.string.url_pokemon_full), id);
    }

    public static float getHeight(int height) {
        float fHeight = (height / 10);
        return fHeight;
    }

    public static float getWeight(int weight) {
        float fHeight = (weight / 10);
        return fHeight;
    }

    public static String getAbilities(List<AbilityModel> aAbilities) {
        String sAbilities = "";
        for (int a = 0; a < aAbilities.size(); a++) {
            if (a == 0)
                sAbilities = sAbilities + aAbilities.get(a).getAbility().getName();
            else
                sAbilities = sAbilities + ", " + aAbilities.get(a).getAbility().getName();
        }
        return sAbilities;
    }

    public static String getMoves(List<MoveModel> aMoves) {
        String sAbilities = "";
        for (int a = 0; a < aMoves.size(); a++) {
            if (a == 0)
                sAbilities = sAbilities + aMoves.get(a).getMove().getName();
            else
                sAbilities = sAbilities + ", " + aMoves.get(a).getMove().getName();
        }
        return sAbilities;
    }
}
