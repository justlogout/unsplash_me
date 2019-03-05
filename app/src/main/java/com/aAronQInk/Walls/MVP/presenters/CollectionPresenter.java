package com.aAronQInk.Walls.MVP.presenters;

import com.aAronQInk.Walls.MVP.callbacks.CollectionCallback;
import com.aAronQInk.Walls.MVP.contracts.CollectionContract;
import com.aAronQInk.Walls.MVP.models.CollectionRepository;
import com.aAronQInk.Walls.POJO.Collection;

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
            if (isFirstLoading) {
                if (isNetworkConnection()) {
                    mView.hideNoInternetConection();
                    mView.showProgressBar();
                    mRepository.loadMoreCollection(type, page, per_page);
                } else {
                    mView.hideProgressBar();
                    mView.showNoInternetConection();
                }
            } else {
                if (isNetworkConnection()) {
                    mRepository.loadMoreCollection(type, page, per_page);
                }
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
