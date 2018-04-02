package com.sumroch.spotme.activities.registration.editprofile;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.sumroch.spotme.R;
import com.sumroch.spotme.SpotMe;
import com.sumroch.spotme.activities.bases.NormalActivity;
import com.sumroch.spotme.models.db.Profile;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class ProfileAkunActivity extends NormalActivity {
    @BindView(R.id.et_nama_profile)
    EditText nama;
    @BindView(R.id.et_email_profile)
    EditText email;
    @BindView(R.id.et_tgl_profile)
    EditText tgl_lahir;
    @BindView(R.id.et_tlpn_profile)
    EditText no_hp;
    @BindView(R.id.rd_edit)
    RadioGroup rd_edit;
    String jenkel = "";
    Profile profile = Profile.findFirst();
    public static final String tag_json_obj = "json_obj_req";
    private static final String TAG = ProfileAkunActivity.class.getSimpleName();

    @Override
    protected int getActivityView() {
        return R.layout.activity_profile_akun;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataProfile();
        rd_edit.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rd_male:
                        jenkel = "Male";
                        break;
                    case R.id.rd_female:
                        jenkel = "Female";
                        break;

                }
            }
        });

    }

    public void initDataProfile() {
        nama.setText(profile.getName());
        email.setText(profile.getEmail());
        no_hp.setText(profile.getNoHp());
        tgl_lahir.setText(profile.getDob());
    }

    @Override
    protected boolean isActionBarEnable() {
        return false;
    }

    private void register(final int id) {
        String URL = "http://api.sumroch.com/api/user/update";
        showProgressDialog("Upadte Profile");
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, "Response: " + response.toString());

                        Profile data = Profile.findFirst();
                        data.setEmail(email.getText().toString());
                        data.setName(nama.getText().toString());
                        data.setNoHp(no_hp.getText().toString());
                        data.setJenisKelamin(jenkel);
                        data.setDob(tgl_lahir.getText().toString());
                        Toast.makeText(getApplicationContext(), "Update Profile Sukses", Toast.LENGTH_SHORT).show();
                        finish();


                        dismissProgressDialog();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        dismissProgressDialog();
                        Toast.makeText(getApplicationContext(), error.getMessage().toString(), Toast.LENGTH_LONG).show();
                        Log.d(TAG, error.getMessage().toString());
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("id", String.valueOf(id));
                params.put("name", nama.getText().toString());
                params.put("email", email.getText().toString());
                params.put("no_hp", no_hp.getText().toString());
                params.put("dob", tgl_lahir.getText().toString());
                params.put("jenis_kelamin", jenkel);


                Log.d(TAG, "" + params);
                return params;
            }
        };

        SpotMe.getInstance().addToRequestQueue(stringRequest, tag_json_obj);
    }

    @OnClick(R.id.simp)
    void simpan() {
        register(profile.getId());
    }
    @OnClick(R.id.btn_kembali)
    void kembali (){
        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        finish();
    }

}

