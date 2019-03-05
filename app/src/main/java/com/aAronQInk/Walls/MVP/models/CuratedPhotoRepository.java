package com.aAronQInk.Walls.MVP.models;

import com.aAronQInk.Walls.MVP.callbacks.CuratedPhotoCallback;
import com.aAronQInk.Walls.MVP.contracts.CuratedPhotoContract;
import com.aAronQInk.Walls.POJO.Photo;
import com.aAronQInk.Walls.endpoints.UnsplashPhotoAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CuratedPhotoRepository implements CuratedPhotoContract.Repository {

    private UnsplashPhotoAPI mUnsplashPhotoAPI;
    private CuratedPhotoCallback mCallback;

    public CuratedPhotoRepository(UnsplashPhotoAPI unsplashPhotoAPI) {
        mUnsplashPhotoAPI = unsplashPhotoAPI;
    }

    public void setCallback(CuratedPhotoCallback callback) {
        mCallback = callback;
    }

    @Override
    public void loadMoreCuratedPhoto(int page, int per_page, String order_by) {
        Call<List<Photo>> call = mUnsplashPhotoAPI.getCuratedPhotos(page, per_page, order_by);
        call.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                if (response.code() == 200) {
                    mCallback.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                mCallback.onFailure();
            }
        });
    }
}
