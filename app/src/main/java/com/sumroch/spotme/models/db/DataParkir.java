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
public class DataParkir {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id_mall")
    @Expose
    private Integer idMall;
    @SerializedName("available")
    @Expose
    private String available;
    @SerializedName("non_available")
    @Expose
    private String nonAvailable;
    @SerializedName("jumlah")
    @Expose
    private String jumlah;
}
