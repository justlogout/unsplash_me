package com.aAronQInk.Walls.endpoints;

import com.aAronQInk.Walls.POJO.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UnsplashPhotoAPI {

    String ORDER_BY_LATEST = "latest";
    String ORDER_BY_OLDEST = "oldest";
    String ORDER_BY_POPULAR = "popular";

    @GET("/photos")
    Call<List<Photo>> getNewPhotos(@Query("page") int page,
                                   @Query("per_page") int per_page,
                                   @Query("order_by") String order_by);

    //tab FEATURED
    @GET("/photos/curated")
    Call<List<Photo>> getCuratedPhotos(@Query("page") int page,
                                       @Query("per_page") int per_page,
                                       @Query("order_by") String order_by);

}
