package com.sumroch.spotme.models.db;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
@NoArgsConstructor
public class ParkirLocation {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("id_mall")
    @Expose
    private Integer idMall;
    @SerializedName("nomor_lantai")
    @Expose
    private String nomorLantai;
    @SerializedName("nomor_blok")
    @Expose
    private String nomorBlok;
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
