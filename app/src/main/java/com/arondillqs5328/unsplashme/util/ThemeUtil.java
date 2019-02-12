package com.arondillqs5328.unsplashme.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.arondillqs5328.unsplashme.R;
import com.arondillqs5328.unsplashme.UnsplashMe;

import static android.content.Context.MODE_PRIVATE;

public class ThemeUtil {

    public static String getTheme(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(UnsplashMe.APP_PREFERENCES, MODE_PRIVATE);
        return sharedPreferences.getString(context.getString(R.string.theme_key), context.getString(R.string.default_theme));
    }
}
