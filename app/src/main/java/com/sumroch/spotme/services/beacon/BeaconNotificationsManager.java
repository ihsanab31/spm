package com.sumroch.spotme.services.beacon;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.estimote.coresdk.observation.region.beacon.BeaconRegion;
import com.estimote.coresdk.recognition.packets.Beacon;
import com.estimote.coresdk.service.BeaconManager;
import com.sumroch.spotme.SpotMe;
import com.sumroch.spotme.activities.notification.NotificationActivity;
import com.sumroch.spotme.api.command.BeaconDataCommand;
import com.sumroch.spotme.api.impl.ApiExecutorImpl;
import com.sumroch.spotme.api.interfaces.Callback;
import com.sumroch.spotme.models.db.BeaconData;
import com.sumroch.spotme.models.db.Profile;
import com.sumroch.spotme.models.db.Promotion;
import com.sumroch.spotme.models.db.PromotionData;

import java.util.List;
import java.util.UUID;
/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */
public class BeaconNotificationsManager implements BeaconManager.BeaconMonitoringListener, BeaconManager.BeaconRangingListener {
    private static final String BEACON_NOTIFICATION_GROUP = "spotMeBeacon";
    private static final long TIMEOUT = 60000 * 3; // 10 minute
    private final ApiExecutorImpl apiExecutor;
    BeaconData.Request request = new BeaconData.Request();
    private Context context;
    private BeaconManager beaconManager;
    //    private ArrayMap<String, Long> detectedBeacons = new ArrayMap<>();
//    private ArrayMap<String, Deals> dummyBeaconDeals = new ArrayMap<>();

    public BeaconNotificationsManager(Context context) {
        this.context = context;
        beaconManager = new BeaconManager(context);
        beaconManager.setMonitoringListener(this);
        beaconManager.setRangingListener(this);
//        setDummyBeaconDeals();

        apiExecutor = new ApiExecutorImpl();
    }

    public void startMonitoring() {
        beaconManager.connect(new BeaconManager.ServiceReadyCallback() {
            @Override
            public void onServiceReady() {
                beaconManager.startMonitoring(new BeaconRegion("monitored region",
                        UUID.fromString("B9407F30-F5F8-466E-AFF9-25556B57FE6D"), null, null));
            }
        });
    }

    @Override
    public void onEnteredRegion(BeaconRegion beaconRegion, List<Beacon> beacons) {
        SpotMe.log("Enter Region : " + beaconRegion.toString());
        beaconManager.startRanging(beaconRegion);

        if (Profile.findFirst() != null)
            checkBeaconData(beaconRegion);
    }

    private void checkBeaconData(BeaconRegion beaconRegion) {
        long currentTime = SystemClock.uptimeMillis();
        long lastRequest = request.getLast_request();
        if ((currentTime - lastRequest) >= TIMEOUT) {
            request.setUuid(beaconRegion.getProximityUUID().toString());
//            request.setLimit("5");
//            request.setOffset("0");
            request.setLast_request(currentTime);
            apiExecutor.execute(BeaconDataCommand.class, request, new Callback<List<BeaconData>>() {
                @Override
                public void onSuccess(List<BeaconData> data) {
                    BeaconData beaconData = data.get(0);
                    if (BeaconData.getFirst() == null) {
                        BeaconData.add(beaconData);
                        if (beaconData.getPromotionData().size() > 1) {
                            showGroupNotification(beaconData);
                        } else {
                            Promotion promotion = beaconData.getPromotionData().get(0).getPromotion();
                            showNotification(promotion.getTitle(), Integer.valueOf(promotion.getId()), promotion.getTitle());
                        }
                    } else if (!BeaconData.getFirst().getUpdated_at().equals(beaconData.getUpdated_at())) {
                        BeaconData.deleteAll();
                        BeaconData.add(beaconData);
                        if (beaconData.getPromotionData().size() > 1) {
                            showGroupNotification(beaconData);
                        } else {
                            Promotion promotion = beaconData.getPromotionData().get(0).getPromotion();
                            showNotification(promotion.getTitle(), Integer.valueOf(promotion.getId()), promotion.getTitle());
                        }
                    }
                }

                @Override
                public void onFailure(String message) {

                }
            });
        }
    }

    @Override
    public void onExitedRegion(BeaconRegion beaconRegion) {
        SpotMe.log("Exit Region : " + beaconRegion.toString());
        beaconManager.stopRanging(beaconRegion);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.cancelAll();
    }

    @Override
    public void onBeaconsDiscovered(BeaconRegion beaconRegion, List<Beacon> beacons) {
        if (Profile.findFirst() != null)
            checkBeaconData(beaconRegion);
//        for (Beacon beacon : beacons) {
//            final String uniqueId = getBeaconSerial(beacon);
//            if (RegionUtils.computeProximity(beacon) != Proximity.FAR) {
//                BeaconDeals beaconDeals = BeaconDeals.getBy("beaconSubscription.beaconId", uniqueId);
//                if (beaconDeals != null) {
//                    if ((System.currentTimeMillis() - beaconDeals.getDetectedTime()) >= TIMEOUT) {
//                        BeaconDeals newBeaconDeals = new BeaconDeals();
//                        newBeaconDeals.setDetectedTime(System.currentTimeMillis());
//                        newBeaconDeals.setBeaconSubscription(beaconDeals.getBeaconSubscription());
//                        newBeaconDeals.setDeals(beaconDeals.getDeals());
//                        newBeaconDeals.setId();
//                        BeaconDeals.save(newBeaconDeals);
//                        if (BeaconDeals.countUnReadDeals() > 1)
//                            showGroupNotification();
//                        else
//                            showNotification("Nearby Deals", dummyBeaconDeals.get(uniqueId).getId(), dummyBeaconDeals.get(uniqueId).getName());
//                    }
//                } else {
//                    BeaconSubscription beaconSubscription = new BeaconSubscription();
//                    beaconSubscription.setMajor(beacon.getMajor());
//                    beaconSubscription.setMinor(beacon.getMinor());
//                    beaconSubscription.setUuid(beacon.getProximityUUID().toString());
//                    beaconSubscription.setBeaconId();
//
//                    beaconDeals = new BeaconDeals();
//                    beaconDeals.setDeals(dummyBeaconDeals.get(uniqueId));
//                    beaconDeals.setDetectedTime(System.currentTimeMillis());
//                    beaconDeals.setBeaconSubscription(beaconSubscription);
//                    beaconDeals.setId();
//                    BeaconDeals.save(beaconDeals);
//                    if (BeaconDeals.countUnReadDeals() > 1) {
//                        showGroupNotification();
//                    } else {
//                        showNotification("Nearby Deals", dummyBeaconDeals.get(uniqueId).getId(), dummyBeaconDeals.get(uniqueId).getName());
//                    }
//                }
//            } else {
//                Realm.getDefaultInstance().executeTransaction(new Realm.Transaction() {
//                    @Override
//                    public void execute(Realm realm) {
//                        BeaconDeals beaconDeals = Realm.getDefaultInstance().where(BeaconDeals.class).equalTo("beaconSubscription.beaconId", uniqueId, Case.INSENSITIVE).findFirst();
//                        if (beaconDeals != null) {
//                            beaconDeals.deleteFromRealm();
//                        }
//                    }
//                });
//            }
//        }
    }

    private void showNotification(String title, int id, String message) {
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.cancelAll();
        Intent intent = new Intent(context, NotificationActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle(title)
                .setContentText(message)
                .setGroupSummary(true)
                .setGroup(BEACON_NOTIFICATION_GROUP)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(resultPendingIntent);
        notificationManager.notify(id, builder.build());
//        SpotMe.log("Beacon Detection : " + message);
    }

    private void showGroupNotification(BeaconData beaconData) {
        Intent intent = new Intent(context, NotificationActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.cancelAll();

        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();

//        List<BeaconDeals> beaconDealsList = BeaconDeals.getUnReadDeals();
//        for (BeaconDeals beaconDeals : beaconDealsList) {
//            inboxStyle.addLine(beaconDeals.getDeals().getName());
//        }
        for (PromotionData promotionData : beaconData.getPromotionData()) {
            inboxStyle.addLine(promotionData.getPromotion().getTitle());
        }
//        String title = beaconDealsList.size() + " Nearby Deals";
        inboxStyle.setBigContentTitle(beaconData.getName());
        inboxStyle.setSummaryText("SpotMe");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentTitle(beaconData.getName())
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setStyle(inboxStyle)
                .setGroup(BEACON_NOTIFICATION_GROUP)
                .setAutoCancel(true)
                .setContentIntent(resultPendingIntent)
                .setDefaults(Notification.DEFAULT_ALL)
                .setGroupSummary(true)
                .setNumber(beaconData.getPromotionData().size());
//                .setNumber(beaconDealsList.size());
        notificationManager.notify(877, builder.build());
    }

    private String getBeaconSerial(Beacon beacon) {

        String uuid = String.valueOf(beacon.getProximityUUID().toString().toLowerCase());
        String major = String.valueOf(beacon.getMajor());
        String minor = String.valueOf(beacon.getMinor());
        return uuid + "#" + major + "#" + minor;
    }

//    private void setDummyBeaconDeals() {
//        String beacon1 = "b9407f30-f5f8-466e-aff9-25556b57fe6d#13076#41945";
//        String beacon2 = "b9407f30-f5f8-466e-aff9-25556b57fe6d#48386#11932";
//        String beacon3 = "b9407f30-f5f8-466e-aff9-25556b57fe6d#18358#55308";
//
//        dummyBeaconDeals.put(beacon1, new Deals(1, "Men Flannel Checked Long-Sleeve", 50d));
//        dummyBeaconDeals.put(beacon2, new Deals(2, "Zara Animal Print Shirt In Blue", 20d));
//        dummyBeaconDeals.put(beacon3, new Deals(3, "Men Military Work Long Sleeve Shirt", 70d));
//    }

}
