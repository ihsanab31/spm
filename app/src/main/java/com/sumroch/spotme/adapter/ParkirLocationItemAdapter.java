package com.sumroch.spotme.adapter;

import android.view.View;
import android.view.ViewGroup;

import com.sumroch.spotme.adapter.bases.BaseItemAdapter;
import com.sumroch.spotme.adapter.viewholder.ParkirLocationItemHolder;
import com.sumroch.spotme.models.db.ParkirLocation;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */
public class ParkirLocationItemAdapter extends BaseItemAdapter<ParkirLocation> {

    @Override
    protected View bindView(int position, View view, ViewGroup parent) {
        ParkirLocationItemHolder holder = new ParkirLocationItemHolder(
                parent,
                getData().get(position)
        );
        return holder.getRootView();
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return getData().get(position).getStatus().equalsIgnoreCase("Available");
    }
}