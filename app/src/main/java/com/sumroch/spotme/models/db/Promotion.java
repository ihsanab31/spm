package com.sumroch.spotme.models.db;

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
public class Promotion extends RealmObject {

    @PrimaryKey
    private String id;
    private String title;
    private String short_description;
    private String content;
    private String picture;
    private String url;
    private String expired;
    private String created_at;
    private String updated_at;
    private float discount;

    public static void deleteById(final String id) {
        Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.where(PromotionData.class).equalTo("id", id).findFirst().deleteFromRealm();
            }
        });
    }
}
