package com.sumroch.spotme.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.sumroch.spotme.R;
import com.sumroch.spotme.activities.gridmenu.GridMenuActivity;
import com.sumroch.spotme.api.command.LoginCommand;
import com.sumroch.spotme.api.command.MasterDataCommand;
import com.sumroch.spotme.api.impl.ApiExecutorImpl;
import com.sumroch.spotme.api.interfaces.Callback;
import com.sumroch.spotme.models.db.BaseImageUrl;
import com.sumroch.spotme.models.db.Kendaraan;
import com.sumroch.spotme.models.db.LoginData;
import com.sumroch.spotme.models.db.Mall;
import com.sumroch.spotme.models.db.MasterData;
import com.sumroch.spotme.models.db.Profile;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Andrian.Lippox on 8/21/2017.
 */

public class LoginDialog extends BaseDialog implements Validator.ValidationListener {

    @NotEmpty(sequence = 0)
    @Email(sequence = 1)
    @BindView(R.id.et_email)
    EditText etEmail;
    @NotEmpty
    @BindView(R.id.et_password)
    EditText etPassword;

    Validator mValidator;
    ApiExecutorImpl apiExecutor;

    public LoginDialog() {
    }

    @SuppressLint("ValidFragment")
    public LoginDialog(Context context) {
        super(context);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.DialogStyle);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mValidator = new Validator(this);
        mValidator.setValidationListener(this);

        apiExecutor = new ApiExecutorImpl();

        etEmail.setText("");
        etPassword.setText("");
    }

    @Override
    public int getDialogView() {
        return R.layout.dialog_login;
    }

    @Override
    public boolean isDialogCancelable() {
        return true;
    }

    @Override
    public void onLoadInstance(Bundle savedInstanceBundle) {
    }

    @Override
    public void onPostInit() {
    }

    @OnClick(R.id.bt_sign_in)
    public void onOkClicked() {
        mValidator.validate();
//        if (!etEmail.getText().toString().isEmpty() && !etPassword.getText().toString().isEmpty()) {
//            //TODO Login
//            dismiss();
//        }
    }

    @Override
    public void onValidationSucceeded() {
        showProgressDialog("Request login...");
        LoginData.Request request = new LoginData.Request(
                etEmail.getText().toString(),
                etPassword.getText().toString()
        );
        apiExecutor.execute(LoginCommand.class, request, new Callback<LoginData>() {
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

                startActivity(new Intent(getActivity(), GridMenuActivity.class));
                getActivity().finishAffinity();
            }

            @Override
            public void onFailure(String message) {
                dismissProgressDialog();
                showMessage(message);
            }
        });

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
