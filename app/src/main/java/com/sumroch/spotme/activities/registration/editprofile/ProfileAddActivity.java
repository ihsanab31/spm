package com.sumroch.spotme.activities.registration.editprofile;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.sumroch.spotme.R;
import com.sumroch.spotme.activities.bases.NormalActivity;
import com.sumroch.spotme.helper.RealmHelper;

import butterknife.BindView;
import butterknife.OnClick;

public class ProfileAddActivity extends NormalActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener, TabLayout.OnTabSelectedListener {
    @BindView(R.id.tl_type_add)
    TabLayout tlType;
    @BindView(R.id.et_plat_no)
    AutoCompleteTextView plat;
    @BindView(R.id.et_warna_mobil)
    EditText warna;
    @BindView(R.id.coordinator)
    CoordinatorLayout coordinatorLayout;
    String jenked = null, plat_nomor = null;
    int id = 0;
    private RealmHelper realmHelper;

    @Override
    protected int getActivityView() {
        return R.layout.activity_profile_add;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tlType.addOnTabSelectedListener(this);
        realmHelper = new RealmHelper(ProfileAddActivity.this);
        initData();
    }

    @Override
    protected boolean isActionBarEnable() {
        return false;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    public void initData() {

        jenked = getBundle().getString("title", null);
        plat_nomor = getBundle().getString("description", null);
        if (plat_nomor == null && jenked == null) {
            Snackbar snackc = Snackbar.make(coordinatorLayout, "Silahkan Input Kendaraan", Snackbar.LENGTH_LONG);
            snackc.show();
        } else {
            id = getBundle().getInt("id");
            warna.setText("Silver");
            plat.setText(plat_nomor);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String s = plat.getText().toString();
        if (s.equalsIgnoreCase("MPV")) {
            tlType.getTabAt(0).select();
        } else if (s.equalsIgnoreCase("SUV")) {
            tlType.getTabAt(1).select();
        } else if (s.equalsIgnoreCase("SEDAN")) {
            tlType.getTabAt(2).select();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @OnClick(R.id.btn_simpan_ken)
    void simpan_kedaraan() {
        if (jenked==null) {
            realmHelper.addArticle(tlType.getTabAt(tlType.getSelectedTabPosition()).getText().toString() + " | " + warna.getText().toString()
                    , plat.getText().toString());
            finish();
            startActivity(new Intent(getApplicationContext(), ProfileKendaraanActivity.class));
        } else {
            realmHelper.updateArticle(id, tlType.getTabAt(tlType.getSelectedTabPosition()).getText().toString() + " | " + warna.getText().toString(),
                    plat.getText().toString());

            startActivity(new Intent(getApplicationContext(), ProfileKendaraanActivity.class));
            finish();
        }
    }

    @OnClick(R.id.btn_kembali)
    void kembali() {
        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        finish();
    }
}
