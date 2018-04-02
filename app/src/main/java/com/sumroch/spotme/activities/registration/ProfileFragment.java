package com.sumroch.spotme.activities.registration;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mobsandgeeks.saripaar.QuickRule;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Checked;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Order;
import com.sumroch.spotme.R;
import com.sumroch.spotme.activities.bases.BaseFragment;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import id.zelory.compressor.Compressor;
import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */

public class ProfileFragment extends BaseFragment implements DatePickerDialog.OnDateSetListener, TextWatcher, Validator.ValidationListener {

    public static final String TAG = "ProfileFragment";

    @Order(0)
    @BindView(R.id.iv_picture)
    SimpleDraweeView civPicture;
    @Order(1)
    @NotEmpty
    @BindView(R.id.et_name)
    EditText etName;
    @Order(2)
    @NotEmpty
    @BindView(R.id.et_phone_number)
    EditText etPhoneNumber;
    @Order(3)
    @Checked
    @BindView(R.id.rg_sex)
    RadioGroup rgSex;
    @BindView(R.id.rb_man)
    RadioButton rgMale;
    @BindView(R.id.rb_woman)
    RadioButton rgFemale;
    @Order(4)
    @NotEmpty
    @BindView(R.id.et_dob)
    EditText etDOB;

    RegistrationActivity registrationActivity;
    Calendar now = Calendar.getInstance();
    private Validator mValidator;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_profile;
    }

    @Override
    protected void onBindView() {

        registrationActivity = (RegistrationActivity) getActivity();

        mValidator = new Validator(this);
        mValidator.setValidationListener(this);
        mValidator.put(civPicture, new QuickRule<SimpleDraweeView>() {
            @Override
            public boolean isValid(SimpleDraweeView view) {
                if (registrationActivity.profile.getPhoto() == null)
                    return false;
                else if (registrationActivity.profile.getPhoto().isEmpty())
                    return false;
                else return true;
            }

            @Override
            public String getMessage(Context context) {
                return "This field is required";
            }
        });

        EasyImage.configuration(getActivity())
                .setImagesFolderName("My app images")
                .saveInAppExternalFilesDir()
                .saveInRootPicturesDirectory();

        if (registrationActivity.profile.getPhoto() != null)
            civPicture.setImageURI(registrationActivity.profile.getPhoto());

        if (registrationActivity.profile.getName() != null)
            etName.setText(registrationActivity.profile.getName());
        if (registrationActivity.profile.getNoHp() != null)
            etPhoneNumber.setText(registrationActivity.profile.getNoHp());

        if (registrationActivity.profile.getJenisKelamin() != null) {
            if (registrationActivity.profile.getJenisKelamin().equalsIgnoreCase("MALE"))
                rgMale.setSelected(true);
            else
                rgFemale.setSelected(true);
        }
        if (registrationActivity.profile.getDob() != null)
            etDOB.setText(registrationActivity.profile.getDob());

        etName.addTextChangedListener(this);
        etPhoneNumber.addTextChangedListener(this);
    }

    @OnClick(R.id.btn_continue)
    void onClickedContinue() {
        registrationActivity.profile.setName(etName.getText().toString());
        registrationActivity.profile.setNoHp(etPhoneNumber.getText().toString());
        mValidator.validate();
    }

    @OnClick(R.id.et_dob)
    void onClickDOB() {
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        dpd.setTitle("Date of Birth");
        dpd.show(getActivity().getFragmentManager(), "Datepickerdialog");
    }

    @OnClick({R.id.iv_picture, R.id.iv_picture_edit})
    void onClickPicture() {
        new AlertDialog.Builder(getActivity())
                .setMessage("Take photo from camera or choose from gallery?")
                .setNegativeButton("Camera", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EasyImage.openCamera(ProfileFragment.this, 0);
                    }
                })
                .setPositiveButton("Gallery", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EasyImage.openGallery(ProfileFragment.this, 0);
                    }
                })
                .create().show();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        EasyImage.handleActivityResult(requestCode, resultCode, data, getActivity(), new DefaultCallback() {
            @Override
            public void onImagePicked(File imageFile, EasyImage.ImageSource source, int type) {
                try {
                    File compressToFile = new Compressor(getActivity()).compressToFile(imageFile);
                    registrationActivity.profile.setPhoto(Uri.fromFile(compressToFile).toString());
                    civPicture.setImageURI(registrationActivity.profile.getPhoto());

                } catch (IOException e) {
                }
            }

            @Override
            public void onCanceled(EasyImage.ImageSource source, int type) {
                super.onCanceled(source, type);
                if (source == EasyImage.ImageSource.CAMERA) {
                    File photoFile = EasyImage.lastlyTakenButCanceledPhoto(getActivity());
                    if (photoFile != null) photoFile.delete();
                }
            }
        });
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
        etDOB.setText(date);

        registrationActivity.profile.setDob(date);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        if (editable == etName.getEditableText()) {
            registrationActivity.profile.setName(editable.toString());
        } else if (editable == etPhoneNumber.getEditableText()) {
            registrationActivity.profile.setNoHp(editable.toString());
        }
    }

    @OnCheckedChanged({R.id.rb_man, R.id.rb_woman})
    void onCheckedChange(RadioButton radioButton) {
        switch (radioButton.getId()) {
            case R.id.rb_man:
                registrationActivity.profile.setJenisKelamin("MALE");
                break;
            case R.id.rb_woman:
                registrationActivity.profile.setJenisKelamin("FEMALE");
                break;
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
