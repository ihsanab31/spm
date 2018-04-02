package com.sumroch.spotme.activities.dashboard;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.sumroch.spotme.Constant;
import com.sumroch.spotme.R;
import com.sumroch.spotme.activities.bases.NormalActivity;
import com.sumroch.spotme.activities.bases.ToolbarActivity;
import com.sumroch.spotme.api.impl.ApiExecutorImpl;

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

public class DashboardActivity extends NormalActivity {
    View selectedView;
    @BindView(R.id.ll_dashboard_header)
    LinearLayout llDashboardHeader;
    @BindView(R.id.search_container)
    View searchContainer;
    private List<Fragment> fragmentMenu = new ArrayList<>();
    public ApiExecutorImpl apiExecutor;



    @Override
    protected int getActivityView() {
        return R.layout.activity_dashboard;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentMenu.add(new DealsFragment());
        fragmentMenu.add(new RecommendationFragment());
        fragmentMenu.add(new PopularFragment());
        fragmentMenu.add(new ExplorerFragment());

        apiExecutor = new ApiExecutorImpl();

        Bundle bundle = getIntent().getExtras();
        if (bundle == null) bundle = new Bundle();
        String showFragment = bundle.getString(Constant.SHOW_FRAGMENT, "");
        switch (showFragment) {
            case ExplorerFragment.TAG:
                if (bundle.getBoolean(Constant.EXPLORER_FROM_MENU_GRID, false))
                    llDashboardHeader.setVisibility(View.GONE);
                findViewById(R.id.btn_explorer).performClick();
                break;
            default:
                findViewById(R.id.btn_deals).performClick();
                break;
        }

//        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
//        Drawable drawable = getDrawable(R.drawable.ic_back_white);
//        drawable.setTint(getColor(R.color.white));
//        getSupportActionBar().setHomeAsUpIndicator(drawable);
    }

    @OnClick(R.id.btn_deals)
    public void showDeals(View view) {
        onDashboardMenuClicked(view, fragmentMenu.get(0));
    }

    @OnClick(R.id.btn_recommendation)
    public void showRecommendation(View view) {
        onDashboardMenuClicked(view, fragmentMenu.get(1));
    }

    @OnClick(R.id.btn_popular)
    public void showPopular(View view) {
        onDashboardMenuClicked(view, fragmentMenu.get(2));
    }

    @OnClick(R.id.btn_explorer)
    public void showExplorer(View view) {
        onDashboardMenuClicked(view, fragmentMenu.get(3));
    }

    /**
     * click method for dashboard menu
     *
     * @param view     {@link View} clicked menu
     * @param fragment {@link Fragment} want to replace on main container
     */
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

    @Override
    protected boolean isActionBarEnable() {
        return false;
    }

    @OnClick(R.id.back_explore)
    void back() {
        supportFinishAfterTransition();
    }
}
