package com.sumroch.spotme.activities.registration.editprofile;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.flexbox.FlexboxLayout;
import com.mobsandgeeks.saripaar.QuickRule;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Order;
import com.sumroch.spotme.R;
import com.sumroch.spotme.activities.bases.BaseFragment;
import com.sumroch.spotme.api.command.SurveyCommand;
import com.sumroch.spotme.api.interfaces.Callback;
import com.sumroch.spotme.models.db.SurveyData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import fisk.chipcloud.ChipCloud;
import fisk.chipcloud.ChipCloudConfig;
import fisk.chipcloud.ChipListener;


public class InterestsEditFragment extends BaseFragment implements Validator.ValidationListener {

    public static final String TAG = "InterestsEditFragment";

    @Order(0)
    @BindView(R.id.flexbox_edit)
    FlexboxLayout flexboxLayout;

    EditProfileActivity registrationActivity;
    List<SurveyData> surveyDataList = new ArrayList<>();
    private ChipCloudConfig chipCloudConfig;
    private ChipCloud chipCloud;
    private Validator mValidator;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_interests_edit;
    }

    @Override
    protected void onBindView() {

        registrationActivity = (EditProfileActivity) getActivity();

        mValidator = new Validator(this);
        mValidator.setValidationListener(this);
        mValidator.put(flexboxLayout, new QuickRule<FlexboxLayout>() {
            @Override
            public boolean isValid(FlexboxLayout view) {
                if (SurveyData.getSelectedSurvey(surveyDataList).isEmpty())
                    return false;
                else return true;
            }

            @Override
            public String getMessage(Context context) {
                return "This field is required";
            }
        });

        chipCloudConfig = new ChipCloudConfig()
                .selectMode(ChipCloud.SelectMode.multi)
                .checkedChipColor(Color.parseColor("#ddaa00"))
                .checkedTextColor(Color.parseColor("#ffffff"))
                .uncheckedChipColor(Color.parseColor("#e0e0e0"))
                .uncheckedTextColor(Color.parseColor("#000000"));

        chipCloud = new ChipCloud(getActivity(), flexboxLayout, chipCloudConfig);

        chipCloud.addChips(SurveyData.getSurveyStringList(surveyDataList));
        for (int i = 0; i < surveyDataList.size(); i++) {
            if (surveyDataList.get(i).isSelected()) {
                chipCloud.setChecked(i);
            }
        }

        chipCloud.setListener(new ChipListener() {
            @Override
            public void chipCheckedChange(int index, boolean checked, boolean userClick) {
                surveyDataList.get(index).setSelected(checked);
//                Toast.makeText(registrationActivity, SurveyData.getSelectedSurvey(surveyDataList).toString(), Toast.LENGTH_SHORT).show();
                registrationActivity.profile.setIdSurveyInterest(SurveyData.getSelectedSurvey(surveyDataList).toString());
            }
        });

        if (surveyDataList.isEmpty()) {
            registrationActivity.showProgressDialog("Loading survey...");
            registrationActivity.apiExecutor.execute(SurveyCommand.class, null, new Callback<List<SurveyData>>() {
                @Override
                public void onSuccess(List<SurveyData> data) {
                    registrationActivity.dismissProgressDialog();
                    surveyDataList = data;
                    chipCloud.addChips(SurveyData.getSurveyStringList(surveyDataList));
                    if (registrationActivity.profile.getIdSurveyInterest() != null) {
                        String interest = registrationActivity.profile.getIdSurveyInterest().replace("[", "").replace("]", "");
                        for (String selected : interest.split(",")) {
                            chipCloud.setChecked(Integer.parseInt(selected.trim()) - 1);
                        }
                    }
                }

                @Override
                public void onFailure(String message) {
                    registrationActivity.showMessage(message);
                }
            });
        }
    }

    @OnClick(R.id.btn_continue_edit)
    void onClickedContinue() {
        mValidator.validate();
    }

    @Override
    public void onValidationSucceeded() {
        registrationActivity.getOnClickedFragment(TAG);
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        View view = errors.get(0).getView();
        String message = errors.get(0).getFailedRules().get(0).getMessage(getActivity());
        if (view instanceof EditText) {
            ((EditText) view).setError(message);
            view.requestFocus();
        } else {
            Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
        }
    }
}
