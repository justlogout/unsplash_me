package com.arondillqs5328.unsplashme.MVP.presenters;

import com.arondillqs5328.unsplashme.MVP.contracts.BaseContract;

public class BasePresenter {

    public boolean isFirstLoading = true;

    public boolean isViewReady(BaseContract.View view) {
        return view != null;
    }

    public boolean isNetworkConnection() {
        return true;
    }

    public void setFirstLoading(boolean firstLoading) {
        isFirstLoading = firstLoading;
    }
}
