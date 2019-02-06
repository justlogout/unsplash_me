package com.arondillqs5328.unsplashme.MVP.presenters;

import com.arondillqs5328.unsplashme.MVP.callbacks.CollectionCallback;
import com.arondillqs5328.unsplashme.MVP.contracts.CollectionContract;
import com.arondillqs5328.unsplashme.MVP.models.CollectionRepository;
import com.arondillqs5328.unsplashme.POJO.Collection;

import java.util.List;

public class CollectionPresenter extends BasePresenter implements CollectionContract.Presenter, CollectionCallback {

    private CollectionContract.View mView;
    private CollectionRepository mRepository;

    public CollectionPresenter(CollectionContract.View view, CollectionRepository repository) {
        mView = view;
        mRepository = repository;
        mRepository.setCallback(this);
    }

    @Override
    public void onSuccess(List<Collection> collections) {
        if (isViewReady(mView)) {
            isFirstLoading = false;
            mView.hideProgressBar();
            mView.showMoreCollection(collections);
            mView.updateQuery();
        }
    }

    @Override
    public void onFailure() {

    }

    @Override
    public void onLoadMoreCollection(int type, int page, int per_page) {
        if (isViewReady(mView)) {
            if (isNetworkConnection()) {
                if (isFirstLoading) {
                    mView.hideNoInternetConection();
                    mView.showProgressBar();
                    mRepository.loadMoreCollection(type, page, per_page);
                } else {
                    mRepository.loadMoreCollection(type, page, per_page);
                }
            } else {
                mView.hideProgressBar();
                mView.showNoInternetConection();
            }
        }
    }

    @Override
    public void onLoadFirst() {
        setFirstLoading(true);
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
