package com.sumroch.spotme.activities.registration.editprofile;

import android.content.Intent;
import android.os.Bundle;

import com.sumroch.spotme.R;
import com.sumroch.spotme.activities.bases.NormalActivity;

import butterknife.OnClick;

public class ProfileKontaActivity extends NormalActivity {

    @Override
    protected int getActivityView() {
        return R.layout.activity_profile_konta;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected boolean isActionBarEnable() {
        return false;
    }

    @OnClick(R.id.btn_kembali)
    void kembali() {
        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        finish();
    }
}
