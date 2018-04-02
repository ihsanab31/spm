package com.sumroch.spotme.activities.parkir;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;

import com.sumroch.spotme.Constant;
import com.sumroch.spotme.R;
import com.sumroch.spotme.activities.bases.NormalActivity;
import com.sumroch.spotme.adapter.ParkirLocationItemAdapter;
import com.sumroch.spotme.api.command.ParkirLocationCommand;
import com.sumroch.spotme.api.impl.ApiExecutorImpl;
import com.sumroch.spotme.api.interfaces.Callback;
import com.sumroch.spotme.eventbus.OnChangeSelectedMallIndexEvent;
import com.sumroch.spotme.models.db.Mall;
import com.sumroch.spotme.models.db.ParkirLocation;

import org.greenrobot.eventbus.EventBus;

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

public class AvailableParkirActivity extends NormalActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {


    @BindView(R.id.spinner)
    Spinner spinnerMallName;

    @BindView(R.id.gv_data)
    GridView gvData;
    List<ParkirLocation> mData;
    private ApiExecutorImpl apiExecutor;
    private ParkirLocationItemAdapter adapter;
    private ArrayAdapter spinnerAdapter;
    private boolean spinnerInitData;
    private int id;


    @Override
    protected int getActivityView() {
        return R.layout.activity_available_parkir;
    }

    @Override
    protected boolean isActionBarEnable() {
        return false;
    }

    @Override
    protected void onBindView() {
        super.onBindView();

        apiExecutor = new ApiExecutorImpl();

        spinnerAdapter = new ArrayAdapter(this, R.layout.view_spinner_dark_pure, android.R.id.text1, Mall.getMallName());
        spinnerAdapter.setDropDownViewResource(R.layout.list_item_spinner);
        spinnerMallName.setAdapter(spinnerAdapter);
        spinnerMallName.setSelection(getBundle().getInt(Constant.SELECTED_MALL_INDEX));
        spinnerMallName.setOnItemSelectedListener(this);

        getAvailableParkir(String.valueOf(getBundle().getInt(Constant.ID)));

//        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
//        Drawable drawable = getDrawable(R.drawable.ic_back_white);
//        drawable.setTint(getColor(R.color.black));
//        getSupportActionBar().setHomeAsUpIndicator(drawable);
    }

    private void getAvailableParkir(String id) {
        showProgressDialog("Loading parkir location...");
        apiExecutor.execute(ParkirLocationCommand.class, id, new Callback<List<ParkirLocation>>() {
            @Override
            public void onSuccess(List<ParkirLocation> data) {
                dismissProgressDialog();
                mData = data;

                adapter = new ParkirLocationItemAdapter();
                adapter.setData(mData);
                gvData.setAdapter(adapter);
                gvData.setOnItemClickListener(AvailableParkirActivity.this);
            }

            @Override
            public void onFailure(String message) {
                dismissProgressDialog();
                showMessage(message);
            }
        });
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

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        EventBus.getDefault().post(mData.get(i));
        finish();
    }

    @OnClick(R.id.back_available)
    void back(){
        finish();
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (!spinnerInitData)
            spinnerInitData = true;
        else {
            id = Mall.getMall().get(i).getId();
            getAvailableParkir(String.valueOf(id));
            EventBus.getDefault().post(new OnChangeSelectedMallIndexEvent(i));
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
