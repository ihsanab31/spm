package com.sumroch.spotme.models.db;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */
@Data
@Parcel
@NoArgsConstructor
public class EventItem {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nama_event")
    @Expose
    private String namaEvent;
    @SerializedName("short_description")
    @Expose
    private String shortDescription;
    @SerializedName("waktu_event")
    @Expose
    private String waktuEvent;
    @SerializedName("picture")
    @Expose
    private String picture;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
}
