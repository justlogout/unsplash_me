package com.aAronQInk.Walls.MVP.callbacks;

import com.aAronQInk.Walls.POJO.Collection;

import java.util.List;

public interface CollectionCallback extends BaseCallback {
    void onSuccess(List<Collection> collections);
}
