package com.sumroch.spotme.activities.parkir;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;

import com.sumroch.spotme.R;
import com.sumroch.spotme.activities.bases.NormalActivity;
import com.sumroch.spotme.activities.gridmenu.GridMenuActivity;
import com.sumroch.spotme.api.command.DataParkirCommand;
import com.sumroch.spotme.api.impl.ApiExecutorImpl;
import com.sumroch.spotme.api.interfaces.Callback;
import com.sumroch.spotme.models.db.DataParkir;
import com.sumroch.spotme.models.db.Mall;

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

public class ListMallParkirActivity extends NormalActivity {

    @BindView(R.id.container_toolbar)
    FrameLayout containerToolbar;
    @BindView(R.id.rv_mall_parkir)
    RecyclerView rvMallParkir;
    @BindView(R.id.view)
    View view;
    List<Mall> mallList = new ArrayList<>();
    MallParkirAdapter adapter;
    private ApiExecutorImpl apiExecutor;


    @Override
    protected int getActivityView() {
        return R.layout.activity_list_mall_parkir;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        apiExecutor = new ApiExecutorImpl();

        adapter = new MallParkirAdapter();
        rvMallParkir.setLayoutManager(new LinearLayoutManager(this));
        rvMallParkir.setAdapter(adapter);

        rvMallParkir.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (recyclerView.canScrollVertically(-1)) {
                    view.setVisibility(View.VISIBLE);
                } else {
                    view.setVisibility(View.GONE);
                }
            }
        });

//        Mall.getMall(new RealmChangeListener<RealmResults<Mall>>() {
//            @Override
//            public void onChange(RealmResults<Mall> malls) {
        if (Mall.getMall() != null) {
            showProgressDialog("Load parkir data...");
            mallList.addAll(Mall.getMall());
            apiExecutor.execute(DataParkirCommand.class, null, new Callback<List<DataParkir>>() {
                @Override
                public void onSuccess(final List<DataParkir> data) {
                    dismissProgressDialog();
                    for (int i = 0; i < mallList.size(); i++) {
                        Mall mall = mallList.get(i);
                        for (int j = 0; j < data.size(); j++) {
                            DataParkir dataParkir = data.get(j);
                            if (mall.getId() == dataParkir.getIdMall()) {
                                mallList.get(i).setAvailableSpace(dataParkir.getAvailable());
                                mallList.get(i).setNonAvailableSpace(dataParkir.getNonAvailable());
                                mallList.get(i).setTotalSpace(dataParkir.getJumlah());
                                break;
                            }
                        }
                    }
                    Mall.saveAll(mallList);
                    adapter.setMallList(mallList);
                    adapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(String message) {
                    dismissProgressDialog();
                    showMessage(message);
                }
            });
        }
//            }
//        });
//        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
//        Drawable drawable = getDrawable(R.drawable.ic_back_white);
//        drawable.setTint(getColor(R.color.white));
//        getSupportActionBar().setHomeAsUpIndicator(drawable);
    }

    @Override
    protected boolean isActionBarEnable() {
        return false;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                startActivity(new Intent(getApplicationContext(), GridMenuActivity.class));
//                finish();
//                return true;
//            default:
//                return false;
//        }
//    }
    @OnClick(R.id.back_list_mall)
    void back(){
        startActivity(new Intent(getApplicationContext(), GridMenuActivity.class));
        finish();
    }
}
