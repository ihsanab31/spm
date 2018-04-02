package com.sumroch.spotme.activities.registration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.sumroch.spotme.Constant;
import com.sumroch.spotme.R;
import com.sumroch.spotme.activities.bases.NormalActivity;
import com.sumroch.spotme.activities.gridmenu.GridMenuActivity;
import com.sumroch.spotme.helper.auth.facebookSignIn.FacebookHelper;
import com.sumroch.spotme.helper.auth.facebookSignIn.FacebookResponse;
import com.sumroch.spotme.helper.auth.facebookSignIn.FacebookUser;
import com.sumroch.spotme.helper.auth.googleAuthSignin.GoogleAuthResponse;
import com.sumroch.spotme.helper.auth.googleAuthSignin.GoogleAuthUser;
import com.sumroch.spotme.helper.auth.googleAuthSignin.GoogleSignInHelper;
import com.sumroch.spotme.models.db.Profile;

import java.util.List;

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
public class SignInActivity extends NormalActivity implements FacebookResponse, GoogleAuthResponse, Validator.ValidationListener {

    @NotEmpty
    @Email
    @BindView(R.id.et_email)
    EditText etEmail;
    @NotEmpty
    @BindView(R.id.et_password)
    EditText etPassword;

    Validator mValidator;
    FacebookHelper mFbHelper;
    GoogleSignInHelper mGAuthHelper;

    @Override
    protected int getActivityView() {
        return R.layout.activity_sign_in;
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mValidator = new Validator(this);
        mValidator.setValidationListener(this);

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

    @OnClick({
            R.id.bt_sign_in,
            R.id.btn_sign_up, R.id.btn_forgot_password,
            R.id.btn_sign_up_google, R.id.btn_sign_up_facebook
    })
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sign_in:
                mValidator.validate();
                break;
            case R.id.btn_sign_up:
                startActivity(new Intent(SignInActivity.this, RegistrationActivity.class));
                break;
            case R.id.btn_forgot_password:
                startActivity(new Intent(SignInActivity.this, ForgotPasswordActivity.class));
                break;
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

    @Override
    protected boolean isActionBarEnable() {
        return false;
    }

    @Override
    public void onValidationSucceeded() {

    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }
        }
    }
}