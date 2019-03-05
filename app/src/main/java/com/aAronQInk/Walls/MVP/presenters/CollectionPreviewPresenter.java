package com.aAronQInk.Walls.MVP.presenters;

import com.aAronQInk.Walls.MVP.callbacks.CollectionPreviewCallback;
import com.aAronQInk.Walls.MVP.contracts.CollectionPreviewContract;
import com.aAronQInk.Walls.MVP.models.CollectionPreviewRepository;
import com.aAronQInk.Walls.POJO.Photo;

import java.util.List;

public class CollectionPreviewPresenter extends BasePresenter implements CollectionPreviewContract.Presenter, CollectionPreviewCallback {

    private CollectionPreviewContract.View mView;
    private CollectionPreviewRepository mRepository;

    public CollectionPreviewPresenter(CollectionPreviewContract.View view, CollectionPreviewRepository repository) {
        mView = view;
        mRepository = repository;
        mRepository.setCallback(this);
    }

    @Override
    public void onSuccess(List<Photo> photos) {
        if (isViewReady(mView)) {
            isFirstLoading = false;
            mView.hideProgressBar();
            mView.showMorePhoto(photos);
            mView.updateQuery();
        }
    }

    @Override
    public void onFailure() {

    }

    @Override
    public void onLoadMorePhoto(int id, int page, int per_page) {
        if (isViewReady(mView)) {
            if (isFirstLoading) {
                if (isNetworkConnection()) {
                    mView.hideNoInternetConection();
                    mView.showProgressBar();
                    mRepository.loadMoreNewPhoto(id, page, per_page);
                } else {
                    mView.hideProgressBar();
                    mView.showNoInternetConection();
                }
            } else {
                if (isNetworkConnection()) {
                    mRepository.loadMoreNewPhoto(id, page, per_page);
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
