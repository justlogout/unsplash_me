package com.aAronQInk.Walls;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;

import com.aAronQInk.Walls.POJO.Urls;
import com.aAronQInk.Walls.POJO.User;

public class ItemDecorator {

    public ItemDecorator() {

    }

    public int getFinalHeight(int width, int height) {
        DisplayMetrics displayMetrics = Walls.getInstance().getResources().getDisplayMetrics();
        float finalHeight = displayMetrics.widthPixels / ((float) width / (float) height);
        return (int) finalHeight;
    }

    public String getPhotoUrl(Urls urls) {
        SharedPreferences preferences = Walls.getInstance().getSharedPreferences(Walls.APP_PREFERENCES, Context.MODE_PRIVATE);
        String url = Walls.getInstance().getString(R.string.default_load_quality);

        switch (preferences.getString(Walls.getInstance().getString(R.string.load_quality_key), Walls.getInstance().getString(R.string.default_load_quality))) {
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

    public ColorDrawable getPlaceholder(String color) {
        return new ColorDrawable(Color.parseColor(color));
    }

    public String getAuthor(User user) {
        String author = "By ";
        if (!user.getName().equals("null")) {
            author += user.getName();
        }
        return author;
    }

    public String getTotalCount(int count) {
        String format = "%d " + Walls.getInstance().getString(R.string.photos);
        return String.format(format, count);
    }
}