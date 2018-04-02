package com.sumroch.spotme.adapter.viewholder;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sumroch.spotme.R;
import com.sumroch.spotme.adapter.bases.BaseItemHolder;
import com.sumroch.spotme.models.db.ParkirLocation;

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

public class ParkirLocationItemHolder extends BaseItemHolder<ParkirLocation> {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.image_mobil)
    ImageView mobil;
    public ParkirLocationItemHolder(ViewGroup parent, ParkirLocation data) {
        super(parent, data);
    }

    @Override
    protected int getItemLayout() {
        return R.layout.grid_item_available_parkir;
    }

    @Override
    protected void bindView() {
        tvTitle.setText(getData().getNomorBlok());
        tvTitle.setEnabled(getData().getStatus().equalsIgnoreCase("Available"));
        if (tvTitle.isEnabled()) {
            tvTitle.setBackgroundColor(getContext().getResources().getColor(R.color.color_buttondetail));
        } else if (!tvTitle.isEnabled()) {
            tvTitle.setVisibility(View.GONE);
            mobil.setVisibility(View.VISIBLE);
        } else if (getData().getStatus().equalsIgnoreCase("Available")) {
            tvTitle.setBackgroundColor(getContext().getResources().getColor(R.color.booked));
        }

    }
}
