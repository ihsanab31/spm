package com.sumroch.spotme.models;

import io.realm.Realm;
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
public class BeaconSubscription extends RealmObject {
    @PrimaryKey
    private String beaconId;
    private String uuid;
    private int major;
    private int minor;

    public static void add(final BeaconSubscription beaconSubscription) {
        Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(beaconSubscription);
            }
        });
    }

    public static boolean isBeaconSubscribe(String beaconId) {
        BeaconSubscription beacon = Realm.getDefaultInstance().where(BeaconSubscription.class).equalTo("beaconId", beaconId).findFirst();
        return beacon != null;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getMajor() {
        return major;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public int getMinor() {
        return minor;
    }

    public void setMinor(int minor) {
        this.minor = minor;
    }

    public String getBeaconId() {
        return beaconId;
    }

    public void setBeaconId(String beaconId) {
        this.beaconId = beaconId;
    }

    public void setBeaconId() {
        this.beaconId = uuid + "#" + major + "#" + minor;
    }
}
