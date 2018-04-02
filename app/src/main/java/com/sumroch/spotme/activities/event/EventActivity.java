package com.sumroch.spotme.activities.event;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.Spinner;

import com.sumroch.spotme.Constant;
import com.sumroch.spotme.R;
import com.sumroch.spotme.activities.bases.NormalActivity;
import com.sumroch.spotme.activities.bases.ToolbarActivity;
import com.sumroch.spotme.adapter.EventAdapter;
import com.sumroch.spotme.api.command.EventCommand;
import com.sumroch.spotme.api.impl.ApiExecutorImpl;
import com.sumroch.spotme.api.interfaces.Callback;
import com.sumroch.spotme.eventbus.OnChangeSelectedMallIndexEvent;
import com.sumroch.spotme.models.db.BaseImageUrl;
import com.sumroch.spotme.models.db.EventData;
import com.sumroch.spotme.models.db.EventItem;
import com.sumroch.spotme.models.db.Mall;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

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

public class EventActivity extends NormalActivity implements AdapterView.OnItemSelectedListener {

    @BindView(R.id.rv_data)
    RecyclerView rvData;
    @BindView(R.id.spinner)
    Spinner spinnerMallName;
    @BindView(R.id.container_toolbar)
    FrameLayout containerToolbar;
    private EventAdapter eventAdapter;
    private List<EventItem> eventItemList;
    private Handler handler;
    private ApiExecutorImpl apiExecutor;
    private ArrayAdapter spinnerAdapter;
    private Bundle bundle;
    private List<Mall> mallList = new ArrayList<>();
    private boolean spinnerInitData;

    @Override
    protected int getActivityView() {
        return R.layout.activity_event;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        handler = new Handler(getMainLooper());
        eventItemList = new ArrayList<>();

        apiExecutor = new ApiExecutorImpl();

        eventAdapter = new EventAdapter();
        rvData.setAdapter(eventAdapter);
        rvData.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvData.setHasFixedSize(true);
        rvData.setNestedScrollingEnabled(false);

        bundle = getIntent().getExtras();

        mallList.addAll(Mall.getMall());
        spinnerAdapter = new ArrayAdapter(EventActivity.this, R.layout.view_spinner_light, android.R.id.text1, Mall.getMallName());
        spinnerAdapter.setDropDownViewResource(R.layout.list_item_spinner);
        spinnerMallName.setAdapter(spinnerAdapter);
        spinnerMallName.setSelection(bundle.getInt(Constant.SELECTED_MALL_INDEX));
        spinnerMallName.setOnItemSelectedListener(EventActivity.this);
        getEventData(String.valueOf(mallList.get(bundle.getInt(Constant.SELECTED_MALL_INDEX)).getId()));

//        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);;
//        Drawable drawable = getDrawable(R.drawable.ic_back_white);
//        drawable.setTint(getColor(R.color.white));
//        getSupportActionBar().setHomeAsUpIndicator(drawable);
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case android.R.id.home:
//                supportFinishAfterTransition();
//                return true;
//            default:
//                return false;
//        }
//    }

    private void getEventData(String id) {
        showProgressDialog("Loading event data...");
        apiExecutor.execute(EventCommand.class, id, new Callback<EventData>() {
            @Override
            public void onSuccess(EventData data) {
                dismissProgressDialog();
                eventItemList.clear();
                eventItemList.addAll(data.getEventItems());
                eventAdapter.setEventItemList(eventItemList);
                eventAdapter.setBaseImageUri(data.getImageUrl());
                BaseImageUrl baseImageUrl = BaseImageUrl.getData();
                baseImageUrl.setEvent(data.getImageUrl());
                BaseImageUrl.add(baseImageUrl);
                eventAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(String message) {
                dismissProgressDialog();
                showMessage(message);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (!spinnerInitData)
            spinnerInitData = true;
        else {
            getEventData(String.valueOf(mallList.get(i).getId()));
            EventBus.getDefault().post(new OnChangeSelectedMallIndexEvent(i));
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    protected boolean isActionBarEnable() {
        return false;
    }

    @OnClick(R.id.back_event)
    void back() {
        supportFinishAfterTransition();
    }
}
