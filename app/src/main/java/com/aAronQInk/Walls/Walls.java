package com.aAronQInk.Walls;

import android.app.Application;

import com.aAronQInk.Walls.POJO.Collection;
import com.aAronQInk.Walls.POJO.Photo;

public class Walls extends Application {

    public static String APP_PREFERENCES = "com.arondillqs5328.unsplashme_preferences";
    private static Walls instance;

    public static Photo sDefaultPhoto;
    public static Collection sDefaultCollection;

    public static Walls getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
    }
}
