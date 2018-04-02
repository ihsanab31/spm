package com.sumroch.spotme.services.beacon;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.estimote.coresdk.common.config.EstimoteSDK;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.sumroch.spotme.Constant;
import com.sumroch.spotme.SpotMe;
import com.sumroch.spotme.activities.event.EventActivity;
import com.sumroch.spotme.activities.notification.NotificationActivity;
import com.sumroch.spotme.models.db.EventData;
import com.sumroch.spotme.models.db.EventItem;
import com.sumroch.spotme.models.db.Mall;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */

public class SpotMeService extends Service implements LocationListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private static final long INTERVAL = 60000 * 10; //10minute
    private static final long FASTEST_INTERVAL = 60000 * 10; //10minute
    private SpotMe spotMe;
    private List<EventItem> eventItemList;
    private LocationRequest mLocationRequest;
    private GoogleApiClient mGoogleApiClient;
    private Location myLocation;
    private List<Mall> malls;
    private Mall lastMall;
    private  int h=0;
    Date date = new Date();  // to get the date
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // getting date in this format
    String formattedDate = df.format(date.getTime());
    private EventItem lastEvent;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        spotMe = (SpotMe) getApplicationContext();
        getMallData();
//        getEventData();
        EstimoteSDK.initialize(spotMe, "notification-demo--0ef", "7c7d39d735afa96ff6881b2edbeefdcf");
        if (!spotMe.isBeaconNotificationsEnabled())
            spotMe.enableBeaconNotifications();
        setupFusedLocation();
        return START_STICKY;
    }

    private void showNotification(Mall mall, String message) {
        lastMall = mall;
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(spotMe);
        notificationManager.cancelAll();
        Intent intent = new Intent(spotMe, NotificationActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(spotMe, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(spotMe)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle(mall.getName())
                .setContentText(message)
                .setGroupSummary(true)
                .setGroup(Constant.GEO_LOCATION_NOTIFICATION_GROUP)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(resultPendingIntent);
        notificationManager.notify(mall.getId(), builder.build());
    }

    private void showNotificationEvent(EventItem eventItem, String message) {
        lastEvent = eventItem;
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(spotMe);
        notificationManager.cancelAll();
        Intent intent = new Intent(spotMe, EventActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(spotMe, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(spotMe)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle(eventItem.getNamaEvent())
                .setContentText(message)
                .setGroupSummary(true)
                .setGroup(Constant.GEO_LOCATION_NOTIFICATION_GROUP)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(resultPendingIntent);
        notificationManager.notify(eventItem.getId(), builder.build());
    }

    /**
     * for setup fused location
     */
    private void setupFusedLocation() {
        mLocationRequest = LocationRequest.create();
        mLocationRequest.setInterval(INTERVAL);
        mLocationRequest.setFastestInterval(FASTEST_INTERVAL);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mGoogleApiClient = new GoogleApiClient.Builder(spotMe).addApi(LocationServices.API)
                .addConnectionCallbacks(this).addOnConnectionFailedListener(this).build();
        mGoogleApiClient.connect();
    }

    private void getMallData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                new Handler(spotMe.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (myLocation != null) {
                            Mall.getMall(new RealmChangeListener<RealmResults<Mall>>() {
                                @Override
                                public void onChange(RealmResults<Mall> mallsData) {
                                    malls = Realm.getDefaultInstance().copyFromRealm(mallsData);
                                }
                            });
//                            malls = Mall.getDummyMall();

                            if (malls != null) {
                                for (int i = 0; i < malls.size(); i++) {
                                    Location mallLocation = new Location("");
                                    mallLocation.setLatitude(malls.get(i).getLatitude());
                                    mallLocation.setLongitude(malls.get(i).getLongitude());
                                    malls.get(i).setDistance(Double.valueOf(myLocation.distanceTo(mallLocation) / 1000));
                                    if (malls.get(i).getDistance() <= 0.1) {
                                        showNotification(malls.get(i), String.format("Selamat Datang di %s", malls.get(i).getName()));
                                    }else if (malls.get(i).getDistance() <= 0.5) {
                                        showNotification(malls.get(i), String.format("Jangan Lewatkan Promosi di %s", malls.get(i).getName()));
                                    } else if (malls.get(i).getDistance() <= 1) {
                                        showNotification(malls.get(i), String.format("Jangan Lupa mampir ke %s", malls.get(i).getName()));
                                    }
                                }
                                Collections.sort(malls, new Comparator<Mall>() {
                                    @Override
                                    public int compare(Mall mall1, Mall mall2) {
                                        return mall1.getDistance().compareTo(mall2.getDistance());
                                    }
                                });
                                if (lastMall == null) {
                                    Mall nearestMall = malls.get(0);
                                    if (nearestMall.getDistance() <= 0.1) {
                                        showNotification(nearestMall, String.format("Selamat datang di %s", nearestMall.getName()));
                                    } else if (nearestMall.getDistance() <= 0.5) {
                                        showNotification(nearestMall, String.format("Jangan lewatkan promosi di %s", nearestMall.getName()));
                                    } else if (nearestMall.getDistance() <= 1) {
                                        showNotification(nearestMall, String.format("Jangan Lupa mampir ke %s", nearestMall.getName()));
                                    }
                                } else {
                                    Mall nearestMall = malls.get(0);
                                    if (nearestMall.getId() != lastMall.getId())
                                        if (nearestMall.getDistance() <= 0.1 && lastMall.getDistance() > 0.1) {
                                            showNotification(nearestMall, String.format("Selamat datang di %s", nearestMall.getName()));
                                        } else if (nearestMall.getDistance() <= 0.5 && lastMall.getDistance() > 0.5) {
                                            showNotification(nearestMall, String.format("Jangan lewatkan promosi di %s", nearestMall.getName()));
                                        } else if (nearestMall.getDistance() <= 1 && lastMall.getDistance() > 1) {
                                            showNotification(nearestMall, String.format("Jangan Lupa mampir ke %s", nearestMall.getName()));
                                        }
                                }
                            }
                        }
                    }
                }, 300);
            }
        }).start();
    }

//    private void getEventData() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                new Handler(spotMe.getMainLooper()).postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        if (myLocation != null) {
//                            EventItem.getEvent(new RealmChangeListener<RealmResults<EventItem>>() {
//                                @Override
//                                public void onChange(RealmResults<EventItem> eventData) {
//                                    eventItemList = Realm.getDefaultInstance().copyFromRealm(eventData);
//                                }
//                            });
//                            if (eventItemList != null) {
//                                for (int i = 0; i < eventItemList.size(); i++) {
//                                    if (eventItemList.get(i).getWaktuEvent().equalsIgnoreCase("2018-01-26 11:27:00")) {
//                                        showNotificationEvent(eventItemList.get(i), String.format("Event Segera Berakhir %s", eventItemList.get(i).getNamaEvent()));
//                                    }
//                                }
//                            }
//
//                        }
//                    }
//                }, 300);
//            }
//        }).start();
//    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        myLocation = location;
        getMallData();
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onConnected(@Nullable Bundle bundle) {
        try {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        } catch (Exception e) {
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
