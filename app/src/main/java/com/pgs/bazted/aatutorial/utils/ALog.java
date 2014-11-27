package com.pgs.bazted.aatutorial.utils;

import android.util.Log;

import com.pgs.bazted.aatutorial.BuildConfig;

public class ALog {

    public static void E(Object from, String log) {
        if (BuildConfig.DEBUG) {
            String simpleName = from.getClass().getSimpleName();
            Log.e(simpleName, log);
        }
    }

    public static void D(Object from, String log) {
        if (BuildConfig.DEBUG) {
            String simpleName = from.getClass().getSimpleName();
            Log.d(simpleName, log);
        }
    }

    public static void dResponse(Object from, String requestName, String log) {
        if (BuildConfig.DEBUG) {
            String simpleName = from.getClass().getSimpleName();
            Log.d(simpleName, "[" + requestName + "] " + log);
        }
    }

    public static void eResponse(Object from, String requestName, String log) {
        if (BuildConfig.DEBUG) {
            String simpleName = from.getClass().getSimpleName();
            Log.e(simpleName, "[" + requestName + "] " + log);
        }
    }

}