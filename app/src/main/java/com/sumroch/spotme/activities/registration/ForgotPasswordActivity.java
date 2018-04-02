package com.sumroch.spotme.activities.registration;

import android.os.Bundle;

import com.sumroch.spotme.R;
import com.sumroch.spotme.activities.bases.NormalActivity;
/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */
public class ForgotPasswordActivity extends NormalActivity {

    @Override
    protected int getActivityView() {
        return R.layout.activity_forgot_password;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected boolean isActionBarEnable() {
        return false;
    }
}
