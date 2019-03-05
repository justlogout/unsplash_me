package com.aAronQInk.Walls.MVP.contracts;

public interface BaseContract {

    interface View {
        void showProgressBar();

        void hideProgressBar();

        void showNoInternetConection();

        void hideNoInternetConection();

        void updateQuery();
    }

    interface Presenter {
        void onLoadFirst();

        void detachView();
    }

    interface Repository {

    }
}
