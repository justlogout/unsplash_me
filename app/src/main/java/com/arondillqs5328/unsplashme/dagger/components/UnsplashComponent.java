package com.arondillqs5328.unsplashme.dagger.components;

import com.arondillqs5328.unsplashme.dagger.modules.PicassoModule;
import com.arondillqs5328.unsplashme.dagger.modules.RetrofitClientModule;
import com.arondillqs5328.unsplashme.endpoints.UnsplashAPI;
import com.squareup.picasso.Picasso;

import dagger.Component;

@Component(modules = {RetrofitClientModule.class, PicassoModule.class})
public interface UnsplashComponent {
    UnsplashAPI getUnsplashAPIService();

    Picasso getPicasso();
}
