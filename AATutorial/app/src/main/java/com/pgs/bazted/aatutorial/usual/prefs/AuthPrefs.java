package com.pgs.bazted.aatutorial.usual.prefs;

import org.androidannotations.annotations.sharedpreferences.SharedPref;

/**
 * Created by bazted on 05/11/14.
 */
@SharedPref(SharedPref.Scope.UNIQUE)
public interface AuthPrefs {

    String token();

    int user_id();

    long timestamp();
}
