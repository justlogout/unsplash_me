package com.arondillqs5328.unsplashme.MVP.models;

import android.content.SharedPreferences;

import com.arondillqs5328.unsplashme.MVP.contracts.SettingsContract;
import com.arondillqs5328.unsplashme.UnsplashMe;

public class SettingsRepository implements SettingsContract.Model {

    @Override
    public void changePreference(String key, Object value) {
        SharedPreferences.Editor editor = UnsplashMe.mSettings.edit();
        editor.putString(key, String.valueOf(value));
        editor.apply();
    }
}