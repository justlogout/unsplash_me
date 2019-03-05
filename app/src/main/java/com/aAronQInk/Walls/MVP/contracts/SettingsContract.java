package com.aAronQInk.Walls.MVP.contracts;

public interface SettingsContract {

    interface View {
        void restart();
    }

    interface Presenter {
        void detachView();

        void onChangedPreference(String key, Object value);
    }

    interface Repository {
        void changePreference(String key, Object value);
    }
}
