package com.arondillqs5328.unsplashme.MVP.callbacks;

import com.arondillqs5328.unsplashme.POJO.Collection;

import java.util.List;

public interface CollectionCallback extends BaseCallback {
    void onSuccess(List<Collection> collections);
}
