package com.arondillqs5328.unsplashme.MVP.presenters;

import com.arondillqs5328.unsplashme.MVP.contracts.CollectionContract;
import com.arondillqs5328.unsplashme.MVP.models.CollectionRepository;

public class CollectionPresenter extends BasePresenter {

    private CollectionContract.View mView;
    private CollectionRepository mRepository;

    public CollectionPresenter(CollectionContract.View view, CollectionRepository repository) {
        mView = view;
        mRepository = repository;
    }
}
