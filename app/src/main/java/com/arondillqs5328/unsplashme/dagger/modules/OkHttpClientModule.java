package com.arondillqs5328.unsplashme.dagger.modules;

import java.io.IOException;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Module
public class OkHttpClientModule {

    private final String API_HEADER = "client_id";
    private final String API_KEY = "";

    @Provides
    public OkHttpClient okHttpClient(Interceptor interceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
    }

    @Provides
    public Interceptor interceptor() {
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
