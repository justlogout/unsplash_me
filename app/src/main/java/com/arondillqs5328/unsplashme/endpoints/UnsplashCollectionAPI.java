package com.arondillqs5328.unsplashme.endpoints;

import com.arondillqs5328.unsplashme.POJO.Collection;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
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

}
