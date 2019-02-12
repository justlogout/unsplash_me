package com.arondillqs5328.unsplashme.MVP.presenters;

import com.arondillqs5328.unsplashme.MVP.callbacks.SettingsCallback;
import com.arondillqs5328.unsplashme.MVP.contracts.SettingsContract;
import com.arondillqs5328.unsplashme.MVP.models.SettingsRepository;

public class SettingsPresenter implements SettingsContract.Presenter, SettingsCallback {

    private SettingsContract.View mView;
    private SettingsRepository mRepository;

    public SettingsPresenter(SettingsContract.View view, SettingsRepository settingsRepository) {
        mView = view;
        mRepository = settingsRepository;
        mRepository.setCallback(this);
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public void onChangedPreference(String key, Object value) {
        mRepository.changePreference(key, value);
    }

    @Override
    public void onPreferenceChanged(String preference) {
        switch (preference) {
            case "Language":
                if (isViewReady()) {
                    mView.restart();
                }
                break;
            case "Theme":
                if (isViewReady()) {
                    mView.restart();
                }
                break;
        }
    }

    private boolean isViewReady() {
        return mView != null;
    }
}
