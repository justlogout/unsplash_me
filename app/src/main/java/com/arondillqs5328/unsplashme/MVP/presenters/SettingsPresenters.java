package com.arondillqs5328.unsplashme.MVP.presenters;

import com.arondillqs5328.unsplashme.MVP.contracts.SettingsContract;
import com.arondillqs5328.unsplashme.MVP.models.SettingsRepository;

public class SettingsPresenters implements SettingsContract.Presenter {

    private SettingsContract.View mView;
    private SettingsContract.Model mModel;

    public SettingsPresenters(SettingsContract.View view) {
        mView = view;
        mModel = new SettingsRepository();
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public void onChangedPreference(String key, Object value) {
        mModel.changePreference(key, value);
    }
}
