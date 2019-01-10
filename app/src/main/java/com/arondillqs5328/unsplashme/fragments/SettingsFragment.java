package com.arondillqs5328.unsplashme.fragments;

import android.os.Bundle;

import com.arondillqs5328.unsplashme.MVP.contracts.SettingsContract;
import com.arondillqs5328.unsplashme.MVP.presenters.SettingsPresenters;
import com.arondillqs5328.unsplashme.R;

import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

public class SettingsFragment extends PreferenceFragmentCompat implements SettingsContract.View,
        Preference.OnPreferenceChangeListener {

    private SettingsContract.Presenter mPresenter;

    private ListPreference mLanguagePreference;
    private ListPreference mThemePreference;
    private ListPreference mLoadQualityPreference;
    private ListPreference mDownloadQualityPreference;
    private ListPreference mWallpaperQuality;

    public static SettingsFragment newInstance() {
        SettingsFragment fragment = new SettingsFragment();
        return fragment;
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.preferences);

        mPresenter = new SettingsPresenters();
        mPresenter.attachView(this);

        initPreferences();
    }

    private void initPreferences() {
        mLanguagePreference = findPreference(getString(R.string.language_key));
        mThemePreference = findPreference(getString(R.string.theme_key));
        mLoadQualityPreference = findPreference(getString(R.string.load_quality_key));
        mDownloadQualityPreference = findPreference(getString(R.string.download_quality_key));
        mWallpaperQuality = findPreference(getString(R.string.wallpaper_quality_key));

        mLanguagePreference.setOnPreferenceChangeListener(this);
        mThemePreference.setOnPreferenceChangeListener(this);
        mLoadQualityPreference.setOnPreferenceChangeListener(this);
        mDownloadQualityPreference.setOnPreferenceChangeListener(this);
        mWallpaperQuality.setOnPreferenceChangeListener(this);
    }


    @Override
    public void onDestroyView() {
        mPresenter.detachView();
        super.onDestroyView();
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        if (preference == mLanguagePreference) {
            mPresenter.onChangedPreference(preference.getKey(), newValue);
            return true;
        } else if (preference == mThemePreference) {
            mPresenter.onChangedPreference(preference.getKey(), newValue);
            return true;
        } else if (preference == mLoadQualityPreference) {
            mPresenter.onChangedPreference(preference.getKey(), newValue);
            return true;
        } else if (preference == mDownloadQualityPreference) {
            mPresenter.onChangedPreference(preference.getKey(), newValue);
            return true;
        } else if (preference == mWallpaperQuality) {
            mPresenter.onChangedPreference(preference.getKey(), newValue);
            return true;
        }
        return false;
    }
}
