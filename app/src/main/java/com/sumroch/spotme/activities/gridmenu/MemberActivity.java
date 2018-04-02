package com.sumroch.spotme.activities.gridmenu;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.bottlerocketstudios.barcode.generation.ui.BarcodeView;
import com.sumroch.spotme.R;
import com.sumroch.spotme.activities.bases.NoActionBarConfig;
import com.sumroch.spotme.models.db.Profile;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */
public class MemberActivity extends AppCompatActivity {
    @BindView(R.id.bv_data)
    BarcodeView barcodeView;
    @BindView(R.id.tv_data)
    TextView tvData;
    @BindView(R.id.tv_data_phone)
    TextView tvData1;
    Profile profile = Profile.findFirst();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);
        NoActionBarConfig noActionBarConfig = new NoActionBarConfig();
        noActionBarConfig.fullScreen(this);
        getSupportActionBar().hide();
        ButterKnife.bind(this);
        tvData.setText(profile.getName());
        tvData1.setText(profile.getNoHp());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                barcodeView.setBarcodeText(profile.getNoHp());
            }
        }, 200);
    }
}
