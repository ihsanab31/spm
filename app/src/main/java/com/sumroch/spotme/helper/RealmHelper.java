package com.sumroch.spotme.helper;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.sumroch.spotme.models.KendaraanModel;
import com.sumroch.spotme.models.db.Add_Kendaraan;
import com.sumroch.spotme.models.db.Kendaraan;
import com.sumroch.spotme.models.db.Mall;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */

public class RealmHelper {

    private static final String TAG = "RealmHelper";
    private Realm realm;
    private RealmResults<Add_Kendaraan> realmResults;
    public Context context;

    /**
     * constructor untuk membuat instance realm
     *
     * @param context
     */
    public RealmHelper(Context context) {
        realm = Realm.getDefaultInstance();
        this.context = context;
    }

    public void addArticle(String j_kendaraan, String plat) {
        Add_Kendaraan kendaraanModel = new Add_Kendaraan();
        kendaraanModel.setId((int) (System.currentTimeMillis() / 1000));
        kendaraanModel.setJ_kendaraan(j_kendaraan);
        kendaraanModel.setPlat(plat);
        realm.beginTransaction();
        realm.copyToRealm(kendaraanModel);
        realm.commitTransaction();
        showLog("Added ; " + plat);
        showToast(plat + " berhasil disimpan.");


    }


    public ArrayList<KendaraanModel> findAllArticle() {
        ArrayList<KendaraanModel> data = new ArrayList<>();
        realmResults = realm.where(Add_Kendaraan.class).findAll();
        realmResults.sort("id", Sort.DESCENDING);
        if (realmResults.size() > 0) {
            showLog("Size : " + realmResults.size());
            for (int i = 0; i < realmResults.size(); i++) {
                String j_kendaraan, plat;
                int id = realmResults.get(i).getId();
                plat = realmResults.get(i).getPlat();
                j_kendaraan = realmResults.get(i).getJ_kendaraan();
                data.add(new KendaraanModel(id, j_kendaraan, plat));
            }

        } else {
            showLog("Size : 0");
            showToast("Database Kosong!");
        }

        return data;
    }



    public static ArrayList<String> getListPlatNumber() {
        ArrayList<String> listPlatNomor = new ArrayList<>();
        for (Add_Kendaraan kendaraan : getAll())
            listPlatNomor.add(kendaraan.getPlat());
        return listPlatNomor;
    }

    public static List<Add_Kendaraan> getAll() {
        Realm realm = Realm.getDefaultInstance();
        return realm.copyFromRealm(realm.where(Add_Kendaraan.class).findAll());
    }

    public void updateArticle(int id, String title, String description) {
        realm.beginTransaction();
        Add_Kendaraan kendaraan = realm.where(Add_Kendaraan.class).equalTo("id", id).findFirst();
        kendaraan.setJ_kendaraan(title);
        kendaraan.setPlat(description);
        realm.commitTransaction();
        showLog("Updated : " + title);

        showToast(title + " berhasil diupdate.");
    }

    public void deleteData(int id) {
        RealmResults<Add_Kendaraan> dataDesults = realm.where(Add_Kendaraan.class).equalTo("id", id).findAll();
        realm.beginTransaction();
        dataDesults.remove(0);
        dataDesults.clear();
        realm.commitTransaction();

        showToast("Hapus data berhasil.");
    }

    private void showLog(String s) {
        Log.d(TAG, s);

    }

    /**
     * Membuat Toast Informasi
     */
    private void showToast(String s) {
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
    }
}
