package com.arondillqs5328.unsplashme.MVP.models;

import android.content.SharedPreferences;

import com.arondillqs5328.unsplashme.MVP.contracts.SettingsContract;

public class SettingsRepository implements SettingsContract.Repository {

    private SharedPreferences mPreferences;

    public SettingsRepository(SharedPreferences preferences) {
        mPreferences = preferences;
    }

    @Override
    public void changePreference(String key, Object value) {
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putString(key, String.valueOf(value));
        editor.apply();
    }
}