package com.sumroch.spotme.activities.registration.editprofile;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
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

public class ProfilePassworActivity extends NormalActivity {
    @BindView(R.id.et_pass_lama)
    EditText pass_lama;
    @BindView(R.id.et_pass_baru)
    EditText pass_baru;
    @BindView(R.id.et_password_konfirm)
    EditText pass_kon;
    Profile profile = Profile.findFirst();
    public static final String tag_json_obj = "json_obj_req";
    private static final String TAG = ProfileAkunActivity.class.getSimpleName();

    @Override
    protected int getActivityView() {
        return R.layout.activity_profile_passwor;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        initDataProfile();
    }

    @Override
    protected boolean isActionBarEnable() {
        return false;
    }

    public void initDataProfile() {
        pass_lama.setText(profile.getPassword());

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
                        Toast.makeText(getApplicationContext(), "Update Password Success", Toast.LENGTH_SHORT).show();
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
                params.put("password", pass_baru.getText().toString());


                Log.d(TAG, "" + params);
                return params;
            }
        };

        SpotMe.getInstance().addToRequestQueue(stringRequest, tag_json_obj);
    }

    @OnClick(R.id.btn_simpan_pass)
    void simpan() {
        register(profile.getId());
    }

    @OnClick(R.id.btn_kembali)
    void kembali() {
        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        finish();
    }
}
