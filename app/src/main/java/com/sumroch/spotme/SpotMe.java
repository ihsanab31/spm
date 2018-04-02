package com.sumroch.spotme;

import android.app.Application;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.multidex.MultiDexApplication;
import android.text.TextUtils;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.crashlytics.android.Crashlytics;
import com.estimote.coresdk.common.config.EstimoteSDK;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.stetho.Stetho;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.sumroch.spotme.services.beacon.BeaconNotificationsManager;
import com.sumroch.spotme.services.beacon.SpotMeService;
import com.tsengvn.typekit.Typekit;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import io.fabric.sdk.android.Fabric;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.exceptions.RealmFileException;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */

public class SpotMe extends MultiDexApplication {
    public static final String TAG = SpotMe.class.getSimpleName();
    private static SpotMe mInstance;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;
    private boolean beaconNotificationsEnabled = false;

    public static synchronized SpotMe getInstance() {
        return mInstance;
    }

    public static void log(String message) {
        if (BuildConfig.BUILD_TYPE.equalsIgnoreCase("debug")) {
            Log.d("SpotMe", message);
        }
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        Fabric.with(this, new Crashlytics());
        Fresco.initialize(this);
        //image loader config
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .defaultDisplayImageOptions(
                        new DisplayImageOptions.Builder()
                                .cacheInMemory(true)
                                .cacheOnDisk(true)
                                .bitmapConfig(Bitmap.Config.RGB_565)
                                .build()
                ).build();
        ImageLoader.getInstance().init(config); // init image loader
        EstimoteSDK.initialize(getApplicationContext(), "notification-demo--0ef", "7c7d39d735afa96ff6881b2edbeefdcf");

        Realm.init(this);
        RealmConfiguration ralmConfig = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(ralmConfig);
        try {
            Realm.getDefaultInstance();
        } catch (RealmFileException e) {
            Realm.deleteRealm(ralmConfig);
        }

        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                        .build()
        );

        Typekit.getInstance()
                .addNormal(Typekit.createFromAsset(this, "fonts/Quicksand-Regular.ttf"))
                .addBold(Typekit.createFromAsset(this, "fonts/Quicksand-Bold.ttf"))
                .addItalic(Typekit.createFromAsset(this, "fonts/OpenSans-Italic.ttf"))
                .addBoldItalic(Typekit.createFromAsset(this, "fonts/OpenSans-BoldItalic.ttf"))
                .add("consolas", Typekit.createFromAsset(this, "fonts/Consolas.ttf"))
                .add("medium", Typekit.createFromAsset(this, "fonts/Quicksand-Medium.ttf"))
                .add("light", Typekit.createFromAsset(this, "fonts/Quicksand-Light.ttf"));

        startService(new Intent(this, SpotMeService.class));

    }

    public void enableBeaconNotifications() {
        if (beaconNotificationsEnabled) {
            return;
        }

        BeaconNotificationsManager beaconNotificationsManager = new BeaconNotificationsManager(this);
        beaconNotificationsManager.startMonitoring();

        beaconNotificationsEnabled = true;
    }

    public boolean isBeaconNotificationsEnabled() {
        return beaconNotificationsEnabled;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}
