package com.sumroch.spotme.models.db;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(callSuper = false)
public class Kendaraan extends RealmObject {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("plat_nomor")
    @Expose
    private String platNomor;
    @SerializedName("jenis_kendaraan")
    @Expose
    private String jenisKendaraan;
    @SerializedName("warna")
    @Expose
    private String warna;
    @SerializedName("id_user")
    @Expose
    private Integer idUser;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public static void addAll(final List<Kendaraan> kendaraans) {
        Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(kendaraans);
            }
        });
    }

    public static void deleteAll() {
        Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try {
                    realm.where(Kendaraan.class).findAll().deleteAllFromRealm();
                } catch (Exception e) {

                }
            }
        });
    }

    public static List<Kendaraan> getAll() {
        Realm realm = Realm.getDefaultInstance();
        return realm.copyFromRealm(realm.where(Kendaraan.class).findAll());
    }

    public static List<String> getListPlatNumber() {
        List<String> listPlatNomor = new ArrayList<>();
        for (Kendaraan kendaraan : getAll())
            listPlatNomor.add(kendaraan.getPlatNomor());
        return listPlatNomor;
    }
}
