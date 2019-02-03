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

    public Collection(int id, String title, String description, String publishedAt,
                      String updatedAt, boolean curated, boolean featured, int totalPhotos,
                      boolean _private, String shareKey, List<Tag> tags, Photo photo,
                      List<PreviewPhoto> previewPhotos, User user, CollectionLinks links) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.publishedAt = publishedAt;
        this.updatedAt = updatedAt;
        this.curated = curated;
        this.featured = featured;
        this.totalPhotos = totalPhotos;
        this._private = _private;
        this.shareKey = shareKey;
        this.tags = tags;
        this.photo = photo;
        this.previewPhotos = previewPhotos;
        this.user = user;
        this.links = links;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isCurated() {
        return curated;
    }

    public void setCurated(boolean curated) {
        this.curated = curated;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public int getTotalPhotos() {
        return totalPhotos;
    }

    public void setTotalPhotos(int totalPhotos) {
        this.totalPhotos = totalPhotos;
    }

    public boolean is_private() {
        return _private;
    }

    public void set_private(boolean _private) {
        this._private = _private;
    }

    public String getShareKey() {
        return shareKey;
    }

    public void setShareKey(String shareKey) {
        this.shareKey = shareKey;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public List<PreviewPhoto> getPreviewPhotos() {
        return previewPhotos;
    }

    public void setPreviewPhotos(List<PreviewPhoto> previewPhotos) {
        this.previewPhotos = previewPhotos;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CollectionLinks getLinks() {
        return links;
    }

    public void setLinks(CollectionLinks links) {
        this.links = links;
    }
}
