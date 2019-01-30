package com.arondillqs5328.unsplashme.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Collection {

    @SerializedName("id")
    @Expose
    public int id;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("published_at")
    @Expose
    public String publishedAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;
    @SerializedName("curated")
    @Expose
    public boolean curated;
    @SerializedName("featured")
    @Expose
    public boolean featured;
    @SerializedName("total_photos")
    @Expose
    public int totalPhotos;
    @SerializedName("private")
    @Expose
    public boolean _private;
    @SerializedName("share_key")
    @Expose
    public String shareKey;
    @SerializedName("tags")
    @Expose
    public List<Tag> tags;
    @SerializedName("cover_photo")
    @Expose
    public Photo photo;
    @SerializedName("preview_photos")
    @Expose
    public List<PreviewPhoto> previewPhotos;
    @SerializedName("user")
    @Expose
    public User user;
    @SerializedName("links")
    @Expose
    public CollectionLinks links;

}
