package com.sumroch.spotme.activities.registration;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.layer_net.stepindicator.StepIndicator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.sumroch.spotme.Constant;
import com.sumroch.spotme.R;
import com.sumroch.spotme.activities.bases.NormalActivity;
import com.sumroch.spotme.activities.gridmenu.GridMenuActivity;
import com.sumroch.spotme.api.command.MasterDataCommand;
import com.sumroch.spotme.api.command.RegisterCommand;
import com.sumroch.spotme.api.impl.ApiExecutorImpl;
import com.sumroch.spotme.api.interfaces.Callback;
import com.sumroch.spotme.models.db.BaseImageUrl;
import com.sumroch.spotme.models.db.Kendaraan;
import com.sumroch.spotme.models.db.LoginData;
import com.sumroch.spotme.models.db.Mall;
import com.sumroch.spotme.models.db.MasterData;
import com.sumroch.spotme.models.db.Profile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import id.zelory.compressor.Compressor;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */
public class RegistrationActivity extends NormalActivity {

    List<Fragment> fragmentMenu = new ArrayList<>();
    Profile profile = new Profile();
    StepIndicator stepIndicator;
    ApiExecutorImpl apiExecutor;
    Fragment lastFragment;
    int fragmentIndex;

    Bundle bundle;
    String id;
    String name;
    String email;
    String photo;

    @Override
    protected int getActivityView() {
        return R.layout.activity_registration;
    }

    @Override
    protected boolean isActionBarEnable() {
        return false;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bundle = getIntent().getExtras();
        if (bundle != null) {
            profile.setEmail(bundle.getString(Constant.EMAIL));
            ImageLoader.getInstance().loadImage(bundle.getString(Constant.PHOTO), new SimpleImageLoadingListener() {
                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                    try {
                        File dir = new File(Environment.getExternalStorageDirectory().getPath());
                        File file = File.createTempFile(UUID.randomUUID().toString(), ".jpg", dir);
                        file.createNewFile();
                        FileOutputStream ostream = new FileOutputStream(file);
                        loadedImage.compress(Bitmap.CompressFormat.JPEG, 100, ostream);
                        ostream.close();
                        File compressToFile = new Compressor(RegistrationActivity.this).compressToFile(file);
                        profile.setPhoto(Uri.fromFile(compressToFile).toString());
                    } catch (IOException e) {
                    }
                }
            });
        }

        stepIndicator = (StepIndicator) findViewById(R.id.step_indicator);
        stepIndicator.setClickable(false);

        fragmentMenu.add(new RegistrationFragment());
        fragmentMenu.add(new ProfileFragment());
        fragmentMenu.add(new InterestsFragment());

        replaceFragment(fragmentMenu.get(fragmentIndex));

        apiExecutor = new ApiExecutorImpl();

    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
        fragmentIndex = fragmentMenu.indexOf(fragment);
    }

    @Override
    public void onBackPressed() {
        if (fragmentIndex == 0)
            super.onBackPressed();
        else {
            fragmentIndex--;
            stepIndicator.setCurrentStepPosition(fragmentIndex);
            replaceFragment(fragmentMenu.get(fragmentIndex));
        }
    }

    public void getOnClickedFragment(final String tag) {
        switch (tag) {
            case RegistrationFragment.TAG:
                fragmentIndex = 1;
                stepIndicator.setCurrentStepPosition(fragmentIndex);
                replaceFragment(fragmentMenu.get(fragmentIndex));
                break;
            case ProfileFragment.TAG:
                fragmentIndex = 2;
                stepIndicator.setCurrentStepPosition(fragmentIndex);
                replaceFragment(fragmentMenu.get(fragmentIndex));
                break;
            case InterestsFragment.TAG:
                showProgressDialog("Loading regist...");
                apiExecutor.execute(RegisterCommand.class, profile, new Callback<LoginData>() {
                    @Override
                    public void onSuccess(LoginData data) {
                        getMasterData(data.getToken());
                    }

                    @Override
                    public void onFailure(String message) {
                        dismissProgressDialog();
                        showMessage(message);
                    }
                });
                break;
        }
    }

    public void getMasterData(String token) {
        showProgressDialog("Request data...");
        apiExecutor.execute(MasterDataCommand.class, token, new Callback<MasterData>() {
            @Override
            public void onSuccess(MasterData data) {
                dismissProgressDialog();

                Profile.deleteAll();
                Profile.add(data.getProfile());

                Mall.deleteAll();
                Mall.saveAll(data.getMall());

                BaseImageUrl.deleteAll();
                BaseImageUrl.add(data.getImageUrl());

                Kendaraan.deleteAll();
                Kendaraan.addAll(data.getKendaraan());

                startActivity(new Intent(RegistrationActivity.this, GridMenuActivity.class));
                finishAffinity();
            }

            @Override
            public void onFailure(String message) {
                dismissProgressDialog();
                showMessage(message);
            }
        });

    }
}
