package com.sumroch.spotme.dialog;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.sumroch.spotme.R;
import com.sumroch.spotme.activities.bases.NormalActivity;
import com.sumroch.spotme.activities.parkir.ReserveParkirActivity;

import butterknife.BindView;
import butterknife.OnClick;
/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */
public class DialogParkir extends NormalActivity {
    String id_plat, title, des;
    @BindView(R.id.dat_plat)
    TextView textView;
    @Override
    protected int getActivityView() {
        return R.layout.dialog_parkir;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    @Override
    protected boolean isActionBarEnable() {
        return false;
    }
    public void initData() {
        title = getBundle().getString("title", null);
        des = getBundle().getString("description", null);
        id_plat = getBundle().getString("id", null);
        textView.setText(des);

    }
    @OnClick(R.id.edit_plat)
    void edit(){

    }
    @OnClick(R.id.pilih_plat)
    void pilih(){
        Intent i = new Intent(getApplicationContext(), ReserveParkirActivity.class);
        i.putExtra("description", des);
        startActivity(i);
        finish();
    }
}
