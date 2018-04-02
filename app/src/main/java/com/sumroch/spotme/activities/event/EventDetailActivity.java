package com.sumroch.spotme.activities.event;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.widget.TextView;

import com.sumroch.spotme.Constant;
import com.sumroch.spotme.R;
import com.sumroch.spotme.activities.bases.NormalActivity;
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

public class EventDetailActivity extends NormalActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
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
        PromotionData promotionData = PromotionData.getById(bundle.getString(Constant.BEACON_DEALS_ID, ""));
        if (promotionData != null) {
            tvTitle.setText(promotionData.getPromotion().getTitle());
            if (promotionData.getPromotion().getContent() != null)
                tvShortDescription.setText(Html.fromHtml(promotionData.getPromotion().getContent()));
        }
    }
}
