package com.sumroch.spotme.models.db;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
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
public class BeaconData extends RealmObject {

    @PrimaryKey
    private String id;
    private String name;
    private String uuid;
    private String major;
    private String minor;
    private String x_position;
    private String y_position;
    private String position;
    private String created_at;
    private String updated_at;
    @SerializedName("promotions")
    private RealmList<PromotionData> promotionData;

    public static BeaconData getFirst() {
        return Realm.getDefaultInstance().where(BeaconData.class).findFirst();
    }

    public static void add(final BeaconData beaconData) {
        Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(beaconData);
            }
        });
    }

    public static void addAll(final List<BeaconData> beaconDataList) {
        Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(beaconDataList);
            }
        });
    }

    public static void deleteAll() {
        Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.where(Promotion.class).findAll().deleteAllFromRealm();
                realm.where(PromotionData.class).findAll().deleteAllFromRealm();
                realm.where(BeaconData.class).findAll().deleteAllFromRealm();
            }
        });
    }

    public static void deleteById(final String id) {
        Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.where(BeaconData.class).equalTo("id", id).findFirst().deleteFromRealm();
            }
        });
    }

    @Data
    @NoArgsConstructor
    public static class Request {
        private String uuid;
        private String limit;
        private String offset;
        private long last_request;
    }
}
