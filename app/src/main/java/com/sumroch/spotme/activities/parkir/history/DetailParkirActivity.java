package com.sumroch.spotme.activities.parkir.history;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sumroch.spotme.R;
import com.sumroch.spotme.activities.bases.NormalActivity;
import com.sumroch.spotme.models.db.Profile;

import butterknife.BindView;
import butterknife.OnClick;

public class DetailParkirActivity extends NormalActivity {
    @BindView(R.id.txt_mobil_detail)
    TextView mobil;
    @BindView(R.id.txt_name_detail)
    TextView name;
    @BindView(R.id.txt_phone_detail)
    TextView phone;
    @BindView(R.id.txt_platmbl_detail)
    TextView plat;
    @BindView(R.id.txt_lokasi_detail)
    TextView lokasi;
    @BindView(R.id.txt_status_detail)
    TextView status;
    @BindView(R.id.tanggal_masuk)
    TextView tanggal;
    Profile profile = Profile.findFirst();
    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    View dialogView;

    @Override
    protected int getActivityView() {
        return R.layout.activity_detail_parkir;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    public void initData() {
        Bundle extras = getIntent().getExtras();
        name.setText(profile.getName());
        phone.setText(profile.getNoHp());
        mobil.setText(extras.getString("mobil"));
        plat.setText(extras.getString("plat"));
        lokasi.setText(extras.getString("mall"));
        status.setText(extras.getString("status"));
        tanggal.setText(extras.getString("tanggal"));
    }

    @OnClick(R.id.btn_selesai)
    void selesai() {
        dialog();
    }

    public void dialog() {
        dialog = new AlertDialog.Builder(DetailParkirActivity.this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.dialog_barcode, null);
        final TextView verifikasi = (TextView) dialogView.findViewById(R.id.kode_verifikasi);
        final Button btn_verifikasi = (Button) dialogView.findViewById(R.id.btn_verifikasi);
        dialog.setView(dialogView);
        dialog.setCancelable(true);
        dialog.show();
    }
    @OnClick(R.id.btn_kembali)
    void kembali (){
        startActivity(new Intent(getApplicationContext(), HistoryParkirActivity.class));
        finish();
    }
    @Override
    protected boolean isActionBarEnable() {
        return false;
    }
}
