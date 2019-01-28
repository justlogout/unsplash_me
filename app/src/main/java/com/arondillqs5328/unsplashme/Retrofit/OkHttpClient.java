package com.arondillqs5328.unsplashme.Retrofit;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpClient {

    private final String API_HEADER = "client_id";
    private final String API_KEY = "";

    public okhttp3.OkHttpClient getOkHttpClientInstance() {
        okhttp3.OkHttpClient okHttpClient = new okhttp3.OkHttpClient.Builder()
                .addInterceptor(createInterceptor())
                .build();

        return okHttpClient;
    }

    private Interceptor createInterceptor() {
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder()
                        .addHeader(API_HEADER, API_KEY)
                        .build();

                return chain.proceed(request);
            }
        };

        return interceptor;
    }
}
