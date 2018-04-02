package com.sumroch.spotme.activities.registration.editprofile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.sumroch.spotme.R;
import com.sumroch.spotme.activities.bases.NormalActivity;
import com.sumroch.spotme.activities.frontier.LoginActivity;
import com.sumroch.spotme.activities.gridmenu.GridMenuActivity;
import com.sumroch.spotme.api.impl.ApiExecutorImpl;
import com.sumroch.spotme.models.db.Profile;

import java.io.File;
import java.io.IOException;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import id.zelory.compressor.Compressor;
import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;

public class ProfileActivity extends NormalActivity {
    Profile profile = Profile.findFirst();
    ApiExecutorImpl apiExecutor;
    @BindView(R.id.iv_picture_editf)
    CircleImageView foto;
    @BindView(R.id.name_pro)
    TextView nama;

    ProfileActivity profileActivity;

    @Override
    protected int getActivityView() {
        return R.layout.activity_profile;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initUserData();

    }

    private void initUserData() {
        String removeCurrency=profile.getPhoto();
        String  urlphoto = removeCurrency.substring(1);
        Picasso.with(this).load("http://api.sumroch.com/photos/%20"+urlphoto).into(foto);
        nama.setText(profile.getName());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
        } else if (id == R.id.edit_profile) {
            startActivity(new Intent(getApplicationContext(), EditProfileActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.edit, menu);
        return super.onCreateOptionsMenu(menu);

    }
//
//    @OnClick({R.id.iv_picture_editf, R.id.iv_picture_editku})
//    void onClickPicture() {
//        new AlertDialog.Builder(this)
//                .setMessage("Take photo from camera or choose from gallery?")
//                .setNegativeButton("Camera", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        EasyImage.openCamera(ProfileActivity.this, 0);
//                    }
//                })
//                .setPositiveButton("Gallery", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        EasyImage.openGallery(ProfileActivity.this, 0);
//                    }
//                })
//                .create().show();
//
//    }

    @OnClick({R.id.txt_akun, R.id.txt_kendaraan, R.id.txt_kontak, R.id.txt_ganti_pass, R.id.txt_logout})
    void onClickText(View view) {
        switch (view.getId()) {
            case R.id.txt_akun:
                startActivity(new Intent(getApplicationContext(), ProfileAkunActivity.class));
                finish();
                break;
            case R.id.txt_kendaraan:
                startActivity(new Intent(getApplicationContext(), ProfileKendaraanActivity.class));
                finish();
                break;
            case R.id.txt_kontak:
                startActivity(new Intent(getApplicationContext(), ProfileKontaActivity.class));
                finish();
                break;
            case R.id.txt_ganti_pass:
                startActivity(new Intent(getApplicationContext(), ProfilePassworActivity.class));
                finish();
                break;
            case R.id.txt_logout:
                Profile.deleteAll();
                if (Profile.findFirst() == null) {
                    startActivity(new Intent(this, LoginActivity.class));
                    finishAffinity();
                }
                break;
        }

    }

    @OnClick(R.id.btn_kembali)
    void kembali() {
        startActivity(new Intent(getApplicationContext(), GridMenuActivity.class));
        finish();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        EasyImage.handleActivityResult(requestCode, resultCode, data, this, new DefaultCallback() {
            @Override
            public void onImagePicked(File imageFile, EasyImage.ImageSource source, int type) {
                try {
                    File compressToFile = new Compressor(getApplicationContext()).compressToFile(imageFile);
                    profileActivity.profile.setPhoto(Uri.fromFile(compressToFile).toString());
//                    foto.setImageURI(profileActivity.profile.getPhoto());

                } catch (IOException e) {
                }
            }

            @Override
            public void onCanceled(EasyImage.ImageSource source, int type) {
                super.onCanceled(source, type);
                if (source == EasyImage.ImageSource.CAMERA) {
                    File photoFile = EasyImage.lastlyTakenButCanceledPhoto(getApplicationContext());
                    if (photoFile != null) photoFile.delete();
                }
            }
        });
    }

    @Override
    protected boolean isActionBarEnable() {
        return false;
    }
}
