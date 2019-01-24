package com.arondillqs5328.unsplashme.dagger.modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    private Context mContext;

    public ContextModule(Context context) {
        mContext = context;
    }

    @Provides
    public Context context() {
        return mContext.getApplicationContext();
    }
}
