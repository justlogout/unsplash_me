package com.arondillqs5328.unsplashme.fragments;

import android.os.Bundle;

import com.arondillqs5328.unsplashme.MVP.contracts.SettingsContract;
import com.arondillqs5328.unsplashme.MVP.presenters.SettingsPresenters;
import com.arondillqs5328.unsplashme.R;

import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

public class SettingsFragment extends PreferenceFragmentCompat implements SettingsContract.View {

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

        mLanguagePreference = findPreference(getString(R.string.language_key));
        mLanguagePreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                mPresenter.onChangedPreference(mLanguagePreference.getKey(), newValue);
                return true;
            }
        });

        mThemePreference = findPreference(getString(R.string.theme_key));
        mThemePreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                mPresenter.onChangedPreference(mThemePreference.getKey(), newValue);
                return true;
            }
        });

        mLoadQualityPreference = findPreference(getString(R.string.load_quality_key));
        mLoadQualityPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                mPresenter.onChangedPreference(mLoadQualityPreference.getKey(), newValue);
                return true;
            }
        });

        mDownloadQualityPreference = findPreference(getString(R.string.download_quality_key));
        mDownloadQualityPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                mPresenter.onChangedPreference(mDownloadQualityPreference.getKey(), newValue);
                return true;
            }
        });

        mWallpaperQuality = findPreference(getString(R.string.wallpaper_quality_key));
        mWallpaperQuality.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                mPresenter.onChangedPreference(mWallpaperQuality.getKey(), newValue);
                return true;
            }
        });
    }

    @Override
    public void onDestroyView() {
        mPresenter.detachView();
        super.onDestroyView();
    }
}
