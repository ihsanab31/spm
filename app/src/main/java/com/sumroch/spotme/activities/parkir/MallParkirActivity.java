package com.sumroch.spotme.activities.parkir;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.MenuItem;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.sumroch.spotme.Constant;
import com.sumroch.spotme.R;
import com.sumroch.spotme.activities.bases.NormalActivity;
import com.sumroch.spotme.models.db.BaseImageUrl;
import com.sumroch.spotme.models.db.Mall;

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

public class MallParkirActivity extends NormalActivity implements OnMapReadyCallback {

    @BindView(R.id.iv_pin)
    SimpleDraweeView ivBanner;
    @BindView(R.id.tv_mall_name)
    TextView tvMallName;
    @BindView(R.id.tv_mall_address)
    TextView tvMallAddess;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_short_description)
    TextView tvShortDescription;
    @BindView(R.id.tv_space)
    TextView tvSpace;

    Mall mall;
    private int id;

    @Nullable
    private GoogleMap googleMap;


    @Override
    protected int getActivityView() {
        return R.layout.activity_mall_parkir;
    }

    @Override
    protected boolean isActionBarEnable() {
        return false;
    }

    @Override
    protected void onBindView() {
        super.onBindView();

        id = getBundle().getInt(Constant.ID);

        if (id >= 0) {
            mall = Mall.getMallById(id);
            ivBanner.setImageURI(BaseImageUrl.getData().getMall() + mall.getPicture());
            tvMallName.setText(mall.getName());
            tvTitle.setText(mall.getName());
            tvMallAddess.setText(mall.getAddress());
            tvShortDescription.setText(mall.getDescription());
            tvSpace.setText(Html.fromHtml(String.format("<b>%1$s</b>/%2$s", mall.getAvailableSpace(), mall.getTotalSpace())));

//            List<HistoryParkir> historyParkirList = HistoryParkir.getData(mall.getName());
//            if (historyParkirList != null && historyParkirList.size() > 0) {
//                HistoryParkirAdapter adapter = new HistoryParkirAdapter();
//                adapter.setData(historyParkirList);
//                lvData.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
//                    @Override
//                    public void onLayoutChange(View view, int i, int i1, int i2, int bottom, int i4, int i5, int i6, int old_bottom) {
//                        ViewGroup.LayoutParams params = lvData.getLayoutParams();
//                        params.height += bottom - old_bottom;
//                        lvData.setLayoutParams(params);
//                        lvData.requestLayout();
//                    }
//                });
//                lvData.setAdapter(adapter);
//                lvData.setNestedScrollingEnabled(true);
//            }
        }

//        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
//        Drawable drawable = getDrawable(R.drawable.ic_back_white);
//        drawable.setTint(getColor(R.color.black));
//        getSupportActionBar().setHomeAsUpIndicator(drawable);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                supportFinishAfterTransition();
                return true;
            default:
                return false;
        }
    }

    @OnClick(R.id.btn_reserve)
    public void onClick() {
        Intent intent = new Intent(this, ReserveParkirActivity.class);
        intent.putExtra(Constant.SELECTED_MALL_INDEX, getBundle().getInt(Constant.SELECTED_MALL_INDEX));
        intent.putExtra(Constant.ID, mall.getId());
        startActivity(intent);

    }

    @OnClick(R.id.btn_kembali)
    void kembali() {
        startActivity(new Intent(getApplicationContext(), ListMallParkirActivity.class));
        finish();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

        LatLng mallLocation = new LatLng(mall.getLatitude(), mall.getLongitude());
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(mallLocation, 15f));

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(mallLocation);
        googleMap.addMarker(markerOptions);
    }
}
