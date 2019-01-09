package com.arondillqs5328.unsplashme;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class UnsplashMe extends Application {

    public static SharedPreferences mSettings;
    private final String APP_PREFERENCES = "com.arondillqs5328.unsplashme_preferences";

    @Override
    public void onCreate() {
        super.onCreate();

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
    }
}
