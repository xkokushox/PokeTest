package com.freakybyte.poketest.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.freakybyte.poketest.PokeApplication;

/**
 * Created by Jose Torres in FreakyByte on 13/06/16.
 */
public class SharedPreferencesUtil {

    private static final String SHARED_PROJECT = "SharedPreferences_PokeTest";

    public static final String TOTAL_POKEMONS = "total_pokemons"; //int


    /**
     * Method that saves a String in Shared Preference
     *
     * @param key   The String that is going to be the key
     * @param value The String that is going to be saved
     */
    public static void setAppPreference(String key, String value) {
        SharedPreferences manager = PokeApplication.getInstance().getSharedPreferences(SHARED_PROJECT, 0);
        Editor editor = manager.edit();
        editor.putString(key, value);
        editor.commit();
    }

    /**
     * Method that saves a Integer in Shared Preference
     *
     * @param key   The String that is going to be the key
     * @param value The Integer that is going to be saved
     */
    public static void setAppPreference(String key, int value) {
        SharedPreferences manager = PokeApplication.getInstance().getSharedPreferences(SHARED_PROJECT, 0);
        Editor editor = manager.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    /**
     * Method that saves a Boolean in Shared Preference
     *
     * @param key   The String that is going to be the key
     * @param value The String that is going to be saved
     */
    public static void setAppPreference(String key, boolean value) {
        SharedPreferences manager = PokeApplication.getInstance().getSharedPreferences(SHARED_PROJECT, 0);
        Editor editor = manager.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    /**
     * Method that saves a Long in Shared Preference
     *
     * @param key   The String that is going to be the key
     * @param value The Long that is going to be saved
     */
    public static void setAppPreference(String key, long value) {
        SharedPreferences manager = PokeApplication.getInstance().getSharedPreferences(SHARED_PROJECT, 0);
        Editor editor = manager.edit();
        editor.putLong(key, value);
        editor.commit();
    }

    /**
     * Method that saves a Float in Shared Preference
     *
     * @param key   The String that is going to be the key
     * @param value The Long that is going to be saved
     */
    public static void setAppPreference(String key, float value) {
        SharedPreferences manager = PokeApplication.getInstance().getSharedPreferences(SHARED_PROJECT, 0);
        Editor editor = manager.edit();
        editor.putFloat(key, value);
        editor.commit();
    }

    /**
     * Method that returns a String from Shared Preference
     *
     * @param key The String that is going to be the key
     * @return String The string that was saved with the key
     */
    public static String getStringPreference(String key) {
        SharedPreferences manager = PokeApplication.getInstance().getSharedPreferences(SHARED_PROJECT, 0);
        return manager.getString(key, "");
    }

    /**
     * Method that returns a Integer from Shared Preference
     *
     * @param key The String that is going to be the key
     * @return The Integer that was saved with the key
     */
    public static int getIntPreference(String key) {
        SharedPreferences manager = PokeApplication.getInstance().getSharedPreferences(SHARED_PROJECT, 0);
        return manager.getInt(key, 0);
    }

    /**
     * Method that returns a Long from Shared Preference
     *
     * @param key The String that is going to be the key
     * @return The Long that was saved with the key
     */
    public static long getLongPreference(String key) {
        SharedPreferences manager = PokeApplication.getInstance().getSharedPreferences(SHARED_PROJECT, 0);
        return manager.getLong(key, 0);
    }

    /**
     * Method that returns a Long from Shared Preference
     *
     * @param key The String that is going to be the key
     * @return The Float that was saved with the key
     */
    public static float getFloatPreference(String key) {
        SharedPreferences manager = PokeApplication.getInstance().getSharedPreferences(SHARED_PROJECT, 0);
        return manager.getFloat(key, 0);
    }

    /**
     * Method that returns a Boolean from Shared Preference
     *
     * @param key The String that is going to be the key
     * @return The Boolean that was saved with the key
     */
    public static boolean getBooleanPreference(String key) {
        SharedPreferences manager = PokeApplication.getInstance().getSharedPreferences(SHARED_PROJECT, 0);
        return manager.getBoolean(key, false);
    }


    public static void clearAllPreferences() {
        SharedPreferences manager = PokeApplication.getInstance().getSharedPreferences(SHARED_PROJECT, 0);
        Editor editor = manager.edit();
        editor.clear();
        editor.commit();
    }

    public static SharedPreferences getPreferences(Context context, String app) {
        return context.getSharedPreferences(app, Context.MODE_PRIVATE);
    }
}