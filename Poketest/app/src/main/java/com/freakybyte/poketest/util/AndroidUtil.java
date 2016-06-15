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

    public static String getCapitalizeWord(String word) {
        if (word == null || word.isEmpty())
            return "";
        else
            return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    public static String capitalizeWord(String word) {
        if (word == null || word.isEmpty())
            return "";
        else {
            StringBuffer res = new StringBuffer();

            String[] strArr = word.split(" ");
            for (String str : strArr) {
                char[] stringArray = str.trim().toCharArray();
                stringArray[0] = Character.toUpperCase(stringArray[0]);
                str = new String(stringArray);

                res.append(str).append(" ");
            }
            return res.toString().trim();
        }
    }
}
