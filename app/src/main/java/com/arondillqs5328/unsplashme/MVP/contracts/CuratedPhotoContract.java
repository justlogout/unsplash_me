package com.arondillqs5328.unsplashme.MVP.contracts;

import com.arondillqs5328.unsplashme.POJO.Photo;

import java.util.List;

public interface CuratedPhotoContract {

    interface View extends BaseContract.View {
        void showMorePhoto(List<Photo> photos);
    }

    interface Presenter extends BaseContract.Presenter {
        void onLoadMorePhoto(int page, int per_page, String order_by);
    }

    interface Repository extends BaseContract.Repository {
        void loadMoreCuratedPhoto(int page, int per_page, String order_by);
    }
}
