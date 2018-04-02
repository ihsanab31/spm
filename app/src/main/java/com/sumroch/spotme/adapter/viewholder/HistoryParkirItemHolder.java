package com.sumroch.spotme.adapter.viewholder;

import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sumroch.spotme.R;
import com.sumroch.spotme.adapter.HistoryParkirAdapter;
import com.sumroch.spotme.adapter.bases.BaseItemHolder;
import com.sumroch.spotme.models.db.HistoryParkir;

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

public class HistoryParkirItemHolder extends BaseItemHolder<HistoryParkir> {

    @BindView(R.id.tv_id_parkir)
    TextView tvIdParkir;
    @BindView(R.id.tv_waktu_masuk)
    TextView tvWaktuMasuk;
    @BindView(R.id.tv_nama_user)
    TextView tvNameUser;
    @BindView(R.id.notif_parkir)
    TextView txtnotif;
    @BindView(R.id.tv_id_parki)
    TextView parkir;
    HistoryParkirAdapter adapter;

    public HistoryParkirItemHolder(ViewGroup parent, HistoryParkir data, HistoryParkirAdapter adapter) {
        super(parent, data);
        this.adapter = adapter;
    }

    @Override
    protected int getItemLayout() {
        return R.layout.list_item_history_parkir;
    }

    @Override
    protected void bindView() {
        tvIdParkir.setText(getData().getStatus());
        parkir.setText(getData().getIdParkir());
        String status= getData().getStatus();
        tvWaktuMasuk.setText(getData().getWaktuMasuk());
        if (getData().getStatus().equalsIgnoreCase("Diparkir")) {
            txtnotif.setText("PROGRESS");
        } else {
            txtnotif.setText("SUKSES");
        }
        tvNameUser.setText(getData().getNamaMall());
    }
}
