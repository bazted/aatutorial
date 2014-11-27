package com.pgs.bazted.aatutorial.usual.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by bazted on 04/11/14.
 */
public class PrefManager {

    private final Context context;

    public PrefManager(Context context) {
        this.context = context;
    }

    public void putSomeValue(String someValue) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        defaultSharedPreferences.edit().putString("STRING_VALUE_KEY", someValue).apply();
    }

    public void putSomeArrayValue(String someValue) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        defaultSharedPreferences.edit().putString("STRING_VALUE_KEY", someValue).apply();
    }
}
