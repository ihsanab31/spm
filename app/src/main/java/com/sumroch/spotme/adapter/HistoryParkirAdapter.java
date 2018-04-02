package com.sumroch.spotme.adapter;

import android.view.View;
import android.view.ViewGroup;

import com.sumroch.spotme.adapter.bases.BaseItemAdapter;
import com.sumroch.spotme.adapter.viewholder.HistoryParkirItemHolder;
import com.sumroch.spotme.models.db.HistoryParkir;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */

public class HistoryParkirAdapter extends BaseItemAdapter<HistoryParkir> {

    @Override
    protected View bindView(int position, View view, ViewGroup parent) {
        HistoryParkirItemHolder holder = new HistoryParkirItemHolder(
                parent,
                getData().get(position),
                this
        );
        return holder.getRootView();
    }
}
