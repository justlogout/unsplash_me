package com.arondillqs5328.unsplashme.MVP.contracts;

import com.arondillqs5328.unsplashme.POJO.Photo;

import java.util.List;

public interface CollectionPreviewContract {

    interface View extends BaseContract.View {
        void showMorePhoto(List<Photo> photos);
    }

    interface Presenter extends BaseContract.Presenter {
        void onLoadMorePhoto(int id, int page, int per_page);
    }

    interface Repository extends BaseContract.Repository {
        void loadMoreNewPhoto(int id, int page, int per_page);
    }
}
