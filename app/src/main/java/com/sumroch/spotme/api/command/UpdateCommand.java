package com.sumroch.spotme.api.command;

import android.net.Uri;

import com.sumroch.spotme.api.ApiResponse;
import com.sumroch.spotme.api.HttpClient;
import com.sumroch.spotme.api.impl.ApiService;
import com.sumroch.spotme.models.db.LoginData;
import com.sumroch.spotme.models.db.Profile;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;

/**
 * Created by iihsa on 10/01/2018.
 */

public class UpdateCommand extends ApiService<Profile, LoginData> {

    public UpdateCommand(Profile request) {
        super(request);
    }

    public static RequestBody requestBodyString(String value) {
        return RequestBody.create(MediaType.parse("text/plain"), value);
    }

    public static RequestBody requestBodyFile(File value) {
        return RequestBody.create(MediaType.parse("multipart/form-data"), value);
    }

    @Override
    public Call<ApiResponse<LoginData>> getApi() {
        return HttpClient.getInstance("tag").getApi().update(
                request.getId(),
                request.getUsername(),
                request.getEmail(),
                request.getPhoto(),
                request.getName(),
                request.getNoHp(),
                request.getJenisKelamin(),
                request.getDob(),
                request.getIdSurveyInterest()
        );
    }


    public MultipartBody.Part getFile(String key, String fileUri) {
        File file = new File(Uri.parse(fileUri).getPath());
        RequestBody reqFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData(key, file.getName(), reqFile);
        return body;
    }

    public MultipartBody.Part getString(String key, String data) {
        RequestBody reqFile = RequestBody.create(MediaType.parse("multipart/form-data"), data);
        MultipartBody.Part body = MultipartBody.Part.createFormData(key, data);
        return body;
    }

    public MultipartBody.Part getInt(String key, Integer data) {
        RequestBody reqFile = RequestBody.create(MediaType.parse("multipart/form-data"), String.valueOf(data));
        MultipartBody.Part body = MultipartBody.Part.createFormData(key, String.valueOf(data));
        return body;
    }

    public RequestBody getString(String data) {
        return RequestBody.create(MediaType.parse("multipart/form-data"), data);
    }
}
