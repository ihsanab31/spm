package com.sumroch.spotme.adapter.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.sumroch.spotme.R;
import com.sumroch.spotme.adapter.bases.BaseItemHolder;

/**
 * Created by
 * Name     : Kiki Prayudi
 * Email    : kikipryd@gmail.com
 * WA       : 082240603377
 * on Wednesday, 22-11-2017
 * ------------------------------
 * This class for
 */

public class SpinnerItemHolder extends BaseItemHolder<String> {

    //    @BindView(R.id.tv_data)
    public TextView tvData;

    public SpinnerItemHolder(ViewGroup parent, String data) {
        super(parent, data);
    }

    @Override
    protected int getItemLayout() {
        return R.layout.list_item_spinner;
    }

    @Override
    protected void bindView() {
        tvData.setText(getData());
    }
}
