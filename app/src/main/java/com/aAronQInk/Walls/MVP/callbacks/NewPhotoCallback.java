package com.aAronQInk.Walls.MVP.callbacks;

import com.aAronQInk.Walls.POJO.Photo;

import java.util.List;

public interface NewPhotoCallback extends BaseCallback {
    void onSuccess(List<Photo> photos);
}
