package com.freakybyte.poketest.util;

import android.content.res.Resources;
import android.util.TypedValue;

import com.freakybyte.poketest.PokeApplication;

/**
 * Created by Jose Torres in FreakyByte on 19/04/16.
 */
public class AndroidUtil {


    public static int dpToPx(float dp) {
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, PokeApplication.getInstance().getResources().getDisplayMetrics());
        return (int) px;
    }

    public static int dpToPx(float dp, Resources resources) {
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.getDisplayMetrics());
        return (int) px;
    }
}
