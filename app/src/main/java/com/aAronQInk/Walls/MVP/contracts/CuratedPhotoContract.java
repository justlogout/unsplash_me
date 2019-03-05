package com.aAronQInk.Walls.MVP.contracts;

import com.aAronQInk.Walls.POJO.Photo;

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
