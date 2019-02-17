package com.arondillqs5328.unsplashme.endpoints;

import com.arondillqs5328.unsplashme.POJO.Collection;
import com.arondillqs5328.unsplashme.POJO.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UnsplashCollectionAPI {

    @GET("/collections")
    Call<List<Collection>> getAllCollections(@Query("page") int page,
                                             @Query("per_page") int per_page);

    @GET("/collections/curated")
    Call<List<Collection>> getCuratedCollections(@Query("page") int page,
                                                 @Query("per_page") int per_page);

    @GET("/collections/featured")
    Call<List<Collection>> getFeaturedCollections(@Query("page") int page,
                                                  @Query("per_page") int per_page);

    @GET("/collections/{id}/photos")
    Call<List<Photo>> getCollectionPhotos(@Path("id") int id,
                                          @Query("page") int page,
                                          @Query("per_page") int per_page);
}
