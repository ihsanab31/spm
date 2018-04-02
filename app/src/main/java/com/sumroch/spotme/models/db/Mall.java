package com.sumroch.spotme.models.db;

import com.directions.route.Route;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;
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
public class Mall extends RealmObject implements RealmModel {

    @PrimaryKey
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("longitude")
    @Expose
    private Double longitude;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("note")
    @Expose
    private String note;
    @SerializedName("picture")
    @Expose
    private String picture;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("deleted_at")
    @Expose
    private String deletedAt;

    @SerializedName("description")
    private String description;
    @SerializedName("status")
    private int status;

    private String availableSpace;
    private String nonAvailableSpace;
    private String totalSpace;

    @Ignore
    private ArrayList<Route> routes = new ArrayList<>();
    @Ignore
    private Double distance;

    private Double savedDistance;

    public static ArrayList<String> getMallName() {
        RealmResults<Mall> mallRealmResults = Realm.getDefaultInstance().where(Mall.class).findAll();
        List<Mall> mallArrayList = Realm.getDefaultInstance().copyFromRealm(mallRealmResults);
        ArrayList<String> listMallName = new ArrayList<>();
        for (Mall mall : mallArrayList)
            listMallName.add(mall.getName());
        return listMallName;
    }

    public static void getMall(RealmChangeListener<RealmResults<Mall>> realmChangeListener) {
        Realm.getDefaultInstance().where(Mall.class).findAllAsync().addChangeListener(realmChangeListener);
    }

    public static List<Mall> getMall() {
        Realm realm = Realm.getDefaultInstance();
        return realm.copyFromRealm(realm.where(Mall.class).findAll());
    }

    public static Mall getMallById(Integer id) {
        return Realm.getDefaultInstance().where(Mall.class).equalTo("id", id).findFirst();
    }

    public static void saveAll(final List<Mall> mallList) {
        Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(mallList);
            }
        });
    }

    public static void deleteAll() {
        Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try {
                    realm.where(Mall.class).findAll().deleteAllFromRealm();
                } catch (Exception e) {

                }
            }
        });
    }

    public static class Request {
        //TODO : add request field here
    }
}
