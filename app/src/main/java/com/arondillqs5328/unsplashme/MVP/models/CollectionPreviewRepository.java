package com.arondillqs5328.unsplashme.MVP.models;

import android.util.Log;

import com.arondillqs5328.unsplashme.MVP.callbacks.CollectionPreviewCallback;
import com.arondillqs5328.unsplashme.MVP.contracts.CollectionPreviewContract;
import com.arondillqs5328.unsplashme.POJO.Photo;
import com.arondillqs5328.unsplashme.endpoints.UnsplashCollectionAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CollectionPreviewRepository implements CollectionPreviewContract.Repository {

    private UnsplashCollectionAPI mUnsplashCollectionAPI;
    private CollectionPreviewCallback mCallback;

    public CollectionPreviewRepository(UnsplashCollectionAPI unsplashCollectionAPI) {
        mUnsplashCollectionAPI = unsplashCollectionAPI;
    }

    public void setCallback(CollectionPreviewCallback callback) {
        mCallback = callback;
    }

    @Override
    public void loadMoreNewPhoto(int id, int page, int per_page) {
        Call<List<Photo>> call = mUnsplashCollectionAPI.getCollectionPhotos(id, page, per_page);
        call.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                if (response.code() == 200) {
                    mCallback.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                Log.i("TAG_L", t.toString());
                mCallback.onFailure();
            }
        });
    }
}
