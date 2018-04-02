package com.sumroch.spotme.activities.parkir;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AlertDialog;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.sumroch.spotme.Constant;
import com.sumroch.spotme.R;
import com.sumroch.spotme.activities.bases.NormalActivity;
import com.sumroch.spotme.activities.gridmenu.GridMenuActivity;
import com.sumroch.spotme.api.command.ParkirCommand;
import com.sumroch.spotme.api.impl.ApiExecutorImpl;
import com.sumroch.spotme.api.interfaces.Callback;
import com.sumroch.spotme.eventbus.OnChangeSelectedMallIndexEvent;
import com.sumroch.spotme.models.db.HistoryParkir;
import com.sumroch.spotme.models.db.Mall;
import com.sumroch.spotme.models.db.Parkir;
import com.sumroch.spotme.models.db.ParkirLocation;
import com.sumroch.spotme.models.db.Profile;
import com.sumroch.spotme.helper.RealmHelper;
import com.sumroch.spotme.activities.registration.editprofile.ProfileKendaraanActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.Calendar;
import java.util.Date;
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

public class ReserveParkirActivity extends NormalActivity implements AdapterView.OnItemSelectedListener, TabLayout.OnTabSelectedListener, Validator.ValidationListener, AdapterView.OnItemClickListener {

    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_email)
    TextView tvEmail;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tl_type)
    TabLayout tlType;
//    @NotEmpty
//    @BindView(R.id.atv_license_plate)
//    AutoCompleteTextView atvLicensePlate;
    @NotEmpty
    @BindView(R.id.tv_parkir_location)
    TextView tvParkirLocation;
    @BindView(R.id.container_toolbar)
    FrameLayout containerToolbar;
    @BindView(R.id.spinner)
    Spinner spinnerMallName;
    @BindView(R.id.spinnerku)
    EditText spinnerPlat;
    Profile profile = Profile.findFirst();
    int id;
    Validator mValidator;
    private ArrayAdapter spinnerAdapter;
    private ArrayAdapter spinnerAdapterkendaraan;
    private boolean spinnerInitData;
    private ParkirLocation mParkirLocation;
    private ApiExecutorImpl apiExecutor;

    @Override
    protected int getActivityView() {
        return R.layout.activity_reserve_parkir;
    }

    @Override
    protected boolean isActionBarEnable() {
        return false;
    }




    @Override
    protected void onBindView() {
        super.onBindView();
        mValidator = new Validator(this);
        mValidator.setValidationListener(this);
        apiExecutor = new ApiExecutorImpl();
        EventBus.getDefault().register(this);
        spinnerAdapter = new ArrayAdapter(this, R.layout.view_spinner_white, android.R.id.text1, Mall.getMallName());
        spinnerAdapter.setDropDownViewResource(R.layout.view_spinner_dark);
        spinnerMallName.setAdapter(spinnerAdapter);
        spinnerMallName.setSelection(getBundle().getInt(Constant.SELECTED_MALL_INDEX));
        spinnerMallName.setOnItemSelectedListener(this);
        tvName.setText(profile.getName());
        tvEmail.setText(profile.getEmail());
        tvPhone.setText(profile.getNoHp());
        updateTime();
        initData();
        tlType.addOnTabSelectedListener(this);
        id = getBundle().getInt(Constant.ID);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                RealmHelper.getListPlatNumber()
        );
//        spinnerPlat.setAdapter(adapter);

//        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
//        Drawable drawable = getDrawable(R.drawable.ic_back_white);
//        drawable.setTint(getColor(R.color.white));
//        getSupportActionBar().setHomeAsUpIndicator(drawable);
    }

    private void updateTime() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Date date = Calendar.getInstance().getTime();
                date.setMinutes(date.getMinutes() + 30);
                String time = "hh:mm";
                tvTime.setText(DateFormat.format(time, date));
                updateTime();
            }
        }, 500);
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                supportFinishAfterTransition();
//                return true;
//            default:
//                return false;
//        }
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    @OnClick(R.id.back_reserve)
    void back(){
        supportFinishAfterTransition();
    }
    @Subscribe
    public void subscriberParkirLocation(ParkirLocation parkirLocation) {
        mParkirLocation = parkirLocation;
        tvParkirLocation.setText(String.format("%1$s - %2$s", parkirLocation.getNomorLantai(), parkirLocation.getNomorBlok()));
    }

    @OnClick(R.id.tv_parkir_location)
    public void onClickParkirLocation() {
        Intent intent = new Intent(this, AvailableParkirActivity.class);
        intent.putExtra(Constant.SELECTED_MALL_INDEX, spinnerMallName.getSelectedItemPosition());
        intent.putExtra(Constant.ID, id);
        startActivity(intent);
    }

    @OnClick(R.id.btn_reserve)
    public void onClickReserve() {
        mValidator.validate();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (!spinnerInitData) {
            spinnerInitData = true;
        } else {
//            getEventData(String.valueOf(mallList.get(i).getId()));
            id = Mall.getMall().get(i).getId();
            EventBus.getDefault().post(new OnChangeSelectedMallIndexEvent(i));
            tvParkirLocation.setText("");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onValidationSucceeded() {
        showProgressDialog("Sumbit parkir...");

        Parkir.Request request = new Parkir.Request();
        request.setIdMall(mParkirLocation.getIdMall());
        request.setIdUser(Profile.findFirst().getId());
        request.setIdLokasi(mParkirLocation.getId());
        request.setPlatNomor(spinnerPlat.getText().toString());
        request.setJenisKendaraan(tlType.getTabAt(tlType.getSelectedTabPosition()).getText().toString());

        apiExecutor.execute(ParkirCommand.class, request, new Callback<List<HistoryParkir>>() {

            @Override
            public void onSuccess(List<HistoryParkir> data) {
                dismissProgressDialog();
                AlertDialog dialog = new AlertDialog.Builder(ReserveParkirActivity.this).create();
                dialog.setMessage("Reserve parkir success");
                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        startActivity(new Intent(ReserveParkirActivity.this, GridMenuActivity.class));
                        finishAffinity();
                    }
                });
                dialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                dialog.show();
                HistoryParkir.saveAll(data);
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
        String message = errors.get(0).getFailedRules().get(0).getMessage(this);
        if (view instanceof EditText) {
            ((EditText) view).setError(message);
            view.requestFocus();
        } else {
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
    }

    @Subscribe
    public void onChangeSelectedMallIndex(OnChangeSelectedMallIndexEvent e) {
//        spinnerInitData = false;
        spinnerMallName.setSelection(e.getIndex());
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String s = spinnerPlat.getText().toString();
        if (s.equalsIgnoreCase("MPV")) {
            tlType.getTabAt(0).select();
        } else if (s.equalsIgnoreCase("SUV")) {
            tlType.getTabAt(1).select();
        } else if (s.equalsIgnoreCase("SEDAN")) {
            tlType.getTabAt(2).select();
        }
    }
 @OnClick(R.id.find_plat)
    void find(){
        startActivity(new Intent(getApplicationContext(), ProfileKendaraanActivity.class));
        finish();

 }
 private void initData(){
     spinnerPlat.setText(getBundle().getString("description", null));
 }
}
