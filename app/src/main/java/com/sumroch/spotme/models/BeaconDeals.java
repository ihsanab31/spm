package com.sumroch.spotme.models;

import java.util.List;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmObject;
import io.realm.RealmResults;
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

public class BeaconDeals extends RealmObject {
    @PrimaryKey
    private String id;
    private BeaconSubscription beaconSubscription;
    private Deals deals;
    private long detectedTime;
    private boolean read;

    public static void save(final BeaconDeals beaconDeals) {
        Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(beaconDeals);
            }
        });
    }

    public static BeaconDeals getById(String id) {
        return Realm.getDefaultInstance().where(BeaconDeals.class).equalTo("id", id, Case.INSENSITIVE).findFirst();
    }

    public static BeaconDeals getBy(String key, String value) {
        return Realm.getDefaultInstance().where(BeaconDeals.class).equalTo(key, value, Case.INSENSITIVE).findFirst();
    }

    public static void deleteBeaconDeals(final String uniqueId) {
        Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                BeaconDeals beaconDeals = Realm.getDefaultInstance().where(BeaconDeals.class).equalTo("id", uniqueId, Case.INSENSITIVE).findFirst();
                if (beaconDeals != null)
                    beaconDeals.deleteFromRealm();
            }
        });
    }

    public static void getAll(RealmChangeListener<RealmResults<BeaconDeals>> realmChangeListener) {
        Realm.getDefaultInstance().where(BeaconDeals.class).findAllAsync().addChangeListener(realmChangeListener);
    }

    public static long countUnReadDeals() {
        return Realm.getDefaultInstance().where(BeaconDeals.class).equalTo("read", false).count();
    }

    public static List<BeaconDeals> getUnReadDeals() {
        return Realm.getDefaultInstance().where(BeaconDeals.class).equalTo("read", false).findAll();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setId() {
        this.id = beaconSubscription.getBeaconId() + "|" + deals.getId();
    }

    public BeaconSubscription getBeaconSubscription() {
        return beaconSubscription;
    }

    public void setBeaconSubscription(BeaconSubscription beaconSubscription) {
        this.beaconSubscription = beaconSubscription;
    }

    public Deals getDeals() {
        return deals;
    }

    public void setDeals(Deals deals) {
        this.deals = deals;
    }

    public long getDetectedTime() {
        return detectedTime;
    }

    public void setDetectedTime(long detectedTime) {
        this.detectedTime = detectedTime;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }
}
