package com.sumroch.spotme.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sumroch.spotme.R;
import com.sumroch.spotme.adapter.bases.BaseItemAdapter;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */

public class SpinnerItemAdapter extends BaseItemAdapter<String> {

    private Context context;
    private View rootView;

    @Override
    protected View bindView(int position, View view, ViewGroup parent) {
        initViewData(parent, R.layout.view_spinner_dark, position);
        return rootView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        initViewData(parent, R.layout.list_item_spinner, position);
        return rootView;
    }

    private void initViewData(ViewGroup parent, int layoutRes, int position) {
        context = parent.getContext();
        rootView = LayoutInflater.from(context)
                .inflate(layoutRes, parent, false);
//        ((TextView) rootView.findViewById(R.id.tv_data)).setText(getData().get(position));
    }
}
