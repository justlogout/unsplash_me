package com.arondillqs5328.unsplashme.Retrofit;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpClient {

    private final String API_HEADER = "Authorization";
    private final String API_KEY = "Client-ID 7b68c267ba5e383941db64b802d989769684634fbff5490e4195a2c30587d09c";

    public okhttp3.OkHttpClient getOkHttpClientInstance() {
        return new okhttp3.OkHttpClient.Builder()
                .addInterceptor(createInterceptor())
                .build();
    }

    private Interceptor createInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder()
                        .addHeader(API_HEADER, API_KEY)
                        .build();

                return chain.proceed(request);
            }
        };
    }
}
