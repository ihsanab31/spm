package com.sumroch.spotme.activities.notification;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ViewAnimator;

import com.facebook.drawee.view.SimpleDraweeView;
import com.sumroch.spotme.Constant;
import com.sumroch.spotme.R;
import com.sumroch.spotme.activities.bases.NormalActivity;
import com.sumroch.spotme.eventbus.OnChangeSelectedMallIndexEvent;
import com.sumroch.spotme.models.BeaconDeals;
import com.sumroch.spotme.models.db.BaseImageUrl;
import com.sumroch.spotme.models.db.Mall;
import com.sumroch.spotme.models.db.Promotion;
import com.sumroch.spotme.models.db.PromotionData;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
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

public class NotificationActivity extends NormalActivity implements AdapterView.OnItemSelectedListener {
    @BindView(R.id.rv_notification)
    RecyclerView rvNotification;
    @BindView(R.id.animator_notification)
    ViewAnimator animator;
    private NotificationListAdapter notificationListAdapter;
    private List<BeaconDeals> beaconDealsList;
    private List<PromotionData> promotionDataList;
    private Handler handler;
    private List<Mall> mallList = new ArrayList<>();
    private ArrayList<String> listMallName = new ArrayList<>();
    private boolean spinnerInitData;
    private ArrayAdapter spinnerAdapter;
    @BindView(R.id.spinner)
    Spinner spinnerMallName;
    @Override
    protected boolean isActionBarEnable() {
        return false;
    }

    @Override
    protected int getActivityView() {
        return R.layout.activity_notification;
    }

    @Override
    protected void onBindView() {
        super.onBindView();
        mallList.addAll(Mall.getMall());
        handler = new Handler(getMainLooper());
        beaconDealsList = new ArrayList<>();
        promotionDataList = new ArrayList<>();
        notificationListAdapter = new NotificationListAdapter(this, promotionDataList);
        rvNotification.setAdapter(notificationListAdapter);
        rvNotification.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvNotification.setHasFixedSize(true);
        rvNotification.setNestedScrollingEnabled(false);
        getNotificationData();
        getMallData();
    }
    private void initSpinnerMallName(List<String> listMallName) {
        spinnerAdapter = new ArrayAdapter(this, R.layout.view_spinner_white, android.R.id.text1, listMallName);
        spinnerAdapter.setDropDownViewResource(R.layout.list_item_spinner);
        spinnerMallName.setAdapter(spinnerAdapter);
        spinnerMallName.setOnItemSelectedListener(this);
    }
    private void getNotificationData() {
        PromotionData.getAll(new RealmChangeListener<RealmResults<PromotionData>>() {
            @Override
            public void onChange(RealmResults<PromotionData> beaconDataList) {
                NotificationActivity.this.promotionDataList.clear();
                NotificationActivity.this.promotionDataList.addAll(beaconDataList);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        notificationListAdapter.notifyDataSetChanged();
                        if (NotificationActivity.this.promotionDataList.size() > 0)
                            animator.setDisplayedChild(1);
                        else
                            animator.setDisplayedChild(2);
                    }
                });
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (!spinnerInitData)
            spinnerInitData = true;
        else {
            EventBus.getDefault().post(new OnChangeSelectedMallIndexEvent(position));
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    private void getMallData() {
        listMallName = Mall.getMallName();
        initSpinnerMallName(listMallName);
    }
    private class NotificationListAdapter extends Adapter<NotificationListAdapter.ViewHolder> {
        private LayoutInflater inflater;
        private List<PromotionData> promotionDataList;

        NotificationListAdapter(Context context, List<PromotionData> promotionDataList) {
            inflater = LayoutInflater.from(context);
            this.promotionDataList = promotionDataList;
        }

        @Override
        public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
            return new ViewHolder(
                    LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.list_item_event, parent, false));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            final PromotionData promotionData = promotionDataList.get(position);
            Promotion promotion = promotionData.getPromotion();
            if (promotion.getPicture() != null && !promotion.getPicture().isEmpty() && !promotion.getPicture().equalsIgnoreCase("placeholder.jpg")) {
                holder.layoutImage.setVisibility(View.VISIBLE);
                holder.layoutData.setVisibility(View.GONE);
                holder.ivEvent.setImageURI(BaseImageUrl.getData().getPromotion() + promotion.getPicture());
            } else {
                holder.layoutImage.setVisibility(View.GONE);
                holder.layoutData.setVisibility(View.VISIBLE);
                holder.tvTitle.setText(promotion.getTitle());
                holder.tvExpired.setText(promotion.getExpired());
                if (promotion.getShort_description() != null && !promotion.getShort_description().isEmpty())
                    holder.tvShortDescription.setText(Html.fromHtml(promotion.getShort_description()));
                else
                    holder.tvShortDescription.setText(Html.fromHtml(promotion.getContent()));
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(NotificationActivity.this, NotificationDetailActivity.class);
                    intent.putExtra(Constant.BEACON_DEALS_ID, promotionData.getId());
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return promotionDataList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            ConstraintLayout layoutImage;
            ConstraintLayout layoutData;
            SimpleDraweeView ivEvent;
            TextView tvTitle;
            TextView tvExpired;
            TextView tvShortDescription;

            public ViewHolder(View itemView) {
                super(itemView);
                layoutImage = (ConstraintLayout) itemView.findViewById(R.id.layout_image);
                layoutData = (ConstraintLayout) itemView.findViewById(R.id.layout_data);
                ivEvent = (SimpleDraweeView) itemView.findViewById(R.id.iv_event);
                tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
                tvExpired = (TextView) itemView.findViewById(R.id.tv_expired);
                tvShortDescription = (TextView) itemView.findViewById(R.id.tv_short_description);

            }
        }
    }
}
