package com.sumroch.spotme.models.db;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

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
public class MasterData {

    @SerializedName("mall")
    @Expose
    private List<Mall> mall = new ArrayList<>();
    @SerializedName("user")
    @Expose
    private Profile profile;
    @SerializedName("kendaraan")
    @Expose
    private List<Kendaraan> kendaraan = null;
    @SerializedName("image_url")
    @Expose
    private BaseImageUrl imageUrl;
}
