package com.aAronQInk.Walls.helpers;

import android.app.DownloadManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Environment;

import com.aAronQInk.Walls.POJO.Urls;
import com.aAronQInk.Walls.R;
import com.aAronQInk.Walls.Walls;

import java.util.UUID;

public class DownloadHelper {

    public DownloadHelper() {
    }

    public static String getUrl(Urls urls) {
        SharedPreferences preferences = Walls.getInstance().getSharedPreferences(Walls.APP_PREFERENCES, Context.MODE_PRIVATE);
        String url = Walls.getInstance().getString(R.string.default_download_quality);

        switch (preferences.getString(Walls.getInstance().getString(R.string.download_quality_key), Walls.getInstance().getString(R.string.default_download_quality))) {
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

    public void download(Context context) {
        String fileName = UUID.randomUUID().toString() + ".jpg";

        DownloadManager downloadmanager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(DownloadHelper.getUrl(Walls.sDefaultPhoto.getUrls()));

        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setTitle("Walls");
        request.setDescription("Downloading");
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setVisibleInDownloadsUi(false);
        request.setDestinationUri(Uri.parse("file://" + Environment.getExternalStorageDirectory() + "/Pictures/Walls/" + fileName));

        downloadmanager.enqueue(request);
    }
}
