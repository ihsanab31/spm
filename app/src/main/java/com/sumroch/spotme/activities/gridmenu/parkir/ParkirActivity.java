package com.sumroch.spotme.activities.gridmenu.parkir;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Spinner;

import com.sumroch.spotme.Constant;
import com.sumroch.spotme.R;
import com.sumroch.spotme.activities.bases.ToolbarActivity;
import com.sumroch.spotme.adapter.ParkirItemAdapter;
import com.sumroch.spotme.api.command.EventCommand;
import com.sumroch.spotme.api.impl.ApiExecutorImpl;
import com.sumroch.spotme.api.interfaces.Callback;
import com.sumroch.spotme.eventbus.OnChangeSelectedMallIndexEvent;
import com.sumroch.spotme.models.db.EventData;
import com.sumroch.spotme.models.db.Parkir;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

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
public class ParkirActivity extends ToolbarActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {

    @BindView(R.id.lv_parkir)
    ListView lvParkir;
//    @BindView(R.id.navigation)
//    NavigationView navigation;

    ParkirItemAdapter parkirItemAdapter;
    @BindView(R.id.spinner)
    Spinner spinnerMallName;
    @BindView(R.id.container_toolbar)
    FrameLayout containerToolbar;

    private ArrayList<String> listMallName = new ArrayList<>();
    private ArrayAdapter spinnerAdapter;
    private boolean spinnerInitData;
    private ApiExecutorImpl apiExecutor;
    private Bundle bundle;

    @Override
    protected int getActivityView() {
        return R.layout.activity_parkir;
    }

    @Override
    protected int getToolbarView() {
        return R.id.toolbar;
    }

    @Override
    protected int getDrawerLayoutView() {
        return R.id.drawer_layout;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle("");

        bundle = getIntent().getExtras();
        listMallName = bundle.getStringArrayList(Constant.DATA_LIST_MALL);

        apiExecutor = new ApiExecutorImpl();

        spinnerAdapter = new ArrayAdapter(this, R.layout.view_spinner_light, android.R.id.text1, listMallName);
        spinnerAdapter.setDropDownViewResource(R.layout.list_item_spinner);
        spinnerMallName.setAdapter(spinnerAdapter);
        spinnerMallName.setSelection(bundle.getInt(Constant.SELECTED_MALL_INDEX));
        spinnerMallName.setOnItemSelectedListener(this);

        parkirItemAdapter = new ParkirItemAdapter();
        getEventData(listMallName.get(bundle.getInt(Constant.SELECTED_MALL_INDEX)));

        lvParkir.setAdapter(parkirItemAdapter);
        lvParkir.setOnItemClickListener(this);

    }

    private void initDataSpinner(List<String> dummyMallData) {
        if (dummyMallData != null) {
            spinnerAdapter.clear();
            spinnerAdapter.addAll(dummyMallData);
            spinnerAdapter.notifyDataSetChanged();
        }
    }

    private void initDataParkir() {
        parkirItemAdapter.setData(Parkir.getDummyPArkir());
        parkirItemAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (!spinnerInitData)
            spinnerInitData = true;
        else {
            getEventData(listMallName.get(i));
            EventBus.getDefault().post(new OnChangeSelectedMallIndexEvent(i));
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void getEventData(String mallName) {
        showProgressDialog("Fetching " + mallName + " Data...");
        apiExecutor.execute(EventCommand.class, mallName, new Callback<EventData>() {

            @Override
            public void onSuccess(EventData data) {
                dismissProgressDialog();
            }

            @Override
            public void onFailure(String message) {
                dismissProgressDialog();
                initDataParkir();
            }
        });
    }
}
