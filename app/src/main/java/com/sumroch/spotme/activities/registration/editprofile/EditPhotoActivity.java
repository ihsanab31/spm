package com.sumroch.spotme.activities.registration.editprofile;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.sumroch.spotme.activities.gridmenu.GridMenuActivity;
import com.sumroch.spotme.api.command.MasterDataCommand;
import com.sumroch.spotme.api.command.RegisterCommand;
import com.sumroch.spotme.api.interfaces.Callback;
import com.sumroch.spotme.models.db.BaseImageUrl;
import com.sumroch.spotme.models.db.Kendaraan;
import com.sumroch.spotme.models.db.LoginData;
import com.sumroch.spotme.models.db.Mall;
import com.sumroch.spotme.models.db.MasterData;
import com.sumroch.spotme.models.db.Profile;
import com.facebook.drawee.view.SimpleDraweeView;
import com.sumroch.spotme.R;
import com.sumroch.spotme.api.impl.ApiExecutorImpl;

import java.io.File;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.zelory.compressor.Compressor;
import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;

public class EditPhotoActivity extends AppCompatActivity {
    @BindView(R.id.foto)
    SimpleDraweeView foto;
    Profile profile = Profile.findFirst();
    ApiExecutorImpl apiExecutor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_photo);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this);
        initUserData();
        EasyImage.configuration(this)
                .setImagesFolderName("My app images")
                .saveInAppExternalFilesDir()
                .saveInRootPicturesDirectory();
        apiExecutor = new ApiExecutorImpl();
    }
    private void initUserData() {
        String imageUrl = BaseImageUrl.getData().getUser() + profile.getPhoto();
        foto.setImageURI(imageUrl);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.edit, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
        } else if (id == R.id.edit_profile) {
            new AlertDialog.Builder(this)
                    .setMessage("Take photo from camera or choose from gallery?")
                    .setNegativeButton("Camera", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            EasyImage.openCamera(EditPhotoActivity.this, 0);
                        }
                    })
                    .setPositiveButton("Gallery", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            EasyImage.openGallery(EditPhotoActivity.this, 0);
                        }
                    })
                    .create().show();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        EasyImage.handleActivityResult(requestCode, resultCode, data, this, new DefaultCallback() {
            @Override
            public void onImagePicked(File imageFile, EasyImage.ImageSource source, int type) {
                try {
                    File compressToFile = new Compressor(getApplicationContext()).compressToFile(imageFile);
                    profile.setPhoto(Uri.fromFile(compressToFile).toString());
                    foto.setImageURI(profile.getPhoto());
                    apiExecutor.execute(RegisterCommand.class, profile, new Callback<LoginData>() {
                        @Override
                        public void onSuccess(LoginData data) {
                            getMasterData(data.getToken());
                        }

                        @Override
                        public void onFailure(String message) {
                        }
                    });
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

    public void getMasterData(String token) {
        apiExecutor.execute(MasterDataCommand.class, token, new Callback<MasterData>() {
            @Override
            public void onSuccess(MasterData data) {

                Profile.deleteAll();
                Profile.add(data.getProfile());

                Mall.deleteAll();
                Mall.saveAll(data.getMall());

                BaseImageUrl.deleteAll();
                BaseImageUrl.add(data.getImageUrl());

                Kendaraan.deleteAll();
                Kendaraan.addAll(data.getKendaraan());

//                Profile.deleteAll();
//                Profile.updatePhotoFromUri(data.getPhoto());

                startActivity(new Intent(getApplicationContext(), GridMenuActivity.class));
                finishAffinity();
            }

            @Override
            public void onFailure(String message) {

            }

        });
    }

}
