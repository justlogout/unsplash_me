package com.arondillqs5328.unsplashme.helpers;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.provider.MediaStore;
import android.widget.Toast;

import com.arondillqs5328.unsplashme.POJO.Urls;
import com.arondillqs5328.unsplashme.R;
import com.arondillqs5328.unsplashme.UnsplashMe;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.lang.ref.WeakReference;

public class DownloadHelper implements Target {

    private Context context;
    private WeakReference<ContentResolver> contentResolverWeakReference;
    private String name;
    private String desc;

    public DownloadHelper(Context context, ContentResolver contentResolver, String name, String desc) {
        this.context = context;
        this.contentResolverWeakReference = new WeakReference<>(contentResolver);
        this.name = name;
        this.desc = desc;
    }


    public static String getUrl(Urls urls) {
        SharedPreferences preferences = UnsplashMe.getInstance().getSharedPreferences(UnsplashMe.APP_PREFERENCES, Context.MODE_PRIVATE);
        String url = UnsplashMe.getInstance().getString(R.string.default_download_quality);

        switch (preferences.getString(UnsplashMe.getInstance().getString(R.string.download_quality_key), UnsplashMe.getInstance().getString(R.string.default_download_quality))) {
            case "Raw":
                url = urls.getRaw();
                break;
            case "Full":
                url = urls.getFull();
                break;
            case "Regular":
                url = urls.getRegular();
                break;
            case "Small":
                url = urls.getSmall();
                break;
            case "Thumb":
                url = urls.getThumb();
                break;
        }
        return url;
    }

    @Override
    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
        ContentResolver contentResolver = contentResolverWeakReference.get();
        if (contentResolver != null) {
            MediaStore.Images.Media.insertImage(contentResolver, bitmap, name, desc);
        }
        Toast.makeText(context, "Download succeed", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onBitmapFailed(Exception e, Drawable errorDrawable) {

    }

    @Override
    public void onPrepareLoad(Drawable placeHolderDrawable) {

    }
}
