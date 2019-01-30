package com.arondillqs5328.unsplashme.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserLinks {

    @SerializedName("self")
    @Expose
    public String self;
    @SerializedName("html")
    @Expose
    public String html;
    @SerializedName("photos")
    @Expose
    public String photos;
    @SerializedName("likes")
    @Expose
    public String likes;
    @SerializedName("portfolio")
    @Expose
    public String portfolio;
    @SerializedName("following")
    @Expose
    public String following;
    @SerializedName("followers")
    @Expose
    public String followers;

}
