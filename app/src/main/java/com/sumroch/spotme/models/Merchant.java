package com.sumroch.spotme.models;

import com.google.gson.annotations.SerializedName;
import com.sumroch.spotme.models.db.Mall;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */

public class Merchant {
    @SerializedName("id")
    private int id;
    @SerializedName("location_x")
    private String locationX;
    @SerializedName("location_y")
    private String locationY;
    @SerializedName("description")
    private Object description;
    @SerializedName("picture")
    private Object picture;
    @SerializedName("deleted_at")
    private Object deletedAt;
    @SerializedName("brand")
    private Brand brand;
    @SerializedName("mall")
    private Mall mall;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocationX() {
        return locationX;
    }

    public void setLocationX(String locationX) {
        this.locationX = locationX;
    }

    public String getLocationY() {
        return locationY;
    }

    public void setLocationY(String locationY) {
        this.locationY = locationY;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Object getPicture() {
        return picture;
    }

    public void setPicture(Object picture) {
        this.picture = picture;
    }

    public Object getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Mall getMall() {
        return mall;
    }

    public void setMall(Mall mall) {
        this.mall = mall;
    }
}
