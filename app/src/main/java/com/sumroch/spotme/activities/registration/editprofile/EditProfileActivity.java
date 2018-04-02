package com.sumroch.spotme.activities.registration.editprofile;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.layer_net.stepindicator.StepIndicator;
import com.sumroch.spotme.R;
import com.sumroch.spotme.activities.bases.NormalActivity;
import com.sumroch.spotme.activities.gridmenu.GridMenuActivity;
import com.sumroch.spotme.api.command.UpdateCommand;
import com.sumroch.spotme.api.impl.ApiExecutorImpl;
import com.sumroch.spotme.api.interfaces.Callback;
import com.sumroch.spotme.models.db.LoginData;
import com.sumroch.spotme.models.db.Profile;

import java.util.ArrayList;
import java.util.List;

public class EditProfileActivity extends NormalActivity {

    List<Fragment> fragmentMenu = new ArrayList<>();
    Profile profile = new Profile();
    StepIndicator stepIndicator;
    ApiExecutorImpl apiExecutor;
    Fragment lastFragment;
    int fragmentIndex;
    @Override
    protected int getActivityView() {
        return R.layout.activity_edit_profile;
    }

    @Override
    protected boolean isActionBarEnable() {
        return false;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Profile data = Profile.findFirst();
        profile.setUsername(data.getUsername());
        profile.setEmail(data.getEmail());
        profile.setPassword(data.getPassword());
        profile.setPhoto(data.getPhoto());
        profile.setName(data.getName());
        profile.setNoHp(data.getNoHp());
        profile.setJenisKelamin(data.getJenisKelamin());
        profile.setDob(data.getDob());
        profile.setIdSurveyInterest(data.getIdSurveyInterest());

        stepIndicator = (StepIndicator) findViewById(R.id.step_indicator);
        stepIndicator.setClickable(false);

        fragmentMenu.add(new RegistrationEditFragment());
        fragmentMenu.add(new ProfileEditFragment());
        fragmentMenu.add(new InterestsEditFragment());

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
            case RegistrationEditFragment.TAG:
                fragmentIndex = 1;
                stepIndicator.setCurrentStepPosition(fragmentIndex);
                replaceFragment(fragmentMenu.get(fragmentIndex));
                break;
            case ProfileEditFragment.TAG:
                fragmentIndex = 2;
                stepIndicator.setCurrentStepPosition(fragmentIndex);
                replaceFragment(fragmentMenu.get(fragmentIndex));
                break;
            case InterestsEditFragment.TAG:
                showProgressDialog("Loading regist...");
                apiExecutor.execute(UpdateCommand.class,profile, new Callback<LoginData>() {

                    @Override
                    public void onSuccess(LoginData data) {
                        dismissProgressDialog();
                        Profile.add(profile);
                        startActivity(new Intent(EditProfileActivity.this, GridMenuActivity.class));
                        finishAffinity();
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
}
