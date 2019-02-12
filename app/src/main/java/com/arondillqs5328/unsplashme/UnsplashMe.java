package com.arondillqs5328.unsplashme;

import android.app.Application;

import com.arondillqs5328.unsplashme.POJO.Collection;
import com.arondillqs5328.unsplashme.POJO.Photo;

public class UnsplashMe extends Application {

    public static String APP_PREFERENCES = "com.arondillqs5328.unsplashme_preferences";
    private static UnsplashMe instance;

    public static Photo sDefaultPhoto;
    public static Collection sDefaultCollection;

    public static UnsplashMe getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
    }
}
