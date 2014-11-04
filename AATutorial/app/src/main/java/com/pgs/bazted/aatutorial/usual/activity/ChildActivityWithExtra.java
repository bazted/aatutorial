package com.pgs.bazted.aatutorial.usual.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;

/**
 * Created by bazted on 04/11/14.
 */
public class ChildActivityWithExtra extends FragmentActivity {
    public static final String STRING_EXTRA_KEY = "STRING_EXTRA_KEY";

    public static void startChild(Context context, String stringExtra) {
        Intent intent = new Intent(context, ChildActivityWithExtra.class);
        context.startActivity(intent);
    }

}
