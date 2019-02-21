package com.arondillqs5328.unsplashme.MVP.presenters;

import com.arondillqs5328.unsplashme.MVP.callbacks.NewPhotoCallback;
import com.arondillqs5328.unsplashme.MVP.contracts.NewPhotoContract;
import com.arondillqs5328.unsplashme.MVP.models.NewPhotoRepository;
import com.arondillqs5328.unsplashme.POJO.Photo;

import java.util.List;

public class NewPhotoPresenter extends BasePresenter implements NewPhotoContract.Presenter, NewPhotoCallback {

    private NewPhotoContract.View mView;
    private NewPhotoRepository mRepository;

    public NewPhotoPresenter(NewPhotoContract.View view, NewPhotoRepository repository) {
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
    public void onLoadMorePhoto(int page, int per_page, String order_by) {
        if (isViewReady(mView)) {
            if (isFirstLoading) {
                if (isNetworkConnection()) {
                    mView.hideNoInternetConection();
                    mView.showProgressBar();
                    mRepository.loadMoreNewPhoto(page, per_page, order_by);
                } else {
                    mView.hideProgressBar();
                    mView.showNoInternetConection();
                }
            } else {
                if (isNetworkConnection()) {
                    mRepository.loadMoreNewPhoto(page, per_page, order_by);
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
