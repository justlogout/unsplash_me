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


    public Photo(String id, String createdAt, String updatedAt, int width, int height,
                 String color, String description, Urls urls, Links links, List<Object> categories,
                 boolean sponsored, Object sponsoredBy, Object sponsoredImpressionsId, int likes,
                 boolean likedByUser, List<Object> currentUserCollections, String slug, User user) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.width = width;
        this.height = height;
        this.color = color;
        this.description = description;
        this.urls = urls;
        this.links = links;
        this.categories = categories;
        this.sponsored = sponsored;
        this.sponsoredBy = sponsoredBy;
        this.sponsoredImpressionsId = sponsoredImpressionsId;
        this.likes = likes;
        this.likedByUser = likedByUser;
        this.currentUserCollections = currentUserCollections;
        this.slug = slug;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Urls getUrls() {
        return urls;
    }

    public void setUrls(Urls urls) {
        this.urls = urls;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public List<Object> getCategories() {
        return categories;
    }

    public void setCategories(List<Object> categories) {
        this.categories = categories;
    }

    public boolean isSponsored() {
        return sponsored;
    }

    public void setSponsored(boolean sponsored) {
        this.sponsored = sponsored;
    }

    public Object getSponsoredBy() {
        return sponsoredBy;
    }

    public void setSponsoredBy(Object sponsoredBy) {
        this.sponsoredBy = sponsoredBy;
    }

    public Object getSponsoredImpressionsId() {
        return sponsoredImpressionsId;
    }

    public void setSponsoredImpressionsId(Object sponsoredImpressionsId) {
        this.sponsoredImpressionsId = sponsoredImpressionsId;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public boolean isLikedByUser() {
        return likedByUser;
    }

    public void setLikedByUser(boolean likedByUser) {
        this.likedByUser = likedByUser;
    }

    public List<Object> getCurrentUserCollections() {
        return currentUserCollections;
    }

    public void setCurrentUserCollections(List<Object> currentUserCollections) {
        this.currentUserCollections = currentUserCollections;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
