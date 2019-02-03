package com.arondillqs5328.unsplashme;

import android.app.Application;

public class UnsplashMe extends Application {

    public static String APP_PREFERENCES = "com.arondillqs5328.unsplashme_preferences";
    private static UnsplashMe instance;

    public static UnsplashMe getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
    }
}
