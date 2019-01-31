package com.arondillqs5328.unsplashme.MVP.contracts;

public interface BaseContract {

    interface View {
        void showProgressBar();

        void hideProgressBar();

        void showFooter();

        void hideFooter();

        void showNoInternetConection();

        void hideNoInternetConection();

        void updateQuery();
    }

    interface Presenter {
        void detachView();
    }

    interface Repository {

    }
}
