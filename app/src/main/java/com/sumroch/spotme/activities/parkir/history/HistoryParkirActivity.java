package com.sumroch.spotme.activities.parkir.history;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.sumroch.spotme.Constant;
import com.sumroch.spotme.R;
import com.sumroch.spotme.activities.bases.NormalActivity;
import com.sumroch.spotme.activities.gridmenu.GridMenuActivity;
import com.sumroch.spotme.activities.parkir.fragment.BelumTanggapiFragment;
import com.sumroch.spotme.activities.parkir.fragment.TanggapiFragment;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class HistoryParkirActivity extends NormalActivity {
    View selectedView;
    @BindView(R.id.ll_transaksi)
    LinearLayout llDashboardHeader;
    @BindView(R.id.proses)
    Button btn_proses;
    @BindView(R.id.selesai)
    Button btn_selesai;
    private List<Fragment> fragmentMenu = new ArrayList<>();

    @Override
    protected int getActivityView() {
        return R.layout.activity_history_parkir;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentMenu.add(new BelumTanggapiFragment());
        fragmentMenu.add(new TanggapiFragment());
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) bundle = new Bundle();
        String showFragment = bundle.getString(Constant.SHOW_FRAGMENT, "");
        switch (showFragment) {
            case BelumTanggapiFragment.TAG:
                findViewById(R.id.proses).performClick();
                break;
            default:
                if (bundle.getBoolean(Constant.EXPLORER_FROM_MENU_GRID, false))
                    llDashboardHeader.setVisibility(View.GONE);
                findViewById(R.id.proses).performClick();
                break;
        }

    }

    @Override
    protected boolean isActionBarEnable() {
        return false;
    }

    @OnClick(R.id.proses)
    public void showDeals(View view) {
        onDashboardMenuClicked(view, fragmentMenu.get(0));
        btn_proses.setTextColor(Color.BLACK);
        btn_selesai.setTextColor(Color.WHITE);
    }

    @OnClick(R.id.selesai)
    public void showRecommendation(View view) {
        onDashboardMenuClicked(view, fragmentMenu.get(1));
        btn_proses.setTextColor(Color.WHITE);
        btn_selesai.setTextColor(Color.BLACK);
    }
    @OnClick(R.id.ic_menu)
    void kembali (){
        startActivity(new Intent(getApplicationContext(), GridMenuActivity.class));
        finish();
    }
    private void onDashboardMenuClicked(View view, Fragment fragment) {
        if (selectedView != null)
            selectedView.setSelected(false);
        if (fragment != null)
            replaceFragment(fragment);
        selectedView = view;
        selectedView.setSelected(true);
    }

    /**
     * for replace fragment
     *
     * @param fragment {@link Fragment}
     */
    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}
