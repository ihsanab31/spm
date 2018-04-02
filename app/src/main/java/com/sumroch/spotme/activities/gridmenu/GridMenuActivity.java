package com.sumroch.spotme.activities.gridmenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.multidex.MultiDex;
import android.support.v7.widget.AppCompatSpinner;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.TextView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.squareup.picasso.Picasso;
import com.sumroch.spotme.Constant;
import com.sumroch.spotme.R;
import com.sumroch.spotme.activities.bases.ToolbarActivity;
import com.sumroch.spotme.activities.dashboard.DashboardActivity;
import com.sumroch.spotme.activities.dashboard.ExplorerFragment;
import com.sumroch.spotme.activities.event.EventActivity;
import com.sumroch.spotme.activities.notification.NotificationActivity;
import com.sumroch.spotme.adapter.GridMenuItemAdapter;
import com.sumroch.spotme.api.command.MasterDataCommand;
import com.sumroch.spotme.api.impl.ApiExecutorImpl;
import com.sumroch.spotme.api.interfaces.Callback;
import com.sumroch.spotme.eventbus.OnChangeSelectedMallIndexEvent;
import com.sumroch.spotme.models.db.BaseImageUrl;
import com.sumroch.spotme.models.db.GridMenu;
import com.sumroch.spotme.models.db.Kendaraan;
import com.sumroch.spotme.models.db.Mall;
import com.sumroch.spotme.models.db.MasterData;
import com.sumroch.spotme.models.db.Profile;
import com.sumroch.spotme.activities.parkir.ListMallParkirActivity;
import com.sumroch.spotme.activities.parkir.history.HistoryParkirActivity;
import com.sumroch.spotme.activities.registration.editprofile.ProfileActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */

public class GridMenuActivity extends ToolbarActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener, NavigationView.OnNavigationItemSelectedListener {

    //    @BindView(R.id.container)
//    ConstraintLayout container;
//    @BindView(R.id.navigation)
//    NavigationView navigation;
    @BindView(R.id.gv_menu)
    GridView gridViewMenu;
    @BindView(R.id.spinner)
    AppCompatSpinner spinnerMallName;
    @BindView(R.id.slider)
    SliderLayout sliderLayout;
    @BindView(R.id.navigation)
    NavigationView navigationView;

    @BindView(R.id.iv_avatar)
    CircleImageView ivAvatar;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_id)
    TextView tvId;
    //    @BindView(R.id.tv_notif_user)
//    TextView tvNotifUser;
//    @BindView(R.id.iv_user)
//    ImageView ivUser;
//    @BindView(R.id.tv_notif_setting)
//    TextView tvNotifSetting;
//    @BindView(R.id.iv_setting)
//    ImageView ivSetting;
    @BindView(R.id.container_toolbar)
    FrameLayout containerToolbar;

    Profile profile = Profile.findFirst();
    private ArrayList<String> listMallName = new ArrayList<>();
    private ArrayAdapter spinnerAdapter;
    private boolean spinnerInitData;

    //    private ArrayList<GridMenu> gridMenuList = new ArrayList<>();
    private GridMenuItemAdapter gridMenuItemAdapter;
    private boolean gridMenuInitData;

    private ApiExecutorImpl apiExecutor;

    @Override
    protected int getActivityView() {
        return R.layout.activity_grid_menu;
    }

    @Override
    protected int getToolbarView() {
        return R.id.toolbar;
    }

    @Override
    protected int getDrawerLayoutView() {
        return R.id.drawer_layout;
    }

//    @Override
//    protected View getContainerView() {
//        return container;
//    }
//
//    @Override
//    protected View getNavigationView() {
//        return navigation;
//    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MultiDex.install(this);
        navigationView.setNavigationItemSelectedListener(this);

        EventBus.getDefault().register(this);

        getSupportActionBar().setTitle("");

        startBeaconService();

        apiExecutor = new ApiExecutorImpl();

        initUserData();

        getMallData();
        initslider();
        initDataMenuGrid(GridMenu.getDummyGridMenuData());
    }

    public void initslider() {
        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Parkir", R.drawable.dummy_ads);
        file_maps.put("Promosi", R.drawable.dummy_ads_b);
        file_maps.put("Event", R.drawable.dummy_banner);
        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .image(file_maps.get(name));

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);
            sliderLayout.addSlider(textSliderView);
            sliderLayout.setPresetTransformer(SliderLayout.Transformer.Default);
            sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
            sliderLayout.setCustomAnimation(new DescriptionAnimation());
            sliderLayout.setDuration(4000);
        }
    }
        @Override
        protected void onDestroy () {
            EventBus.getDefault().unregister(this);
            super.onDestroy();
        }

    private void initSpinnerMallName(List<String> listMallName) {
        spinnerAdapter = new ArrayAdapter(this, R.layout.view_spinner_white, android.R.id.text1, listMallName);
        spinnerAdapter.setDropDownViewResource(R.layout.view_spinner_dark);
        spinnerMallName.setAdapter(spinnerAdapter);
        spinnerMallName.setOnItemSelectedListener(this);
    }

    private void initUserData() {
        String removeCurrency=profile.getPhoto();
        String  urlphoto = removeCurrency.substring(1);
        Picasso.with(this).load("http://api.sumroch.com/photos/%20"+urlphoto).into(ivAvatar);
        tvName.setText(profile.getName());
        tvId.setText(profile.getNoHp());


//        if (user.getNotifUser() > 0)
//            tvNotifUser.setText(String.valueOf(user.getNotifUser()));
//        else
//        tvNotifUser.setVisibility(View.GONE);

//        if (user.getNotifSetting() > 0)
//            tvNotifSetting.setText(String.valueOf(user.getNotifSetting()));
//        else
//        tvNotifSetting.setVisibility(View.GONE);
    }

    private void getMallData() {
//        showProgressDialog("Fetching Mall Data...");
//        apiExecutor.execute(MallCommand.class, new Callback<List<Mall>>() {
//
//            @Override
//            public void onSuccess(List<Mall> data) {
//                dismissProgressDialog();
//            }
//
//            @Override
//            public void onFailure(String message) {
//                dismissProgressDialog();

        listMallName = Mall.getMallName();
        initSpinnerMallName(listMallName);
        getMasterData(profile.getToken());
//            }
//        });
    }

    private void getGridMenuData(String mallName) {
//        showProgressDialog("Fetching " + mallName + " Data...");
//        apiExecutor.execute(GridMenuCommand.class, mallName, new Callback<List<GridMenu>>() {
//
//            @Override
//            public void onSuccess(List<GridMenu> data) {
//                dismissProgressDialog();
//            }
//
//            @Override
//            public void onFailure(String message) {
//                dismissProgressDialog();
        if (!gridMenuInitData)
            initDataMenuGrid(GridMenu.getDummyGridMenuData());
        else
            setDataMenuGrid(GridMenu.getDummyGridMenuData());
//            }
//        });
    }

    private void initDataMenuGrid(List<GridMenu> gridMenuList) {
        gridMenuItemAdapter = new GridMenuItemAdapter();
        gridMenuItemAdapter.setData(gridMenuList);
        gridViewMenu.setAdapter(gridMenuItemAdapter);
        gridViewMenu.setOnItemClickListener(this);
        gridMenuInitData = true;
    }

    private void setDataMenuGrid(List<GridMenu> gridMenuList) {
        gridMenuItemAdapter.setData(gridMenuList);
        gridMenuItemAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_search:
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = null;
        switch (i) {
            case 0:
//                intent = new Intent(this, ParkirActivity.class);
//                intent.putStringArrayListExtra(Constant.DATA_LIST_MALL, listMallName);
//                intent.putExtra(Constant.SELECTED_MALL_INDEX, spinnerMallName.getSelectedItemPosition());
                intent = new Intent(this, ListMallParkirActivity.class);
//                intent.putStringArrayListExtra(Constant.DATA_LIST_MALL, listMallName);
//                intent.putExtra(Constant.SELECTED_MALL_INDEX, spinnerMallName.getSelectedItemPosition());
                break;
            case 1:
                intent = new Intent(this, NotificationActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                break;
            case 2:
//                AlertDialog alertDialog = new AlertDialog.Builder(this).create();
//                alertDialog.show();
//                alertDialog.setContentView(R.layout.dialog_barcode);
//                final BarcodeView barcodeView = (BarcodeView) alertDialog.findViewById(R.id.bv_data);
//                final TextView tvData = (TextView) alertDialog.findViewById(R.id.tv_data);
//                final TextView tvData1 = (TextView) alertDialog.findViewById(R.id.tv_data_phone);
//                tvData.setText(profile.getName());
//                tvData1.setText(profile.getNoHp());
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        barcodeView.setBarcodeText(profile.getNoHp());
//                    }
//                }, 200);
                startActivity(new Intent(getApplicationContext(), MemberActivity.class));
                break;
            case 3:
                intent = new Intent(this, DashboardActivity.class);
                intent.putExtra(Constant.SHOW_FRAGMENT, ExplorerFragment.TAG);
                intent.putExtra(Constant.EXPLORER_FROM_MENU_GRID, true);
                break;
            case 4:
                intent = new Intent(this, EventActivity.class);
                intent.putStringArrayListExtra(Constant.DATA_LIST_MALL, listMallName);
                intent.putExtra(Constant.SELECTED_MALL_INDEX, spinnerMallName.getSelectedItemPosition());
                break;
            default:
                break;
        }

        if (intent != null) {
            startActivity(intent);
//            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (!spinnerInitData)
            spinnerInitData = true;
        else
            getGridMenuData(listMallName.get(i));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    @Subscribe
    public void onChangeSelectedMallIndex(OnChangeSelectedMallIndexEvent e) {
//        spinnerInitData = false;
        spinnerMallName.setSelection(e.getIndex());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_edit_profile:
                startActivity(new Intent(this, ProfileActivity.class));
                finish();
                break;
            case R.id.feeds:

                break;
            case R.id.history_parkir:
                startActivity(new Intent(getApplicationContext(), HistoryParkirActivity.class));
                finish();
                break;
            case R.id.setting:

                break;
        }
        return true;
    }

    @OnClick(R.id.iv_avatar)
    void onClickedAvatar() {
        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (apiExecutor != null)
            getMasterData(profile.getToken());
    }

    public void getMasterData(String token) {
        showProgressDialog("Request data...");
        apiExecutor.execute(MasterDataCommand.class, token, new Callback<MasterData>() {
            @Override
            public void onSuccess(MasterData data) {
                dismissProgressDialog();

                Profile.deleteAll();
                Profile.add(data.getProfile());

                Mall.deleteAll();
                Mall.saveAll(data.getMall());


                BaseImageUrl.deleteAll();
                BaseImageUrl.add(data.getImageUrl());

                Kendaraan.deleteAll();
                Kendaraan.addAll(data.getKendaraan());

//                startActivity(new Intent(GridMenuActivity.this, GridMenuActivity.class));
//                finishAffinity();
            }

            @Override
            public void onFailure(String message) {
                dismissProgressDialog();
                showMessage(message);
            }
        });

    }
}
