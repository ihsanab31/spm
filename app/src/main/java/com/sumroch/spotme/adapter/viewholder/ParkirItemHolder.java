package com.sumroch.spotme.adapter.viewholder;

import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sumroch.spotme.R;
import com.sumroch.spotme.adapter.ParkirItemAdapter;
import com.sumroch.spotme.adapter.bases.BaseItemHolder;
import com.sumroch.spotme.models.db.Parkir;

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

public class ParkirItemHolder extends BaseItemHolder<Parkir> {

    @BindView(R.id.tv_floor)
    TextView tvFloor;
    @BindView(R.id.tv_available_spaces)
    TextView tvAvailableSpaces;
    @BindView(R.id.pb_usage_spaces)
    ProgressBar pbUsageSpaces;

    ParkirItemAdapter adapter;

    public ParkirItemHolder(ViewGroup parent, Parkir data, ParkirItemAdapter adapter) {
        super(parent, data);
        this.adapter = adapter;
    }

    @Override
    protected int getItemLayout() {
        return R.layout.list_item_parkir;
    }

    @Override
    protected void bindView() {
        tvFloor.setText(getData().getFloorName());
        tvAvailableSpaces.setText(String.valueOf(getData().getAvailableSpaces()));
        pbUsageSpaces.setMax(getData().getMaxSpaces());
        pbUsageSpaces.setProgress(getProgressed(getData()));
    }

    private int getProgressed(Parkir data) {
        return data.getMaxSpaces() - data.getAvailableSpaces();
    }
}
