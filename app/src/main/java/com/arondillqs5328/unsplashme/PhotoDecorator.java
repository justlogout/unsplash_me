package com.arondillqs5328.unsplashme;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.DisplayMetrics;

import com.arondillqs5328.unsplashme.POJO.Urls;

public class PhotoDecorator {

    private int width;
    private int height;

    public PhotoDecorator() {

    }

    public PhotoDecorator(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getFinalHeight() {
        DisplayMetrics displayMetrics = UnsplashMe.getInstance().getResources().getDisplayMetrics();
        float height = displayMetrics.widthPixels / ((float) getWidth() / (float) getHeight());
        return (int) height;
    }

    public String getPhotoUrl(Urls urls) {
        SharedPreferences preferences = UnsplashMe.getInstance().getSharedPreferences(UnsplashMe.APP_PREFERENCES, Context.MODE_PRIVATE);
        String url = UnsplashMe.getInstance().getString(R.string.default_load_quality);

        switch (preferences.getString(UnsplashMe.getInstance().getString(R.string.load_quality_key), UnsplashMe.getInstance().getString(R.string.default_load_quality))) {
            case "Raw":
                url = urls.raw;
                break;
            case "Full":
                url = urls.full;
                break;
            case "Regular":
                url = urls.regular;
                break;
            case "Small":
                url = urls.small;
                break;
            case "Thumb":
                url = urls.thumb;
                break;
        }
        return url;
    }
}