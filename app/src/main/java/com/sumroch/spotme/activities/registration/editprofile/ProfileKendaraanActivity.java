package com.sumroch.spotme.activities.registration.editprofile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sumroch.spotme.R;
import com.sumroch.spotme.activities.bases.NormalActivity;
import com.sumroch.spotme.adapter.AdapterArticle;
import com.sumroch.spotme.dialog.DialogParkir;
import com.sumroch.spotme.models.KendaraanModel;
import com.sumroch.spotme.helper.RealmHelper;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class ProfileKendaraanActivity extends NormalActivity {
    private RealmHelper helper;
    private ArrayList<KendaraanModel> data;
    @BindView(R.id.list_kendaraan)
    RecyclerView recyclerView;

    @Override
    protected int getActivityView() {
        return R.layout.activity_profile_kendaraan;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data = new ArrayList<>();
        helper = new RealmHelper(ProfileKendaraanActivity.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        setRecyclerView();
    }

    @Override
    protected boolean isActionBarEnable() {
        return false;
    }

    @OnClick(R.id.add_data)
    void pindah (){
        startActivity(new Intent(getApplicationContext(), ProfileAddActivity.class));
    }

    public void setRecyclerView() {
        try {
            data = helper.findAllArticle();
        } catch (Exception e) {
            e.printStackTrace();
        }
        AdapterArticle adapter = new AdapterArticle(data, new AdapterArticle.OnItemClickListener() {
            @Override
            public void onClick(KendaraanModel item) {
                Intent i = new Intent(getApplicationContext(), DialogParkir.class);
                i.putExtra("id", item.getId());
                i.putExtra("title", item.getJ_kendaraan());
                i.putExtra("description", item.getPlat());
                startActivity(i);
            }
        });

        recyclerView.setAdapter(adapter);
    }
    @OnClick(R.id.btn_kembali)
    void kembali (){
        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        finish();
    }

}
