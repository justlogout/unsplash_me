package com.aAronQInk.Walls.MVP.presenters;

import com.aAronQInk.Walls.MVP.callbacks.NewPhotoCallback;
import com.aAronQInk.Walls.MVP.contracts.NewPhotoContract;
import com.aAronQInk.Walls.MVP.models.NewPhotoRepository;
import com.aAronQInk.Walls.POJO.Photo;

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
