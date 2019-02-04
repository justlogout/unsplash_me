package com.arondillqs5328.unsplashme.MVP.contracts;

public interface SettingsContract {

    interface View {

    }

    interface Presenter extends BaseContract {
        void detachView();

        void onChangedPreference(String key, Object value);
    }

    interface Repository {
        void changePreference(String key, Object value);
    }
}
