package com.arondillqs5328.unsplashme.MVP.presenters;

import com.arondillqs5328.unsplashme.MVP.contracts.SettingsContract;
import com.arondillqs5328.unsplashme.MVP.models.SettingsRepository;

public class SettingsPresenter implements SettingsContract.Presenter {

    private SettingsContract.View mView;
    private SettingsContract.Repository mRepository;

    public SettingsPresenter(SettingsContract.View view, SettingsRepository settingsRepository) {
        mView = view;
        mRepository = settingsRepository;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public void onChangedPreference(String key, Object value) {
        mRepository.changePreference(key, value);
    }
}
