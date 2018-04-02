package com.sumroch.spotme.models.db;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.Realm;
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
public class BaseImageUrl extends RealmObject {

    @PrimaryKey
    @SerializedName("user")
    @Expose
    private String user;
    @SerializedName("mall")
    @Expose
    private String mall;
    private String event;
    private String promotion = "http://api.sumroch.com/file/promotion_picture?path=";

    public static void add(final BaseImageUrl baseImageUrl) {
        Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(baseImageUrl);
            }
        });
    }

    public static void deleteAll() {
        Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try {
                    realm.where(BaseImageUrl.class).findAll().deleteAllFromRealm();
                } catch (Exception e) {

                }
            }
        });
    }

    public static BaseImageUrl getData() {
        Realm realm = Realm.getDefaultInstance();
        return realm.copyFromRealm(realm.where(BaseImageUrl.class).findFirst());
    }
}
