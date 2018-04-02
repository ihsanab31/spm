package com.sumroch.spotme.activities.notification;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.sumroch.spotme.Constant;
import com.sumroch.spotme.R;
import com.sumroch.spotme.activities.bases.NormalActivity;
import com.sumroch.spotme.models.db.BaseImageUrl;
import com.sumroch.spotme.models.db.PromotionData;

import butterknife.BindView;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */

public class NotificationDetailActivity extends NormalActivity {

    @BindView(R.id.cv_image)
    CardView cvImage;
    @BindView(R.id.iv_event)
    SimpleDraweeView ivEvent;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_expired)
    TextView tvExpired;
    @BindView(R.id.tv_short_description)
    TextView tvShortDescription;

    @Override
    protected boolean isActionBarEnable() {
        return false;
    }

    @Override
    protected int getActivityView() {
        return R.layout.activity_notification_detail;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();
        if (bundle == null) bundle = new Bundle();
//        BeaconDeals beaconDeals = BeaconDeals.getById(bundle.getString(Constant.BEACON_DEALS_ID, ""));
//        if (beaconDeals != null) {
//            tvShortDescription.setText(beaconDeals.getDeals().getName());
//            tvNotificationValueUnit.setText("%");
//            tvTitle.setText(String.valueOf(Math.round(beaconDeals.getDeals().getDiscount())));
//        }
        PromotionData promotionData = PromotionData.getById(bundle.getString(Constant.BEACON_DEALS_ID, ""));
        if (promotionData != null) {
            tvTitle.setText(promotionData.getPromotion().getTitle());
            if (promotionData.getPromotion().getContent() != null)
                tvShortDescription.setText(Html.fromHtml(promotionData.getPromotion().getContent()));

            if (promotionData.getPromotion().getPicture() != null && !promotionData.getPromotion().getPicture().isEmpty() && !promotionData.getPromotion().getPicture().equalsIgnoreCase("placeholder.jpg")) {
                cvImage.setVisibility(View.VISIBLE);
                ivEvent.setImageURI(BaseImageUrl.getData().getPromotion() + promotionData.getPromotion().getPicture());
            }
            tvTitle.setText(promotionData.getPromotion().getTitle());
            tvExpired.setText(promotionData.getPromotion().getExpired());
            tvShortDescription.setText(Html.fromHtml(promotionData.getPromotion().getContent()));
        }
    }
}
