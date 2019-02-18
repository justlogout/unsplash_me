package com.arondillqs5328.unsplashme.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PreviewPhoto {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("urls")
    @Expose
    private Urls urls;

    public PreviewPhoto(String id, Urls urls) {
        this.id = id;
        this.urls = urls;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Urls getUrls() {
        return urls;
    }

    public void setUrls(Urls urls) {
        this.urls = urls;
    }
}
