package com.arondillqs5328.unsplashme.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private final String API_BASE_URL = "https://api.unsplash.com";

    public Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .client(new OkHttpClient().getOkHttpClientInstance())
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
