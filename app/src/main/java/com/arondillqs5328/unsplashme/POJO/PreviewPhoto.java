package com.arondillqs5328.unsplashme.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PreviewPhoto {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("urls")
    @Expose
    public Urls urls;

}
