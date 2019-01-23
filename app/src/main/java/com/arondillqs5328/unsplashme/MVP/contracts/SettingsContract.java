package com.arondillqs5328.unsplashme.MVP.contracts;

public interface SettingsContract {

    interface View {

    }

    interface Presenter {
        void detachView();
        void onChangedPreference(String key, Object value);
    }

    interface Model {
        void changePreference(String key, Object value);
    }
}
