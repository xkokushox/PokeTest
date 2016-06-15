package com.freakybyte.poketest.util;

import com.freakybyte.poketest.PokeApplication;
import com.freakybyte.poketest.R;
import com.freakybyte.poketest.model.summary.AbilityModel;
import com.freakybyte.poketest.model.summary.MoveModel;
import com.freakybyte.poketest.ui.textview.AutoFitTxtView;

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

    public static void setType(String type, AutoFitTxtView textView) {
        switch (type) {
            case "normal":
                textView.setBackground(PokeApplication.getInstance().getResources().getDrawable(R.drawable.background_type_normal));
                break;
            case "fighting":
                textView.setBackground(PokeApplication.getInstance().getResources().getDrawable(R.drawable.background_type_fighting));
                break;
            case "flying":
                textView.setBackground(PokeApplication.getInstance().getResources().getDrawable(R.drawable.background_type_fly));
                break;
            case "fire":
                textView.setBackground(PokeApplication.getInstance().getResources().getDrawable(R.drawable.background_type_fire));
                break;
            case "grass":
                textView.setBackground(PokeApplication.getInstance().getResources().getDrawable(R.drawable.background_type_grass));
                break;
            case "poison":
                textView.setBackground(PokeApplication.getInstance().getResources().getDrawable(R.drawable.background_type_poison));
                break;
            case "water":
                textView.setBackground(PokeApplication.getInstance().getResources().getDrawable(R.drawable.background_type_water));
                break;
            case "electric":
                textView.setBackground(PokeApplication.getInstance().getResources().getDrawable(R.drawable.background_type_electric));
                break;
            case "ice":
                textView.setBackground(PokeApplication.getInstance().getResources().getDrawable(R.drawable.background_type_ice));
                break;
            case "ground":
                textView.setBackground(PokeApplication.getInstance().getResources().getDrawable(R.drawable.background_type_ground));
                break;
            case "psychic":
                textView.setBackground(PokeApplication.getInstance().getResources().getDrawable(R.drawable.background_type_psychic));
                break;
            case "bug":
                textView.setBackground(PokeApplication.getInstance().getResources().getDrawable(R.drawable.background_type_bug));
                break;
            case "rock":
                textView.setBackground(PokeApplication.getInstance().getResources().getDrawable(R.drawable.background_type_rock));
                break;
            case "ghost":
                textView.setBackground(PokeApplication.getInstance().getResources().getDrawable(R.drawable.background_type_ghost));
                break;
            case "dragon":
                textView.setBackground(PokeApplication.getInstance().getResources().getDrawable(R.drawable.background_type_dragon));
                break;
            case "dark":
                textView.setBackground(PokeApplication.getInstance().getResources().getDrawable(R.drawable.background_type_dark));
                break;
            case "steel":
                textView.setBackground(PokeApplication.getInstance().getResources().getDrawable(R.drawable.background_type_steel));
                break;
            case "fairy":
                textView.setBackground(PokeApplication.getInstance().getResources().getDrawable(R.drawable.background_type_fairy));
                break;
            default:

                break;
        }

        textView.setText(type.toUpperCase());
    }
}
