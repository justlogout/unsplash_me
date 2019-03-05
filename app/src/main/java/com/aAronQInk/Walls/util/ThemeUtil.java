package com.aAronQInk.Walls.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.aAronQInk.Walls.R;
import com.aAronQInk.Walls.Walls;

import static android.content.Context.MODE_PRIVATE;

public class ThemeUtil {

    public static String getTheme(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Walls.APP_PREFERENCES, MODE_PRIVATE);
        return sharedPreferences.getString(context.getString(R.string.theme_key), context.getString(R.string.default_theme));
    }
}
