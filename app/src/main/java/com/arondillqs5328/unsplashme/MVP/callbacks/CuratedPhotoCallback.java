package com.arondillqs5328.unsplashme.MVP.callbacks;

import com.arondillqs5328.unsplashme.POJO.Photo;

import java.util.List;

public interface CuratedPhotoCallback extends BaseCallback {
    void onSuccess(List<Photo> photos);
}
