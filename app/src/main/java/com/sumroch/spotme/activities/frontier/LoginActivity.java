package com.sumroch.spotme.activities.frontier;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.sumroch.spotme.Constant;
import com.sumroch.spotme.R;
import com.sumroch.spotme.activities.bases.NormalActivity;
import com.sumroch.spotme.activities.gridmenu.GridMenuActivity;
import com.sumroch.spotme.dialog.LoginDialog;
import com.sumroch.spotme.helper.auth.facebookSignIn.FacebookHelper;
import com.sumroch.spotme.helper.auth.facebookSignIn.FacebookResponse;
import com.sumroch.spotme.helper.auth.facebookSignIn.FacebookUser;
import com.sumroch.spotme.helper.auth.googleAuthSignin.GoogleAuthResponse;
import com.sumroch.spotme.helper.auth.googleAuthSignin.GoogleAuthUser;
import com.sumroch.spotme.helper.auth.googleAuthSignin.GoogleSignInHelper;
import com.sumroch.spotme.models.db.Profile;
import com.sumroch.spotme.activities.registration.RegistrationActivity;

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

public class LoginActivity extends NormalActivity implements GoogleAuthResponse, FacebookResponse {

    private GoogleSignInHelper mGAuthHelper;
    private FacebookHelper mFbHelper;

    @Override
    protected int getActivityView() {
        return R.layout.activity_login;
    }

    @Override
    protected boolean isActionBarEnable() {
        return false;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mGAuthHelper = new GoogleSignInHelper(this, null, this);
        mFbHelper = new FacebookHelper(this,
                "id,name,email,gender,birthday,picture.width(400).height(400),cover",
                this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Profile.findFirst() != null) {
            startActivity(new Intent(this, GridMenuActivity.class));
            finishAffinity();
        }
    }

    @OnClick(R.id.bt_sign_in)
    public void onSignInClicked() {
        LoginDialog loginDialog = new LoginDialog(this);
        loginDialog.show();
    }

    @OnClick(R.id.bt_sign_up)
    public void onSignUpClicked() {
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }

    @OnClick({R.id.btn_sign_up_google, R.id.btn_sign_up_facebook})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sign_up_google:
                try {
                    mGAuthHelper.performSignOut();
                } catch (Exception e) {

                }
                mGAuthHelper.performSignIn(this);
                break;
            case R.id.btn_sign_up_facebook:
                try {
                    mFbHelper.performSignOut();
                } catch (Exception e) {

                }
                mFbHelper.performSignIn(this);
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //handle results
        mFbHelper.onActivityResult(requestCode, resultCode, data);
        mGAuthHelper.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onFbSignInFail() {
    }

    @Override
    public void onFbSignInSuccess() {
    }

    @Override
    public void onFbProfileReceived(FacebookUser facebookUser) {
        Bundle bundle = new Bundle();
//        bundle.putString(Constant.ID, facebookUser.facebookID);
//        bundle.putString(Constant.NAME, facebookUser.name);
        bundle.putString(Constant.EMAIL, facebookUser.email);
        bundle.putString(Constant.PHOTO, facebookUser.profilePic);

        Intent intent = new Intent(this, RegistrationActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void onFBSignOut() {
    }


    @Override
    public void onGoogleAuthSignIn(GoogleAuthUser user) {

        Bundle bundle = new Bundle();
//        bundle.putString(Constant.ID, user.id);
//        bundle.putString(Constant.NAME, user.name);
        bundle.putString(Constant.EMAIL, user.email);
        bundle.putString(Constant.PHOTO, String.valueOf(user.photoUrl));

        Intent intent = new Intent(this, RegistrationActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void onGoogleAuthSignInFailed() {
    }

    @Override
    public void onGoogleAuthSignOut(boolean isSuccess) {
    }
}
