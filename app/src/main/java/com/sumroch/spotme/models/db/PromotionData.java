package com.sumroch.spotme.models.db;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmObject;
import io.realm.RealmResults;
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
public class PromotionData extends RealmObject {

    @PrimaryKey
    private String id;
    private String beacon_id;
    private String promotion_id;
    private String created_at;
    private String updated_at;
    private Promotion promotion;

    public static void getAll(RealmChangeListener<RealmResults<PromotionData>> realmChangeListener) {
        Realm.getDefaultInstance().where(PromotionData.class).findAllAsync().addChangeListener(realmChangeListener);
    }

    public static PromotionData getById(String id) {
        return Realm.getDefaultInstance().where(PromotionData.class).equalTo("id", id, Case.INSENSITIVE).findFirst();
    }

    public static void deleteById(final String id) {
        Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.where(PromotionData.class).equalTo("id", id).findFirst().deleteFromRealm();
            }
        });
    }
}
