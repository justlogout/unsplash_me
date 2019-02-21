package com.arondillqs5328.unsplashme.MVP.presenters;

import android.content.Context;
import android.net.ConnectivityManager;

import com.arondillqs5328.unsplashme.MVP.contracts.BaseContract;
import com.arondillqs5328.unsplashme.UnsplashMe;

public class BasePresenter {

    public boolean isFirstLoading = true;

    public boolean isViewReady(BaseContract.View view) {
        return view != null;
    }

    public boolean isNetworkConnection() {
        ConnectivityManager cm = (ConnectivityManager) UnsplashMe.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    public void setFirstLoading(boolean firstLoading) {
        isFirstLoading = firstLoading;
    }
}
