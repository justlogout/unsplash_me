package com.aAronQInk.Walls.MVP.presenters;

import android.content.Context;
import android.net.ConnectivityManager;

import com.aAronQInk.Walls.MVP.contracts.BaseContract;
import com.aAronQInk.Walls.Walls;

public class BasePresenter {

    public boolean isFirstLoading = true;

    public boolean isViewReady(BaseContract.View view) {
        return view != null;
    }

    public boolean isNetworkConnection() {
        ConnectivityManager cm = (ConnectivityManager) Walls.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    public void setFirstLoading(boolean firstLoading) {
        isFirstLoading = firstLoading;
    }
}
