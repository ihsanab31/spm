package com.sumroch.spotme.adapter;

import android.view.View;
import android.view.ViewGroup;

import com.sumroch.spotme.adapter.bases.BaseItemAdapter;
import com.sumroch.spotme.adapter.viewholder.GridMenuItemHolder;
import com.sumroch.spotme.models.db.GridMenu;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */

public class GridMenuItemAdapter extends BaseItemAdapter<GridMenu> {

    @Override
    protected View bindView(int position, View view, ViewGroup parent) {
        GridMenuItemHolder holder = new GridMenuItemHolder(
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
        return getData().get(position).isEnable();
    }
}