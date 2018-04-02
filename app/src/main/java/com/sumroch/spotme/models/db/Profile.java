package com.sumroch.spotme.models.db;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.view.View;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import id.zelory.compressor.Compressor;
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
public class Profile extends RealmObject {

    @SerializedName("token")
    @Expose
    public String token;
    @PrimaryKey
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("role")
    @Expose
    private Integer role;
    @SerializedName("remember_token")
    @Expose
    private String rememberToken;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("jenis_kelamin")
    @Expose
    private String jenisKelamin;
    @SerializedName("no_hp")
    @Expose
    private String noHp;
    @SerializedName("photo")
    @Expose
    private String photo;
    @SerializedName("id_survey_interest")
    @Expose
    private String idSurveyInterest;

    public static void add(final Profile profile) {
        Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(profile);
            }
        });
    }

    public static void deleteAll() {
        Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try {

                } catch (Exception e) {

                }
                realm.where(Profile.class).findAll().deleteAllFromRealm();
            }
        });
    }

    public static Profile findFirst() {
        Realm realm = Realm.getDefaultInstance();
        Profile profile = realm.where(Profile.class).findFirst();
        if (profile != null)
            return realm.copyFromRealm(profile);
        else
            return null;
    }

    public static void updatePhotoFromUri(final Context context, String stringUri){
        ImageLoader.getInstance().loadImage(stringUri, new SimpleImageLoadingListener() {
            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                try {
                    File dir = new File(Environment.getExternalStorageDirectory().getPath());
                    File file = File.createTempFile(UUID.randomUUID().toString(), ".jpg", dir);
                    file.createNewFile();
                    FileOutputStream ostream = new FileOutputStream(file);
                    loadedImage.compress(Bitmap.CompressFormat.JPEG, 100, ostream);
                    ostream.close();
                    File compressToFile = new Compressor(context).compressToFile(file);
                    findFirst().setPhoto(compressToFile.getPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
