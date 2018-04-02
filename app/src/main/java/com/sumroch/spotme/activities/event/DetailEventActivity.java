package com.sumroch.spotme.activities.event;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.sumroch.spotme.R;
import com.sumroch.spotme.activities.bases.NormalActivity;
import com.sumroch.spotme.activities.bases.ToolbarActivity;
import com.sumroch.spotme.models.db.BaseImageUrl;
import com.sumroch.spotme.models.db.EventItem;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */

public class DetailEventActivity extends NormalActivity {

    public static final String EVENT_ITEM = "event_item";

    @BindView(R.id.tv_toolbar)
    TextView tvToolbar;
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
    protected int getActivityView() {
        return R.layout.activity_detail_entevent;
    }


    @Override
    protected boolean isActionBarEnable() {
        return false;
    }

    @Override
    protected void onBindView() {
        super.onBindView();

//        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
//        Drawable drawable = getDrawable(R.drawable.ic_back_white);
//        drawable.setTint(getColor(R.color.white));
//        getSupportActionBar().setHomeAsUpIndicator(drawable);

        EventItem eventItem = Parcels.unwrap(getIntent().getParcelableExtra(EVENT_ITEM));

        if (eventItem != null) {
            tvToolbar.setText(eventItem.getNamaEvent());
            if (eventItem.getPicture() != null && !eventItem.getPicture().isEmpty() && !eventItem.getPicture().equalsIgnoreCase("placeholder.jpg")) {
                cvImage.setVisibility(View.VISIBLE);
                ivEvent.setImageURI(BaseImageUrl.getData().getEvent() + eventItem.getPicture());
            }
            tvTitle.setText(eventItem.getNamaEvent());
            tvExpired.setText(eventItem.getWaktuEvent());
            tvShortDescription.setText(eventItem.getShortDescription());
        }
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                supportFinishAfterTransition();
//                return true;
//            default:
//                return false;
//        }
//    }
    @OnClick(R.id.back_event_detail)
    void back(){
        supportFinishAfterTransition();
    }
}
