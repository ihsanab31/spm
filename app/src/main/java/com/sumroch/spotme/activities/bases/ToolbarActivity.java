package com.sumroch.spotme.activities.bases;

import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.balysv.materialmenu.MaterialMenuDrawable;
import com.sumroch.spotme.R;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */

public abstract class ToolbarActivity extends BaseActivity implements DrawerLayout.DrawerListener {

    private MaterialMenuDrawable materialMenu;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private boolean isDrawerOpened;

    public Toolbar getToolbar() {
        return toolbar;
    }

    @IdRes
    protected abstract int getToolbarView();

    @IdRes
    protected abstract int getDrawerLayoutView();

    protected View getNavigationView() {
        return null;
    }

    protected View getContainerView() {
        return null;
    }

    @Override
    protected int getActivityView() {
        return 0;
    }

    @Override
    protected void onBindView() {
        super.onBindView();

        initToolbar();
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(getToolbarView());
        drawerLayout = (DrawerLayout) findViewById(getDrawerLayoutView());
        drawerLayout.setScrimColor(getResources().getColor(R.color.color_darker_20));

        if (toolbar != null)
            setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setElevation(0);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        if (toolbar != null && drawerLayout != null) {
            ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
            drawerToggle.syncState();
            if (getNavigationView() != null && getContainerView() != null) {
                materialMenu = new MaterialMenuDrawable(this, Color.BLACK, MaterialMenuDrawable.Stroke.THIN);
                toolbar.setNavigationIcon(materialMenu);
                drawerLayout.addDrawerListener(this);
            }
        }
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        getContainerView().setTranslationX(slideOffset * getNavigationView().getWidth());
        drawerLayout.bringChildToFront(drawerView);

        materialMenu.setTransformationOffset(
                MaterialMenuDrawable.AnimationState.BURGER_ARROW,
                isDrawerOpened ? 2 - slideOffset : slideOffset
        );

//        if(slideOffset > .55 && !isDrawerOpened){
//            onDrawerOpened(drawerView);
//        } else if(slideOffset < .45 && isDrawerOpened) {
//            onDrawerClosed(drawerView);
//        }
    }

    @Override
    public void onDrawerOpened(View drawerView) {
        isDrawerOpened = true;
    }

    @Override
    public void onDrawerClosed(View drawerView) {
        isDrawerOpened = false;
    }

    @Override
    public void onDrawerStateChanged(int newState) {

    }
}
