package com.aAronQInk.Walls.MVP.models;

import android.util.Log;

import com.aAronQInk.Walls.MVP.callbacks.NewPhotoCallback;
import com.aAronQInk.Walls.MVP.contracts.NewPhotoContract;
import com.aAronQInk.Walls.POJO.Photo;
import com.aAronQInk.Walls.endpoints.UnsplashPhotoAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewPhotoRepository implements NewPhotoContract.Repository {

    private UnsplashPhotoAPI mUnsplashPhotoAPI;
    private NewPhotoCallback mCallback;

    public NewPhotoRepository(UnsplashPhotoAPI unsplashPhotoAPI) {
        mUnsplashPhotoAPI = unsplashPhotoAPI;
    }

    public void setCallback(NewPhotoCallback callback) {
        mCallback = callback;
    }

    @Override
    public void loadMoreNewPhoto(int page, int per_page, String order_by) {
        Call<List<Photo>> call = mUnsplashPhotoAPI.getNewPhotos(page, per_page, order_by);
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
