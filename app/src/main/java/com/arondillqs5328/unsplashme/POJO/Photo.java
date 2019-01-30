package com.arondillqs5328.unsplashme.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Photo {

    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;
    @SerializedName("width")
    @Expose
    public int width;
    @SerializedName("height")
    @Expose
    public int height;
    @SerializedName("color")
    @Expose
    public String color;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("urls")
    @Expose
    public Urls urls;
    @SerializedName("links")
    @Expose
    public Links links;
    @SerializedName("categories")
    @Expose
    public List<Object> categories;
    @SerializedName("sponsored")
    @Expose
    public boolean sponsored;
    @SerializedName("sponsored_by")
    @Expose
    public Object sponsoredBy;
    @SerializedName("sponsored_impressions_id")
    @Expose
    public Object sponsoredImpressionsId;
    @SerializedName("likes")
    @Expose
    public int likes;
    @SerializedName("liked_by_user")
    @Expose
    public boolean likedByUser;
    @SerializedName("current_user_collections")
    @Expose
    public List<Object> currentUserCollections;
    @SerializedName("slug")
    @Expose
    public String slug;
    @SerializedName("user")
    @Expose
    public User user;

}
