package com.sumroch.spotme.activities.registration;

import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.ConfirmPassword;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Order;
import com.mobsandgeeks.saripaar.annotation.Password;
import com.sumroch.spotme.R;
import com.sumroch.spotme.activities.bases.BaseFragment;

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

public class RegistrationFragment extends BaseFragment implements TextWatcher, Validator.ValidationListener {


    public final static String TAG = "RegistrationFragment";

    @Order(0)
    @NotEmpty
    @BindView(R.id.et_username)
    EditText etUsername;
    @Order(1)
    @NotEmpty(sequence = 0)
    @Email(sequence = 1)
    @BindView(R.id.et_email)
    EditText etEmail;
    @Order(2)
    @NotEmpty(sequence = 0)
    @Password(sequence = 1)
    @BindView(R.id.et_password)
    EditText etPassword;
    @Order(3)
    @ConfirmPassword
    @BindView(R.id.et_confirm_password)
    EditText etConfirmPassword;

    RegistrationActivity registrationActivity;
    private Validator mValidator;


    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_registration;
    }

    @Override
    protected void onBindView() {

        registrationActivity = (RegistrationActivity) getActivity();

        mValidator = new Validator(this);
        mValidator.setValidationListener(this);

        etPassword.setTransformationMethod(new PasswordTransformationMethod());
        etConfirmPassword.setTransformationMethod(new PasswordTransformationMethod());

        if (registrationActivity.profile.getUsername() != null)
            etUsername.setText(registrationActivity.profile.getUsername());
        if (registrationActivity.profile.getEmail() != null)
            etEmail.setText(registrationActivity.profile.getEmail());

        etUsername.addTextChangedListener(this);
        etEmail.addTextChangedListener(this);
        etPassword.addTextChangedListener(this);
    }

    @OnClick(R.id.btn_continue)
    void onClickedContinue() {
        mValidator.validate();
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        if (editable == etUsername.getEditableText()) {
            registrationActivity.profile.setUsername(editable.toString());
        } else if (editable == etEmail.getEditableText()) {
            registrationActivity.profile.setEmail(editable.toString());
        } else if (editable == etPassword.getEditableText()) {
            registrationActivity.profile.setPassword(editable.toString());
        }
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
