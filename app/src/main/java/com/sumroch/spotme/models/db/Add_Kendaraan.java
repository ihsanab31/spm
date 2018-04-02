package com.sumroch.spotme.models.db;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */

public class Add_Kendaraan extends RealmObject {
    @PrimaryKey
    private int id;
    private String j_kendaraan;
    private String plat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJ_kendaraan() {
        return j_kendaraan;
    }

    public void setJ_kendaraan(String j_kendaraan) {
        this.j_kendaraan = j_kendaraan;
    }

    public String getPlat() {
        return plat;
    }

    public void setPlat(String plat) {
        this.plat = plat;
    }
}
