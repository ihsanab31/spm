package com.sumroch.spotme.models.db;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
public class HistoryParkir extends RealmObject {

    @SerializedName("id_parkir")
    @Expose
    private String idParkir;
    @SerializedName("nama_mall")
    @Expose
    private String namaMall;
    @SerializedName("name_user")
    @Expose
    private String nameUser;
    @SerializedName("plat_nomor")
    @Expose
    private String platNomor;
    @SerializedName("jenis_kendaraan")
    @Expose
    private String jenisKendaraan;
    @SerializedName("nomor_lantai")
    @Expose
    private String nomorLantai;
    @SerializedName("nomor_blok")
    @Expose
    private String nomorBlok;
    @SerializedName("harga_perjam")
    @Expose
    private Integer hargaPerjam;
    @SerializedName("waktu_masuk")
    @Expose
    private String waktuMasuk;
    @SerializedName("waktu_keluar")
    @Expose
    private String waktuKeluar;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("total_harga")
    @Expose
    private Integer totalHarga;

    public static void saveAll(final List<HistoryParkir> historyParkir) {
        Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(historyParkir);
            }
        });
    }

    public static List<HistoryParkir> getData(String namaUser, String status) {
        Realm realm = Realm.getDefaultInstance();
        return realm.copyFromRealm(
                realm.where(HistoryParkir.class)
                        .equalTo("nameUser", namaUser)
                        .equalTo("status", status)
                        .findAll()
        );
    }

}

